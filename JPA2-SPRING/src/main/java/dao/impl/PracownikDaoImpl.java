package main.java.dao.impl;

import main.java.dao.PracownikDao;
import main.java.model.Pracownik;

import javax.persistence.TypedQuery;
import java.util.List;

public class PracownikDaoImpl extends AbstractDao<Pracownik, Long> implements PracownikDao {

    @Override
    public List<Pracownik> findPracownikByName(String nazwisko) {
        TypedQuery<Pracownik> query = entityManager.createQuery(
                "select book from Pracownik book where upper(book.nazwisko) like concat(upper(:nazwisko), '%')", Pracownik.class);
        query.setParameter("nazwisko", nazwisko);
        return query.getResultList();
    }
}
