package modules;

import junit.framework.TestCase;
import org.junit.Test;

public class HeroTest extends TestCase {
    Hero shero = new Hero("Barry", "speed", "speed-force", "male", 20, 1);

    @Test
    public void testGetHeroName() {
       assertEquals("Barry", shero.getHeroName());
    }

    @Test
    public void testSetHeroName() {
        assertEquals("Barry", shero.getHeroName());
    }

    @Test
    public void testGetHeroPower() {
        assertEquals("speed", shero.getHeroPower());
    }

    @Test
    public void testSetHeroPower() {
        assertEquals("speed", shero.getHeroPower());
    }

    @Test
    public void testGetHeroWeakness() {
        assertEquals("speed-force", shero.getHeroWeakness());
    }

    @Test
    public void testSetHeroWeakness() {
        assertEquals("speed-force", shero.getHeroWeakness());
    }

    @Test
    public void testGetHeroGender() {
        assertEquals("male", shero.getHeroGender());
    }

    @Test
    public void testSetHeroGender() {
        assertEquals("male", shero.getHeroGender());
    }

    @Test
    public void testGetHeroAge() {
        assertEquals(20, shero.getHeroAge());
    }

    @Test
    public void testSetHeroAge() {
        assertEquals(20, shero.getHeroAge());
    }

    @Test
    public void testGetSquadId() {
        assertEquals(1, shero.getSquadId());
    }

    @Test
    public void testSetSquadId() {
        assertEquals(1, shero.getSquadId());
    }
}