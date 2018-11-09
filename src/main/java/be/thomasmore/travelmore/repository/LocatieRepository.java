package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocatieRepository {


    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Locatie findById(int id) {
        return entityManager.find(Locatie.class, id);
    }

    public List<Locatie> findAll() {
        return entityManager.createNamedQuery(Locatie.FIND_ALL, Locatie.class).getResultList();
    }

    public void insert(Locatie locatie) {
        entityManager.persist(locatie);
        entityManager.flush();
    }

    public void delete(int id) {
        Locatie locatie = entityManager.find(Locatie.class, id);
        entityManager.remove(locatie);
    }

    public void update (Locatie locatie1) {
        //Locatie locatie = entityManager.find(Locatie.class, locatie1.getId());
        //locatie.setNaam(locatie.getNaam());
        entityManager.merge(locatie1);
    }
}
