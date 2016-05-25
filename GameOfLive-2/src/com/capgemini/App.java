package com.capgemini;

import java.util.Scanner;

public class App {
	
	
	public static void main(String[] args) {
	
		Scanner reader = new Scanner(System.in);		
		
		GameOfLife gol = new GameOfLife(150, 40, 1000);
		
		// blinker
		gol.addCell(0, 3, CellState.ALIVE);
		gol.addCell(1, 3, CellState.ALIVE);
		gol.addCell(2, 3, CellState.ALIVE);
		// spaceship 1
		gol.addCell(6, 3, CellState.ALIVE);
		gol.addCell(6, 4, CellState.ALIVE);
		gol.addCell(6, 5, CellState.ALIVE);
		gol.addCell(5, 5, CellState.ALIVE);
		gol.addCell(4, 4, CellState.ALIVE);
		// spaceship 2
		gol.addCell(15, 3, CellState.ALIVE);
		gol.addCell(15, 4, CellState.ALIVE);
		gol.addCell(15, 5, CellState.ALIVE);
		gol.addCell(14, 5, CellState.ALIVE);
		gol.addCell(15, 4, CellState.ALIVE);
		// spaceship 3
		gol.addCell(19, 3, CellState.ALIVE);
		gol.addCell(19, 4, CellState.ALIVE);
		gol.addCell(19, 5, CellState.ALIVE);
		gol.addCell(18, 5, CellState.ALIVE);
		gol.addCell(19, 4, CellState.ALIVE);
		
		String execTime = "";
		int generation = 0;
		
		while(true) {
			
			gol.printGrid();
			System.out.println(execTime);
			System.out.println(generation + " generation");
			System.out.println("press q for quit, ENTER for next");
			
			String command = reader.nextLine();
			
			if(command.equals("q")){
				break;
			} else {
				long start = System.currentTimeMillis();
				
				gol.nextGeneration();
				
				
				long end = System.currentTimeMillis();
				execTime = ((end - start) + " ms");
				generation = (gol.getGenerationCount());
			}
		
		}

	}

}
