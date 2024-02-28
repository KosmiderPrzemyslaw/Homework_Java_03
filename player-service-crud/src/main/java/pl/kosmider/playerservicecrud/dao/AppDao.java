package pl.kosmider.playerservicecrud.dao;

import pl.kosmider.playerservicecrud.entity.Player;
import pl.kosmider.playerservicecrud.entity.PlayerDetails;
import pl.kosmider.playerservicecrud.entity.Training;

import java.util.List;

public interface AppDao {

    void save(Player player);

    Player findPlayerById(int theId);

    void deletePlayerById(int theId);

    PlayerDetails findPlayerDetailsById(int theId);

    void deletePlayerDetailsById(int theId);

    List<Training> findTrainingsByPlayerId(int theId);

    Player findPlayerByIdJoinFetch(int theId);

    void update(Player player);

    void update(Training training);

    Training findTrainingById(int theId);

    }
