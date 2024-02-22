package pl.kosmider.playerservicecrud.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kosmider.playerservicecrud.entity.Player;
import pl.kosmider.playerservicecrud.entity.PlayerDetails;

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
}
