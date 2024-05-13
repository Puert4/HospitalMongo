package doctor.system;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import connection.ConnectionDB;
import entities.Doctor;
import entities.User;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bson.conversions.Bson;

public class DoctorDAO implements IDoctorDAO {

    private static final Logger LOGGER = Logger.getLogger(DoctorDAO.class.getName());
    private final MongoCollection<User> collectionUser;

    public DoctorDAO() {
        this.collectionUser = ConnectionDB.getDatabase().getCollection("user", User.class);
    }

    /*
    @Override
    public void registerDoctor(NewDoctorDTO doctorDTO) {
        DoctorEntity doctor = DtoToEntity(doctorDTO);
        doctor.setSpecialization(setSpecilaization(doctorDTO.getSpecialization()));
        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();

    }

    public Specialization setSpecilaization(String string) {

        return switch (string) {
            case "PEDIATRIC" ->
                Specialization.PEDIATRIC;
            case "SURGERY" ->
                Specialization.SURGERY;
            case "PSYCHIATRY" ->
                Specialization.PSYCHIATRY;
            case "ANESTHIOLOGY" ->
                Specialization.ANESTHIOLOGY;
            case "FAMILY" ->
                Specialization.FAMILY;
            case "CARDIOLOGY" ->
                Specialization.CARDIOLOGY;
            default ->
                null;
        };

    }
    
     */
    @Override
    public Doctor DtoToEntity(DoctorDTO doctorDTO) {

        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setFirstLastName(doctorDTO.getFirstLastName());
        doctor.setSecondLastName(doctorDTO.getSecondLastName());
        doctor.setMedicalCart(doctorDTO.getMedicalCart());
        doctor.setSpecialization(doctorDTO.getSpecialization());

        return doctor;
    }

    /*

    @Override
    public DoctorEntity ExistentDtoToEntity(ExistentDoctorDTO existentDoctorDTO) {

        return em.find(DoctorEntity.class, existentDoctorDTO.getId());

    }

    @Override
    public DoctorEntity serachById(Long idDoctor) {

        try {
            return em.find(DoctorEntity.class, idDoctor);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "No se encontró ningún doctor con el ID especificado.");
            return null;
        } finally {

        }
    }
     */
    @Override
    public Doctor searchByMedicart(String medicart) {
        try {
            Bson filter = Filters.eq("doctor.medicalCart", medicart);

            User user = collectionUser.find(filter).first();
            if (user != null) {
                return user.getDoctor();
            } else {
                JOptionPane.showMessageDialog(null, "The medicalCart has no owner");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while searching for the medicalCart");
            return null;
        }
    }


    /*
    @Override
    public List<ExistentDoctorDTO> searchBySpecialization(Specialization specialization) {
        List<ExistentDoctorDTO> doctorsDTO = new ArrayList<>();

        try {
            TypedQuery<DoctorEntity> query = em.createQuery("SELECT d FROM DoctorEntity d WHERE d.specialization = :specialization", DoctorEntity.class);
            query.setParameter("specialization", specialization);
            List<DoctorEntity> doctors = query.getResultList();

            for (DoctorEntity doctor : doctors) {
                ExistentDoctorDTO doctorDTO = EntityToDTO(doctor);
                doctorsDTO.add(doctorDTO);
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Error al buscar médicos por especialización: " + e.getMessage());
        } finally {

        }

        return doctorsDTO;
    }
     */
    public DoctorDTO EntityToDTO(Doctor doctorEntity) {
        DoctorDTO doctorDTO = new DoctorDTO();
        // doctorDTO.setId(doctorEntity.getId());
        doctorDTO.setName(doctorEntity.getName());
        doctorDTO.setFirstLastName(doctorEntity.getFirstLastName());
        doctorDTO.setSecondLastName(doctorEntity.getSecondLastName());
        doctorDTO.setSpecialization(doctorEntity.getSpecialization());
        doctorDTO.setMedicalCart(doctorEntity.getMedicalCart());
        return doctorDTO;
    }

    public static DoctorDAO getInstance() {
        return new DoctorDAO() {
        };
    }
}
