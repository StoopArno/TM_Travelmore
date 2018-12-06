package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Booking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BookingService;
import be.thomasmore.travelmore.service.MailService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.mail.MessagingException;
import java.awt.print.Book;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public  int aantalPlaatsenOver(int id) { return  this.bookingService.aantalPlaatsenOver(id);}

    public List<Booking> getReizenByUserId(int gebruikersID){
        List<Booking> test =  this.bookingService.findAllBookingsByUserId(gebruikersID);
        return test;
    }
    public String reserveerBooking(int gerbuikerId){
        Gebruiker gebruiker = gebruikerController.getGebruikerByID(gerbuikerId);
        nieuweBooking.setBetaald(false);
        nieuweBooking.setGebruiker(gebruikerController.getGebruikerByID(gerbuikerId));
        nieuweBooking.setReis(geslecteerdeReis);
        bookingService.insert(nieuweBooking);
        sendMail(gebruiker);
        nieuweBooking = new Booking();
        return "/gebruiker/boekingen";
    }
    public void navigateToBooken(int id) throws IOException {
        setGeslecteerdeReis(reisService.findReisById(id));
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.redirect("/travelmore/gebruiker/boeken.xhtml");
    }
    public String betaalReservatie(int bookingID){
        Booking booking = bookingService.findBookingById(bookingID);
        booking.setBetaald(true);
        bookingService.update(booking);

        return "/gebruiker/boekingen";
    }
    public String navigateToOverzichtBooking(){
        nieuweBooking.setPrijsPPTeBetalen(geslecteerdeReis.getPrijsPerPersoon());
        return "/gebruiker/overzichtBoeking";
    }
    public void sendMail(Gebruiker gebruiker){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String msg =
                "Beste " + gebruiker.getNaam() +
                        ", <br/>bedankt voor je boeking bij TravelMore! <br/><br/>Hier is je boeking:" +
                        " <br/><strong>Reis: </strong>" +
                        nieuweBooking.getReis().getVertrekLocatie().getLand() +",  "+nieuweBooking.getReis().getVertrekLocatie().getStad()+" "+nieuweBooking.getReis().getVertrekLocatie().getNaam()+
                        " -> " +
                        nieuweBooking.getReis().getAankomstLocatie().getLand() + ",  "+nieuweBooking.getReis().getAankomstLocatie().getStad()+ " "+nieuweBooking.getReis().getAankomstLocatie().getNaam()+
                        "<br/><strong>Datum: </strong>" + df.format(nieuweBooking.getReis().getAankomstTijd()) + " - " +df.format(nieuweBooking.getReis().getAankomstTijd()) +
                        "<br/><strong>Aantal personen: </strong>" + nieuweBooking.getAantalPersonen() + "<br/>" +
                        "<br/><strong>Prijs: </strong>" + nieuweBooking.getAantalPersonen() +" X "+ nieuweBooking.getPrijsPPTeBetalen() +" = " +nieuweBooking.getAantalPersonen() *nieuweBooking.getPrijsPPTeBetalen()   + "<br/>"
                ;

        try {
            MailService.send(gebruiker.getEmail(),"TravelMore | Booking",msg);
        }
        catch(MessagingException ex) {
        }
    }
    public String betaalBooking(int gerbuikerId){
        Gebruiker gebruiker = gebruikerController.getGebruikerByID(gerbuikerId);
        nieuweBooking.setBetaald(true);
        nieuweBooking.setGebruiker(gebruiker);
        nieuweBooking.setReis(geslecteerdeReis);
        bookingService.insert(nieuweBooking);
        sendMail(gebruiker);
        nieuweBooking = new Booking();
        return "/gebruiker/boekingen";
    }

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
