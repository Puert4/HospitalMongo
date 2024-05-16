package patient.system;

import java.util.Calendar;
import java.util.Objects;

public class ExistentPatientDTO {

    private String name;
    private String firstName;
    private String secondName;
    private String curp;
    private String phone;
    private Calendar birthDate;
    private String sex;
    private String street;
    private int zipCode;
    private String colonia;
    private String socialNumber;

    /**
     *
     */
    public ExistentPatientDTO() {
    }

    /**
     *
     * @param name
     * @param firstName
     * @param secondName
     * @param curp
     * @param phone
     * @param birthDate
     * @param sex
     * @param street
     * @param zipCode
     * @param colonia
     * @param socialNumber
     */
    public ExistentPatientDTO(String name, String firstName, String secondName, String curp, String phone, Calendar birthDate, String sex, String street, int zipCode, String colonia, String socialNumber) {
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.curp = curp;
        this.phone = phone;
        this.birthDate = birthDate;
        this.sex = sex;
        this.street = street;
        this.zipCode = zipCode;
        this.colonia = colonia;
        this.socialNumber = socialNumber;
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
    public Calendar getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(Calendar birthDate) {
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
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return
     */
    public String getColonia() {
        return colonia;
    }

    /**
     *
     * @param colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
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
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExistentPatientDTO other = (ExistentPatientDTO) obj;
        if (this.zipCode != other.zipCode) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.secondName, other.secondName)) {
            return false;
        }
        if (!Objects.equals(this.curp, other.curp)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.colonia, other.colonia)) {
            return false;
        }
        if (!Objects.equals(this.socialNumber, other.socialNumber)) {
            return false;
        }

        return Objects.equals(this.birthDate, other.birthDate);
    }

}
