package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Pracownik;
import com.capgemini.repository.PracownikRepository;
import com.capgemini.service.PracownikService;


@Transactional
@Service("pracownikService")
public class PracownikServiceImpl implements PracownikService {

	@Autowired
	private PracownikRepository pracownikRepository;
	
	@Override
	public Pracownik findPracownikById(Integer id) {

		return pracownikRepository.findPracownikById(id);
	}	

	@Override
	public List<Pracownik> findPracownikByNazwisko(String nazwisko) {
		
		return pracownikRepository.findPracownikByNazwisko(nazwisko);
	}
	

	@Override
	public List<Pracownik> findAll() {

		return pracownikRepository.findAll();
	}

	@Override
	public Pracownik addPracownik(Pracownik pracownik) {
		pracownikRepository.save(pracownik);
		return pracownik;
	}
	

	@Override
	public Pracownik updatePracownik(Pracownik pracownik) {
		//Pracownik pracownikToUpdate = pracownikRepository.findPracownikById(id);
		pracownikRepository.save(pracownik);
		return pracownik;		
	}


}
