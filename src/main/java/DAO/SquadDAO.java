package DAO;

import modules.Squad;

import java.util.List;

public interface SquadDAO {
    //List
    List<Squad> getAllSquads();
// adding data to the squad
    void addSquad(Squad squad);

    Squad getSquadById(int id);

}
