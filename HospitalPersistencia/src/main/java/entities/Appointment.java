package entities;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author TeLesheo
 */
public class Appointment {

    private ObjectId id;
    private Doctor doctor;
    private Patient patient;
    private Date appointmentDate;
    private String appointmentState;
    private String note;

    public Appointment() {
    }

    public Appointment(ObjectId id, Doctor doctor, Patient patient, Date appointmentDate, String appointmentState, String note) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentState = appointmentState;
        this.note = note;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentState() {
        return appointmentState;
    }

    public void setAppointmentState(String appointmentState) {
        this.appointmentState = appointmentState;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
