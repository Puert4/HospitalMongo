package user.system;

import administrator.system.newAdministratorDTO;
import doctor.system.NewDoctorDTO;
import org.bson.types.ObjectId;
import patient.system.NewPatientDTO;

/**
 *
 * @author TeLesheo
 */
public class ExistentUserDTO {

    private ObjectId id;
    private String user;
    private String password;
    private String userType;
    private NewPatientDTO patientDTO;
    private NewDoctorDTO doctorDTO;
    private newAdministratorDTO administratorDTO;

    public ExistentUserDTO(ObjectId id, String user, String password, String userType, NewPatientDTO patientDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.patientDTO = patientDTO;
    }

    public ExistentUserDTO(ObjectId id, String user, String password, String userType, NewDoctorDTO doctorDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.doctorDTO = doctorDTO;
    }

    public ExistentUserDTO(ObjectId id, String user, String password, String userType, newAdministratorDTO administratorDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.administratorDTO = administratorDTO;
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

    public NewPatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(NewPatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public NewDoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(NewDoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public newAdministratorDTO getAdministratorDTO() {
        return administratorDTO;
    }

    public void setAdministratorDTO(newAdministratorDTO administratorDTO) {
        this.administratorDTO = administratorDTO;
    }

}
