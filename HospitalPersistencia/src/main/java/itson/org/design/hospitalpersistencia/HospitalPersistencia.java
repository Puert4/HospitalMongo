package itson.org.design.hospitalpersistencia;

import doctor.system.DoctorDTO;
import factory.Factory;
import java.util.Date;
import patient.system.PatientDTO;
import user.system.IUserDAO;
import user.system.NewUserDTO;
import appointment.system.NewAppointmentDTO;

/**
 *
 * @author Laboratorios
 */
public class HospitalPersistencia {

    public static void main(String[] args) {

        /*
        String names = "Juan";
        String firstName = "González";
        String secondName = "López";
        String curp = "GOLJ910101HDFNRR02";
        String phone = "555-123-4567";
        Date birthDate = new Date(90, 0, 1); // 1 de enero de 1990
        String sex = "M";
        String street = "Calle Principal";
        Integer zipCode = 12345;
        String colony = "Centro";
        String socialNumber = "123-45-6789";

        PatientDTO patientDTO = new PatientDTO(names, firstName, secondName, curp, phone, birthDate, sex, street, zipCode, colony, socialNumber);

        IUserDAO userDAO = Factory.getUserDAO();
        NewUserDTO userDTO = new NewUserDTO("Carlos", "Carlos", patientDTO);
        userDAO.registerUser(userDTO);

         */
 /*
        DoctorDTO doctorDTO = new DoctorDTO(
                "Juan",
                "Perez",
                "Perez",
                "FAMILY",
                "XXXXX"
        );

        IUserDAO userDAO = Factory.getUserDAO();
        NewUserDTO userDTO = new NewUserDTO("Juan", "Juan", doctorDTO);
        userDAO.registerUser(userDTO);
         */
         
        
        NewAppointmentDTO appointmentDTO = new NewAppointmentDTO();
        
 
    }
}
