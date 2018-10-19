package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.SoortGebruiker;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;

public class SoortGebruikerRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public SoortGebruiker findById(int id) {
        return entityManager.find(SoortGebruiker.class, id);
    }

    public List<SoortGebruiker> findAll() {
        return entityManager.createNamedQuery(SoortGebruiker.FIND_ALL, SoortGebruiker.class).getResultList();
    }
}
