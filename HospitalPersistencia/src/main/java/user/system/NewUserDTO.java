package user.system;

import administrator.system.newAdministratorDTO;
import doctor.system.NewDoctorDTO;
import patient.system.NewPatientDTO;

public class NewUserDTO {

    private String user;

    private String password;

    private NewPatientDTO patientDTO;

    private NewDoctorDTO doctorDTO;

    private newAdministratorDTO administratorDTO;

    public NewUserDTO() {
    }

    public NewUserDTO(String user, String password, NewPatientDTO patientDTO) {
        this.user = user;
        this.password = password;
        this.patientDTO = patientDTO;
    }

    public NewUserDTO(String user, String password, NewDoctorDTO doctorDTO) {
        this.user = user;
        this.password = password;
        this.doctorDTO = doctorDTO;
    }

    public NewUserDTO(String user, String password, newAdministratorDTO administratorDTO) {
        this.user = user;
        this.password = password;
        this.administratorDTO = administratorDTO;
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
