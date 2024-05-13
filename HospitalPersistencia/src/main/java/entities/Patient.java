package entities;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author TeLesheo
 */
public class Patient {

    private String names;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private String sex;
    private String curp;
    private String socialNumber;
    private String phone;
    private String street;
    private String colony;
    private Integer zipCode;

    public Patient() {
    }

    public Patient(String names, String firstName, String secondName, Date birthDate, String sex, String curp, String socialNumber, String phone, String street, String colony, Integer zipCode) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

}
