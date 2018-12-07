package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.LocatieService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ManagedBean(name="ReisController", eager = true)
@SessionScoped
public class ReisController {

    private Reis geselecteerdeReis = new Reis();
    private int geselecteerdeId;
    public String geselecteerdeFilter;
    public String filterTekst;
    public String vertrekTijdZoek;
    public List<Reis> sugestieList = new ArrayList<>();
    public int sugestieRequests = 0;

    public String getAankomstTijdZoek() {
        return aankomstTijdZoek;
    }

    public void setAankomstTijdZoek(String aankomstTijdZoek) {
        this.aankomstTijdZoek = aankomstTijdZoek;
    }

    public String aankomstTijdZoek;

    public String getVertrekTijdZoek() {
        return vertrekTijdZoek;
    }

    public void setVertrekTijdZoek(String vertrekTijdZoek) {
        this.vertrekTijdZoek = vertrekTijdZoek;
    }

    public String getLocatieZoek() {
        return locatieZoek;
    }

    public void setLocatieZoek(String locatieZoek) {
        this.locatieZoek = locatieZoek;
    }

    public String locatieZoek;


    @Inject
    private ReisService reisService;
    @Inject
    private LocatieService locatieService;

    public static boolean isNumeric(String str)
    {
        try{
            double d = Double.parseDouble(str.trim());
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public  List<Reis> getRandomReizen(){
        if (sugestieList.isEmpty() || sugestieRequests == 5){
            List<Reis> reizen =  getReizen();
            if (!reizen.isEmpty()){
                Collections.shuffle(reizen);
                sugestieList = reizen.subList(0, 3);
                sugestieRequests = 0;
                return sugestieList;
            } else{
                return sugestieList;
            }
        } else {
            sugestieRequests ++;
            return sugestieList;
        }
    }

    public  List<Reis> getFilterToepassen(){
        if (geselecteerdeFilter == null || geselecteerdeFilter.equals("0") || filterTekst == null  || filterTekst.equals("")){
            return getReizen();
        }else if(this.geselecteerdeFilter.equals("1")){
            return getReizenFilterByVertrekLocatie(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("2")){
            return getReizenFilterByAankomstLocatie(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("3")){
            return getReizenFilterByTransportmiddel(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("4") && isNumeric(filterTekst)){
            return getReizenFilterByAantalPlaatsen(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("5") && isNumeric(filterTekst)){
            return getReizenFilterByPrijsPerPersoon(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("6")){
            return getReizenFilterByAankomstTijd(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("7")){
            return getReizenFilterByVertrekTijd(filterTekst.trim());
        }else if(this.geselecteerdeFilter.equals("8")){
            return this.reisService.reisZoeken(locatieZoek,vertrekTijdZoek,aankomstTijdZoek);
        }else {
           return getReizen();
        }

    }



    public void submitFilter(){
        getFilterToepassen();
    }


    public String getFilterTekst() {
        return filterTekst;
    }

    public void setFilterTekst(String filterTekst) {
        this.filterTekst = filterTekst;
    }

    public String getGeselecteerdeFilter() {
        return geselecteerdeFilter;
    }

    public void setGeselecteerdeFilter(String geselecteerdeFilter) {
        this.geselecteerdeFilter = geselecteerdeFilter;
    }

    public  List<Reis> getReizen() {return this.reisService.findAllReis();}

    public  List<Reis> getReizenFilterByVertrekLocatie(String value) {return this.reisService.filterReisVertrekLocatie(value);}

    public  List<Reis> getReizenFilterByAankomstLocatie(String value) {return this.reisService.filterReisAankomstLocatie(value);}

    public  List<Reis> getReizenFilterByAantalPlaatsen(String value) {return this.reisService.filterReisAantalPlaatsen(value);}

    public  List<Reis> getReizenFilterByPrijsPerPersoon(String value) {return this.reisService.filterReisPrijsPerPersoon(value);}

    public  List<Reis> getReizenFilterByTransportmiddel(String value) {return this.reisService.filterReisTransportmiddel(value);}

    public  List<Reis> getReizenFilterByVertrekTijd(String value) {return this.reisService.filterReisVertrekTijd(value);}

    public  List<Reis> getReizenFilterByAankomstTijd(String value) {return this.reisService.filterReisAankomstTijd(value);}

    public  String  zoekReizen() {

        geselecteerdeFilter = "8";
        filterTekst =" ";

        return "/bezoeker/reizen";
    }



    public void updateReis(int vertrekLocatieId, int aankomstLocatieId){
        geselecteerdeReis.setVertrekLocatie(locatieService.findLocationById(vertrekLocatieId));
        geselecteerdeReis.setAankomstLocatie(locatieService.findLocationById(aankomstLocatieId));
        if (geselecteerdeReis.getId() == 0) {
            reisService.insert(geselecteerdeReis);
        } else {
            reisService.update(geselecteerdeReis);
        }
    }

    public void newReis(){
        geselecteerdeReis = new Reis();
        geselecteerdeReis.setId(0);
    }

    public void deleteReis(int reisId){
        reisService.delete(reisId);
    }

    public Reis getGeselecteerdeReis() {
        return geselecteerdeReis;
    }
    public void setGeselecteerdeReis(Reis geselecteerdeReis) {
        this.geselecteerdeReis = geselecteerdeReis;
    }

    public int getGeselecteerdeId() {
        if(geselecteerdeReis == null){
            geselecteerdeReis = new Reis();
        }
        return geselecteerdeId;
    }
    public void setGeselecteerdeId(int geselecteerdeId) {
        this.setGeselecteerdeReis(reisService.findReisById(geselecteerdeId));
        this.geselecteerdeId = geselecteerdeId;
    }


    /*    public Reis getReisByID(){
        return this.reisService.findReisById(geselecteerdeReis.getId());
    }*/
}
