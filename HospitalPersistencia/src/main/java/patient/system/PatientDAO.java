package patient.system;

import JPAEntities.PatientEntity;
import connection.ConnectionDB;
import connection.IConnectionDB;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PatientDAO implements IPatientDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;

    public PatientDAO() {

        IConnectionDB connection = new ConnectionDB();
        emf = connection.createConnection();
        em = emf.createEntityManager();

    }

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
    public void registerPatient(NewPatientDTO newPatientDTO) {
        PatientEntity patient = DtoToEntity(newPatientDTO);
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
//        em.close();
//        emf.close();

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

    @Override
    public ExistentPatientDTO EntityToDto(PatientEntity patient) {
        ExistentPatientDTO existentPatientDTO = new ExistentPatientDTO();
        existentPatientDTO.setId(patient.getId());
        existentPatientDTO.setName(patient.getNames());
        existentPatientDTO.setFirstName(patient.getFirstName());
        existentPatientDTO.setSecondName(patient.getSecondName());
        existentPatientDTO.setCurp(patient.getCurp());
        existentPatientDTO.setPhone(patient.getPhone());
        existentPatientDTO.setBirthDate(patient.getBirthDate());
        existentPatientDTO.setSex(patient.getSex());
        existentPatientDTO.setStreet(patient.getStreet());
        existentPatientDTO.setZipCode(patient.getZipCode());
        existentPatientDTO.setColonia(patient.getColony());
        existentPatientDTO.setSocialNumber(patient.getSocialNumber());

        return existentPatientDTO;
    }

    @Override
    public PatientEntity DtoToEntity(NewPatientDTO newPatientDTO) {
        PatientEntity patient = new PatientEntity();

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

    public static PatientDAO getInstance() {
        return new PatientDAO() {
        };
    }
}
