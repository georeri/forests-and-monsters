package com.levelup.environment;

import java.util.ArrayList;
import java.util.List;

import com.levelup.creatures.Creature;
import com.levelup.items.Item;

public class Tile {
	
	int width;
	int height;
	int xPosition;
	int yPosition;

	List<Creature> creatures;
	List<Item> items;

	public Tile (int xPosition, int yPosition, int width, int height) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
		creatures = new ArrayList<Creature>();
		items = new ArrayList<Item>();
	}

	//TODO: If a monster is there, kill the creature entering
	public void enterTile(Creature creatureEnteringTile) {
		for (Creature creature : creatures) {
			creature.attack(creatureEnteringTile);
		}
	}

	//TODO: Explore picks up any items that are there and add to creature inventory
	public void explore(Creature creatureExploring) {
		for (Item item : items) {
			creatureExploring.addToInventory(item);
		}
		this.items = new ArrayList<Item>();
	}

	public void addCreature(Creature creature) {
		creatures.add(creature);
	}

	public void addItem(Item item) {
		items.add(item);
	}

}
