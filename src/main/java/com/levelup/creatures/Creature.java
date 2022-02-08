package com.levelup.creatures;

import java.util.ArrayList;
import java.util.List;

import com.levelup.items.Item;

public class Creature {
    
    static final boolean DEFAULT_CREATURE_ALIVE = true;
    static final int DEFAULT_CREATURE_HEALTH = 1;
    static final String DEFAULT_CREATURE_NAME = "CREATURE";
    boolean alive;
    String name;
    int health;

    List<Item> inventory;

    public Creature() {
        alive = DEFAULT_CREATURE_ALIVE;
        name = DEFAULT_CREATURE_NAME;
        health = DEFAULT_CREATURE_HEALTH;
        inventory = new ArrayList<Item>();
    }

    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int damageAmount) {
        this.health = health - damageAmount;
        if (health < 0) {
            health = 0;
        }
    }

    public Item[] getInventory() {
        return inventory.toArray(new Item[0]);
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public String[] printInventory() {
        String[] inventoryStrings = new String[inventory.size()];
        for (int i = 0; i < inventory.size(); i++) {
            inventoryStrings[i] = inventory.get(i).getName();
        }

        return inventoryStrings;
    }

    //Iteration 1 = auto zero out strength of target
    public void attack(Creature target) {
        target.health = 0;
        target.alive = false;
    }

}
