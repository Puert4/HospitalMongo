package connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDB implements IConnectionDB {

    private EntityManagerFactory emf;

    public ConnectionDB() {
        emf = Persistence.createEntityManagerFactory("connectionPU");
    }

    @Override
    public EntityManagerFactory createConnection() {
        return emf;
    }

}
