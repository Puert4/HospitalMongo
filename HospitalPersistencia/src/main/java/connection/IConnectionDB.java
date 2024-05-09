package connection;

import javax.persistence.EntityManagerFactory;

public interface IConnectionDB {

    public EntityManagerFactory createConnection();
}
