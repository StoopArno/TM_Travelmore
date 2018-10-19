package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HotelRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Hotel findById(int id) {
        return entityManager.find(Hotel.class, id);
    }

    public List<Hotel> findAll() {
        return entityManager.createNamedQuery(Hotel.FIND_ALL, Hotel.class).getResultList();
    }

    public List<Hotel> findBySterren(int aantalSterren) {
        return entityManager.createNamedQuery(Hotel.FIND_BY_STERREN, Hotel.class).setParameter("aantalSterren", aantalSterren).getResultList();
    }

    public List<Hotel> findByLocatie(int locatieId) {
        return entityManager.createNamedQuery(Hotel.FIND_BY_LOCATIE, Hotel.class).setParameter("locatieId", locatieId).getResultList();
    }
}
