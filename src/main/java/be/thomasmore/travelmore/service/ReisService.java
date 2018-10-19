package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ReisService {

    @Inject
    private ReisRepository reisRepository;

    public Reis findReisById(int id) {
        return reisRepository.findById(id);
    }

    public List<Reis> findAllReis() {
        return reisRepository.findAll();
    }
}
