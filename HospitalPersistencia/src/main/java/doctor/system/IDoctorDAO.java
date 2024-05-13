package doctor.system;

import entities.Doctor;
import java.util.List;

public interface IDoctorDAO {

    /*

    public void registerDoctor(NewDoctorDTO doctorDTO);
     */
    public Doctor DtoToEntity(DoctorDTO doctorDTO);

    /*

    public DoctorEntity ExistentDtoToEntity(ExistentDoctorDTO existentDoctorDTO);

    public DoctorEntity serachById(Long idDoctor);
     */
    public Doctor searchByMedicart(String medicart);

    public DoctorDTO EntityToDTO(Doctor doctorEntity);

    public List<DoctorDTO> searchBySpecialization(String specialization);

    /*

    public Specialization setSpecilaization(String string);

     */
}
