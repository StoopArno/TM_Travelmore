package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Booking;
import be.thomasmore.travelmore.service.BookingService;

import javax.inject.Inject;
import java.util.List;

public class BookingController {

    private Booking geselecteerdeBooking = new Booking();


    @Inject
    private BookingService bookingService;

    public List<Booking> getBooking(){
        return this.bookingService.findAllBookings();
    }

    public Booking getBookingByID(){
        return this.bookingService.findBookingById(geselecteerdeBooking.getId());
    }

}
