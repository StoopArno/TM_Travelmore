package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReisRepository {


    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Reis findById(int id) {
        return entityManager.find(Reis.class, id);
    }

    public List<Reis> findAll() {
        return entityManager.createNamedQuery(Reis.FIND_ALL, Reis.class).getResultList();
    }

   // public List<Reis> findAllVertrekLocaties() {
   //     return entityManager.createNamedQuery(Reis.FIND_ALLVERTREKLOCATIES, Reis.class).getResultList();
   // }

    public List<Integer> findVertrekLocatieIds(){
        return entityManager.createNamedQuery(Reis.FIND_ALLVERTREKLOCATIEIDS, Integer.class).getResultList();
    }

    public List<Integer> findAankomstLocatieIds(){
        return entityManager.createNamedQuery(Reis.FIND_ALLAANKOMSTLOCATIEIDS, Integer.class).getResultList();
    }

    public void update (Reis reis) {
        entityManager.merge(reis);
    }

    public void insert(Reis reis) {
        entityManager.persist(reis);
        entityManager.flush();
    }

    public void delete(int id) {
        Reis locatie = entityManager.find(Reis.class, id);
        entityManager.remove(locatie);
    }

}
