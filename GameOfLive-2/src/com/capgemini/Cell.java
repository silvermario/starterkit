package com.capgemini;

public class Cell {
	
	public final int x;
	public final int y;
	public CellState state;

	public Cell(int x, int y, CellState state) {
		this.x = x;
		this.y = y;
		this.state = state;		
	}
	
	public CellState getState() {
		return state;
	}

	public void setState(CellState state) {
		this.state = state;
	}
	
	@Override
    public final boolean equals (Object obj)    
    {
        Cell p = (Cell) obj;
        return x == p.x && y == p.y && state == p.state;
    }
    
    @Override
    public final int hashCode ()
    {
        return x * 3 + y * 5;
    }
    
    @Override
    public String toString ()
    {
        return "(" + x + "," + y + " "+ state + " )";
    }

}
