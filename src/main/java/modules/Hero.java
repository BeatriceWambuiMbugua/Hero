package modules;

public class Hero {
    private String heroName;
    private String heroPower;
    private String heroWeakness;
    private String heroGender;
    private int heroAge;
    private int heroId;
    /* the property attributes have to be private to avoid being accessed directly without getters and setters or modified, thus, reducing the pesky bugs. */

    public Hero(String heroName, String heroPower, String heroWeakness, String heroGender, int heroAge) {
        this.heroName = heroName;
        this.heroPower = heroPower;
        this.heroWeakness = heroWeakness;
        this.heroGender = heroGender;
        this.heroAge = heroAge;
        // generate constructor argument. However, the id will not be generated since it will be generated and defined in the database
    }

}

