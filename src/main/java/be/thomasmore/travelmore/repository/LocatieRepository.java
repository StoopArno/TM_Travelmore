package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
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

    public List<Locatie> findAllVertrekLocaties(List<Integer> ids){
        return entityManager.createNamedQuery(Locatie.FIND_VERTREKLOCATIES, Locatie.class).setParameter("ids", ids).getResultList();
    }

    public List<Locatie> findAllAankomstLocaties(List<Integer> ids){
        return entityManager.createNamedQuery(Locatie.FIND_AANKOMSTLOCATIES, Locatie.class).setParameter("ids", ids).getResultList();
    }

    public void insert(Locatie locatie) {
        entityManager.persist(locatie);
    }


    public void update (Locatie locatie1) {
        entityManager.merge(locatie1);
    }
}
