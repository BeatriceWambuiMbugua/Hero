package DAO;

import modules.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSquadDAO  implements  SquadDAO{
    /* create Sql2o object to enable the Sql2oSquadDAO to fetch data from the database */
    private final Sql2o sql2o;

    public Sql2oSquadDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    //Override the method to implement the interface
    @Override
    public List<Squad> getAllSquads() {
        String sql = "SELECT * FROM squads";
        //error handling using try and catch
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Squad.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }
}
