package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GebruikerRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public void insert(Gebruiker gebruiker) {
        entityManager.persist(gebruiker);
    }

}
