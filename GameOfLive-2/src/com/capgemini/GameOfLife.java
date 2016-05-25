package com.capgemini;

import java.util.HashMap;

public class GameOfLife {

	private HashMap<Cell, Integer> cellSet = new HashMap<>();
	private final int width;
	private final int height;
	private int generation = 0;
	private final Pair[] offsetValues =   {new Pair( 1,  1),
										   new Pair( 1,  0),
										   new Pair( 1, -1), 
										   new Pair( 0,  1), 
										   new Pair( 0, -1), 
										   new Pair(-1,  1), 
										   new Pair(-1,  0),
										   new Pair(-1, -1)};

	public GameOfLife(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public GameOfLife(int width, int height, int cellCount) {
		this.width = width;
		this.height = height;		
		
		for(int i=0; i < cellCount; i++){
			int randomX = (int )(Math.random() * width + 1) -1;
			int randomY = (int )(Math.random() * height + 1) -1;
			addCell(randomX, randomY);			
		}		
	}
		
	private void addCell(int x, int y, CellState state, HashMap<Cell, Integer> map) {
		if(!outOfGridBounds(x, y)){
			map.put(new Cell(x, y, state), 0);
		}
	}
	
	public void addCell(int x, int y, CellState state) {
		if(!outOfGridBounds(x, y)){
			cellSet.put(new Cell(x, y, state), 0);
		}
	}		

	public void addCell(int x, int y) {
		addCell(x, y, CellState.ALIVE);
	}
	
	
	/**
	 * 
	 * for testing purposes
	 */
	public String printCellsInfo() {
		String grid = "";
		for (Cell c : cellSet.keySet()) {
			grid += "Cell x: " + c.x + ", y: " + c.y + ", neighbours: " + cellSet.get(c) + "\n";
		}
		return grid;
	}
	

	public void printGrid() {
		String grid = getGrid();
		System.out.println(grid);
	}
	
	
	public String getGrid() {		
		StringBuilder grid = getEmptyGrid();
		StringBuilder gridWithCells = paintCellsOnGrid(grid);		

		return gridWithCells.toString();
	}	
	
	/**
	 * 
	 * @return String representing an empty grid
	 */
	private StringBuilder getEmptyGrid() {
		int gridLength = width * height;
		StringBuilder grid = new StringBuilder(gridLength);

		int i = 0;
		while (i < gridLength) {
			if (i >= width && i % width == 0) {
				grid.append("\n");
			}
			grid.append(".");
			i++;
		}
		return grid;
	}
	
	/**
	 * 
	 * @return String representing a grid with ALIVE cells
	 */
	private StringBuilder paintCellsOnGrid(StringBuilder grid) {
		for (Cell c : cellSet.keySet()) {
			if (c.getState() == CellState.ALIVE) {
				int index = (c.y) * (width + 1) + c.x;
				grid.setCharAt(index, '#');
			}
		}
		return grid;
	}
	
	/**
	 * Adds DEAD cells around all ALIVE cells, which could become resurrected in this generation
	 */
	private void addDeadCellsAroundLiveCells(){
		HashMap<Cell, Integer> tempDeadCellSet = new HashMap<>();
		for(Cell c: cellSet.keySet()){
			if (c.getState() == CellState.ALIVE) {				
				for (Pair offset : offsetValues) {
					if(!cellExist(c.x + offset.x, c.y + offset.y, CellState.ALIVE)) {
						addCell(c.x + offset.x, c.y + offset.y, CellState.DEAD, tempDeadCellSet);
					}
		        }
			}
		}
		cellSet.putAll(tempDeadCellSet);
		tempDeadCellSet.clear();
		
	}
	

	private int countNeighbours(Cell cell) {

		int count = 0;
		int xCoord = cell.x;
		int yCoord = cell.y;
		
		for (Pair offset : offsetValues) {
           	count += (cellExist(xCoord + offset.x, yCoord + offset.y, CellState.ALIVE)) ? 1 : 0;
        }		
		
		return count;
	}

	
	private boolean cellExist(int xCoord, int yCoord, CellState state) {
		if(!outOfGridBounds(xCoord, yCoord)) {
			Integer value = cellSet.get(new Cell(xCoord, yCoord, state));
            if (value != null) {
                return true;
            } else {
            	return false;
            }
		} else {
			return false;			
		}
	}
	
	/**
	 * 
	 * @param xCoord
	 * @param yCoord
	 * @return true if the (x,y) coordinates are in the grid boundaries, false otherwise
	 */
	private boolean outOfGridBounds(int xCoord, int yCoord){
		if(xCoord >= 0 && xCoord < width && yCoord >=0 && yCoord < height){
			return false;
		} else {
			return true;
		}
			
	}
	
	private void calculateAllCellsNeighbours(){
		HashMap<Cell, Integer> tempDeadCellSet = new HashMap<>();
		
		for (Cell c : cellSet.keySet()) {
			cellSet.put(c, countNeighbours(c) );					
		}		
	}
	
	public String nextGeneration(){
		addDeadCellsAroundLiveCells();
		calculateAllCellsNeighbours();		
		
		HashMap<Cell, Integer> tempCellSet = new HashMap<>();
		
		for (Cell c : cellSet.keySet()) {
			int neighboursCount = cellSet.get(c);
			if(c.getState() == CellState.ALIVE){
				if(neighboursCount == 2 || neighboursCount == 3){
					tempCellSet.put(new Cell(c.x,c.y, CellState.ALIVE), neighboursCount );
				}				
			} else {
				if(neighboursCount == 3){
					tempCellSet.put(new Cell(c.x,c.y, CellState.ALIVE), neighboursCount );
				}
			}
		}
		this.cellSet = tempCellSet;
		generation++;		
		return "done";
	}

	public int getGenerationCount() {
		return generation;
	}
	
	@Override
	public String toString() {		
		return getGrid();		
	}

}
