package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Medico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-17T16:11:02")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile ListAttribute<Especialidad, Medico> medico;
    public static volatile SingularAttribute<Especialidad, Integer> id;
    public static volatile SingularAttribute<Especialidad, String> nombre;

}