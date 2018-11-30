package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Booking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookingRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Booking findById(int id) {
        return entityManager.find(Booking.class, id);
    }

    public Booking findByBookingHashCode(String bookingHashCode) {
        return entityManager.find(Booking.class, bookingHashCode);
    }

    public List<Booking> findAll() {
        return entityManager.createNamedQuery(Booking.FIND_ALL, Booking.class).getResultList();
    }

    public void insert(Booking booking) {
        entityManager.persist(booking);
    }

}

