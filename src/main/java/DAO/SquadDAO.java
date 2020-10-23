package DAO;

import modules.Hero;
import modules.Squad;

import java.util.List;

public interface SquadDAO {
    //List
    List<Squad> getAllSquads();
// adding data to the squad
    void addSquad(Squad squad);

    Squad getSquadById(int id);

    List<Hero> getSquadsHeroesById(int id);

    //create a delete method for squad

    void deleteSquadById(int id);

}
