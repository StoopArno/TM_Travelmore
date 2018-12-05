package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Booking;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.BookingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BookingService {

    @Inject
    private BookingRepository bookingRepository;
    @Inject
    private ReisService reisService;

    public Booking findBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findAllBookingsByUserId(int gebruikersID){
        return bookingRepository.findAllByUserId(gebruikersID);
}

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    public  int aantalPlaatsenOver(int id) {return  bookingRepository.countPlaatsen(id);}

    public void insert(Booking booking){
        bookingRepository.insert(booking);
    }
    public void update(Booking booking){bookingRepository.update(booking);}
}