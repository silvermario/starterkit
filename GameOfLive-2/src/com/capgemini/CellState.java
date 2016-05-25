package com.capgemini;

public enum  CellState {
	DEAD(0), ALIVE(1);
	
	private final int state;
	
	private CellState(int state) {
		this.state = state;
	}
	
	public int intValue(){
		return state;
	}

	

}
