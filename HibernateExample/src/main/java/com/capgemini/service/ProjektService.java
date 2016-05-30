package com.capgemini.service;

import com.capgemini.model.PracownikHasProjekt;
import com.capgemini.model.Projekt;

public interface ProjektService {
	
	public Projekt createNewProjekt(Projekt projekt);
	
	public PracownikHasProjekt addPracownikToProjekt(PracownikHasProjekt pracownikHasProjekt);
	
	public void removePracownikFromProjekt(PracownikHasProjekt pracownikHasProjekt);

}
