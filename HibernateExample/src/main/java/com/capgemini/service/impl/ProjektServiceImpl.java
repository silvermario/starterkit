package com.capgemini.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.PracownikHasProjekt;
import com.capgemini.model.Projekt;
import com.capgemini.repository.PracownikHasProjektRepository;
import com.capgemini.repository.ProjektRepository;
import com.capgemini.service.ProjektService;

@Transactional
@Service("projektService")
public class ProjektServiceImpl implements ProjektService {
	
	@Autowired
	ProjektRepository projektRepository;
	
	@Autowired
	PracownikHasProjektRepository pracownikHasProjektRepository;

	@Override
	public Projekt createNewProjekt(Projekt projekt) {
		return projektRepository.save(projekt);
	}
	
	@Override
	public PracownikHasProjekt addPracownikToProjekt(PracownikHasProjekt pracownikHasProjekt) {
		return pracownikHasProjektRepository.save(pracownikHasProjekt);
	}

	@Override
	public PracownikHasProjekt removePracownikFromProjekt(PracownikHasProjekt pracownikHasProjekt) {
		pracownikHasProjekt.setDataZakonczenia(new Date());
		return pracownikHasProjektRepository.save(pracownikHasProjekt);
	}

}
