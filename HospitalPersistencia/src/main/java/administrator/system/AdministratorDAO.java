package administrator.system;

import JPAEntities.AdministratorEntity;
import JPAEntities.UserAdministrator;
import connection.ConnectionDB;
import connection.IConnectionDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import patient.system.PatientDAO;

public class AdministratorDAO implements IAdministratorDAO {

    private static final Logger LOGGER = Logger.getLogger(PatientDAO.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;

    public AdministratorDAO() {

        IConnectionDB connection = new ConnectionDB();
        emf = connection.createConnection();
        em = emf.createEntityManager();
    }

    @Override
    public void registerAdministrator(newAdministratorDTO administratorDTO) {

        AdministratorEntity administrator = DtoToEntity(administratorDTO);
        em.getTransaction().begin();
        em.persist(administrator);
        em.getTransaction().commit();

    }

    @Override
    public AdministratorEntity DtoToEntity(newAdministratorDTO administratorDTO) {
        AdministratorEntity adminisrator = new AdministratorEntity();

        adminisrator.setNames(administratorDTO.getName());

        return adminisrator;
    }

    @Override
    public ExistentAdministratorDTO EntityToDto(AdministratorEntity administrator) {
        ExistentAdministratorDTO administratorDTO = new ExistentAdministratorDTO();
        administratorDTO.setId(administrator.getId());
        administratorDTO.setName(administrator.getNames());
        return administratorDTO;
    }

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

    public static AdministratorDAO getInstance() {
        return new AdministratorDAO() {
        };
    }

}
