package user.system;

import administrator.system.AdministratorDTO;
import doctor.system.DoctorDTO;
import org.bson.types.ObjectId;
import patient.system.PatientDTO;

/**
 *
 * @author TeLesheo
 */
public class ExistentUserDTO {

    private ObjectId id;
    private String user;
    private String password;
    private String userType;
    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;
    private AdministratorDTO administratorDTO;

    public ExistentUserDTO() {
    }

    public ExistentUserDTO(ObjectId id, String user, String password, String userType, PatientDTO patientDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.patientDTO = patientDTO;
    }

    public ExistentUserDTO(ObjectId id, String user, String password, String userType, DoctorDTO doctorDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.doctorDTO = doctorDTO;
    }

    public ExistentUserDTO(ObjectId id, String user, String password, String userType, AdministratorDTO administratorDTO) {
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

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public AdministratorDTO getAdministratorDTO() {
        return administratorDTO;
    }

    public void setAdministratorDTO(AdministratorDTO administratorDTO) {
        this.administratorDTO = administratorDTO;
    }

}
