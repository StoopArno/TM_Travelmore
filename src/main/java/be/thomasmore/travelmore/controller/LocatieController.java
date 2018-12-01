package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name="LocatieController", eager = true)
@SessionScoped
public class LocatieController {

    private Locatie geselecteerdeLocatie = new Locatie();
    private int geselecteerdeId;

    @Inject
    private LocatieService locatieService;

    public List<Locatie> getLocaties(){
        return this.locatieService.findAllLocations();
    }

    public List<Locatie> getVertrekLocaties(){
        return this.locatieService.findAllVertrekLocaties();
    }

    public List<Locatie> getAankomstLocaties(){
        return this.locatieService.findAllAankomstLocaties();
    }

    public Locatie getLocatieByID(){
        return this.locatieService.findLocationById(geselecteerdeLocatie.getId());
    }

    public void updateLocatie(int locatieId, String naam, String stad, String code, String land){
        Locatie locatie = (locatieId == 0) ? new Locatie() : locatieService.findLocationById(locatieId);
        locatie.setNaam(naam);
        locatie.setStad(stad);
        locatie.setCode(code);
        locatie.setLand(land);
        if(locatieId == 0){locatieService.insert(locatie);}
            else{locatieService.update(locatie);}

    }

    public void newLocatie(){
        geselecteerdeLocatie = new Locatie();
        geselecteerdeLocatie.setId(0);
    }

    public Locatie getGeselecteerdeLocatie() {
        System.out.println("getgeselecteerdeLocatie naam: " + geselecteerdeLocatie.getNaam());
        return geselecteerdeLocatie;
    }
    public void setGeselecteerdeLocatie(Locatie geselecteerdeLocatie) {
        this.geselecteerdeLocatie = geselecteerdeLocatie;
    }

    public int getGeselecteerdeId() {
        System.out.println("get selected id: " + geselecteerdeId);
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        System.out.println("set selected id: " + geselecteerdeId);
        this.setGeselecteerdeLocatie(locatieService.findLocationById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }
}
