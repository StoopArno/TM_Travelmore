package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Hotel;
import be.thomasmore.travelmore.repository.HotelRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class HotelService {

    @Inject
    private HotelRepository hotelRepository;

    public Hotel findHotelById(int id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public List<Hotel> findHotelsBySterren(int aantalSterren) {
        return hotelRepository.findBySterren(aantalSterren);
    }
    public List<Hotel> findHotelsByLocatie(int locatieId) {
        return hotelRepository.findByLocatie(locatieId);
    }
}
