package patient.system;

import java.util.Calendar;
import java.util.Objects;

public class ExistentPatientDTO {

    private Long id;
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

    public ExistentPatientDTO() {
    }

    public ExistentPatientDTO(Long id, String name, String firstName, String secondName, String curp, String phone, Calendar birthDate, String sex, String socialNumber) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.curp = curp;
        this.phone = phone;
        this.birthDate = birthDate;
        this.sex = sex;
        this.socialNumber = socialNumber;
    }

    public ExistentPatientDTO(Long id, String name, String firstName, String secondName, String curp, String phone, Calendar birthDate, String sex, String street, int zipCode, String colonia, String socialNumber) {
        this.id = id;
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

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return name + ", " + curp;
    }
    
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.birthDate, other.birthDate);
    }

    
    
}
