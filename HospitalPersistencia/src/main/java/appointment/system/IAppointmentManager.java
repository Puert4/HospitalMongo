package appointment.system;

import entities.Appointment;
import java.util.Calendar;
import java.util.List;
import org.bson.types.ObjectId;

public interface IAppointmentManager {

    public void createAppointment(AppointmentDTO newAppointmentDTO);

    public Appointment DtoToEntity(AppointmentDTO appointmentDTO);

    public ExistentAppointmentDTO convertToDTO(Appointment appointmentEntity);

    public List<ExistentAppointmentDTO> getAppointmentsByCurp(String curp);

    public boolean cancelAppointment(ObjectId appointmentId);

    public List<ExistentAppointmentDTO> getAppointmentsByMedicalCart(String medicalCart);
    /*
  

    public List<Calendar> findLimitDays(DoctorEntity doctorEntity);

    public List<Calendar> findLimitDays(PatientEntity patientEntity);

    // public List<AppointmentEntity> findAppointmentsByPatientId(Long patientId);
    public List<ExistentAppointmentDTO> findAppointmentsByPatientId(Long patientId);


    public List<ExistentAppointmentDTO> findAppointmentsByDoctorId(Long doctorId);

   

    public ExistentAppointmentDTO findAppointmentById(Long appointmentId);

     */
}
