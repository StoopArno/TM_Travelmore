package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocatieController {

    private Locatie geselecteerdeLocatie = new Locatie();

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
}
