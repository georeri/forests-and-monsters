
package com.levelup.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.levelup.environment.Environment.InvalidMoveException;

import org.junit.jupiter.api.BeforeEach;

public class EnvironmentTest {
    
    int startingX = 2;
    int startingY = 3;
    int arbitraryTileSize = 1;
    int environmentSizeToEnsureWeDoNotHitABorder = 5;
    
    Environment testObj;
    Tile startingTile;

    @BeforeEach
    public void setUp() {

        startingTile = new Tile(startingX,startingY,arbitraryTileSize,arbitraryTileSize);
        testObj = new Environment(environmentSizeToEnsureWeDoNotHitABorder,environmentSizeToEnsureWeDoNotHitABorder);
    }

    @Test
    public void getTileMovedTo_North() throws Exception {
        //Move North 1 space
        Tile newTile = testObj.getTileMovedTo(startingTile, Environment.DIRECTION.NORTH);
        assertEquals(startingY+1,newTile.yPosition);
        assertEquals(startingX,newTile.xPosition);
    }

    @Test
    public void getTileMovedTo_South() throws Exception {
        //Move South 1 space
        Tile newTile = testObj.getTileMovedTo(startingTile, Environment.DIRECTION.SOUTH);
        assertEquals(startingY-1,newTile.yPosition);
        assertEquals(startingX,newTile.xPosition);
    }

    @Test
    public void getTileMovedTo_East() throws Exception {
        //Move South 1 space
        Tile newTile = testObj.getTileMovedTo(startingTile, Environment.DIRECTION.EAST);
        assertEquals(startingY,newTile.yPosition);
        assertEquals(startingX+1,newTile.xPosition);
    }


    @Test
    public void getTileMovedTo_West() throws Exception {
        //Move South 1 space
        Tile newTile = testObj.getTileMovedTo(startingTile, Environment.DIRECTION.WEST);
        assertEquals(startingY,newTile.yPosition);
        assertEquals(startingX-1,newTile.xPosition);
    }

    @Test
    public void getTileMovedTo_NorthernBorder() {
        //set tile at border
        Tile newTile = startingTile;
        try {
            newTile = testObj.getTileMovedTo(startingTile, Environment.DIRECTION.NORTH);
        }
        catch (InvalidMoveException ie) {
            fail("Setup move hit border too soon.");
        }

        //assertThrows didn't like this unless it was a final var
        final Tile testTile = newTile;

        InvalidMoveException e = assertThrows(InvalidMoveException.class, () -> {
            testObj.getTileMovedTo(testTile, Environment.DIRECTION.NORTH);
        });

        assertEquals(Environment.MOVE_IS_NOT_POSSIBLE_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void getTileMovedTo_SouthernBorder() {
        //set tile at border
        final Tile testTile = testObj.getTile(startingX, 0);

        InvalidMoveException e = assertThrows(InvalidMoveException.class, () -> {
            testObj.getTileMovedTo(testTile, Environment.DIRECTION.SOUTH);
        });

        assertEquals(Environment.MOVE_IS_NOT_POSSIBLE_ERROR_MESSAGE, e.getMessage());
    }

    @Test
    public void getTileMovedTo_EasternBorder() {
        //set tile at border
        final Tile testTile = testObj.getTile(testObj.ENVIRONMENT_WIDTH-1, startingY);

        InvalidMoveException e = assertThrows(InvalidMoveException.class, () -> {
            testObj.getTileMovedTo(testTile, Environment.DIRECTION.EAST);
        });

        assertEquals(Environment.MOVE_IS_NOT_POSSIBLE_ERROR_MESSAGE, e.getMessage());
    }


    @Test
    public void getTileMovedTo_WesternBorder() {
        //set tile at border
        final Tile testTile = testObj.getTile(0, startingY);

        InvalidMoveException e = assertThrows(InvalidMoveException.class, () -> {
            testObj.getTileMovedTo(testTile, Environment.DIRECTION.WEST);
        });

        assertEquals(Environment.MOVE_IS_NOT_POSSIBLE_ERROR_MESSAGE, e.getMessage());
    }

}