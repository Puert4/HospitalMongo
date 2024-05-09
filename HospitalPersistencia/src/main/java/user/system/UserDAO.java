package user.system;

import JPAEntities.AdministratorEntity;
import JPAEntities.DoctorEntity;
import JPAEntities.PatientEntity;
import JPAEntities.UserAdministrator;
import JPAEntities.UserDoctor;
import JPAEntities.UserEntity;
import JPAEntities.UserPatient;
import administrator.system.IAdministratorDAO;
import administrator.system.newAdministratorDTO;
import connection.ConnectionDB;
import connection.IConnectionDB;
import doctor.system.IDoctorDAO;
import doctor.system.NewDoctorDTO;
import factory.Factory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import patient.system.IPatientDAO;
import patient.system.PatientDAO;

/**
 *
 * @author TeLesheo
 */
public class UserDAO implements IUserDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;

    private UserDAO() {

        IConnectionDB connection = new ConnectionDB();
        emf = connection.createConnection();
        em = emf.createEntityManager();

    }

    @Override
    public void registerUser(NewUserDTO userDTO) {
        UserEntity user = DtoToEntity(userDTO);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }

    //aqui hice cambios de UserEntity a UserPatient
    @Override
    public UserEntity DtoToEntity(NewUserDTO userDTO) {
        IPatientDAO patientD = Factory.getPatientDAO();
        UserPatient user = new UserPatient();
        user.setUser(userDTO.getUser());
        user.setPassword(userDTO.getPassword());
        PatientEntity patient = patientD.searchPatientByCurp(userDTO.getPatientDTO().getCurp());
        user.setPatient(patient);

        return user;
    }

    public static UserDAO getInstance() {
        return new UserDAO() {
        };
    }

    @Override
    public void registerAdminUser(newAdministratorDTO administratorDTO, NewUserDTO userDTO) {
        IAdministratorDAO administratorD = Factory.getAdministratorDAO();
        administratorD.DtoToEntity(administratorDTO);
        UserAdministrator user = new UserAdministrator();
        user.setUser(userDTO.getUser());
        user.setPassword(userDTO.getPassword());

        AdministratorEntity administrator = administratorD.searchAdministratorByName(userDTO.getAdministratorDTO().getName());
        user.setAdministrator(administrator);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
//        em.close();
//        emf.close();

    }

    @Override
    public String getUserType(Long userId) {

        try {
            UserEntity user = em.find(UserEntity.class, userId);
            if (user != null) {
                if (user instanceof UserAdministrator) {
                    return "admin";
                } else if (user instanceof UserPatient) {
                    return "patient";
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
//            em.close();
//            emf.close();
        }

        return null;
    }

    @Override
    public boolean userExist(String user) {

        try {

            TypedQuery<UserEntity> consultUser = em.createQuery("SELECT u FROM UserEntity u WHERE u.user = :user", UserEntity.class);
            consultUser.setParameter("user", user);
            List<UserEntity> resultList = consultUser.getResultList();

            int inUse = resultList.size();

            if (inUse > 0) {

                return true;
            } else {
                return false;
            }
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        } finally {
//            em.close();
//            emf.close();
        }

    }

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

    @Override
    public void registerDoctorUser(NewDoctorDTO newDoctorDTO, NewUserDTO userDTO) {
        IDoctorDAO doctorD = Factory.getDoctorDAO();
        doctorD.DtoToEntity(newDoctorDTO);
        UserDoctor user = new UserDoctor();
        user.setUser(userDTO.getUser());
        user.setPassword(userDTO.getPassword());

        DoctorEntity doctor = doctorD.searchByMedicart(userDTO.getDoctorDTO().getMedicalCart());
        user.setDoctor(doctor);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
//        em.close();
//        emf.close();

    }

}
