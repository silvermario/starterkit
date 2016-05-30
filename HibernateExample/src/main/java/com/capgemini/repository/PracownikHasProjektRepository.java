package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.PracownikHasProjekt;
 
@Repository
@Transactional
public interface PracownikHasProjektRepository extends JpaRepository<PracownikHasProjekt, Integer> {
	
	@Query("select php from PracownikHasProjekt php join fetch php.pracownik p join fetch php.projekt pr "
			+ " where p.idPracownik like :idPracownik and php.dataZakonczenia is null")
	List<PracownikHasProjekt> findProjectsInWhichPracownikIsCurrentlyWorking(@Param("idPracownik") Integer idPracownik);

}
