package administrator.system;

public class AdministratorDTO {

    private String Name;

    public AdministratorDTO() {
    }

    public AdministratorDTO(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
