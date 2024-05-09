package appointment.system;

import JPAEntities.AppointmentEntity;
import JPAEntities.DoctorEntity;
import JPAEntities.PatientEntity;
import java.util.Calendar;
import java.util.List;

public interface IAppointmentManager {

    public void createAppointment(NewAppointmentDTO newAppointmentDTO);

    public AppointmentEntity DtoToEntity(NewAppointmentDTO newAppointmentDTO);

    public List<Calendar> findLimitDays(DoctorEntity doctorEntity);

    public List<Calendar> findLimitDays(PatientEntity patientEntity);

    // public List<AppointmentEntity> findAppointmentsByPatientId(Long patientId);
    public List<ExistentAppointmentDTO> findAppointmentsByPatientId(Long patientId);

    public ExistentAppointmentDTO convertToDTO(AppointmentEntity appointmentEntity);

    public List<ExistentAppointmentDTO> findAppointmentsByDoctorId(Long doctorId);

    public boolean cancelAppointment(Long appointmentId);

    public ExistentAppointmentDTO findAppointmentById(Long appointmentId);

}
