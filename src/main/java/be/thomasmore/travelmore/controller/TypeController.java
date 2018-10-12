package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Type;
import be.thomasmore.travelmore.service.LocatieService;
import be.thomasmore.travelmore.service.TypeService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TypeController {

    private Type geselecteerdeType = new Type();

    @Inject
    private TypeService typeService;

    public List<Type> getTypes(){
        return this.typeService.findAllType();
    }

    public Type getTypeByID(){
        return this.typeService.findTypeById(geselecteerdeType.getId());
    }
}
