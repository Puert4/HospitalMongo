package doctor.system;

import entities.Doctor;

public interface IDoctorDAO {

    /*

    public void registerDoctor(NewDoctorDTO doctorDTO);
     */
    public Doctor DtoToEntity(DoctorDTO doctorDTO);
    /*

    public DoctorEntity ExistentDtoToEntity(ExistentDoctorDTO existentDoctorDTO);

    public DoctorEntity serachById(Long idDoctor);

    public DoctorEntity searchByMedicart(String medicart);

    public List<ExistentDoctorDTO> searchBySpecialization(Specialization specialization);

    public ExistentDoctorDTO EntityToDTO(DoctorEntity doctorEntity);

    public Specialization setSpecilaization(String string);

     */
}
