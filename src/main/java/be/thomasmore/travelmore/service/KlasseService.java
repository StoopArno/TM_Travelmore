package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Klasse;
import be.thomasmore.travelmore.repository.KlasseRepository;
import javax.inject.Inject;
import java.util.List;

public class KlasseService {

    @Inject
    private KlasseRepository klasseRepository;

    public Klasse findKlasseById(int id) {
        return klasseRepository.findById(id);
    }

    public List<Klasse> findAllKlasses() { return klasseRepository.findAll(); }
}
