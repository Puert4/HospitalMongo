package JPAEntities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "AppointmentEntity")
public class AppointmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctor;

    @OneToOne
    @JoinColumn(name = "id_patint", nullable = false)
    private PatientEntity patient;

    @Column(name = "appointment_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar appointmentDate;

    @Column(name = "apponitment_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentStateEntity AppointmentState;

    @Column(name = "note", nullable = true)
    private String note;

    public AppointmentEntity() {
    }

    public AppointmentEntity(DoctorEntity doctor, PatientEntity patient, Calendar appointmentDate, AppointmentStateEntity AppointmentState) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.AppointmentState = AppointmentState;
    }

    public AppointmentEntity(DoctorEntity doctor, PatientEntity patient, Calendar appointmentDate, AppointmentStateEntity AppointmentState, String note) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.AppointmentState = AppointmentState;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public Calendar getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Calendar appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStateEntity getAppointmentState() {
        return AppointmentState;
    }

    public void setAppointmentState(AppointmentStateEntity AppointmentState) {
        this.AppointmentState = AppointmentState;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
