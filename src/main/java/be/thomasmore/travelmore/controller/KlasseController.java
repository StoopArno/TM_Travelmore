package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Klasse;
import be.thomasmore.travelmore.service.KlasseService;

import javax.inject.Inject;
import java.util.List;

public class KlasseController {

    private Klasse geselecteerdeKlasse = new Klasse();

    @Inject
    private KlasseService klasseService;

    public List<Klasse> getKlases(){
        return this.klasseService.findAllKlasses();
    }

    public Klasse getKlasseByID(){
        return this.klasseService.findKlasseById(geselecteerdeKlasse.getId());
    }
}
