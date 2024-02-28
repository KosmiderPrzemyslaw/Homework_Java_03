package pl.kosmider.playerservicecrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kosmider.playerservicecrud.entity.Player;
import pl.kosmider.playerservicecrud.entity.PlayerDetails;
import pl.kosmider.playerservicecrud.entity.Training;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {


    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Player player) {
        entityManager.persist(player);
    }

    @Override
    public Player findPlayerById(int theId) {
        return entityManager.find(Player.class, theId);
    }

    @Override
    @Transactional
    public void deletePlayerById(int theId) {
        Player player = entityManager.find(Player.class, theId);

        List<Training> trainingList = player.getTrainingList();

        //break association of all trainings for the player

        for (Training tempTraining:trainingList
             ) {
            tempTraining.setPlayer(null);
        }

        entityManager.remove(player);
    }

    @Override
    public PlayerDetails findPlayerDetailsById(int theId) {
        return entityManager.find(PlayerDetails.class, theId);
    }

    @Override
    @Transactional
    public void deletePlayerDetailsById(int theId) {

        PlayerDetails playerDetails = entityManager.find(PlayerDetails.class, theId);

        //remove associated object reference
        playerDetails.getPlayer().setPlayerDetails(null);

        entityManager.remove(playerDetails);

        System.out.println("Instructor detail deleted!");
    }

    @Override
    public List<Training> findTrainingsByPlayerId(int theId) {

        TypedQuery<Training> query = entityManager.
                createQuery("FROM Training WHERE player.id =:data", Training.class);
        query.setParameter("data", theId);

        List<Training> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public Player findPlayerByIdJoinFetch(int theId) {

        TypedQuery<Player> query = entityManager.createQuery(
                "SELECT player FROM Player player " +
                        "JOIN FETCH player.trainingList " +
                        "JOIN FETCH player.playerDetails " +
                        "WHERE player.id = :data", Player.class);

        query.setParameter("data", theId);

        Player player = query.getSingleResult();
        return player;
    }

    @Override
    @Transactional
    public void update(Player player) {
        entityManager.merge(player);
    }

    @Override
    @Transactional
    public void update(Training training) {
        entityManager.merge(training);
    }

    @Override
    public Training findTrainingById(int theId) {
        return entityManager.find(Training.class, theId);
    }
}
