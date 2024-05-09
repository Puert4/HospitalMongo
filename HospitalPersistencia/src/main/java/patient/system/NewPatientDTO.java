package patient.system;

import java.util.Calendar;

public class NewPatientDTO {

    private String names;
    private String firstName;
    private String secondName;
    private String curp;
    private String phone;
    private Calendar birthDate;
    private String sex;
    private String street;
    private int zipCode;
    private String colony;
    private String socialNumber;

    public NewPatientDTO() {
    }

    public NewPatientDTO(String names, String firstName, String secondName, Calendar birthDate, String sex, String curp, String socialNumber, String phone, String street, String colony, int zipCode) {
        this.names = names;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.curp = curp;
        this.socialNumber = socialNumber;
        this.phone = phone;
        this.street = street;
        this.colony = colony;
        this.zipCode = zipCode;

    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

}
