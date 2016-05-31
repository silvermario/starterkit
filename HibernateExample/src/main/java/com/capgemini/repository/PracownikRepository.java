package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Pracownik;

 
@Repository
@Transactional
public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {
	
	@Query("select p from Pracownik p where p.idPracownik like :idPracownik")
	Pracownik findPracownikById(@Param("idPracownik") Integer idPracownik);
	
	@Query("select p from Pracownik p where p.nazwisko like :nazwisko")
	List<Pracownik> findPracownikByNazwisko(@Param("nazwisko") String nazwisko);
	
	@Override
	@Query("select p from Pracownik p")
	List<Pracownik> findAll();
	
	@Override
	@Query("select p from Pracownik p where p.idPracownik like :idPracownik")
	Pracownik getOne(@Param("idPracownik") Integer idPracownik);
	
}
