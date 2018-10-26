package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker findById(int id) {
        return entityManager.find(Gebruiker.class, id);
    }

    public void insert(Gebruiker gebruiker) {
        entityManager.persist(gebruiker);
    }

}
