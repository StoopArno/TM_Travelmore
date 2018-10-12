package be.thomasmore.travelmore.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.inject.Inject;

public class GebruikerService {
    @Inject
    private GebruikerRepository gebruikerRepository;

    public void insert(Gebruiker gebruiker){
        String passwordToHash = gebruiker.getWachtwoord();
        String hashPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
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
        gebruiker.setWachtwoord("");
        gebruikerRepository.insert(gebruiker);
    }
}
