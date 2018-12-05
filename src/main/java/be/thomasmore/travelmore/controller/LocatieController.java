package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import java.util.List;

@ManagedBean(name="LocatieController", eager = true)
@SessionScoped
public class LocatieController {

    private Locatie geselecteerdeLocatie = new Locatie();

    private Locatie locatie = new Locatie();

    private int geselecteerdeId;

    @Inject
    private LocatieService locatieService;

    public List<Locatie> getLocaties(){
        return this.locatieService.findAllLocaties();
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

    public void voegLocatieToe(){
        this.locatieService.insert(locatie);
    }

    public Locatie getLocatie() {
        return locatie;
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

    public void deleteLocatie(int locatieId){
        locatieService.delete(locatieId);
    }

    public Locatie getGeselecteerdeLocatie() {
        return geselecteerdeLocatie;
    }
    public void setGeselecteerdeLocatie(Locatie geselecteerdeLocatie) {
        this.geselecteerdeLocatie = geselecteerdeLocatie;
    }

    public int getGeselecteerdeId() {
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        this.setGeselecteerdeLocatie(locatieService.findLocationById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }
}
