package loginManager;

import JPAEntities.UserAdministrator;
import JPAEntities.UserDoctor;
import JPAEntities.UserEntity;
import JPAEntities.UserPatient;
import connection.ConnectionDB;
import connection.IConnectionDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public abstract class LogIn implements ILogIn {

    private static final Logger LOGGER = Logger.getLogger(LogIn.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;

    private LogIn() {

        IConnectionDB connection = new ConnectionDB();
        emf = connection.createConnection();
        em = emf.createEntityManager();

    }

    @Override
    public Long validateUser(String user, String password) {

        try {
            // Consulta para buscar al usuario por nombre de usuario
            TypedQuery<UserEntity> consultUser = em.createQuery("SELECT u FROM UserEntity u WHERE u.user = :user", UserEntity.class);
            consultUser.setParameter("user", user);

            UserEntity userEntity = consultUser.getSingleResult();

            // Verificar si se encontró un usuario y si la contraseña es correcta
            if (userEntity != null && userEntity.getPassword().equals(password)) {
                LOGGER.log(Level.INFO, "Usuario Validado");

                if (userEntity instanceof UserPatient) {

                    return ((UserPatient) userEntity).getPatient().getId();
                } else if (userEntity instanceof UserAdministrator) {

                    return 0L;
                } else if (userEntity instanceof UserDoctor) {
                    return ((UserDoctor) userEntity).getDoctor().getId();
                } else {

                    return null;
                }
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

    public static LogIn getInstance() {
        return new LogIn() {
        };
    }
}
