package administrator.system;

import com.mongodb.client.MongoCollection;
import connection.ConnectionDB;
import entities.Administrator;
import entities.User;
import java.util.logging.Logger;
import user.system.UserDAO;

public class AdministratorDAO implements IAdministratorDAO {

    private static final Logger LOGGER = Logger.getLogger(AdministratorDAO.class.getName());
    private final MongoCollection<User> collectionUser;

    public AdministratorDAO() {
        this.collectionUser = ConnectionDB.getDatabase().getCollection("user", User.class);
    }

    @Override
    public Administrator DtoToEntity(AdministratorDTO administratorDTO) {
        Administrator adminisrator = new Administrator();
        adminisrator.setNames(administratorDTO.getName());
        return adminisrator;
    }

    @Override
    public AdministratorDTO EntityToDTO(Administrator administrator) {
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setName(administrator.getNames());

        return administratorDTO;
    }

    /*
    @Override
    public UserAdministrator findAdministratorById(Long id) {

        return em.find(UserAdministrator.class, id);

    }

    @Override
    public AdministratorEntity searchAdministratorByName(String names) {

        try {
            TypedQuery<AdministratorEntity> query = em.createQuery("SELECT a FROM AdministratorEntity a WHERE a.names = :names", AdministratorEntity.class);
            query.setParameter("names", names);
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "No se encontró ningún paciente con el CURP especificado.");
            return null;
        } finally {

        }
    }


    }
     */
    public static AdministratorDAO getInstance() {
        return new AdministratorDAO() {
        };
    }

}
