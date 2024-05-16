package loginManager;

import com.mongodb.client.MongoDatabase;
import connection.ConnectionDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public abstract class LogIn implements ILogIn {

    private static final Logger LOGGER = Logger.getLogger(LogIn.class.getName());
    private static final MongoDatabase database = ConnectionDB.getDatabase();

    private LogIn() {
    }

    /**
     *
     * @param user
     * @param password
     * @return
     */
    @Override
    public Long validateUser(String user, String password) {

        try {
            Document query = new Document("user", user);
            Document userDocument = database.getCollection("users").find(query).first();

            if (userDocument != null && userDocument.getString("password").equals(password)) {
                LOGGER.log(Level.INFO, "User Validated");

                // Determine user type and return corresponding ID
                String userType = userDocument.getString("type");
                switch (userType) {
                    case "PATIENT":
                        return userDocument.getLong("patientId");
                    case "ADMIN":
                        return 0L;
                    case "DOCTOR":
                        return userDocument.getLong("doctorId");
                    default:
                        return null;
                }
            } else {
                LOGGER.log(Level.INFO, "Invalid Password or User Not Found");
                return null;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error validating user", e);
            return null;
        }
    }

    /**
     *
     * @return
     */
    public static LogIn getInstance() {
        return new LogIn() {
        };
    }
}
