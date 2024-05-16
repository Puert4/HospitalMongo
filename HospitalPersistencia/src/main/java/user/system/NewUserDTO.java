package user.system;

import administrator.system.AdministratorDTO;
import doctor.system.DoctorDTO;
import patient.system.PatientDTO;

public class NewUserDTO {

    private String user;
    private String password;
    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;
    private AdministratorDTO administratorDTO;
    private String userType;

    /**
     *
     */
    public NewUserDTO() {
    }

    /**
     *
     * @param user
     * @param password
     * @param patientDTO
     */
    public NewUserDTO(String user, String password, PatientDTO patientDTO) {
        this.user = user;
        this.password = password;
        this.patientDTO = patientDTO;
        this.userType = "PATIENT";
    }

    /**
     *
     * @param user
     * @param password
     * @param doctorDTO
     */
    public NewUserDTO(String user, String password, DoctorDTO doctorDTO) {
        this.user = user;
        this.password = password;
        this.doctorDTO = doctorDTO;
        this.userType = "DOCTOR";
    }

    /**
     *
     * @param user
     * @param password
     * @param administratorDTO
     */
    public NewUserDTO(String user, String password, AdministratorDTO administratorDTO) {
        this.user = user;
        this.password = password;
        this.administratorDTO = administratorDTO;
        this.userType = "ADMIN";
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

    /**
     *
     * @return
     */
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

}
