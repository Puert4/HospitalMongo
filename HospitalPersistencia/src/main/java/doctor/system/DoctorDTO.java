package doctor.system;

public class DoctorDTO {

    private String name;
    private String firstLastName;
    private String secondLastName;
    private String specialization;
    private String medicalCart;

    /**
     *
     */
    public DoctorDTO() {
    }

    /**
     *
     * @param name
     * @param firstLastName
     * @param secondLastName
     * @param specialization
     * @param medicalCart
     */
    public DoctorDTO(String name, String firstLastName, String secondLastName, String specialization, String medicalCart) {
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.specialization = specialization;
        this.medicalCart = medicalCart;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getFirstLastName() {
        return firstLastName;
    }

    /**
     *
     * @param firstLastName
     */
    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    /**
     *
     * @return
     */
    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    /**
     *
     * @return
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     *
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     *
     * @return
     */
    public String getMedicalCart() {
        return medicalCart;
    }

    /**
     *
     * @param medicalCart
     */
    public void setMedicalCart(String medicalCart) {
        this.medicalCart = medicalCart;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

}
