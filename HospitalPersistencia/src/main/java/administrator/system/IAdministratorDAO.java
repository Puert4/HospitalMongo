package administrator.system;

import entities.Administrator;

public interface IAdministratorDAO {

    /*

    public void registerAdministrator(newAdministratorDTO administratorDTO);
    
     */
    /**
     * 
     * @param administratorDTO
     * @return 
     */
    public Administrator DtoToEntity(AdministratorDTO administratorDTO);

    /**
     * 
     * @param administrator
     * @return 
     */
    public AdministratorDTO EntityToDTO(Administrator administrator);
    /*

    

    public AdministratorEntity searchAdministratorByName(String names);

    public UserAdministrator findAdministratorById(Long id);

     */
}
