package doctor.system;

import entities.Doctor;

public class DoctorDAO implements IDoctorDAO {

    /*
    public DoctorDAO() {

        IConnectionDB connection = new ConnectionDB();
        emf = connection.createConnection();
        em = emf.createEntityManager();

    }

    @Override
    public void registerDoctor(NewDoctorDTO doctorDTO) {
        DoctorEntity doctor = DtoToEntity(doctorDTO);
        doctor.setSpecialization(setSpecilaization(doctorDTO.getSpecialization()));
        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();

    }

    public Specialization setSpecilaization(String string) {

        return switch (string) {
            case "PEDIATRIC" ->
                Specialization.PEDIATRIC;
            case "SURGERY" ->
                Specialization.SURGERY;
            case "PSYCHIATRY" ->
                Specialization.PSYCHIATRY;
            case "ANESTHIOLOGY" ->
                Specialization.ANESTHIOLOGY;
            case "FAMILY" ->
                Specialization.FAMILY;
            case "CARDIOLOGY" ->
                Specialization.CARDIOLOGY;
            default ->
                null;
        };

    }
    
     */
    @Override
    public Doctor DtoToEntity(DoctorDTO doctorDTO) {

        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setFirstLastName(doctorDTO.getFirstLastName());
        doctor.setSecondLastName(doctorDTO.getSecondLastName());
        doctor.setMedicalCart(doctorDTO.getMedicalCart());
        doctor.setSpecialization(doctorDTO.getSpecialization());

        return doctor;
    }

    /*

    @Override
    public DoctorEntity ExistentDtoToEntity(ExistentDoctorDTO existentDoctorDTO) {

        return em.find(DoctorEntity.class, existentDoctorDTO.getId());

    }

    @Override
    public DoctorEntity serachById(Long idDoctor) {

        try {
            return em.find(DoctorEntity.class, idDoctor);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "No se encontró ningún doctor con el ID especificado.");
            return null;
        } finally {

        }
    }

    @Override
    public DoctorEntity searchByMedicart(String medicart) {

        try {
            TypedQuery<DoctorEntity> query = em.createQuery("SELECT d FROM DoctorEntity d WHERE d.medicalCart = :medicalCart", DoctorEntity.class);
            query.setParameter("medicalCart", medicart);
            if (query.getSingleResult() == null) {

                JOptionPane.showMessageDialog(null, "The medicalCart has no owner");
                return null;
            } else {

                List<DoctorEntity> resultList = query.getResultList();
                int numResults = resultList.size();
                if (numResults != 0 && query.getSingleResult() != null && 1 == 0) {

                    JOptionPane.showMessageDialog(null, "The meidcalCart issss already in use");
                    return null;
                } else if (numResults == 1) {

                    return query.getSingleResult();

                }

            }
            JOptionPane.showMessageDialog(null, "No solution");
            return null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "The meidcalCart has been validated");
            return null;
        } finally {

        }
    }



    @Override
    public List<ExistentDoctorDTO> searchBySpecialization(Specialization specialization) {
        List<ExistentDoctorDTO> doctorsDTO = new ArrayList<>();

        try {
            TypedQuery<DoctorEntity> query = em.createQuery("SELECT d FROM DoctorEntity d WHERE d.specialization = :specialization", DoctorEntity.class);
            query.setParameter("specialization", specialization);
            List<DoctorEntity> doctors = query.getResultList();

            for (DoctorEntity doctor : doctors) {
                ExistentDoctorDTO doctorDTO = EntityToDTO(doctor);
                doctorsDTO.add(doctorDTO);
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Error al buscar médicos por especialización: " + e.getMessage());
        } finally {

        }

        return doctorsDTO;
    }

    public ExistentDoctorDTO EntityToDTO(DoctorEntity doctorEntity) {
        ExistentDoctorDTO doctorDTO = new ExistentDoctorDTO();
        doctorDTO.setId(doctorEntity.getId());
        doctorDTO.setName(doctorEntity.getNames());
        doctorDTO.setFirstName(doctorEntity.getFirstLastName());
        doctorDTO.setSecondName(doctorEntity.getSecondLastName());
        doctorDTO.setSpecialization(doctorEntity.getSpecialization());
        doctorDTO.setMedicalCart(doctorEntity.getMedicalCart());
        return doctorDTO;
    }
     */
    public static DoctorDAO getInstance() {
        return new DoctorDAO() {
        };
    }
}
