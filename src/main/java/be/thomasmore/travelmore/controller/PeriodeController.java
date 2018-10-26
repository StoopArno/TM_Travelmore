package be.thomasmore.travelmore.controller;


import be.thomasmore.travelmore.domain.Periode;
import be.thomasmore.travelmore.service.PeriodeService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class PeriodeController {

    private Periode geselecteerdePeriode = new Periode();

    @Inject
    private PeriodeService periodeService;

    public List<Periode> getLocaties(){
        return this.periodeService.findAllPeriodes();
    }

    public Periode getPeriodeByID(){
        return this.periodeService.findPeriodeById(geselecteerdePeriode.getId());
    }
}
