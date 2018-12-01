package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean(name="GebruikerController")
@SessionScoped
public class GebruikerController {

    private Gebruiker gebruiker = new Gebruiker();
    private Gebruiker aangemeldeGebruiker = new Gebruiker();
    private Boolean isAangemeld = false;

    @Inject
    private GebruikerService gebruikerService;

    public  Gebruiker getGebruikerByID(){
        return this.gebruikerService.findGebruikerById(getGebruiker().getId());
    }
    public String registreerGebruiker(){
        if(this.gebruikerService.insert(gebruiker)){
            gebruiker = new Gebruiker();
            return "/index";

        }else{
            return "nav";
        }

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
            return "/index";

        }else{
            return "nav";
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
}


