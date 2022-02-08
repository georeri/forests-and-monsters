package com.levelup.creatures;

import com.levelup.environment.Environment;
import com.levelup.environment.Tile;

public class Player extends Creature {

    Tile currentLocation;

    public Player(String playerName, Tile startingLocation, int startingHealth) {
        super();
        this.currentLocation = startingLocation;
        this.alive = true;
        this.name = playerName;
        this.health = startingHealth;
    }
    
    public void takeTurn(Environment environment, Environment.DIRECTION directionToMove) throws Environment.InvalidMoveException{
        //Iteration 1 - move NSEW, then trigger environment
        currentLocation = environment.getTileMovedTo(currentLocation, directionToMove);
        currentLocation.enterTile(this);
        currentLocation.explore(this);
    }
}
