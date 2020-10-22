package DAO;

import modules.Hero;

import java.util.List;

public interface HeroDAO {
    //List
    List<Hero> getAllHeroes();

    void addHero(Hero hero);
}
