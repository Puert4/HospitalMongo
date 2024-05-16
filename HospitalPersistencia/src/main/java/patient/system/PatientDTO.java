package patient.system;

import java.util.Date;

public class PatientDTO {

    private String names;
    private String firstName;
    private String secondName;
    private String curp;
    private String phone;
    private Date birthDate;
    private String sex;
    private String street;
    private Integer zipCode;
    private String colony;
    private String socialNumber;

    public PatientDTO() {
    }

    /**
     *
     * @param names
     * @param firstName
     * @param secondName
     * @param curp
     * @param phone
     * @param birthDate
     * @param sex
     * @param street
     * @param zipCode
     * @param colony
     * @param socialNumber
     */
    public PatientDTO(String names, String firstName, String secondName, String curp, String phone, Date birthDate, String sex, String street, Integer zipCode, String colony, String socialNumber) {
        this.names = names;
        this.firstName = firstName;
        this.secondName = secondName;
        this.curp = curp;
        this.phone = phone;
        this.birthDate = birthDate;
        this.sex = sex;
        this.street = street;
        this.zipCode = zipCode;
        this.colony = colony;
        this.socialNumber = socialNumber;
    }

    /**
     *
     * @return
     */
    public String getNames() {
        return names;
    }

    /**
     *
     * @param names
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     *
     * @param secondName
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     *
     * @return
     */
    public String getCurp() {
        return curp;
    }

    /**
     *
     * @param curp
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     */
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return
     */
    public String getColony() {
        return colony;
    }

    /**
     *
     * @param colony
     */
    public void setColony(String colony) {
        this.colony = colony;
    }

    /**
     *
     * @return
     */
    public String getSocialNumber() {
        return socialNumber;
    }

    /**
     *
     * @param socialNumber
     */
    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return names;
    }

}
