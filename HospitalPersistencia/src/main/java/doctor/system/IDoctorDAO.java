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
     */
    public Doctor searchByMedicart(String medicart);

    public DoctorDTO EntityToDTO(Doctor doctorEntity);

    /*
    public List<ExistentDoctorDTO> searchBySpecialization(Specialization specialization);

  

    public Specialization setSpecilaization(String string);

     */
}
