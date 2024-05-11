package doctor.system;

public class DoctorDTO {

    private String name;
    private String firstLastName;
    private String secondLastName;
    private String specialization;
    private String medicalCart;

    public DoctorDTO() {
    }

    public DoctorDTO(String name, String firstLastName, String secondLastName, String specialization, String medicalCart) {
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.specialization = specialization;
        this.medicalCart = medicalCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
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
