package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.SoortTransport;
import be.thomasmore.travelmore.service.SoortTransportService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class SoortTransportController {

    private SoortTransport geselecteerdeSoortTransport = new SoortTransport();

    @Inject
    private SoortTransportService soortTransportService;

    public List<SoortTransport> getAllSoortTransport(){
        return this.soortTransportService.findAllSoortTransport();
    }

    public SoortTransport getSoortTransportByID(){
        return this.soortTransportService.findSoortTransportById(geselecteerdeSoortTransport.getId());
    }
}
