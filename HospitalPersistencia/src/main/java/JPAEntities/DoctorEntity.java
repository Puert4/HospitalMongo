package JPAEntities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DoctorEntity")
public class DoctorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "firstLastName", nullable = false)
    private String firstLastName;

    @Column(name = "secondLastName", nullable = false)
    private String secondLastName;

    @Column(name = "specialization", nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "medicalCart", nullable = false)
    private String medicalCart;

    /**
     *
     */
    public DoctorEntity() {

    }

    /**
     *
     * @param names
     * @param firstLastName
     * @param secondLastName
     * @param specialization
     * @param medicalCart
     */
    public DoctorEntity(String names, String firstLastName, String secondLastName, Specialization specialization, String medicalCart) {
        this.names = names;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.specialization = specialization;
        this.medicalCart = medicalCart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getMedicalCart() {
        return medicalCart;
    }

    public void setMedicalCart(String medicalCart) {
        this.medicalCart = medicalCart;
    }

}
