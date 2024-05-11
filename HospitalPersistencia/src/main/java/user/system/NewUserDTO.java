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

    public NewUserDTO() {
    }

    public NewUserDTO(String user, String password, PatientDTO patientDTO) {
        this.user = user;
        this.password = password;
        this.patientDTO = patientDTO;
        this.userType = "PATIENT";
    }

    public NewUserDTO(String user, String password, DoctorDTO doctorDTO) {
        this.user = user;
        this.password = password;
        this.doctorDTO = doctorDTO;
        this.userType = "DOCTOR";
    }

    public NewUserDTO(String user, String password, AdministratorDTO administratorDTO) {
        this.user = user;
        this.password = password;
        this.administratorDTO = administratorDTO;
        this.userType = "ADMIN";
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
