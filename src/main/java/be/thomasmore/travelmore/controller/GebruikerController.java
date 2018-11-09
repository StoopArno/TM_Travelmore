package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class GebruikerController {

    private Gebruiker gebruiker = new Gebruiker();

    @Inject
    private GebruikerService gebruikerService;

    public  Gebruiker getGebruikerByID(){
        return this.gebruikerService.findGebruikerById(getGebruiker().getId());
    }
    public void registreerGebruiker(){
        System.out.println("Gebruiker - e-mail: " + gebruiker.getEmail());
        System.out.println("Gebruiker - password: " + gebruiker.getWachtwoord());
        this.gebruikerService.insert(gebruiker);
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }
}


