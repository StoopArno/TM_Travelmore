package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Type;
import be.thomasmore.travelmore.service.ReisService;
import be.thomasmore.travelmore.service.TypeService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReisController {

    private Reis geselecteerdeReis = new Reis();

    @Inject
    private ReisService reisService;

    public List<Reis> getTypes(){
        return this.reisService.findAllReis();
    }

    public Reis getTypeByID(){
        return this.reisService.findReisById(geselecteerdeReis.getId());
    }
}
