package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.LocatieRepository;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocatieService {

    @Inject
    private LocatieRepository locatieRepository;

    @Inject
    private ReisRepository reisRepository;

    public Locatie findLocationById(int id) {
        return locatieRepository.findById(id);
    }

    public List<Locatie> findAllLocations() {
        return locatieRepository.findAll();
    }

    public List<Locatie> findAllVertrekLocaties() {

        return  locatieRepository.findAllVertrekLocaties(reisRepository.findVertrekLocatieIds());
    }

    public List<Locatie> findAllAankomstLocaties() {

        return  locatieRepository.findAllAankomstLocaties(reisRepository.findAankomstLocatieIds());
    }
}
