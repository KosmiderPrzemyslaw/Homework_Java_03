package pl.kosmider.playerservicecrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kosmider.playerservicecrud.dao.AppDao;
import pl.kosmider.playerservicecrud.entity.Player;
import pl.kosmider.playerservicecrud.entity.PlayerDetails;
import pl.kosmider.playerservicecrud.entity.Training;

import java.util.List;

@SpringBootApplication
public class PlayerServiceCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerServiceCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
             //createPlayer(appDao);

            //findPlayerById(appDao);

            //deletePlayerById(appDao);

            //findPlayerDetailById(appDao);

            //deletePlayerDetails(appDao);

            //createPlayerWithTrainings(appDao);

            //findPlayerWithTrainings(appDao);

            //findTrainingsForPlayer(appDao);

            findPlayerWithListOfTrainingsJoinFetch(appDao);

        };
    }

    private void findPlayerWithListOfTrainingsJoinFetch(AppDao appDao) {
        int theId = 1;

        System.out.println("Finding instructor id: " + theId);
        Player playerByIdJoinFetch = appDao.findPlayerByIdJoinFetch(theId);

        System.out.println("PLayer: "  + playerByIdJoinFetch);
        System.out.println("Associated trainings: "  + playerByIdJoinFetch.getTrainingList());


    }

    private void findTrainingsForPlayer(AppDao appDao) {
        int theId = 1;

        System.out.println("Finding player id: " + theId);

        Player playerById = appDao.findPlayerById(theId);

        System.out.println(playerById);

        System.out.println("Finding trainings for player id: "  + theId);

        List<Training> trainingsByPlayerId = appDao.findTrainingsByPlayerId(theId);

        playerById.setTrainingList(trainingsByPlayerId);

        System.out.println("Trainings list: " + playerById.getTrainingList());
    }

    private void findPlayerWithTrainings(AppDao appDao) {
        int theId = 1;

        System.out.println("Finding player id: " + theId);

        Player playerById = appDao.findPlayerById(theId);

        System.out.println(playerById);
        System.out.println("associated trainings: " + playerById.getTrainingList());


    }

    private void createPlayerWithTrainings(AppDao appDao) {
        Player player = new Player("Julian", "Krol");

        PlayerDetails playerDetails = new PlayerDetails("dance", "julian", "21331");

        player.setPlayerDetails(playerDetails);

        Training training = new Training("speed");
        Training training2 = new Training("finishing");

        player.add(training);
        player.add(training2);

        appDao.save(player);


        System.out.println("Saved player " + player);
    }

    private void deletePlayerDetails(AppDao appDao) {
        System.out.println("Deleting player detail id: " + 6);
        appDao.deletePlayerDetailsById(6);
    }

    private void findPlayerDetailById(AppDao appDao) {
        int id = 3;

        PlayerDetails playerDetailsById = appDao.findPlayerDetailsById(id);

        System.out.println("Find player details: " + playerDetailsById);
        System.out.println("Find player: " + playerDetailsById.getPlayer());
    }

    private void deletePlayerById(AppDao appDao) {
        appDao.deletePlayerById(1);

        System.out.println("Player deleted");
    }

    private void findPlayerById(AppDao appDao) {
        int id = 1;
        Player playerById = appDao.findPlayerById(id);

        System.out.println(playerById);
        System.out.println(playerById.getPlayerDetails());
    }

    private void createPlayer(AppDao appDao) {
        Player player = new Player("Julian", "Krol");

        PlayerDetails playerDetails = new PlayerDetails("dance", "julian", "21331");

        player.setPlayerDetails(playerDetails);

        appDao.save(player);


        System.out.println("Saved player " + player);
    }
}
