package JPAEntities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserPatient")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserPatient extends UserEntity implements Serializable {

    @OneToOne
    private PatientEntity patient;

    public UserPatient() {
    }

    public UserPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public UserPatient(PatientEntity patient, Long id, String user, String password) {
        super(id, user, password);
        this.patient = patient;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

}
