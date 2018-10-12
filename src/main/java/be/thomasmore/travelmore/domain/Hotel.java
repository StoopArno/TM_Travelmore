package be.thomasmore.travelmore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
@NamedQueries(
        {
                @NamedQuery(
                        name = Hotel.FIND_ALL,
                        query = "SELECT h FROM Hotel h"
                ),
                @NamedQuery(
                        name = Hotel.FIND_BY_ID,
                        query = "SELECT h FROM Hotel h WHERE h.id = :id"
                ),
                @NamedQuery(
                        name = Hotel.FIND_BY_LOCATIE,
                        query = "SELECT h FROM Hotel h WHERE h.locatieId = :locatieId"
                ),
                @NamedQuery(
                        name = Hotel.FIND_BY_STERREN,
                        query = "SELECT h FROM Hotel h WHERE h.sterren >= :sterren"
                )
        }
)

public class Hotel {

    //properties
    public static final String FIND_ALL = "Hotel.findAll";
    public static final String FIND_BY_ID = "Hotel.findById";
    public static final String FIND_BY_LOCATIE = "Hotel.findByLocatie";
    public static final String FIND_BY_STERREN = "Hotel.findBySterren";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "locatieId")
    private int locatieId;
    @Column(name = "sterren")
    private int sterren;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLocatieId() {
        return locatieId;
    }

    public void setLocatieId(int locatieId) {
        this.locatieId = locatieId;
    }

    public int getSterren() {
        return sterren;
    }

    public void setSterren(int sterren) {
        this.sterren = sterren;
    }
}