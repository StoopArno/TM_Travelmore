package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Booking;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.lang.System;

public class BookingRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Booking findById(int id) {
        return entityManager.find(Booking.class, id);
    }

    public int countPlaatsen(int id)
    {
        Query aantalplaatsenquery = entityManager.createNamedQuery(Booking.COUNTPLAATSEN);
        aantalplaatsenquery.setParameter("id", id );
        List<Integer> listAantalplaatsenQuery = aantalplaatsenquery.getResultList();
        int aantalplaatsenbezet = 0;
        for (int i: listAantalplaatsenQuery
             ) {
                aantalplaatsenbezet += i;
        }
       // System.out.println(aantalplaatsenbezet);
        return aantalplaatsenbezet;

        }

    public Booking findByBookingHashCode(String bookingHashCode) {
        return entityManager.find(Booking.class, bookingHashCode);
    }
    public List<Booking> findAllByUserId(int id) {
        return entityManager.createNamedQuery(Booking.FIND_BY_USER_ID, Booking.class).setParameter("id",id).getResultList();
    }
    public List<Booking> findAll() {
        return entityManager.createNamedQuery(Booking.FIND_ALL, Booking.class).getResultList();
    }

    public void insert(Booking booking) {
        entityManager.persist(booking);
    }

}

