package user.system;

import entities.User;
import patient.system.PatientDTO;

public interface IUserDAO {

    public void registerUser(NewUserDTO userDTO);

    public User DtoToEntity(NewUserDTO newUserDTO);

    User findUserByUsernameAndPassword(String username, String password);

    public ExistentUserDTO EntitytoDTO(User user);

    public boolean userAndPasswordExist(String user, String password);

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
