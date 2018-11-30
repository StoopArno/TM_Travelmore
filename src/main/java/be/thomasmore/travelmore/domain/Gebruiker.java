package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="gebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.FIND_ALL_BY_EMAIL,
                        query = "SELECT l FROM Gebruiker l where l.email = :email"
                ),
                @NamedQuery(
                        name = Gebruiker.FIND_BY_EMAIL,
                        query = "select l from Gebruiker l where l.email = :email"
                )
        }
)
public class Gebruiker {
    public static final String FIND_ALL_BY_EMAIL = "Gebruiker.findAllByEmail";
    public static final String FIND_BY_EMAIL = "Gebruiker.findAllByName";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "voornaam")
    private  String voornaam;
    @Column(name = "achternaam")
    private String achternaam;
    @Column(name = "adres")
    private String adres;
    @Column(name = "gemeente")
    private String gemeente;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wachtwoord;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "soortGebruikerID")
    private SoortGebruiker soortGebruiker;

}
