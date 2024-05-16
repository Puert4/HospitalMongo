package user.system;

import entities.User;
import patient.system.PatientDTO;

public interface IUserDAO {

    /**
     *
     * @param userDTO
     */
    public void registerUser(NewUserDTO userDTO);

    /**
     *
     * @param newUserDTO
     * @return
     */
    public User DtoToEntity(NewUserDTO newUserDTO);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     *
     * @param user
     * @return
     */
    public ExistentUserDTO EntitytoDTO(User user);

    /**
     *
     * @param user
     * @param password
     * @return
     */
    public boolean userAndPasswordExist(String user, String password);

    /**
     *
     * @param username
     * @return
     */
    public boolean userExist(String username);

    // public Long validateUser(String user, String password);
    //public void registerAdminUser(newAdministratorDTO administratorDTO, NewUserDTO userDTO);
    //public void registerDoctorUser(NewDoctorDTO newDoctorDTO, NewUserDTO userDTO);
    //  public String getUserType(Long userId);
//    public String getUserTypeByUserAndPassword(String user, String password);
    //public UserEntity findUserByUserPassword(String user, String password);
    // 
//    
}
