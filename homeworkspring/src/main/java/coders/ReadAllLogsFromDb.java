package coders;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReadAllLogsFromDb implements CustomerLog {
    private String READ_ALL_LOGS_FROM_DB = "SELECT * FROM springHomework.log";

    @Override
    public void log(Customer customer) {

    }

    @Override
    public void readAllLogs() {

        Map<Integer, String> map = new HashMap<>();
        try {
            Connection connection = DbUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(READ_ALL_LOGS_FROM_DB);
            StringBuilder stringBuilder = new StringBuilder();
            FileWriter fileWriter = new FileWriter("logsFromDb.txt");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String log = resultSet.getString("log");
                map.put(id, log);
            }
            for (Map.Entry<Integer, String> entry : map.entrySet()
            ) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                stringBuilder.append(key).append(value).append("\n");
            }
            fileWriter.append(stringBuilder);
            fileWriter.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }
}
