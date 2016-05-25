package main.java.services;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import main.java.exceptions.NonexistentEntityException;

import main.java.model.Dzial;
import main.java.model.Pracownik;

public class PracownikServiceImpl  {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA2");

	public void addPracownik(Date dataUrodzenia, String imie, String nazwisko, String pesel, int idDzial) {

		EntityManager em = emf.createEntityManager();
		try {

			Pracownik pracownik = new Pracownik();
			pracownik.setDataUrodzenia(dataUrodzenia);
			pracownik.setImie(imie);
			pracownik.setNazwisko(nazwisko);
			pracownik.setPesel(pesel);

			try {
				Dzial dzial = em.getReference(Dzial.class, idDzial);
				pracownik.setDzial(dzial);
			} catch (EntityNotFoundException enfe) {
				//System.out.println("The dzial with id " + idDzial + " doesn't exists.");
				throw new NonexistentEntityException("The pracownik with id " + idDzial + " no longer exists.", enfe);
			}

			em.getTransaction().begin();
			em.persist(pracownik);
			em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			em.close();
		}
		
	}

	public void deletePracownik(int id) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Pracownik pracownik = null;

			try {
				pracownik = em.getReference(Pracownik.class, id);
				pracownik.getIdPracownik();
				em.remove(pracownik);
				em.getTransaction().commit();
			} catch (EntityNotFoundException enfe) {
				System.out.println("The pracownik with id " + id + " no longer exists.");
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public void editPracownik(int id) {
		// TODO Auto-generated method stub

	}

}
