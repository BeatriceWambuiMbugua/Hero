import static spark.Spark.*;

import DAO.Sql2oHeroDAO;
import DAO.Sql2oSquadDAO;
import modules.Hero;
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
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");
      String connectionString = "jdbc:postgresql://ec2-34-234-185-150.compute-1.amazonaws.com:5432/d61mb4m8jfijlp";
        //String connectionString = "jdbc:postgresql://localhost:5432/hero";

        Sql2o sql2o = new Sql2o(connectionString, "zbepqrskhdhkkg", "ee3dfaaaa726715c0f7bfa2a6d72051aa71da557e4109caaf46c05344be8c250");
        //Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access");
//        String connectionString = "jdbc:h2:~/Hero.db;INIT=RUNSCRIPT from 'classpath:db/createtables.sql'";
        Connection con;
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
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

        get("/addhero", (req, res) -> {
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/addhero", (req, res) -> {
            String name = req.queryParams("name");
            String power= req.queryParams("power");
            String weakness= req.queryParams("weakness");
            String gender= req.queryParams("gender");
            int age = Integer.parseInt(req.queryParams("age"));
            int squadId = Integer.parseInt(req.queryParams("squad"));
            Hero newHero= new Hero(name, power, weakness, gender, age, squadId);
            heroDAO.addHero(newHero);
            model.put("squads", squadDAO.getAllSquads());
            model.put("heroes", heroDAO.getAllHeroes());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (req, res) -> {
            List<Hero> hero = heroDAO.getAllHeroes();
            model.put("hero", hero);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (req, res) -> {
            List<Squad> squad = squadDAO.getAllSquads();
            model.put("squad", squad);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Hero hero = heroDAO.getHeroById(id);
            Squad squad = squadDAO.getSquadById(hero.getSquadId());
            model.put("hero", heroDAO.getHeroById(id));
            model.put("squad", squad);
            return new ModelAndView(model, "hero-information.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            model.put("heroes", squadDAO.getSquadsHeroesById(id));
            model.put("squad", squadDAO.getSquadById(id));
            return new ModelAndView(model, "squad-information.hbs");
        }, new HandlebarsTemplateEngine());

        get("/deletehero/:id", (req, res) ->{
            int id = Integer.parseInt(req.params("id"));
            heroDAO.deleteHeroById(id);
            model.put("heroes", heroDAO.getAllHeroes());
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/deletesquad/:id", (req, res) ->{
            int id = Integer.parseInt(req.params("id"));
            squadDAO.deleteSquadById(id);
            model.put("heroes", heroDAO.getAllHeroes());
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/edithero/:id", (req, res) ->{
            int id = Integer.parseInt(req.params("id"));
            model.put("editHero", true);
            model.put("hero", heroDAO.getHeroById(id));
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "update-hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/edithero/:id", (req, res) ->{
            int id = Integer.parseInt(req.params("id"));
            String name = req.queryParams("name");
            String power= req.queryParams("power");
            String weakness= req.queryParams("weakness");
            String gender= req.queryParams("gender");
            int age = Integer.parseInt(req.queryParams("age"));
            int squadId = Integer.parseInt(req.queryParams("squad"));
            heroDAO.updateHero(id, name, power, weakness, gender, age, squadId);
            model.put("hero", heroDAO.getHeroById(id));
            return new ModelAndView(model, "hero-information.hbs");
        }, new HandlebarsTemplateEngine());

        get("/editsquad/:id", (req, res) ->{
            int id = Integer.parseInt(req.params("id"));
            model.put("editSquad", true);
            model.put("squads", squadDAO.getAllSquads());
            return new ModelAndView(model, "update-squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/editsquad/:id", (req, res) ->{
            int id = Integer.parseInt(req.params("id"));
            String name = req.queryParams("name");
            String purpose= req.queryParams("purpose");
            int number = Integer.parseInt(req.queryParams("number"));
            String group= req.queryParams("group");
            squadDAO.updateSquad(id, name, purpose, number, group);
            model.put("squad", squadDAO.getSquadById(id));
            return new ModelAndView(model, "squad-information.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
