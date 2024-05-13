package appointment.system;

import doctor.system.DoctorDTO;
import java.util.Date;
import org.bson.types.ObjectId;
import patient.system.PatientDTO;

public class ExistentAppointmentDTO {

    private ObjectId id;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private Date appointmentDate;
    private String status;
    private String note;

    public ExistentAppointmentDTO() {
    }

    public ExistentAppointmentDTO(ObjectId id, DoctorDTO doctor, PatientDTO patient, Date appointmentDate, String status, String note) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.note = note;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
