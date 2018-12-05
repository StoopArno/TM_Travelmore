package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Booking;
import be.thomasmore.travelmore.service.BookingService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "BookingController")
@ViewScoped
public class BookingController {

    private Booking geselecteerdeBooking = new Booking();
    private int geselecteerdeId;


    @Inject
    private BookingService bookingService;

    public List<Booking> getBookingen(){
        return this.bookingService.findAllBookings();
    }

    public Booking getBookingByID(){
        return this.bookingService.findBookingById(geselecteerdeBooking.getId());
    }

    public  int aantalPlaatenOver(int id) { return  this.bookingService.aantalPlaatsenOver(id);}

    public Booking getGeselecteerdeBooking() {
        return geselecteerdeBooking;
    }
    public void setGeselecteerdeBooking(Booking geselecteerdeBooking) {
        this.geselecteerdeBooking = geselecteerdeBooking;
    }
    public String navigateToBooken(){
        return "/gebruiker/booken";
    }
    public int getGeselecteerdeId() {
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        this.setGeselecteerdeBooking(bookingService.findBookingById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }
}
