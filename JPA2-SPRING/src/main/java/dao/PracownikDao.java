package main.java.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.java.model.Pracownik;


@Transactional
public interface PracownikDao extends Dao<Pracownik, Long> {

		List<Pracownik> findPracownikByName(String name);
}

