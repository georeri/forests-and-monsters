package com.levelup.environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.levelup.creatures.Creature;
import com.levelup.items.Item;

import org.junit.jupiter.api.Test;

public class TileTest {
    @Test
    void testEnterTileAndNothingIsThere() {
        //creature is the same as they started
        Tile testObj = new Tile(0,0,1,1);
        //TODO: Consider mocking this later?
        Creature testCreature = new Creature();
        int prevHealth = testCreature.getHealth();
        int prevInventory = testCreature.getInventory().length;
        boolean prevAlive = testCreature.isAlive();

        testObj.enterTile(testCreature);

        assertEquals(prevHealth, testCreature.getHealth());
        assertEquals(prevInventory, testCreature.getInventory().length);
        assertEquals(prevAlive, testCreature.isAlive());
    }

    @Test
    void testEnterTileAndMonsterIsThere() {
        //creature is killed by any monster
        Tile testObj = new Tile(0,0,1,1);
        
        //TODO: Consider mocking this later?
        Creature monster = new Creature();
        testObj.addCreature(monster);

        Creature testCreature = new Creature();
        int prevInventory = testCreature.getInventory().length;
        
        testObj.enterTile(testCreature);

        assertEquals(0, testCreature.getHealth());
        assertEquals(prevInventory, testCreature.getInventory().length);
        assertEquals(false, testCreature.isAlive());
    }

    @Test
    void testExploreAndNothingIsThere() {
        //creature is the same as they started
        Tile testObj = new Tile(0,0,1,1);
        //TODO: Consider mocking this later?
        Creature testCreature = new Creature();
        int prevHealth = testCreature.getHealth();
        int prevInventory = testCreature.getInventory().length;
        boolean prevAlive = testCreature.isAlive();

        testObj.enterTile(testCreature);

        assertEquals(prevHealth, testCreature.getHealth());
        assertEquals(prevInventory, testCreature.getInventory().length);
        assertEquals(prevAlive, testCreature.isAlive());
    }

    @Test
    void testExploreAndItemIsThere() {
        //creature picks up any item
        Tile testObj = new Tile(0,0,1,1);
        
        //TODO: Consider mocking this later?
        Item item = new Item();
        testObj.addItem(item);
        Item item2 = new Item();
        testObj.addItem(item2);

        Creature testCreature = new Creature();
        int prevHealth = testCreature.getHealth();
        int prevInventory = testCreature.getInventory().length;
        boolean prevAlive = testCreature.isAlive();
        
        testObj.explore(testCreature);

        assertEquals(prevHealth, testCreature.getHealth());
        assertEquals(prevAlive, testCreature.isAlive());

        //Creature picks up items
        assertEquals(prevInventory+2, testCreature.getInventory().length);
        assertEquals(0, testObj.items.size());
    }
}
