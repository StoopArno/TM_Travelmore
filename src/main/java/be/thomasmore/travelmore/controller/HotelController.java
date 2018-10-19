package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Hotel;
import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.HotelService;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class HotelController {

    private Hotel geselecteerdeHotel = new Hotel();
    private int aantalSterren = 0;
    private Locatie geselecteerdeLocatie = new Locatie();

    @Inject
    private HotelService hotelService;

    public List<Hotel> getHotels(){
        return this.hotelService.findAllHotels();
    }

    public Hotel getHotelByID(){
        return this.hotelService.findHotelById(geselecteerdeHotel.getId());
    }
    public List<Hotel> getHotelsByLocatie(){
        return this.hotelService.findHotelsByLocatie(geselecteerdeLocatie.getId());
    }
    public List<Hotel> getHotelsBySterren(){
        return this.hotelService.findHotelsBySterren(aantalSterren);
    }
}
