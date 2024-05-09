package JPAEntities;

import JPAEntities.AppointmentStateEntity;
import JPAEntities.DoctorEntity;
import JPAEntities.PatientEntity;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T19:53:48", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(AppointmentEntity.class)
public class AppointmentEntity_ { 

    public static volatile SingularAttribute<AppointmentEntity, DoctorEntity> doctor;
    public static volatile SingularAttribute<AppointmentEntity, String> note;
    public static volatile SingularAttribute<AppointmentEntity, PatientEntity> patient;
    public static volatile SingularAttribute<AppointmentEntity, AppointmentStateEntity> AppointmentState;
    public static volatile SingularAttribute<AppointmentEntity, Long> id;
    public static volatile SingularAttribute<AppointmentEntity, Calendar> appointmentDate;

}