package main.java.dao;

import java.util.List;
import main.java.model.Pracownik;



public interface PracownikDao extends Dao<Pracownik, Long> {

		List<Pracownik> findPracownikByName(String name);
}

