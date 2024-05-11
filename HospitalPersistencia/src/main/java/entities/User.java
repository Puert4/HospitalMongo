package entities;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author TeLesheo
 */
public class User {

    private ObjectId id;
    private String user;
    private String password;
    private String userType;
    private Doctor doctor;
    private Patient patient;
    private Administrator administrator;

    public User() {
    }

    public User(ObjectId id, String user, String password, String userType, Doctor doctor) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.doctor = doctor;

    }

    public User(ObjectId id, String user, String password, String userType, Patient patient) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.patient = patient;

    }

    public User(ObjectId id, String user, String password, String userType, Administrator administrator) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.administrator = administrator;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
