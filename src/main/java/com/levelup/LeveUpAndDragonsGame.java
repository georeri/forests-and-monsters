package com.levelup;

import com.levelup.creatures.Player;
import com.levelup.environment.Environment;
import com.levelup.environment.Environment.InvalidMoveException;

public class LeveUpAndDragonsGame {
    
    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 10;
    private static final int DEFAULT_PLAYER_STARTING_HEALTH = 1;
    
    //results structure to return without exposing too much implementation
    public class GameStatus {
        boolean isPlayerAlive = true;
        int playerHealth = DEFAULT_PLAYER_STARTING_HEALTH;
        String[] playerInventory = null;
        int turnsTaken = 0;
    }
    
    Environment environment;
    Player player;
    int turnsTaken = 0;


    public LeveUpAndDragonsGame() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public LeveUpAndDragonsGame(int environmentWidth, int environmentHeight) {
        //Create environment
        environment = new Environment(environmentWidth, environmentHeight);
        player = null;
    }

    public void registerPlayer(String playerName){
         //Create player
        player = new Player(playerName, environment.getTile(0,0), DEFAULT_PLAYER_STARTING_HEALTH);
    }

    public void takeTurn(Environment.DIRECTION directionToMove) throws InvalidMoveException{
        player.takeTurn(environment, directionToMove);
        turnsTaken++;
    }

    public GameStatus getStatus() {
        GameStatus status = new GameStatus();
        status.isPlayerAlive = player.isAlive();
        status.playerHealth = player.getHealth();
        status.playerInventory = player.printInventory();
        status.turnsTaken = this.turnsTaken;

        return status;
    }
}
