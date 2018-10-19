package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Periode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PeriodeRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Periode findById(int id) {
        return entityManager.find(Periode.class, id);
    }

    public List<Periode> findAll() {
        return entityManager.createNamedQuery(Periode.FIND_ALL, Periode.class).getResultList();
    }
}
