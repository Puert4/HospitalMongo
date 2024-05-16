package appointment.system;

import doctor.system.DoctorDTO;
import java.util.Date;
import patient.system.PatientDTO;

public class AppointmentDTO {

    private DoctorDTO doctor;
    private PatientDTO patient;
    private Date appointmentDate;
    private String status;
    private String note;

    /**
     *
     */
    public AppointmentDTO() {
    }

    /**
     *
     * @param doctor
     * @param patient
     * @param appointmentDate
     * @param status
     * @param note
     */
    public AppointmentDTO(DoctorDTO doctor, PatientDTO patient, Date appointmentDate, String status, String note) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.note = note;
    }

    /**
     *
     * @return
     */
    public DoctorDTO getDoctor() {
        return doctor;
    }

    /**
     *
     * @param doctor
     */
    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    /**
     *
     * @return
     */
    public PatientDTO getPatient() {
        return patient;
    }

    /**
     *
     * @param patient
     */
    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    /**
     *
     * @return
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     *
     * @param appointmentDate
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

}
