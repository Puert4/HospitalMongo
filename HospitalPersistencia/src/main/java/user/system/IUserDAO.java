package user.system;

import JPAEntities.UserEntity;
import administrator.system.newAdministratorDTO;
import doctor.system.NewDoctorDTO;

public interface IUserDAO {

    public void registerUser(NewUserDTO userDTO);

    public UserEntity DtoToEntity(NewUserDTO userDTO);

    public void registerAdminUser(newAdministratorDTO administratorDTO, NewUserDTO userDTO);

    public void registerDoctorUser(NewDoctorDTO newDoctorDTO, NewUserDTO userDTO);

    public String getUserType(Long userId);

    public Long validateUser(String user, String password);

    public UserEntity findUserByUserPassword(String user, String password);

    public String getUserTypeByUserAndPassword(String user, String password);

    public boolean userExist(String user);

}
