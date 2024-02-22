package pl.kosmider.playerservicecrud.dao;

import pl.kosmider.playerservicecrud.entity.Player;
import pl.kosmider.playerservicecrud.entity.PlayerDetails;

public interface AppDao {

    void save(Player player);

    Player findPlayerById(int theId);

    void deletePlayerById(int theId);

    PlayerDetails findPlayerDetailsById(int theId);

    void deletePlayerDetailsById(int theId);
}
