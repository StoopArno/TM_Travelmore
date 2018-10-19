package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Klasse;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class KlasseRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Klasse findById(int id) {
        return entityManager.find(Klasse.class, id);
    }

    public List<Klasse> findAll() {
        return entityManager.createNamedQuery(Klasse.FIND_ALL, Klasse.class).getResultList();
    }
}
