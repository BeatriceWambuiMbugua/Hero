import static spark.Spark.*;

import DAO.Sql2oHeroDAO;
import DAO.Sql2oSquadDAO;
import org.sql2o.Connection;
import modules.Squad;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        String connectionString = "jdbc:h2:~/Hero.db;INIT=RUNSCRIPT from 'classpath:db/createtables.sql'";
        Connection con;
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oSquadDAO squadDAO = new Sql2oSquadDAO(sql2o);
        Sql2oHeroDAO heroDAO = new Sql2oHeroDAO(sql2o);
        Map<String, Object> model = new HashMap<>();
        //Declare the Map<> globally to DRY the code

        List<String> myStrings = new ArrayList<>();

        get("/", (req, res) -> {
            model.put("squads", squadDAO.getAllSquads());
            model.put("heroes", heroDAO.getAllHeroes());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addsquad", (req, res) -> {
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());
        //create the post method to add information in the form

        post("/addsquad", (req, res) -> {
            String name = req.queryParams("name");
            String purpose= req.queryParams("purpose");
            int number = Integer.parseInt(req.queryParams("number"));
            String group= req.queryParams("group");
            Squad newSquad = new Squad(name, purpose, number, group);
            squadDAO.addSquad(newSquad);
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
