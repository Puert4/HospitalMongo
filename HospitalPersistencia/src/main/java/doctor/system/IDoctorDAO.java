package doctor.system;

import entities.Doctor;
import java.util.List;

public interface IDoctorDAO {

    /*

    public void registerDoctor(NewDoctorDTO doctorDTO);
     */
    /**
     *
     * @param doctorDTO
     * @return
     */
    public Doctor DtoToEntity(DoctorDTO doctorDTO);

    /*

    public DoctorEntity ExistentDtoToEntity(ExistentDoctorDTO existentDoctorDTO);

    public DoctorEntity serachById(Long idDoctor);
     */
    /**
     *
     * @param medicart
     * @return
     */
    public Doctor searchByMedicart(String medicart);

    /**
     *
     * @param doctorEntity
     * @return
     */
    public DoctorDTO EntityToDTO(Doctor doctorEntity);

    /**
     *
     * @param specialization
     * @return
     */
    public List<DoctorDTO> searchBySpecialization(String specialization);

    /*

    public Specialization setSpecilaization(String string);

     */
}
