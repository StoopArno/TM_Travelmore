package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Transportmiddel;
import be.thomasmore.travelmore.domain.Type;
import be.thomasmore.travelmore.repository.TransportmiddelRepository;
import be.thomasmore.travelmore.repository.TypeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TransportmiddelService {

    @Inject
    private TransportmiddelRepository transportmiddelRepository;

    public Transportmiddel findTypeById(int id) {
        return transportmiddelRepository.findById(id);
    }

    public List<Transportmiddel> findAllType() {
        return transportmiddelRepository.findAll();
    }
}
