package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.LocatieService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ManagedBean(name="ReisController", eager = true)
@SessionScoped
public class ReisController {

    private Reis geselecteerdeReis = new Reis();
    private int geselecteerdeId;

    @Inject
    private ReisService reisService;
    @Inject
    private LocatieService locatieService;

    public List<Reis> getReizen(){
        return this.reisService.findAllReis();
    }

    public void updateReis(int reisId, int vertrekLocatieId, int aankomstLocatieId, double prijsPerPersoon, String transportmiddel, int plaatsen){
        System.out.println(reisId + " " + vertrekLocatieId + " " + aankomstLocatieId + " " + prijsPerPersoon + " " + transportmiddel + " " + plaatsen);
        Reis reis = (reisId == 0) ? new Reis() : reisService.findReisById(reisId);
        reis.setVertrekLocatie(locatieService.findLocationById(vertrekLocatieId));
        reis.setAankomstLocatie(locatieService.findLocationById(aankomstLocatieId));
        reis.setPrijsPerPersoon(prijsPerPersoon);
        reis.setTransportmiddel(transportmiddel);
        reis.setPlaatsen(plaatsen);
        if(reisId == 0){reisService.insert(reis);}
        else{reisService.update(reis);}
        newReis();
    }

    public void newReis(){
        geselecteerdeReis = new Reis();
        geselecteerdeReis.setId(0);
    }

    public void deleteReis(int reisId){
        reisService.delete(reisId);
    }

    public Reis getGeselecteerdeReis() {
        return geselecteerdeReis;
    }
    public void setGeselecteerdeReis(Reis geselecteerdeReis) {
        this.geselecteerdeReis = geselecteerdeReis;
    }

    public int getGeselecteerdeId() {
        if(geselecteerdeReis == null){
            geselecteerdeReis = new Reis();
        }
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        this.setGeselecteerdeReis(reisService.findReisById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }

    /*    public Reis getReisByID(){
        return this.reisService.findReisById(geselecteerdeReis.getId());
    }*/
}
