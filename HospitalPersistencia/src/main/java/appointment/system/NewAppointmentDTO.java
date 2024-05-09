package appointment.system;

import doctor.system.ExistentDoctorDTO;
import java.util.Calendar;
import patient.system.ExistentPatientDTO;

public class NewAppointmentDTO {

    private ExistentDoctorDTO doctor;
    private ExistentPatientDTO patient;
    private Calendar appointmentDate;
    private AppointmentStatus status;
    private String note;

    public NewAppointmentDTO() {
    }

    public NewAppointmentDTO(ExistentDoctorDTO doctor, ExistentPatientDTO patient, Calendar appointmentDate, AppointmentStatus status, String note) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.note = note;
    }

    public ExistentDoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(ExistentDoctorDTO doctor) {
        this.doctor = doctor;
    }

    public ExistentPatientDTO getPatient() {
        return patient;
    }

    public void setPatient(ExistentPatientDTO patient) {
        this.patient = patient;
    }

    public Calendar getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Calendar appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
