package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ReisRepository {


    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;


    public Reis findById(int id) {
        return entityManager.find(Reis.class, id);
    }

    public List<Reis> findAll() {
        return entityManager.createNamedQuery(Reis.FIND_ALL, Reis.class).getResultList();
    }

   // public List<Reis> findAllVertrekLocaties() {
   //     return entityManager.createNamedQuery(Reis.FIND_ALLVERTREKLOCATIES, Reis.class).getResultList();
   // }


    public  List<Reis> FilterVertreklocatie(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERVERTREKLOCATIE);
        return filterLocatie.setParameter("naam",   value.toLowerCase() ).getResultList();}

    public  List<Reis> FilterAankomstlocatie(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERAANKOMSTLOCATIE);
        return filterLocatie.setParameter("naam",   value.toLowerCase() ).getResultList();}

    public  List<Reis> FilterAantalPlaatsen(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FIND_ALL);
        List<Reis> listReizen = filterLocatie.getResultList();
        List<Reis> listfiltered = new ArrayList<Reis>();
        for (Reis r : listReizen) {
            if (r.getPlaatsen() >= Integer.parseInt(value)) {
                listfiltered.add(r);
            }
        }
        return listfiltered;
    }

    public  List<Reis> FilterPrijsPerPersoon(String value) {
        Query filterLocatie = entityManager.createNamedQuery(Reis.FIND_ALL);
        List<Reis> listReizen = filterLocatie.getResultList();
        List<Reis> listfiltered = new ArrayList<Reis>();
        for (Reis r : listReizen) {
            if (r.getPrijsPerPersoon() <= Double.parseDouble(value)) {
                listfiltered.add(r);
            }
        }
        return listfiltered;
    }

    public  List<Reis> FilterTransportmiddel(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERTRANSPORTMIDDEL);
        return filterLocatie.setParameter("naam",   value.toLowerCase() ).getResultList();}

    public  List<Reis> FilterVertrektijd(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FIND_ALL);
        List<Reis> listReizen =filterLocatie.getResultList();
        List<Reis> listFiltered = new ArrayList<Reis>();
        for(Reis r : listReizen)
        {
            if(r.getVertrekDatum().toString().contains(value))
            {
                listFiltered.add(r);
            }
        }
        return listFiltered;
    }

    public  List<Reis> FilterAankomsttijd(String value)
    {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FIND_ALL);
        List<Reis> listReizen =filterLocatie.getResultList();
        List<Reis> listFiltered = new ArrayList<Reis>();
        for(Reis r : listReizen)
        {
            if(r.getAankomstDatum().toString().contains(value))
            {
                listFiltered.add(r);
            }
        }
        return listFiltered;
    }

    public List<Integer> findVertrekLocatieIds(){
        return entityManager.createNamedQuery(Reis.FIND_ALLVERTREKLOCATIEIDS, Integer.class).getResultList();
    }

    public List<Integer> findAankomstLocatieIds(){
        return entityManager.createNamedQuery(Reis.FIND_ALLAANKOMSTLOCATIEIDS, Integer.class).getResultList();
    }

    public void update (Reis reis) {
        entityManager.merge(reis);
    }

    public void insert(Reis reis) {
        entityManager.persist(reis);
        entityManager.flush();
    }

    public void delete(int id) {
        Reis locatie = entityManager.find(Reis.class, id);
        entityManager.remove(locatie);
    }

    public List<Reis> zoekenReis(String naam, String vertrekdate, String aankomstdate){

        Query  filterLocatie = entityManager.createNamedQuery(Reis.FIND_ALL);
        List<Reis> listReizen =filterLocatie.getResultList();
        List<Reis> listFiltered = new ArrayList<Reis>();

        vertrekdate = vertrekdate.replace('/','-');
        aankomstdate = aankomstdate.replace('/','-');
        for(Reis r : listReizen)
        {

            if(r.getAankomstLocatie().getLand().toLowerCase().equals(naam.toLowerCase()) && r.getVertrekDatum().toString().contains(vertrekdate) && r.getAankomstDatum().toString().contains(aankomstdate))
            {
                listFiltered.add(r);
            }
        }
        return listFiltered;

    }

}
