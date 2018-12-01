package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean(name="GebruikerController")
@SessionScoped
public class GebruikerController {

    private Gebruiker gebruiker = new Gebruiker();
    private Boolean isAangemeld = false;

    @Inject
    private GebruikerService gebruikerService;

    public  Gebruiker getGebruikerByID(){
        return this.gebruikerService.findGebruikerById(getGebruiker().getId());
    }
    public String registreerGebruiker(){
        if(this.gebruikerService.insert(gebruiker)){
            return "login";
        }else{
            return "fout";
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
}


