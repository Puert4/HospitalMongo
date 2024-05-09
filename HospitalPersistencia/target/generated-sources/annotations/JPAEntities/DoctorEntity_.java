package JPAEntities;

import JPAEntities.Specialization;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-08T19:53:48", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(DoctorEntity.class)
public class DoctorEntity_ { 

    public static volatile SingularAttribute<DoctorEntity, String> medicalCart;
    public static volatile SingularAttribute<DoctorEntity, String> secondLastName;
    public static volatile SingularAttribute<DoctorEntity, String> firstLastName;
    public static volatile SingularAttribute<DoctorEntity, String> names;
    public static volatile SingularAttribute<DoctorEntity, Specialization> specialization;
    public static volatile SingularAttribute<DoctorEntity, Long> id;

}