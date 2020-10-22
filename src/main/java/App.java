import static spark.Spark.*;

import DAO.Sql2oSquadDAO;
import org.sql2o.Connection;
import modules.Squad;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        String connectionString = "jdbc:h2:~/Hero.db;INIT=RUNSCRIPT from 'classpath:db/createtables.sql'";
        Connection con;
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oSquadDAO squadDAO = new Sql2oSquadDAO(sql2o);
        Map<String, Object> model = new HashMap<>();
        //Declare the Map<> globally to DRY the code

        get("/", (request, response) -> {
            System.out.println(squadDAO.getAllSquads());
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
