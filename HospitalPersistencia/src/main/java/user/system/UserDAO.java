package user.system;

import administrator.system.IAdministratorDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.logging.Logger;
import entities.User;
import connection.ConnectionDB;
import doctor.system.IDoctorDAO;
import factory.Factory;
import static factory.Factory.administratorDAO;
import java.util.logging.Level;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import patient.system.IPatientDAO;

/**
 *
 * @author TeLesheo
 */
public class UserDAO implements IUserDAO {

    private final MongoCollection<User> userCollection;
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    private UserDAO() {
        this.userCollection = ConnectionDB.getDatabase().getCollection("user", User.class);
    }

    @Override
    public void registerUser(NewUserDTO newUserDTO) {
        try {
            User user = DtoToEntity(newUserDTO);
            userCollection.insertOne(user);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error @ register user", ex);
        }
    }

    @Override
    public User DtoToEntity(NewUserDTO newUserDTO) {
        try {
            User user = new User();
            user.setId(new ObjectId());
            user.setPassword(newUserDTO.getPassword());
            user.setUser(newUserDTO.getUser());
            user.setUserType(newUserDTO.getUserType());
            //Se transforma a entidad y agrega al user

            if (user.getUserType() == "PATIENT") {
                IPatientDAO patientDAO = Factory.getPatientDAO();
                user.setPatient(patientDAO.DtoToEntity(newUserDTO.getPatientDTO()));
            } else if (user.getUserType() == "DOCTOR") {
                IDoctorDAO doctorDAO = Factory.getDoctorDAO();
                user.setDoctor(doctorDAO.DtoToEntity(newUserDTO.getDoctorDTO()));
            } else if (user.getUserType() == "ADMIN") {
                IAdministratorDAO administratorDAO = Factory.getAdministratorDAO();
                user.setAdministrator(administratorDAO.DtoToEntity(newUserDTO.getAdministratorDTO()));
            }

            return user;
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error al convertir usuarioDTO", ex);
            return null;
        }
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            //Filter by username and password
            Bson filter = Filters.and(
                    Filters.eq("user", username),
                    Filters.eq("password", password)
            );

            // Consults and returns the first found
            return userCollection.find(filter).first();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error searching for user", ex);
            return null;
        }
    }

    public ExistentUserDTO EntitytoDTO(User user) {
        ExistentUserDTO ExistentUserDTO = new ExistentUserDTO();
        ExistentUserDTO.setUser(user.getUser());
        ExistentUserDTO.setPassword(user.getPassword());
        ExistentUserDTO.setUserType(user.getUserType());

        if ("PATIENT".equals(user.getUserType())) {
            IPatientDAO patientDAO = Factory.getPatientDAO();

            ExistentUserDTO.setPatientDTO(patientDAO.EntityToDto(user.getPatient()));
        } else if ("DOCTOR".equals(user.getUserType())) {
            IDoctorDAO doctorDAO = Factory.getDoctorDAO();
            ExistentUserDTO.setDoctorDTO(doctorDAO.EntityToDTO(user.getDoctor()));
        } //else if ("ADMIN".equals(user.getUserType())) {
//            newUserDTO.setAdministratorDTO(administratorDAO.DtoToEntity(user.getAdministrator()));
//        }

        return ExistentUserDTO;
    }

    public boolean userExist(String username) {
        try {

            Bson filter = Filters.eq("user", username);

            long count = userCollection.countDocuments(filter);

            return count > 0;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error checking if user exists", ex);
            return false;
        }
    }

    /*
    @Override
    public Long validateUser(String user, String password) {

        try {

            TypedQuery<UserPatient> consultUser = em.createQuery("SELECT u FROM UserPatient u WHERE u.user = :user", UserPatient.class);
            consultUser.setParameter("user", user);

            UserPatient userPatient = consultUser.getSingleResult();

            if (userPatient != null && userPatient.getPassword().equals(password)) {
                LOGGER.log(Level.INFO, "Usuario Validado");

                return userPatient.getPatient().getId();
            } else {
                LOGGER.log(Level.INFO, "Contraseña Inválida o Usuario Inexistente");
                return null;
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Usuario Inválido o Inexistente");
            return null;
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Error al validar", e);
//            return null;
//        } finally {
////            em.close();
////            emf.close();
        }
    }
    
     */
 /*
    @Override
    public UserEntity findUserByUserPassword(String user, String password) {

        try {

            TypedQuery<UserEntity> consultUser = em.createQuery("SELECT u FROM UserEntity u WHERE u.user = :user", UserEntity.class);
            consultUser.setParameter("user", user);

            UserEntity userEntity = consultUser.getSingleResult();

            if (userEntity != null && userEntity.getPassword().equals(password)) {
                LOGGER.log(Level.INFO, "Usuario no existe");

                return userEntity;
            } else {
                LOGGER.log(Level.INFO, "Contraseña Inválida o Usuario Inexistente");
                return null;
            }
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "Usuario Inválido o Inexistente");
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al validar", e);
            return null;
        } finally {
//            em.close();
//            emf.close();
        }
    }

     */
 /*
    
    @Override
    public String getUserTypeByUserAndPassword(String user, String password) {

        try {

            TypedQuery<UserEntity> query = em.createQuery(
                    "SELECT u FROM UserEntity u WHERE u.user = :user AND u.password = :password", UserEntity.class);
            query.setParameter("user", user);
            query.setParameter("password", password);

            UserEntity userEntity = query.getSingleResult();
            if (userEntity != null) {

                if (userEntity instanceof UserAdministrator) {
                    return "admin";
                } else if (userEntity instanceof UserPatient) {
                    return "patient";
                } else if (userEntity instanceof UserDoctor) {
                    return "doctor";
                }
            }
        } catch (NoResultException e) {

            System.err.println("No se encontraron resultados para el usuario y la contraseña proporcionados.");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
//            
//            em.close();
//            emf.close();
        }

        return null;
    }

     */
 /*

    @Override
    public void registerDoctorUser(NewDoctorDTO newDoctorDTO, NewUserDTO userDTO) {
        IDoctorDAO doctorD = Factory.getDoctorDAO();
        doctorD.DtoToEntity(newDoctorDTO);
        UserDoctor user = new UserDoctor();
        user.setUser(userDTO.getUser());
        user.setPassword(userDTO.getPassword());

        DoctorEntity doctor = doctorD.searchByMedicart(userDTO.getDoctorDTO().getMedicalCart());
        user.setDoctor(doctor);

    }
     */
    public static UserDAO getInstance() {
        return new UserDAO() {
        };
    }

}
