package modelo;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="citas")
public class Cita {
    @Id
    @SequenceGenerator(name="sec_citas",initialValue=1,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_citas")
    private int id; //ver para cambiar a long -> demasiados turnos
    @ManyToOne
    private Paciente paciente;
    @OneToOne
    private Medico medico;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date horaComienzo;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)//timestamp ver para cambiar a calendar
    private Date horaTermina;
    private boolean disponible;
    private boolean asistencia;

    public Paciente getPaciente() {
        return paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getHoraComienzo() {
        return horaComienzo;
    }

    public void setHoraComienzo(Date horaComienzo) {
        this.horaComienzo = horaComienzo;
    }

    public Date getHoraTermina() {
        return horaTermina;
    }

    public void setHoraTermina(Date horaTermina) {
        this.horaTermina = horaTermina;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Cita() {
    }

    public Cita(Paciente paciente, Medico medico, Date horaComienzo, Date horaTermina, boolean disponible) {
        this.paciente = paciente;
        this.medico = medico;
        this.horaComienzo = horaComienzo;
        this.horaTermina = horaTermina;
        this.disponible = disponible;
    }

    public Cita(Date horaComienzo, Date horaTermina, boolean disponible) {
        this.horaComienzo = horaComienzo;
        this.horaTermina = horaTermina;
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("E dd-HH:mm");
        SimpleDateFormat formatoFecha1 = new SimpleDateFormat("HH:mm");
        String asist;
        
        if(this.asistencia) {asist = "asistencia ✓";}
        else                {asist = "asistencia ×";}
    
        
        return  "|" +
                formatoFecha.format(horaComienzo) + "-" + 
                formatoFecha1.format(horaTermina) + "| " +
                 " " +  asist;
    }
    
    
    
}
