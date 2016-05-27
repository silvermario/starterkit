package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Pracownik;
import com.capgemini.repository.PracownikRepository;
import com.capgemini.service.PracownikService;


@Service
@Transactional
public class PracownikServiceImpl implements PracownikService {

	@Autowired
	private PracownikRepository pracownikRepository;
	
	@Override
	public Pracownik findPracownikById(Integer id) {

		return pracownikRepository.findPracownikById(id);
	}

	@Override
	public List<Pracownik> findAll() {

		return pracownikRepository.findAll();
	}

	@Override
	public Pracownik addPracownik() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePracownik(Pracownik pracownik, String nazwisko) {

		//Pracownik pracownikToUpdate = pracownikRepository.;
		//pracownikToUpdate.setNazwisko(pracownik.getNazwisko());
		pracownik.setNazwisko("xxxxxxxx");
		pracownikRepository.save(pracownik);
		
	}
	
	

}
