package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Booking;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BookingService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.awt.print.Book;
import java.util.List;

@ManagedBean(name = "BookingController")
@SessionScoped
public class BookingController {
    private Reis geslecteerdeReis = new Reis();
    private Booking geselecteerdeBooking = new Booking();
    private Booking nieuweBooking = new Booking();
    private int geselecteerdeId;


    @Inject
    private BookingService bookingService;
    @Inject
    private GebruikerController gebruikerController;
    @Inject
    private ReisService reisService;

    public List<Booking> getBookingen(){
        return this.bookingService.findAllBookings();
    }

    public Booking getBookingByID(){
        return this.bookingService.findBookingById(geselecteerdeBooking.getId());
    }

    public List<Booking> getReizenByUserId(int gebruikersID){
        return this.bookingService.findAllBookingsByUserId(gebruikersID);
    }

    public String navigateToBooken(int id){
        setGeslecteerdeReis(reisService.findReisById(id));
        return "/gebruiker/booken";
    }
    public String navigateToOverzichtBooking(){
        nieuweBooking.setPrijsPPTeBetalen(geslecteerdeReis.getPrijsPerPersoon());
        return "/gebruiker/overzichtBooking";
    }
    public String betaalBooking(int gerbuikerId){
        nieuweBooking.setBetaald(true);
        nieuweBooking.setGebruiker(gebruikerController.getGebruikerByID(gerbuikerId));
        nieuweBooking.setReis(geslecteerdeReis);
        bookingService.insert(nieuweBooking);
        return "/index";
    }



    //GETTERS en SETTERS
    public Booking getGeselecteerdeBooking() {
        return geselecteerdeBooking;
    }
    public void setGeselecteerdeBooking(Booking geselecteerdeBooking) {
        this.geselecteerdeBooking = geselecteerdeBooking;
    }
    public int getGeselecteerdeId() {
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        this.setGeselecteerdeBooking(bookingService.findBookingById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }
    public Reis getGeslecteerdeReis() {
        return geslecteerdeReis;
    }

    public void setGeslecteerdeReis(Reis geslecteerdeReis) {
        this.geslecteerdeReis = geslecteerdeReis;
    }

    public Booking getNieuweBooking() {
        return nieuweBooking;
    }

    public void setNieuweBooking(Booking nieuweBooking) {
        this.nieuweBooking = nieuweBooking;
    }
}
