package itson.org.design.hospitalpersistencia;

import appointment.system.IAppointmentManager;
import doctor.system.DoctorDTO;
import factory.Factory;
import java.util.Date;
import patient.system.PatientDTO;
import user.system.IUserDAO;
import user.system.NewUserDTO;
import appointment.system.AppointmentDTO;
import doctor.system.IDoctorDAO;
import entities.Doctor;
import entities.Patient;
import patient.system.IPatientDAO;

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
 /*
        //Se crea un appointmetn
        IPatientDAO patientDAO = Factory.getPatientDAO();
        PatientDTO patientDTO = patientDAO.EntityToDto(patientDAO.searchPatientByCurp("GOLJ910101HDFNRR02"));
        System.out.println(patientDTO + " " + patientDTO.getNames());

        IDoctorDAO doctorDAO = Factory.getDoctorDAO();
        DoctorDTO doctorDTO = doctorDAO.EntityToDTO(doctorDAO.searchByMedicart("XXXXX"));

        //  System.out.println(doctorDTO.getName() + " " + doctorDTO.getFirstLastName());
        AppointmentDTO appointmentDTO = new AppointmentDTO(doctorDTO, patientDTO, new Date(), "ACTIVE", "Tummy Ack");

        IAppointmentManager appointmentManager = Factory.getAppointmentManager();
        appointmentManager.createAppointment(appointmentDTO);
         */
    }
}
