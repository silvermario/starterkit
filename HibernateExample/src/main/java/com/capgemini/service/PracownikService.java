package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Pracownik;


public interface PracownikService {
	
	public Pracownik findPracownikById(Integer id_pracownik);

	public List<Pracownik> findPracownikByNazwisko(String nazwisko);
	
	public List<Pracownik> findAll();
	
	public Pracownik addPracownik(Pracownik pracownik);
	
	public Pracownik updatePracownik(Pracownik pracownik);
	

}
