package patient.system;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import connection.ConnectionDB;
import entities.Patient;
import entities.User;
import patient.system.PatientDTO;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

public class PatientDAO implements IPatientDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());
    private final MongoCollection<User> collectionUser;

    /**
     * 
     */
    public PatientDAO() {
        this.collectionUser = ConnectionDB.getDatabase().getCollection("user", User.class);
    }

    /**
     * 
     * @param curp
     * @return 
     */
    @Override
    public Patient searchPatientByCurp(String curp) {
        try {

            Bson filter = Filters.eq("patient.curp", curp);
            User user = collectionUser.find(filter).first();
            if (user == null) {
                LOGGER.log(Level.INFO, "Patient not found by curp");
                return null;
            } else {
                Patient patient = new Patient(
                        user.getPatient().getNames(),
                        user.getPatient().getFirstName(),
                        user.getPatient().getSecondName(),
                        user.getPatient().getBirthDate(),
                        user.getPatient().getSex(),
                        user.getPatient().getCurp(),
                        user.getPatient().getSocialNumber(),
                        user.getPatient().getPhone(),
                        user.getPatient().getStreet(),
                        user.getPatient().getColony(),
                        user.getPatient().getZipCode()
                );

                return patient;
            }

        } catch (MongoException ex) {
            LOGGER.log(Level.INFO, "Patient not found by curp");
            return null;
        }
    }

    /*
    @Override
    public PatientEntity findPatient(Long id) {

        return em.find(PatientEntity.class, id);

    }

    @Override
    public List<ExistentPatientDTO> findAllPatient() {

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> consulta = criteria.createQuery(PatientEntity.class);
        Root<PatientEntity> root = consulta.from(PatientEntity.class);
        TypedQuery<PatientEntity> query = em.createQuery(consulta);
        List<PatientEntity> patientList = query.getResultList();
        List<ExistentPatientDTO> patientDTOsList = new ArrayList<>();
        for (PatientEntity patientEntity : patientList) {

            ExistentPatientDTO patientDTO = EntityToDto(patientEntity);
            patientDTOsList.add(patientDTO);
        }
        return patientDTOsList;

    }



    @Override
    public PatientEntity serachPatientById(Long idPatient) {

        try {
            // Consulta el paciente por su ID
            return em.find(PatientEntity.class, idPatient);

        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "No se encontró ningún paciente con el ID especificado.");
            return null;
        } finally {
//            em.close();
//            emf.close();
        }
    }

    @Override
    public PatientEntity searchPatientByCurp(String curp) {
        try {
            TypedQuery<PatientEntity> query = em.createQuery("SELECT p FROM PatientEntity p WHERE p.curp = :curp", PatientEntity.class);
            query.setParameter("curp", curp);
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "No se encontró ningún paciente con el CURP especificado.");
            return null;
        } finally {
//            em.close();
//            emf.close();
        }
    }
     */
    /**
     * 
     * @param patient
     * @return 
     */
    @Override
    public PatientDTO EntityToDto(Patient patient) {
        PatientDTO PatientDTO = new PatientDTO();
        //   existentPatientDTO.setId(patient.getId());
        PatientDTO.setNames(patient.getNames());
        PatientDTO.setFirstName(patient.getFirstName());
        PatientDTO.setSecondName(patient.getSecondName());
        PatientDTO.setCurp(patient.getCurp());
        PatientDTO.setPhone(patient.getPhone());
        PatientDTO.setBirthDate(patient.getBirthDate());
        PatientDTO.setSex(patient.getSex());
        PatientDTO.setStreet(patient.getStreet());
        PatientDTO.setZipCode(patient.getZipCode());
        PatientDTO.setColony(patient.getColony());
        PatientDTO.setSocialNumber(patient.getSocialNumber());

        return PatientDTO;
    }

    /**
     * 
     * @param newPatientDTO
     * @return 
     */
    @Override
    public Patient DtoToEntity(PatientDTO newPatientDTO) {
        Patient patient = new Patient();

        patient.setNames(newPatientDTO.getNames());
        patient.setFirstName(newPatientDTO.getFirstName());
        patient.setSecondName(newPatientDTO.getSecondName());
        patient.setCurp(newPatientDTO.getCurp());
        patient.setPhone(newPatientDTO.getPhone());
        patient.setBirthDate(newPatientDTO.getBirthDate());
        patient.setSex(newPatientDTO.getSex());
        patient.setStreet(newPatientDTO.getStreet());
        patient.setZipCode(newPatientDTO.getZipCode());
        patient.setColony(newPatientDTO.getColony());
        patient.setSocialNumber(newPatientDTO.getSocialNumber());

        return patient;
    }

    /*
    @Override
    public PatientEntity ExistentDtoToEntity(ExistentPatientDTO existentPatientDTO) {
        PatientEntity patient = new PatientEntity();

        patient.setNames(existentPatientDTO.getName());
        patient.setFirstName(existentPatientDTO.getFirstName());
        patient.setSecondName(existentPatientDTO.getSecondName());
        patient.setCurp(existentPatientDTO.getCurp());
        patient.setPhone(existentPatientDTO.getPhone());
        patient.setBirthDate(existentPatientDTO.getBirthDate());
        patient.setSex(existentPatientDTO.getSex());
        patient.setStreet(existentPatientDTO.getStreet());
        patient.setZipCode(existentPatientDTO.getZipCode());
        patient.setColony(existentPatientDTO.getColonia());
        patient.setSocialNumber(existentPatientDTO.getSocialNumber());

        return patient;
    }
     */
    /**
     * 
     * @return 
     */
    public static PatientDAO getInstance() {
        return new PatientDAO() {
        };
    }

}
