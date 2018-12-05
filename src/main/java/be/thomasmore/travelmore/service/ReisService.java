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

    public List<Reis> filterReisVertrekLocatie(String value) {return  reisRepository.FilterVertreklocatie(value);}

    public List<Reis> filterReisAankomstLocatie(String value) {return  reisRepository.FilterAankomstlocatie(value);}

    public List<Reis> filterReisAantalPlaatsen(String value) {return  reisRepository.FilterAantalPlaatsen(value);}

    public List<Reis> filterReisPrijsPerPersoon(String value) {return  reisRepository.FilterPrijsPerPersoon(value);}

    public List<Reis> filterReisTransportmiddel(String value) {return  reisRepository.FilterTransportmiddel(value);}

    public void insert(Reis reis) { reisRepository.insert(reis); }

    public void delete(int id) { reisRepository.delete(id); }

    public void update(Reis reis){ reisRepository.update(reis); }

}
