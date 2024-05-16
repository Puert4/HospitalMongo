package patient.system;

import entities.Patient;

/**
 *
 * @author TeLesheo
 */
public interface IPatientDAO {

    //  public void registerPatient(PatientDTO newPatient);
    /**
     *
     * @param curp
     * @return
     */
    public Patient searchPatientByCurp(String curp);

    /*

    public PatientEntity serachPatientById(Long idPatient);

 

     */
    /**
     *
     * @param patient
     * @return
     */
    public PatientDTO EntityToDto(Patient patient);

    /**
     *
     * @param newPatientDTO
     * @return
     */
    public Patient DtoToEntity(PatientDTO newPatientDTO);

    /*

    public PatientEntity ExistentDtoToEntity(ExistentPatientDTO existentPatientDTO);
    
    public List<ExistentPatientDTO> findAllPatient();
    
    public PatientEntity findPatient(Long id);
     */
}
