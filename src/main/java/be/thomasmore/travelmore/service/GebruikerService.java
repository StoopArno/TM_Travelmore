package be.thomasmore.travelmore.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.SoortGebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;

    public Gebruiker findGebruikerById(int id) {
        return gebruikerRepository.findById(id);
    }
    public List<Gebruiker> findGebruikerByEmail(Gebruiker gebruiker) {
        return gebruikerRepository.findGeruikerByEmail(gebruiker);
    }
    public boolean insert(Gebruiker gebruiker){
        List<Gebruiker> gebruikers = gebruikerRepository.findGeruikerByEmail(gebruiker);
        if(gebruikers.size() == 0){
            gebruiker.setWachtwoord(hashPassword(gebruiker.getWachtwoord()));
            SoortGebruiker soort = new SoortGebruiker();
            soort.setId(1);
            soort.setSoort("gebruiker");
            gebruiker.setSoortGebruiker(soort);
            gebruikerRepository.insert(gebruiker);
            return true;
          }else{
            return false;
        }

    }
    private String hashPassword(String password){
        String passwordToHash = password;
        String hashPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            hashPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return hashPassword;
    }
    public boolean AuthenticateUser(Gebruiker gebruiker){
        List<Gebruiker> gebruikers =  gebruikerRepository.findGeruikerByEmail(gebruiker);
        if(gebruikers.size() != 0){
            if(hashPassword(gebruiker.getWachtwoord()).equals(gebruikers.get(0).getWachtwoord())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public List<Gebruiker> findAllLocations() {
        return gebruikerRepository.findAll();
    }

    public void update(Gebruiker gebruiker) { gebruikerRepository.update(gebruiker); }

    public void delete(int id){ gebruikerRepository.delete(id); }
}
