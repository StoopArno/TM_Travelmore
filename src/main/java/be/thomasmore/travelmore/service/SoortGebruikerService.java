package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.SoortGebruiker;
import be.thomasmore.travelmore.repository.SoortGebruikerRepository;
import javax.inject.Inject;
import java.util.List;

public class SoortGebruikerService {

    @Inject
    private SoortGebruikerRepository soortGebruikerRepository;

    public SoortGebruiker findSoortGebruikerById(int id) {
        return soortGebruikerRepository.findById(id);
    }

    public List<SoortGebruiker> findAllSoortGebruiker() {
        return soortGebruikerRepository.findAll();
    }

}
