package com.levelup.creatures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.levelup.items.Item;

public class CreatureTest {
    @Test
    void testCreateCreature() {
        Creature testObj = new Creature();
        assertEquals(Creature.DEFAULT_CREATURE_ALIVE, testObj.isAlive());
        assertEquals(Creature.DEFAULT_CREATURE_NAME, testObj.getName());
        assertEquals(Creature.DEFAULT_CREATURE_HEALTH, testObj.getHealth());
        assertEquals(0, testObj.getInventory().length);
    }

    @Test
    void testAttack() {
        Creature testObj = new Creature();
        Creature target = new Creature();

        testObj.attack(target);

        //target dies, attacker takes no damage
        assertEquals(0, target.getHealth());
        assertEquals(false, target.isAlive());
        assertEquals(Creature.DEFAULT_CREATURE_HEALTH, testObj.getHealth());
        assertEquals(Creature.DEFAULT_CREATURE_ALIVE, testObj.isAlive());

    }

    @Test
    void testAddToInventory() {
        Creature testObj = new Creature();

        testObj.addToInventory(new Item());
        assertEquals(1, testObj.getInventory().length);        
    }

    @Test
    void testPrintInventory() {
        Creature testObj = new Creature();
        String testItem1Name = "TEST_ITEM1";
        String testItem2Name = "TEST_ITEM2";

        Item item1 = new Item(testItem1Name, 5);
        testObj.addToInventory(item1);
        Item item2 = new Item(testItem2Name, 10);
        testObj.addToInventory(item2);

        String[] inventoryStrings = testObj.printInventory();
        assertEquals(2, inventoryStrings.length);
        assertEquals(testItem1Name, inventoryStrings[0]);
        assertEquals(testItem2Name, inventoryStrings[1]);
    }

    @Test
    void testDamageWhenAboveZero() {
        Creature testObj = new Creature();
        testObj.health = 10;
        testObj.damage(9);

        assertEquals(1, testObj.getHealth());
    }

    @Test
    void testDamageWhenBelowZero() {
        Creature testObj = new Creature();
        testObj.health = 10;
        testObj.damage(21);

        assertEquals(0, testObj.getHealth());
    }

}
