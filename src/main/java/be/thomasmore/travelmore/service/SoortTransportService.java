package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.SoortTransport;
import be.thomasmore.travelmore.repository.SoortTransportRepository;

import javax.inject.Inject;
import java.util.List;

public class SoortTransportService {

    @Inject
    private SoortTransportRepository soortTransportRepository;

    public SoortTransport findSoortTransportById(int id) {
        return soortTransportRepository.findById(id);
    }

    public List<SoortTransport> findAllSoortTransport() {
        return soortTransportRepository.findAll();
    }
}
