package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Type;
import be.thomasmore.travelmore.repository.LocatieRepository;
import be.thomasmore.travelmore.repository.TypeRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TypeService {

    @Inject
    private TypeRepository typeRepository;

    public Type findTypeById(int id) {
        return typeRepository.findById(id);
    }

    public List<Type> findAllType() {
        return typeRepository.findAll();
    }
}
