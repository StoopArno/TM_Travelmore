package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Periode;
import be.thomasmore.travelmore.repository.PeriodeRepository;

import javax.inject.Inject;
import java.util.List;

public class PeriodeService {

    @Inject
    private PeriodeRepository periodeRepository;

    public Periode findPeriodeById(int id) {
        return periodeRepository.findById(id);
    }

    public List<Periode> findAllPeriodes() {
        return periodeRepository.findAll();
    }
}
