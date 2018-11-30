package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;



@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT l FROM Reis l"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALLVERTREKLOCATIEIDS,
                        query = "SELECT r.vertrekLocatie.id FROM Reis r"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALLAANKOMSTLOCATIEIDS,
                        query = "SELECT r.aankomstLocatie.id FROM Reis r"
                )
        }
)
public class Reis {

    //properties
    public static final String FIND_ALL = "Reis.findAll";
    public static final String FIND_ALLVERTREKLOCATIEIDS = "Reis.findVertrekLocatieIds";
    public static final String FIND_ALLAANKOMSTLOCATIEIDS = "Reis.findAankomstLocatieIds";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vertrekLocatieID")
    private SoortGebruiker vertrekLocatie;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "aankomstLocatieID")
    private SoortGebruiker aankomstLocatie;


    @Column(name = "vertrekTijd")
    private Date vertrekTijd;

    @Column(name = "aankomstTijd")
    private Date aankomstTijd;

    @Column(name = "prijsPerPersoon")
    private double prijsPerPersoon;

    @Column(name = "transportmiddel")
    private String transportmiddel;

    @Column(name = "plaatsen")
    private int plaatsen;
}
