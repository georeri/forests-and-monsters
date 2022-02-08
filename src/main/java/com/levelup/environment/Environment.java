package com.levelup.environment;

public class Environment {

	static final String MOVE_IS_NOT_POSSIBLE_ERROR_MESSAGE = "Current tile at edge of board. That move is not possible";
	static final String MOVE_WITH_UNKNOWN_DIRECTION_ERROR_MESSAGE = "Move direction not recognized. Must be DIRECTION enum.";

	public class InvalidMoveException extends Exception { 
		public InvalidMoveException(String errorMessage) {
			super(errorMessage);
		}
	}
	
	Tile[][] tiles;

	public static enum DIRECTION {
		NORTH, SOUTH, EAST, WEST
	}
	

	//First iteration - all squares are 1x1
	final int TILE_HEIGHT = 1;
	final int TILE_WIDTH = 1;
	int ENVIRONMENT_HEIGHT;
	int ENVIRONMENT_WIDTH;

	//TODO: As tiles are generated, put random items and creatures in them
	public Environment(int height, int width) {
		//Create a space with the number of tiles specified, connected together
		//looks like this (where top is north, right is east): 
		/* 	[0,2][1,2][2,2]
			[0,1][1,1][2,1]
			[0,0][1,0][2,0] */

		ENVIRONMENT_HEIGHT = height;
		ENVIRONMENT_WIDTH = width;

		tiles = new Tile[ENVIRONMENT_WIDTH][ENVIRONMENT_HEIGHT];

		for (int y = 0; y < ENVIRONMENT_HEIGHT; y++)
		{
			for (int x = 0; x < ENVIRONMENT_WIDTH; x++){
				tiles[x][y] = new Tile(x, y, TILE_HEIGHT, TILE_WIDTH);
			}
		}
	}

	//TODO: Handle dimensions outside the array
	public Tile getTile(int xDimension, int yDimension){
		return tiles[xDimension][yDimension];
	}

	public Tile getTileMovedTo(Tile currentTile, DIRECTION directionToMove) throws InvalidMoveException {
		//if move isn't possible, throw exception
		if(!isMovePossible(currentTile, directionToMove)){
			throw new InvalidMoveException(MOVE_IS_NOT_POSSIBLE_ERROR_MESSAGE);
		}

		switch(directionToMove) {
			case NORTH:
				return tiles[currentTile.xPosition][currentTile.yPosition + 1];
			case SOUTH:
				return tiles[currentTile.xPosition][currentTile.yPosition - 1];
			case EAST:
				return tiles[currentTile.xPosition+1][currentTile.yPosition];
			case WEST:
				return tiles[currentTile.xPosition-1][currentTile.yPosition];
			default:
				//Pretty sure ENUM makes it impossible to get here but...ah well
				throw new InvalidMoveException(MOVE_WITH_UNKNOWN_DIRECTION_ERROR_MESSAGE);
		}

	}

	public boolean isMovePossible(Tile currentTile, DIRECTION directionToMove) {
		if(currentTile.yPosition == 0 && directionToMove ==  DIRECTION.SOUTH ){
			//Can't move south at bottom of board
			return false;
		}
		if(currentTile.yPosition == (ENVIRONMENT_HEIGHT-1) && directionToMove ==  DIRECTION.NORTH ){
			//Can't move north at top of board
			return false;
		}
		if(currentTile.xPosition == 0 && directionToMove ==  DIRECTION.WEST ){
			//Can't move west at left of board
			return false;
		}
		if(currentTile.xPosition == ENVIRONMENT_WIDTH-1 && directionToMove ==  DIRECTION.EAST ){
			//Can't move east at right of board
			return false;
		}

		//all other moves valid
		return true;
	}

	
}
