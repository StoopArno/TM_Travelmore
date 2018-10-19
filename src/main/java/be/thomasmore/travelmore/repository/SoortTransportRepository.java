package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.SoortTransport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SoortTransportRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public SoortTransport findById(int id) {
        return entityManager.find(SoortTransport.class, id);
    }

    public List<SoortTransport> findAll() {
        return entityManager.createNamedQuery(SoortTransport.FIND_ALL, SoortTransport.class).getResultList();
    }

}
