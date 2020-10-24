package modules;

import junit.framework.TestCase;
import org.junit.Test;

public class SquadTest extends TestCase {

    Squad clique = new Squad("Flash", "fighting-crimes", 5, "DC");

    @Test
    public void testGetSquadGroup() {
        assertEquals("DC", clique.getSquadGroup());
    }

    @Test
    public void testSetSquadGroup() {
        assertEquals("DC", clique.getSquadGroup());
    }

    @Test
    public void testGetSquadName() {
        assertEquals("Flash", clique.getSquadName());
    }

    @Test
    public void testSetSquadName() {
        assertEquals("Flash", clique.getSquadName());
    }

    @Test
    public void testGetSquadNumber() {
        assertEquals(5, clique.getSquadNumber());
    }

    @Test
    public void testSetSquadNumber() {
        assertEquals(5, clique.getSquadNumber());
    }

    @Test
    public void testGetSquadPurpose() {
        assertEquals("fighting-crimes", clique.getSquadPurpose());
    }

    @Test
    public void testSetSquadPurpose() {
        assertEquals("fighting-crimes", clique.getSquadPurpose());
    }
}