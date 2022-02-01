package coders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
@Qualifier("dbCustomerLogger")
public class DBCustomerLogger implements CustomerLog {

    private static final String CREATE_QUERY = "INSERT INTO springHomework.log(log) VALUE (?)";

    @Override
    public void log(Customer customer) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, customer.toString() + LocalDateTime.now());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readAllLogs() {

    }
}
