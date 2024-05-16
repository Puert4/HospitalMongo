package factory;

import administrator.system.AdministratorDAO;
import administrator.system.IAdministratorDAO;
import appointment.system.AppointmentManager;
import appointment.system.IAppointmentManager;
import doctor.system.DoctorDAO;
import doctor.system.IDoctorDAO;
import loginManager.ILogIn;
import loginManager.LogIn;
import patient.system.IPatientDAO;
import patient.system.PatientDAO;
import user.system.IUserDAO;
import user.system.UserDAO;

/**
 *
 * @author TeLesheo
 */
public class Factory {

    private static IPatientDAO patientDAO;
    private static IUserDAO userDAO;
    private static ILogIn logIn;
    private static IDoctorDAO doctorDAO;
    public static IAppointmentManager appointmentManager;
    public static IAdministratorDAO administratorDAO;

    /**
     *
     */
    public Factory() {

    }

    /**
     *
     * @return
     */
    public static IPatientDAO getPatientDAO() {
        return patientDAO == null ? (patientDAO = PatientDAO.getInstance()) : patientDAO;
    }

    /**
     *
     * @return
     */
    public static IUserDAO getUserDAO() {
        return userDAO == null ? (userDAO = UserDAO.getInstance()) : userDAO;
    }

    /**
     *
     * @return
     */
    public static ILogIn getLogIn() {
        return logIn == null ? (logIn = LogIn.getInstance()) : logIn;
    }

    /**
     *
     * @return
     */
    public static IDoctorDAO getDoctorDAO() {
        return doctorDAO == null ? (doctorDAO = DoctorDAO.getInstance()) : doctorDAO;
    }

    /**
     *
     * @return
     */
    public static IAppointmentManager getAppointmentManager() {
        return appointmentManager == null ? (appointmentManager = AppointmentManager.getInstance()) : appointmentManager;
    }

    /**
     *
     * @return
     */
    public static IAdministratorDAO getAdministratorDAO() {
        return administratorDAO == null ? (administratorDAO = AdministratorDAO.getInstance()) : administratorDAO;
    }

}
