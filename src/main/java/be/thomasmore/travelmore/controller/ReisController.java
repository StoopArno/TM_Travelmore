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
    public  String vertrekTijdZoek;

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
        List<Reis> reizen =  getReizen();
        Collections.shuffle(reizen);
        List<Reis> randomReizen = reizen.subList(0, 3);
        return randomReizen;
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



    public void updateReis(int reisId, int vertrekLocatieId, int aankomstLocatieId, double prijsPerPersoon, String transportmiddel, int plaatsen, String foto){
        Reis reis = (reisId == 0) ? new Reis() : reisService.findReisById(reisId);
        reis.setVertrekLocatie(locatieService.findLocationById(vertrekLocatieId));
        reis.setAankomstLocatie(locatieService.findLocationById(aankomstLocatieId));
        //reis.setVertrekTijd(vertrekTijd);
        //reis.setAankomstTijd(aankomstTijd);
        reis.setPrijsPerPersoon(prijsPerPersoon);
        reis.setTransportmiddel(transportmiddel);
        reis.setPlaatsen(plaatsen);
        reis.setFoto(foto);
        if(reisId == 0){reisService.insert(reis);}
        else{reisService.update(reis);}
        newReis();
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

    public Date formatStringToDate(String date, String time){
        Date newDate = new Date();
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setTimeZone(SimpleTimeZone.getTimeZone(("GMT")));
            newDate = format.parse(date);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return newDate;
    }

    /*    public Reis getReisByID(){
        return this.reisService.findReisById(geselecteerdeReis.getId());
    }*/
}
