package JPAEntities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserEntity")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    /*

    @OneToOne
    private PatientEntity patient;

    @OneToOne
    private AdministratorEntity administrator;

    @OneToOne
    private DoctorEntity doctor;
     */
    public UserEntity() {

    }

    /*
    public UserEntity(String user, String password, PatientEntity patient) {
        this.user = user;
        this.password = password;
        this.patient = patient;
    }

    public UserEntity(String user, String password, AdministratorEntity administrator) {
        this.user = user;
        this.password = password;
        this.administrator = administrator;
    }
    
  
     */
    public UserEntity(Long id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
