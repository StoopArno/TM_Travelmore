package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class GebruikerController {

    private Gebruiker geselecteerdeGebruiker = new Gebruiker();

    @Inject
    private GebruikerService gebruikerService;

    public  Gebruiker getGebruikerByID(){
        return this.gebruikerService.findGebruikerById(geselecteerdeGebruiker.getId());
    }

}


