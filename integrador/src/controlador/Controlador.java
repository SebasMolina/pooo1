/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Persistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import modelo.*;

/**
 *
 * @author claudio
 * Clase que interactua con la vista y la capa de persistencia.
 * Funciona como una capa de servicios (es posible desacoplar en dos capas).
 * 
 * Idea:
 * UI -- Controlador -- Persistencia (DAO) -- Modelo
 * 
 * En aplicaciones complejas:
 * UI -- Controlador -- Servicio -- Persistencia (DAO) -- Modelo
 * 
 * Existen situaciones que se usan servicios y DAOs por cada clase del modelo.
 * 
 * Con JPA la parte de Persistencia se puede obviar o armar un DAO genérico.
 * En este proyecto se usa un DAO genérico (Clase Persistencia).
 * 
 * Esta NO ES una implementacion de controlador cuya tarea es capturar acciones de las vistas.
 * 
 */
public class Controlador {

    Persistencia persistencia;    

    public Controlador(Persistencia p) {
        this.persistencia = p;
    }
    
    public void agregarPaciente(String dni, String nombres, String apellidos, String telefono, String mail, String fechaNacimiento, String calle, String numero, String localidad, String provincia, String historial) {
        this.persistencia.iniciarTransaccion();
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Paciente p = new Paciente(dni, nombres.toUpperCase(), apellidos.toUpperCase(), telefono, mail, formatoFecha.parse(fechaNacimiento), calle.toUpperCase(), numero, localidad.toUpperCase(), provincia.toUpperCase(), historial.toUpperCase());
            // si es un paciente valido
            this.persistencia.insertar(p);
            this.persistencia.confirmarTransaccion();
        } catch (ParseException ex) {
            /*
            this.persistencia.descartarTransaccion();
            System.out.println("Error al capturar fecha");
            */
        }
    }
    
    public List listarPacientes() {
        // retorno valores ordenados de la consulta
        ArrayList<Paciente> listaResultante= new ArrayList<>(this.persistencia.buscarTodos(Paciente.class));
        listaResultante.sort(Comparator.comparing(Paciente::getDni));
        
        return listaResultante;
    }
    
    public Persona buscarPaciente(Long id) {
        return this.persistencia.buscar(Persona.class, id);
    }
    
    public void editarPaciente(Paciente p, String dni, String nombres, String apellidos, String telefono, String mail, String fechaNacimiento, String calle, String numero, String localidad, String provincia, String historial) {
        if (p != null) {
            this.persistencia.iniciarTransaccion();
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                p.setDni(dni);
                p.setNombres(nombres.toUpperCase());
                p.setApellidos(apellidos.toUpperCase());
                p.setTelefono(telefono);
                p.setMail(mail);
                p.setFechaNacimiento(formatoFecha.parse(fechaNacimiento));
                Domicilio d = p.getDomicilio();
                d.setCalle(calle.toUpperCase());
                d.setNumero(numero.toUpperCase());
                d.setLocalidad(localidad.toUpperCase());
                d.setProvincia(provincia.toUpperCase());
                p.setHistorial(historial);
                this.persistencia.modificar(p);
                this.persistencia.confirmarTransaccion();
            } catch (ParseException ex) {
                this.persistencia.descartarTransaccion();
            }
        }
    }
    public int eliminarPaciente(Paciente p) {
        this.persistencia.iniciarTransaccion();
        this.persistencia.eliminar(p);
        this.persistencia.confirmarTransaccion();
        return 0;
    }
    
    public void agregarDoctor(String dni, String matricula, Date horaComienza, Date horaTermina, String nombres, String apellidos, String telefono, String mail, String fechaNacimiento, String calle, String numero, String localidad, String provincia, Especialidad especialidad, int tiempoTurno) {
        this.persistencia.iniciarTransaccion();
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Medico m = new Medico(dni,matricula.toUpperCase(),
                    horaComienza,horaTermina,
                    nombres.toUpperCase(),apellidos.toUpperCase(), telefono, mail,
                    formatoFecha.parse(fechaNacimiento),calle.toUpperCase(), numero,
                    localidad.toUpperCase(), provincia.toUpperCase(), especialidad, tiempoTurno);
            // si es un departamento valido
            if (especialidad != null) {
                m.agregarEspecialidad(especialidad); //agrego al medico la especialidad y en la base de datos
                especialidad.agregarMedico(m);  //agrego en especialidad al medico. hago de los 2 lados.
                this.persistencia.modificar(especialidad);
            }
            this.persistencia.insertar(m);
            this.persistencia.confirmarTransaccion();
        } catch (ParseException ex) {
            this.persistencia.descartarTransaccion();
            System.out.println("Error al capturar fecha");
        }
    }
    
    public List listarDoctores() {
        // retorno valores ordenados de la consulta
        ArrayList<Medico> listaResultante= new ArrayList<>(this.persistencia.buscarTodos(Medico.class));
        listaResultante.sort(Comparator.comparing(Medico::getApellidos));
        
        return listaResultante;
    }
    
    public List listarDoctoresEspecialidad(Especialidad e) {
        // retorno valores ordenados de la consulta
        List<Medico> lista = new ArrayList<>(this.persistencia.buscarTodos(Medico.class));
        List<Medico> listaResultante = new ArrayList<>();
        List<Especialidad> aux = new ArrayList<>();
        
        for(int i=0;i<lista.size();i++){
        int contar=1;
        //el medico tiene una lista de especialidades. lo guardo en aux
            aux = lista.get(i).getEspecialidad();
        //busco si tengo la especialidad que le paso.
            for(int j=0; j<aux.size();j++){
        //si la especialidad es distinta a la del parametro sumo
                if(aux.get(j) != e){
                    contar++;
                } else {
                    contar=0;
                }
            }
            
            if (contar > 0){
                listaResultante.add(lista.get(i));
            }
        }
                
        return listaResultante;
    }
    
    public Persona buscarDoctor(Long id) {
        return this.persistencia.buscar(Persona.class, id);
    }
    
    public void editarDoctor(Medico m, String dni, String matricula, Date horarioInicio, Date horarioFinal, String nombres, String apellidos, String telefono, String mail, String fechaNacimiento, String calle, String numero, String localidad, String provincia, Especialidad especialidad, int tiempoTurno) {
        if (m != null) {
            this.persistencia.iniciarTransaccion();
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                m.setDni(dni);
                m.setNumeroMatricula(matricula);
                m.setHorarioInicio(horarioInicio);
                m.setHorarioFinal(horarioFinal);
                m.setNombres(nombres.toUpperCase());
                m.setApellidos(apellidos.toUpperCase());
                m.setTelefono(telefono);
                m.setMail(mail);
                m.setFechaNacimiento(formatoFecha.parse(fechaNacimiento));
                Domicilio d = m.getDomicilio();
                d.setCalle(calle.toUpperCase());
                d.setNumero(numero.toUpperCase());
                d.setLocalidad(localidad.toUpperCase());
                d.setProvincia(provincia.toUpperCase());
                m.setTiempoTurno(tiempoTurno);
                /* la especialidad no se puede modificar en este metodo.
                if (especialidad!= null) {
                    m.agregarEspecialidad(especialidad);
                    especialidad.agregarMedico(m);  
                //agrego en especialidad al medico. hago de los 2 lados.
                    this.persistencia.modificar(especialidad);
                }
                */
                this.persistencia.modificar(m);
                this.persistencia.confirmarTransaccion();
            } catch (ParseException ex) {
                this.persistencia.descartarTransaccion();
            }
        }
    }
    public int eliminarDoctor(Medico m) {
        this.persistencia.iniciarTransaccion();
        this.persistencia.eliminar(m);
        this.persistencia.confirmarTransaccion();
        return 0;
    }
    
    public List listarEspecialidades() {
        // retorno valores ordenados de la consulta
        ArrayList<Especialidad> listaResultante= new ArrayList<>(this.persistencia.buscarTodos(Especialidad.class));
        listaResultante.sort(Comparator.comparing(Especialidad::getNombre));
        
        return listaResultante;
        
    }
    
    public void agregarEspecialidades(String nombres) {
        this.persistencia.iniciarTransaccion();
        Especialidad e = new Especialidad(nombres.toUpperCase());
        // si es un especialidad valido
        this.persistencia.insertar(e);
        this.persistencia.confirmarTransaccion();
    }
    
    public void agregarEspecialidadesDoctor(Especialidad e, Medico m) {
        this.persistencia.iniciarTransaccion();
        if (e!= null) {      
        //agrego en especialidad al medico. hago de los 2 lados.
            this.persistencia.modificar(e);
        // si es un especialidad valido
            this.persistencia.modificar(m);
        //hago luego asi si salta error 
            m.agregarEspecialidad(e);
            e.agregarMedico(m);
        }
        this.persistencia.confirmarTransaccion();
    }
    
    public int eliminarEspecialidades(Especialidad e) {
        this.persistencia.iniciarTransaccion();
        this.persistencia.eliminar(e);
        this.persistencia.confirmarTransaccion();
        return 0;
    }
    
    public void eliminarEspecialidadDoctor(Especialidad e, Medico m) {
        this.persistencia.iniciarTransaccion();
        e.quitarMedico(m);
        m.quitarEspecialidad(e);
        this.persistencia.modificar(e);
        this.persistencia.modificar(m);
        this.persistencia.confirmarTransaccion();
    }
    
    public void agregarHistoria(Paciente p, Date fecha, String descripcion, Medico m) {
        this.persistencia.iniciarTransaccion();
        Historia historia = new Historia(p, fecha, descripcion.toUpperCase(), m);
        p.agregarHistoriaClinica(historia);    
        //paciente agrega su historia
        this.persistencia.modificar(p); 
        //modifico paciente? por ahora no
        this.persistencia.insertar(historia);
        this.persistencia.confirmarTransaccion();
    }
    
    public int eliminarHistoria(Historia h) {
        this.persistencia.iniciarTransaccion();
        this.persistencia.eliminar(h);
        h.getPaciente().quitarHistoriaClinica(h);
        this.persistencia.confirmarTransaccion();
        return 0;
    }
    
    public List listarTurnos() {
        return this.persistencia.buscarTodosOrdenadosPor(Cita.class,Cita_.medico);
    }
    
    public Object[] listarTurnos(Medico m, Object[] turnos){
    //entra un medico y las citas del dia. tengo que sacar solo las del medico
        ArrayList<Cita> listaResultante = new ArrayList<>();
        Cita aux;
        for(int i=0;i<turnos.length;i++){
            aux = (Cita)turnos[i];
            if(m==aux.getMedico()){
                listaResultante.add(aux);
            } else {
                //break;
            }
        }
        //LISTA ORDENADA
        listaResultante.sort(Comparator.comparing(Cita::getId));
        
        return listaResultante.toArray();
    }
    
    public Object[] listarTurnos(Date d){
                                                                                                   //Cita_.horaComienzo
        ArrayList<Cita> lista= new ArrayList<>(this.persistencia.buscarTodosOrdenadosPor(Cita.class, Cita_.medico));
        ArrayList<Cita> listaResultante = new ArrayList<>();
        Cita aux;
        //todas las citas de ese doctor van a estar al principio de la lista.
        for(int i=0;i<lista.size();i++){
            aux = lista.get(i);
            //pregunto si el dia que le pase es igual al de la cita
            if(d.getDate()== aux.getHoraComienzo().getDate()){
                System.out.println(d.getDate()+" = "+aux.getHoraComienzo().getDate());
                //agrego si esta diponible, si esta ocupado no lo listo
                if(aux.isDisponible()){
                    listaResultante.add(aux);
                }
            }
            
        }
        
        
        return listaResultante.toArray();
    }
    
    public Object[] listarTurnos(Paciente p){
        ArrayList<Cita> lista= new ArrayList<>(this.persistencia.buscarTodosOrdenadosPor(Cita.class, Cita_.paciente));
        ArrayList<Cita> listaResultante = new ArrayList<>();
        Cita aux;

        for(int i=0;i<lista.size();i++){
            aux = lista.get(i);
            if(p==aux.getPaciente()){
            //si esta disponible no deberia aparecer aqui.
                if(!aux.isDisponible())
                    listaResultante.add(aux);
            } else {
                //break;
            }
        }
        listaResultante.sort(Comparator.comparing(Cita::getHoraComienzo));
        
        return listaResultante.toArray();
        
    }
    public Object[] listarTurnosRecordatorio(Date d){
                                                                                                   //Cita_.horaComienzo
        ArrayList<Cita> lista= new ArrayList<>(this.persistencia.buscarTodosOrdenadosPor(Cita.class, Cita_.medico));
        ArrayList<Cita> listaResultante = new ArrayList<>();
        Cita aux;
        //todas las citas de ese doctor van a estar al principio de la lista.
        for(int i=0;i<lista.size();i++){
            aux = lista.get(i);
            //pregunto si el dia que le pase es igual al de la cita
            if(d.getDate()== aux.getHoraComienzo().getDate()){
                //System.out.println(aux);
                //agrego si esta diponible, si esta ocupado no lo listo
                //if(aux.isDisponible()){
                    listaResultante.add(aux);
                //}
                
            }
            
        }
        
        listaResultante.sort(Comparator.comparing(Cita::getHoraComienzo));
        return listaResultante.toArray();
    }
    
    //se usa para crear vacio
    public void agregarTurno(Medico m, Date horaComienzo, Date horaTermina){
        this.persistencia.iniciarTransaccion();
        Cita c = new Cita(horaComienzo,horaTermina, true);
        c.setMedico(m);
        this.persistencia.insertar(c);
        this.persistencia.confirmarTransaccion();
    }
    
    public void editarTurno(Cita c) {
        this.persistencia.iniciarTransaccion();
        this.persistencia.modificar(c);
        //agrego la cita al perfil del paciente
        c.getPaciente().agregarCitas(c);
        this.persistencia.modificar(c.getPaciente());
        this.persistencia.confirmarTransaccion();
    }
    //
    public void cancelarTurno(Cita c) {
        this.persistencia.iniciarTransaccion();
        c.setAsistencia(false);
        c.setPaciente(null);//<------------
        this.persistencia.modificar(c);

        this.persistencia.confirmarTransaccion();
    }
}