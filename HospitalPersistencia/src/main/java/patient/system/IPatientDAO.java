package patient.system;

import entities.Patient;



/**
 *
 * @author TeLesheo
 */
public interface IPatientDAO {

    public void registerPatient(PatientDTO newPatient);
    
    /*

    public PatientEntity serachPatientById(Long idPatient);

    public PatientEntity searchPatientByCurp(String curp);

    public ExistentPatientDTO EntityToDto(PatientEntity patient);
*/

    public Patient DtoToEntity(PatientDTO newPatientDTO);
    
    /*

    public PatientEntity ExistentDtoToEntity(ExistentPatientDTO existentPatientDTO);
    
    public List<ExistentPatientDTO> findAllPatient();
    
    public PatientEntity findPatient(Long id);
    */


    
}
