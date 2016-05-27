package com.capgemini;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "application-context-test.xml")
//@Sql( "/DML-script.sql" )
public class PracownikServiceTest {

	@Autowired
	private PracownikService pracownikService;
	
	@Autowired
	private PracownikRepository pracownikRepository; 

	@Test
	@Ignore
	public void testShouldFindPracownik() {
		// given
		//List<Pracownik> empList = pracownikService.findPracownikById(1);
		List<Pracownik> empList = pracownikService.findPracownikById(1);
		// when
		int numberOfEmp = empList.size();
		// then
		assertEquals(1, numberOfEmp);
	}
	
	@Test
	public void testShouldUpdatePracownik() {
		// given
		Integer id = 1;
		Pracownik pracownikKowalski =  pracownikService.findPracownikById(1);
		// when
		//System.out.println(pracownikKowalski.getNazwisko());
		pracownikKowalski.setNazwisko("XXXXX");
		pracownikKowalski.setImie("Stefan");
		pracownikKowalski.setPesel("99999909999");
		//System.out.println(pracownikKowalski.getNazwisko());
		//pracownikService.updatePracownik(pracownikKowalski, "Nowakowski");
		pracownikRepository.save(pracownikKowalski);
		// then
		assertEquals("XXXXX", pracownikRepository.getOne(id).getNazwisko());		
	}
	
	@Test
	public void shouldAddPracownik() {
		Pracownik pracownik = new Pracownik();
		pracownik.setImie("Jurek");
		pracownik.setDataUrodzenia(new Date());
		pracownik.setNazwisko("Ogórek");
		pracownik.setPesel("82020203345");
		pracownikRepository.save(pracownik);
	}
}
