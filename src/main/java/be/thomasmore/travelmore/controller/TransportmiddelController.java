package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.service.TransportmiddelService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TransportmiddelController {

    private Transportmiddel geselecteerdeTransportmiddel = new Transportmiddel();

    @Inject
    private TransportmiddelService transportmiddelService;

    public List<Transportmiddel> getTransportmiddels(){
        return this.transportmiddelService.findAllType();
    }

    public Transportmiddel getTransportmiddelByID(){
        return this.transportmiddelService.findTypeById(geselecteerdeTransportmiddel.getId());
    }
}
