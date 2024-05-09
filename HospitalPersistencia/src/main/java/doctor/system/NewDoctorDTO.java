package doctor.system;

public class NewDoctorDTO {

    private String name;
    private String firstName;
    private String SecondName;
    private String specialization;
    private String medicalCart;

    public NewDoctorDTO() {
    }

    public NewDoctorDTO(String name, String firstName, String SecondName, String specialization, String medicalCart) {
        this.name = name;
        this.firstName = firstName;
        this.SecondName = SecondName;
        this.specialization = specialization;
        this.medicalCart = medicalCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMedicalCart() {
        return medicalCart;
    }

    public void setMedicalCart(String medicalCart) {
        this.medicalCart = medicalCart;
    }

}
