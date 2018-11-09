package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocatieService {

    @Inject
    private LocatieRepository locatieRepository;

    public Locatie findLocationById(int id) {
        return locatieRepository.findById(id);
    }

    public List<Locatie> findAllLocations() {
        return locatieRepository.findAll();
    }

    public void insert(Locatie locatie) { locatieRepository.insert(locatie); }

    public void delete(int id) { locatieRepository.delete(id); }

    public void update(Locatie locatie){ locatieRepository.update(locatie); }
}
