package appointment.system;

import entities.Appointment;
import java.util.Calendar;
import java.util.List;

public interface IAppointmentManager {

    public void createAppointment(AppointmentDTO newAppointmentDTO);

    public Appointment DtoToEntity(AppointmentDTO appointmentDTO);

    public ExistentAppointmentDTO convertToDTO(Appointment appointmentEntity);

    public List<ExistentAppointmentDTO> getAppointmentsByCurp(String curp);

    /*
  

    public List<Calendar> findLimitDays(DoctorEntity doctorEntity);

    public List<Calendar> findLimitDays(PatientEntity patientEntity);

    // public List<AppointmentEntity> findAppointmentsByPatientId(Long patientId);
    public List<ExistentAppointmentDTO> findAppointmentsByPatientId(Long patientId);


    public List<ExistentAppointmentDTO> findAppointmentsByDoctorId(Long doctorId);

    public boolean cancelAppointment(Long appointmentId);

    public ExistentAppointmentDTO findAppointmentById(Long appointmentId);

     */
}
