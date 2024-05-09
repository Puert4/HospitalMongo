package doctor.system;

import JPAEntities.DoctorEntity;
import JPAEntities.Specialization;
import java.util.List;

public interface IDoctorDAO {

    public void registerDoctor(NewDoctorDTO doctorDTO);

    public DoctorEntity DtoToEntity(NewDoctorDTO doctorDTO);

    public DoctorEntity ExistentDtoToEntity(ExistentDoctorDTO existentDoctorDTO);

    public DoctorEntity serachById(Long idDoctor);

    public DoctorEntity searchByMedicart(String medicart);

    public List<ExistentDoctorDTO> searchBySpecialization(Specialization specialization);

    public ExistentDoctorDTO EntityToDTO(DoctorEntity doctorEntity);

    public Specialization setSpecilaization(String string);

}
