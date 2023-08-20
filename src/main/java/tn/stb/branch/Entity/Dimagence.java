package tn.stb.branch.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "DIMAGENCES", schema = "DIGITAL")
public class Dimagence {
    @Id
    @Size(max = 3)
    @Column(name = "CODE_AGENCE", nullable = false, length = 3)
    private String codeAgence;

    @Size(max = 1024)
    @Column(name = "ADRESSE", length = 1024)
    private String adresse;

    @Column(name = "ADRESSE_KEY")
    private Long adresseKey;

    @Size(max = 50)
    @Nationalized
    @Column(name = "ADRESSEEMAIL", length = 50)
    private String adresseemail;

    @Size(max = 100)
    @Column(name = "AGENCE", length = 100)
    private String agence;

    @Size(max = 10)
    @Column(name = "CODE_DR", length = 10)
    private String codeDr;

    @Size(max = 5)
    @Nationalized
    @Column(name = "CODE_GOV", length = 5)
    private String codeGov;

    @Size(max = 10)
    @Nationalized
    @Column(name = "CODE_POSTAL", length = 10)
    private String codePostal;

    @Size(max = 150)
    @Column(name = "DR", length = 150)
    private String dr;

    @Size(max = 50)
    @Column(name = "FAX", length = 50)
    private String fax;

    @Size(max = 255)
    @Nationalized
    @Column(name = "GOUVERNERAT")
    private String gouvernerat;

    @Size(max = 50)
    @Column(name = "GSM", length = 50)
    private String gsm;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Size(max = 500)
    @Column(name = "LOCALISATION", length = 500)
    private String localisation;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Size(max = 6)
    @Nationalized
    @Column(name = "MATRICULE_CHEFAGENCE", length = 6)
    private String matriculeChefagence;

    @Size(max = 50)
    @Column(name = "TEL1", length = 50)
    private String tel1;

    @Size(max = 50)
    @Column(name = "TEL2", length = 50)
    private String tel2;

}
