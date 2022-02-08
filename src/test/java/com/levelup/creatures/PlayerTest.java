package com.levelup.creatures;

import com.levelup.environment.Environment;
import com.levelup.environment.Tile;
import com.levelup.environment.Environment.InvalidMoveException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {
    @Mock
    Tile tileMock;

    @Mock
    Environment envMock;

    Player testObj;
    String playerName = "Player";
    int startingHealth = 10; 

    @BeforeEach
    void setUp() {
        testObj = new Player(playerName, tileMock, startingHealth);
    }

    @Test
    void testCreatePlayer() {
        assertEquals(testObj.currentLocation, tileMock);
        assertEquals(true, testObj.isAlive());
        assertEquals(playerName, testObj.getName());
        assertEquals(startingHealth, testObj.getHealth());
    }

    @Test
    void testTakeTurn() throws InvalidMoveException{
        //need to do some interaction based testing 
        when(envMock.getTileMovedTo(Mockito.any(Tile.class), Mockito.any(Environment.DIRECTION.class))).thenReturn(tileMock);

        testObj.takeTurn(envMock, Environment.DIRECTION.NORTH);
        verify(tileMock, Mockito.times(1)).enterTile(testObj);
        verify(tileMock, Mockito.times(1)).explore(testObj);
        verifyNoMoreInteractions(tileMock);

    }
}

