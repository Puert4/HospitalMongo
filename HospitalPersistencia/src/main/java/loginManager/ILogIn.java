package loginManager;

public interface ILogIn {

    /**
     * 
     * @param user
     * @param password
     * @return 
     */
    public Long validateUser(String user, String password);
}
