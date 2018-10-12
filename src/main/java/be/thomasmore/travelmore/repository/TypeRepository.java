package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TypeRepository {


    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Type findById(int id) {
        return entityManager.find(Type.class, id);
    }

    public List<Type> findAll() {
        return entityManager.createNamedQuery(Type.FIND_ALL, Type.class).getResultList();
    }


}
