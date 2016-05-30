package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Projekt;

 
@Repository
@Transactional
public interface ProjektRepository extends JpaRepository<Projekt, Integer> {
	
	@Query("select p from Projekt p where p.idProjekt like :idProjekt")
	Projekt findProjektById(@Param("idProjekt") Integer idProjekt);
	
	@Query("select p from Projekt p where p.nazwa like :nazwa")
	List<Projekt> findProjektByNazwa(@Param("nazwa") String nazwa);
	
	@Override
	@Query("select p from Projekt p")
	List<Projekt> findAll();
	
	@Override
	@Query("select p from Projekt p where p.idProjekt like :idProjekt")
	Projekt getOne(@Param("idProjekt") Integer idProjekt);
	
	
}
