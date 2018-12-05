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

    public List<Reis> findAllReizenByUserBookings(int gebruikersID){
        List<Booking> bookings= bookingRepository.findAllByUserId(gebruikersID);
        List<Reis> output = new ArrayList<>();
        for(Booking item:bookings ){
            output.add(reisService.findReisById(item.getReis().getId()));
        }
        return output;
}

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    public void insert(Booking booking){
        bookingRepository.insert(booking);
    }
}