package com.capgemini;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.model.Pracownik;
import com.capgemini.model.Projekt;
import com.capgemini.repository.PracownikHasProjektRepository;
import com.capgemini.repository.PracownikRepository;
import com.capgemini.repository.ProjektRepository;
import com.capgemini.model.PracownikHasProjekt;
import com.capgemini.service.ProjektService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring/applicationContext.xml")
@Sql( "/DML-script.sql" )
public class ProjektServiceTest {

	@Autowired
	private ProjektService projektService;
	
	@Autowired
	private ProjektRepository projektRepository;
	
	@Autowired
	private PracownikHasProjektRepository pracownikHasProjektRepository;
	
	@Autowired
	private PracownikRepository pracownikRepository; 

	@Test
	public void testShouldCreateProjekt() {
		// given
		Projekt projekt = new Projekt();
		String nazwa = "Nowy Projekt";
		projekt.setNazwa(nazwa);
		// when
		projektService.createNewProjekt(projekt);
		// then
		List<Projekt> foundProjekt = projektRepository.findProjektByNazwa(nazwa);
		assertEquals(nazwa, foundProjekt.get(0).getNazwa());
	}
	
	@Test
	public void testShouldAddPracownikToProjekt(){
		// given
		Projekt projekt = projektRepository.findProjektByNazwa("StarterKit").get(0);
		Pracownik pracownik = pracownikRepository.findPracownikById(3);
		// when
		PracownikHasProjekt pracownikToProjekt = new PracownikHasProjekt();
		pracownikToProjekt.setDataRozpoczecia(new Date());
		pracownikToProjekt.setPracownik(pracownik);
		pracownikToProjekt.setProjekt(projekt);
		pracownikToProjekt.setRola("DEV");
		pracownikToProjekt.setStawkaDzienna(200.50);
		projektService.addPracownikToProjekt(pracownikToProjekt);
		// then
		List<PracownikHasProjekt> listOfProjects = pracownikHasProjektRepository.findProjectsInWhichPracownikIsCurrentlyWorking(pracownik.getIdPracownik());
		assertEquals(1, listOfProjects.size());		
	}
	
	@Test
	public void testShouldRemovePracownikFromProjekt(){
		//given
		Pracownik pracownik = pracownikRepository.findPracownikById(1);
		List<PracownikHasProjekt> listOfProjectsPracownikCurrentlyWorks = pracownikHasProjektRepository.findProjectsInWhichPracownikIsCurrentlyWorking(pracownik.getIdPracownik());
		int countBeforeRemoval = listOfProjectsPracownikCurrentlyWorks .size();
		// when
		projektService.removePracownikFromProjekt(listOfProjectsPracownikCurrentlyWorks.get(0));
		// then
		List<PracownikHasProjekt> listOfProjectsPracownikCurrentlyWorksAfterRemoval = pracownikHasProjektRepository.findProjectsInWhichPracownikIsCurrentlyWorking(pracownik.getIdPracownik());
		int countAfterRemoval = listOfProjectsPracownikCurrentlyWorksAfterRemoval .size();
		assertEquals(2, countBeforeRemoval);
		assertEquals(1, countAfterRemoval);
	}
	

}
