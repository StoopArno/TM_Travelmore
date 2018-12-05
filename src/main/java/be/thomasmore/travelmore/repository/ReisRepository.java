package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;

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
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERAANTALPLAATSEN);
        return filterLocatie.setParameter("plaatsen",   Integer.parseInt(value)  ).getResultList();}

    public  List<Reis> FilterPrijsPerPersoon(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERPRIJSPERPERSOON);
        return filterLocatie.setParameter("prijs",    Double.parseDouble(value)  ).getResultList();}

    public  List<Reis> FilterTransportmiddel(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERTRANSPORTMIDDEL);
        return filterLocatie.setParameter("naam",   value.toLowerCase() ).getResultList();}

    public  List<Reis> FilterVertrektijd(String value) {
        Query  filterLocatie = entityManager.createNamedQuery(Reis.FILTERVERTREKTIJD);
        return filterLocatie.setParameter("vertrektijd",  value ).getResultList();}


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

}
