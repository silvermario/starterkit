package main.java.services.PracownikServices;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.exceptions.NonexistentEntityException;

import main.java.model.Dzial;
import main.java.model.Pracownik;

@Repository
@Transactional
public class CreatePracownik implements JpaRepository<Pracownik, Integer> {	
	
	@PersistenceContext
    protected EntityManager em;

	public CreatePracownik(Date dataUrodzenia, String imie, String nazwisko, String pesel, int idDzial) {

		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA2");
		EntityManager em = emf.createEntityManager();*/
		
		
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

	@Override
	public Page<Pracownik> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pracownik arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Pracownik> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pracownik findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pracownik> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pracownik> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Pracownik> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Pracownik> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pracownik> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pracownik> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pracownik> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pracownik> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pracownik> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Pracownik> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Pracownik> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pracownik getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pracownik> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pracownik> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

}
