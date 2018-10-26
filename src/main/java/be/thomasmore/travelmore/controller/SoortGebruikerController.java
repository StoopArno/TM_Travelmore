package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.SoortGebruiker;
import be.thomasmore.travelmore.service.SoortGebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class SoortGebruikerController {

    private SoortGebruiker geselecteerdeSootrGebruiker = new SoortGebruiker();

    @Inject
    private SoortGebruikerService soortTransportService;

    public List<SoortGebruiker> getAllSoortGebruiker(){
        return this.soortTransportService.findAllSoortGebruiker();
    }

    public SoortGebruiker getSoortTransportByID(){
        return this.soortTransportService.findSoortGebruikerById(geselecteerdeSootrGebruiker.getId());
    }

}
