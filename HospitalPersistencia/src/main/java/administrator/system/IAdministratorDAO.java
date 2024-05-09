package administrator.system;

import JPAEntities.AdministratorEntity;
import JPAEntities.UserAdministrator;


public interface IAdministratorDAO {

    public void registerAdministrator(newAdministratorDTO administratorDTO);

    public AdministratorEntity DtoToEntity(newAdministratorDTO administratorDTO);

    public ExistentAdministratorDTO EntityToDto(AdministratorEntity administrator);

    public AdministratorEntity searchAdministratorByName(String names);

    public UserAdministrator findAdministratorById(Long id);

}
