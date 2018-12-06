package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name="GebruikerController")
@SessionScoped
public class GebruikerController  {

    private Gebruiker gebruiker = new Gebruiker();
    private Gebruiker aangemeldeGebruiker = new Gebruiker();
    private Gebruiker geselecteerdeGebruiker = new Gebruiker();
    private int geselecteerdeId;
    private Boolean isAangemeld = false;

    @Inject
    private GebruikerService gebruikerService;

    public  Gebruiker getGebruikerByID(int id){
        return this.gebruikerService.findGebruikerById(id);
    }
    public String registreerGebruiker(){
        if(this.gebruikerService.insert(gebruiker)){
            gebruiker = new Gebruiker();
            return "/bezoeker/login";

        }else{
            return "/index";
        }

    }
    public String admin(){
        if(aangemeldeGebruiker.getSoortGebruiker().getId() == 2){
            return "/admin/boekingen";
        }else {
            return "/index";
        }
    }
    public String gegevens(){
        return "gebruiker/gegevens";
    }
    public String logout(){
        setAangemeldeGebruiker(null);
        setAangemeld(false);
        return "/index";
    }
    public String login(){
        if(this.gebruikerService.AuthenticateUser(gebruiker)){
            setAangemeldeGebruiker(this.gebruikerService.findGebruikerByEmail(gebruiker).get(0));
            setAangemeld(true);
            if(aangemeldeGebruiker.getSoortGebruiker().getId() == 1){
                return "/index";
            }
            else{
                return "/admin/boekingen";
            }

        }else{
            return "/login";
        }
    }
    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Boolean getAangemeld() {
        return isAangemeld;
    }

    public void setAangemeld(Boolean aangemeld) {
        isAangemeld = aangemeld;
    }

    public Gebruiker getAangemeldeGebruiker() {
        return aangemeldeGebruiker;
    }

    public void setAangemeldeGebruiker(Gebruiker aangemeldeGebruiker) {
        this.aangemeldeGebruiker = aangemeldeGebruiker;
    }

    public Gebruiker getGeselecteerdeGebruiker() {
        return geselecteerdeGebruiker;
    }
    public void setGeselecteerdeGebruiker(Gebruiker geselecteerdeGebruiker) {
        this.geselecteerdeGebruiker = geselecteerdeGebruiker;
    }

    public int getGeselecteerdeId() {
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        this.setGeselecteerdeGebruiker(gebruikerService.findGebruikerById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }

    public List<Gebruiker> getGebruikers(){
        return gebruikerService.findAllGebruikers();
    }

    public void newGebruiker(){
        geselecteerdeGebruiker = new Gebruiker();
        geselecteerdeGebruiker.setId(0);
    }

    public void updateGebruiker(int gebruikerId, String voornaam, String achternaam, String adres, String gemeente, String email){
        geselecteerdeGebruiker = (gebruikerId == 0) ? new Gebruiker() : gebruikerService.findGebruikerById(gebruikerId);
        geselecteerdeGebruiker.setVoornaam(voornaam);
        geselecteerdeGebruiker.setAchternaam(achternaam);
        geselecteerdeGebruiker.setAdres(adres);
        geselecteerdeGebruiker.setGemeente(gemeente);
        geselecteerdeGebruiker.setEmail(email);
        if(gebruikerId == 0){
            geselecteerdeGebruiker.setWachtwoord("wachtwoord");
            gebruikerService.insert(geselecteerdeGebruiker);
        }
        else{
            gebruikerService.update(geselecteerdeGebruiker);
        }
        newGebruiker();
    }

    public void deleteGebruiker(int id){
        gebruikerService.delete(id);
    }
}


