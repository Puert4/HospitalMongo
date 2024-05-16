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

    /**
     *
     */
    public ExistentUserDTO() {
    }

    /**
     *
     * @param id
     * @param user
     * @param password
     * @param userType
     * @param patientDTO
     */
    public ExistentUserDTO(ObjectId id, String user, String password, String userType, PatientDTO patientDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.patientDTO = patientDTO;
    }

    /**
     *
     * @param id
     * @param user
     * @param password
     * @param userType
     * @param doctorDTO
     */
    public ExistentUserDTO(ObjectId id, String user, String password, String userType, DoctorDTO doctorDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.doctorDTO = doctorDTO;
    }

    /**
     *
     * @param id
     * @param user
     * @param password
     * @param userType
     * @param administratorDTO
     */
    public ExistentUserDTO(ObjectId id, String user, String password, String userType, AdministratorDTO administratorDTO) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.administratorDTO = administratorDTO;
    }

    /**
     *
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     *
     * @return
     */
    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    /**
     *
     * @param patientDTO
     */
    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    /**
     *
     * @return
     */
    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    /**
     *
     * @param doctorDTO
     */
    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    /**
     *
     * @return
     */
    public AdministratorDTO getAdministratorDTO() {
        return administratorDTO;
    }

    /**
     *
     * @param administratorDTO
     */
    public void setAdministratorDTO(AdministratorDTO administratorDTO) {
        this.administratorDTO = administratorDTO;
    }

}
