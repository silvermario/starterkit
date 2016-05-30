package com.capgemini;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.model.Pracownik;
import com.capgemini.model.Dzial;
import com.capgemini.model.Projekt;
import com.capgemini.repository.PracownikRepository;
import com.capgemini.model.PracownikHasProjekt;
import com.capgemini.service.PracownikService;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring/applicationContext.xml")
@Sql( "/DML-script.sql" )
public class PracownikServiceTest {

	@Autowired
	private PracownikService pracownikService;
	
	@Autowired
	private PracownikRepository pracownikRepository; 

	@Test
	public void testShouldFindPracownik() {
		// given
		Pracownik pracownik = pracownikService.findPracownikById(1);
		// when
		String nazwisko = pracownik.getNazwisko();
		// then
		assertEquals("Kowalski", nazwisko);
	}
	
	@Test
	public void testShouldUpdatePracownik() {
		// given
		Integer id = 2;
		Pracownik pracownikKowalski =  pracownikService.findPracownikById(id);
		// when
		pracownikKowalski.setNazwisko("Nowaks");
		pracownikService.updatePracownik(pracownikKowalski);
		// then
		assertEquals("Nowaks", pracownikRepository.getOne(id).getNazwisko());		
	}
	
	@Test
	public void testShouldAddPracownik() {
		//given
		Pracownik pracownik = new Pracownik();
		Date date = new Date();
		String imie = "Marek";
		String nazwisko = "Jurek";
		String pesel = "12345678910";		
		// when
		pracownik.setImie(imie);
		pracownik.setNazwisko(nazwisko);
		pracownik.setDataUrodzenia(date);
		pracownik.setPesel(pesel);
		pracownikService.addPracownik(pracownik);
		// then
		assertEquals("Jurek",	pracownikRepository.findPracownikByNazwisko(nazwisko).get(0).getNazwisko());
	}
}
