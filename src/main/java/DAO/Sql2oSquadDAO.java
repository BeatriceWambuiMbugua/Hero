package DAO;

import modules.Squad;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oSquadDAO  implements  SquadDAO{
    private final Sql2o sql2o;

    public Sql2oSquadDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public List<Squad> getAllSquads() {
        return null;
    }
}
