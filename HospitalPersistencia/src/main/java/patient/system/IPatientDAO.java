package patient.system;

import JPAEntities.PatientEntity;
import java.util.List;

/**
 *
 * @author TeLesheo
 */
public interface IPatientDAO {

    public void registerPatient(NewPatientDTO newPatient);

    public PatientEntity serachPatientById(Long idPatient);

    public PatientEntity searchPatientByCurp(String curp);

    public ExistentPatientDTO EntityToDto(PatientEntity patient);

    public PatientEntity DtoToEntity(NewPatientDTO newPatientDTO);

    public PatientEntity ExistentDtoToEntity(ExistentPatientDTO existentPatientDTO);
    
    public List<ExistentPatientDTO> findAllPatient();
    
    public PatientEntity findPatient(Long id);
    
}
