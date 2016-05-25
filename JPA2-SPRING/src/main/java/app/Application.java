package main.java.app;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import main.java.exceptions.NonexistentEntityException;
import main.java.model.Pracownik;
import main.java.model.PracownikHasProjekt;
//import main.java.services.PracownikServices.CreatePracownik;
import main.java.dao.impl.PracownikDaoImpl;

public class Application {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)   {
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA2");
        EntityManager em = emf.createEntityManager();
       */ 
        /*Query q1 = em.createQuery("SELECT p FROM Pracownik p");
        List<Pracownik> listaPracownikow = q1.getResultList();
       
        for(Pracownik p: listaPracownikow){
        	System.out.println(p.getImie());
        	System.out.println(p.getNazwisko());
        	System.out.println(p.getDataUrodzenia());
        }
        
        
        Pracownik pierwszy = em.find(Pracownik.class, 1);
        pierwszy.getPracownikHasProjekts().toString();*/
        
        //new CreatePracownik( new Date(90, 1,1) , "Jacek", "Kokot", "82020253367", 55);	
        
		PracownikDaoImpl pracownikDaoImpl = new PracownikDaoImpl();
		System.out.println(pracownikDaoImpl.findAll());
        
		
	}

	

}
