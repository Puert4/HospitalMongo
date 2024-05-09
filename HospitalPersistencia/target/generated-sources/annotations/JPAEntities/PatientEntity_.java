package JPAEntities;

import JPAEntities.DoctorEntity;
import JPAEntities.UserPatient;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T19:53:48", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PatientEntity.class)
public class PatientEntity_ { 

    public static volatile SingularAttribute<PatientEntity, Integer> zipCode;
    public static volatile SingularAttribute<PatientEntity, String> colony;
    public static volatile SingularAttribute<PatientEntity, String> sex;
    public static volatile SingularAttribute<PatientEntity, String> socialNumber;
    public static volatile SingularAttribute<PatientEntity, Calendar> birthDate;
    public static volatile SingularAttribute<PatientEntity, String> firstName;
    public static volatile ListAttribute<PatientEntity, DoctorEntity> asignedDoctors;
    public static volatile SingularAttribute<PatientEntity, String> names;
    public static volatile SingularAttribute<PatientEntity, String> phone;
    public static volatile SingularAttribute<PatientEntity, String> street;
    public static volatile SingularAttribute<PatientEntity, Long> id;
    public static volatile SingularAttribute<PatientEntity, UserPatient> user;
    public static volatile SingularAttribute<PatientEntity, String> curp;
    public static volatile SingularAttribute<PatientEntity, String> secondName;

}