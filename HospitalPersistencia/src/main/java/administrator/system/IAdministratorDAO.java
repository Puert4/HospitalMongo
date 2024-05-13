package administrator.system;

import entities.Administrator;

public interface IAdministratorDAO {

    /*

    public void registerAdministrator(newAdministratorDTO administratorDTO);
    
     */
    public Administrator DtoToEntity(AdministratorDTO administratorDTO);

    public AdministratorDTO EntityToDTO(Administrator administrator);
    /*

    

    public AdministratorEntity searchAdministratorByName(String names);

    public UserAdministrator findAdministratorById(Long id);

     */
}
