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

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(String heroPower) {
        this.heroPower = heroPower;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public void setHeroWeakness(String heroWeakness) {
        this.heroWeakness = heroWeakness;
    }

    public String getHeroGender() {
        return heroGender;
    }

    public void setHeroGender(String heroGender) {
        this.heroGender = heroGender;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public void setHeroAge(int heroAge) {
        this.heroAge = heroAge;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }
}

