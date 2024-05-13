package appointment.system;

import com.mongodb.client.MongoCollection;
import connection.ConnectionDB;
import doctor.system.DoctorDAO;
import doctor.system.DoctorDTO;
import entities.Appointment;
import java.util.logging.Logger;
import patient.system.PatientDAO;
import patient.system.PatientDTO;
import appointment.system.ExistentAppointmentDTO;
import doctor.system.IDoctorDAO;
import entities.Doctor;
import entities.Patient;
import factory.Factory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import org.bson.Document;
import org.bson.types.ObjectId;
import patient.system.IPatientDAO;

public abstract class AppointmentManager implements IAppointmentManager {

    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());
    private final MongoCollection<Appointment> collectionAppointment;

    public AppointmentManager() {
        this.collectionAppointment = ConnectionDB.getDatabase().getCollection("appointment", Appointment.class);
    }

    /**
     *
     * @param AppointmentDTO
     */
    @Override
    public void createAppointment(AppointmentDTO AppointmentDTO) {

        try {
            Appointment appointment = DtoToEntity(AppointmentDTO);

            // Document appointmentDocument = appointmentToDocument(appointment);
            collectionAppointment.insertOne(appointment);
        } catch (Exception ex) {
            Logger.getLogger(AppointmentManager.class.getName()).log(Level.SEVERE, "Error creating appointment", ex);

        }

    }

    /**
     *
     * @param appointment
     * @return
     */
    public ExistentAppointmentDTO convertToDTO(Appointment appointment) {
        try {
            DoctorDAO doctorDAO = new DoctorDAO();
            DoctorDTO doctorDTO = doctorDAO.EntityToDTO(doctorDAO.searchByMedicart(appointment.getDoctor().getMedicalCart()));

            PatientDAO patientDAO = new PatientDAO();
            PatientDTO patientDTO = patientDAO.EntityToDto(patientDAO.searchPatientByCurp(appointment.getPatient().getCurp()));

            ExistentAppointmentDTO existentAppointmentDTO = new ExistentAppointmentDTO();
            existentAppointmentDTO.setId(appointment.getId());
            existentAppointmentDTO.setDoctor(doctorDTO);
            existentAppointmentDTO.setPatient(patientDTO);
            existentAppointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
            existentAppointmentDTO.setStatus(appointment.getAppointmentState().toString());
            existentAppointmentDTO.setNote(appointment.getNote());

            return existentAppointmentDTO;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentManager.class.getName()).log(Level.SEVERE, "Error converting to DTO", ex);
            return null;
        }

    }

    /**
     *
     * @param appointmentDTO
     * @return
     */
    public Appointment DtoToEntity(AppointmentDTO appointmentDTO) {

        try {
            IDoctorDAO doctorDAO = Factory.getDoctorDAO();
            Doctor doctor = doctorDAO.searchByMedicart(appointmentDTO.getDoctor().getMedicalCart());

            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);

            IPatientDAO patientD = Factory.getPatientDAO();
            Patient patient = patientD.searchPatientByCurp(appointmentDTO.getPatient().getCurp());
            appointment.setPatient(patient);

            appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
            appointment.setAppointmentState(appointmentDTO.getStatus());
            appointment.setNote(appointmentDTO.getNote());

            return appointment;
        } catch (Exception ex) {
            Logger.getLogger(AppointmentManager.class.getName()).log(Level.SEVERE, "Error converting to ", ex);
            return null;
        }

    }

    public List<ExistentAppointmentDTO> getAppointmentsByCurp(String curp) {
        List<ExistentAppointmentDTO> appointments = new ArrayList<>();

        try {
            // Crear un filtro para buscar por el CURP del paciente
            Document query = new Document("patient.curp", curp);

            // Obtener las citas que coinciden con el filtro
            List<Appointment> matchingAppointments = collectionAppointment.find(query).into(new ArrayList<>());

            // Convertir las citas a DTO y agregarlas a la lista de retorno
            for (Appointment appointment : matchingAppointments) {
                appointments.add(convertToDTO(appointment));
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error, searching for appoinments by curp", ex);
        }

        return appointments;
    }


    /*
    @Override
    public List<Calendar> findLimitDays(DoctorEntity doctorEntity) {

        System.out.println(doctorEntity);

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<AppointmentEntity> consulta = criteria.createQuery(AppointmentEntity.class);
        Root<AppointmentEntity> root = consulta.from(AppointmentEntity.class);

        consulta = consulta.select(root).where(criteria.equal(root.get("doctor"), doctorEntity));

        TypedQuery<AppointmentEntity> query = em.createQuery(consulta);
        List<AppointmentEntity> ams = query.getResultList();

        List<Calendar> limitDays = new ArrayList<>();
        for (AppointmentEntity appointmentEntity : ams) {
            limitDays.add(appointmentEntity.getAppointmentDate());
        }

        return limitDays;

    }

    @Override
    public List<Calendar> findLimitDays(PatientEntity patientEntity) {

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<AppointmentEntity> consulta = criteria.createQuery(AppointmentEntity.class);
        Root<AppointmentEntity> root = consulta.from(AppointmentEntity.class);

        consulta = consulta.select(root).where(criteria.equal(root.get("patient"), patientEntity));

        TypedQuery<AppointmentEntity> query = em.createQuery(consulta);
        List<AppointmentEntity> ams = query.getResultList();

        List<Calendar> limitDays = new ArrayList<>();
        for (AppointmentEntity appointmentEntity : ams) {
            limitDays.add(appointmentEntity.getAppointmentDate());
        }

        return limitDays;

    }

    //REVISA




    @Override
    public List<ExistentAppointmentDTO> findAppointmentsByPatientId(Long patientId) {
        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<AppointmentEntity> consulta = criteria.createQuery(AppointmentEntity.class);
        Root<AppointmentEntity> root = consulta.from(AppointmentEntity.class);
        Join<AppointmentEntity, PatientEntity> patientJoin = root.join("patient");
        Predicate condiciones = criteria.and(
                criteria.equal(patientJoin.get("id"), patientId)
        );
        consulta = consulta.select(root).where(condiciones);
        TypedQuery<AppointmentEntity> query = em.createQuery(consulta);
        List<AppointmentEntity> appointmentEntities = query.getResultList();

        return appointmentEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExistentAppointmentDTO> findAppointmentsByDoctorId(Long doctorId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<AppointmentEntity> criteriaQuery = criteriaBuilder.createQuery(AppointmentEntity.class);
        Root<AppointmentEntity> root = criteriaQuery.from(AppointmentEntity.class);
        Join<AppointmentEntity, DoctorEntity> doctorJoin = root.join("doctor");
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(doctorJoin.get("id"), doctorId));
        TypedQuery<AppointmentEntity> query = em.createQuery(criteriaQuery);
        List<AppointmentEntity> appointmentEntities = query.getResultList();

        return appointmentEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    @Override
    public boolean cancelAppointment(Long appointmentId) {
        try {
            em.getTransaction().begin();
            AppointmentEntity appointment = em.find(AppointmentEntity.class, appointmentId);
            if (appointment != null) {
                if(appointment.getAppointmentState() == AppointmentStateEntity.CANCELED){
                    
                    JOptionPane.showMessageDialog(null, "the appointment has already been canceled");
                    em.getTransaction().commit();
                    return false;
                    
                }else{
                    
                    appointment.setAppointmentState(AppointmentStateEntity.CANCELED);
                    em.merge(appointment);
                    em.getTransaction().commit();
                    return true;
                    
                }
                
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ExistentAppointmentDTO findAppointmentById(Long appointmentId) {
        try {
            //    em.getTransaction().begin();
            AppointmentEntity appointment = em.find(AppointmentEntity.class, appointmentId);
            if (appointment != null) {
                return convertToDTO(appointment);
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



     */
    public static AppointmentManager getInstance() {
        return new AppointmentManager() {
        };
    }
}
