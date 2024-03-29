/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;

public class VentanaTurnos extends javax.swing.JFrame {

    private final Controlador controlador;
    private final JFrame previo;
    private Cita cita;
    private Object[] listaTurnosDia;
    
    public VentanaTurnos(Controlador c, JFrame p) {
        this.controlador = c;
        this.previo = p;
        this.cita = new Cita();
        initComponents();      
        limpiar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSeleccionarTurno = new javax.swing.JButton();
        comboEspecialidad = new javax.swing.JComboBox<>();
        lblEspecialidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTurnos = new javax.swing.JList();
        dateSeleccion = new rojeru_san.componentes.RSDateChooser();
        comboDoctores = new javax.swing.JComboBox<>();
        lblDoctores = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        lblDuracionTurno = new javax.swing.JLabel();
        lblHorarioTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Turnos");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnSeleccionarTurno.setText("Seleccionar Turno");
        btnSeleccionarTurno.setToolTipText("Editar turno");
        btnSeleccionarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarTurnoActionPerformed(evt);
            }
        });

        comboEspecialidad.setToolTipText("");
        comboEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEspecialidadItemStateChanged(evt);
            }
        });

        lblEspecialidad.setText("Seleccione una especialidad:");

        listaTurnos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listaTurnosFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(listaTurnos);

        dateSeleccion.setToolTipText("seleccionar la fecha que desea");
        dateSeleccion.setName(""); // NOI18N
        dateSeleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateSeleccionMouseEntered(evt);
            }
        });

        comboDoctores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDoctoresItemStateChanged(evt);
            }
        });

        lblDoctores.setText("Seleccione un doctor:");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("TURNOS");

        btnCrear.setText("Crear Turnos");
        btnCrear.setToolTipText("Tiene que confirmar la fecha para que muestre los turnos");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        lblDuracionTurno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblHorarioTurno.setPreferredSize(new java.awt.Dimension(49, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateSeleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDoctores, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(btnSeleccionarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDoctores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDuracionTurno))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEspecialidad)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblHorarioTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(13, 13, 13)
                .addComponent(dateSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEspecialidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctores)
                    .addComponent(lblDuracionTurno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHorarioTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarTurno)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void btnSeleccionarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarTurnoActionPerformed
        // TODO add your handling code here:
        this.cita = (Cita)listaTurnos.getSelectedValue();
        VentanaTurnosABM vcABM = new VentanaTurnosABM(this.controlador, this, this.cita,0);
        this.setVisible(true);
        vcABM.setLocationRelativeTo(null);
        vcABM.setResizable(false);
        vcABM.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarTurnoActionPerformed

    private void comboEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEspecialidadItemStateChanged
        // TODO add your handling code here:
        Especialidad e = (Especialidad) comboEspecialidad.getSelectedItem();
        
        mostrarDoctor();
        if (e!=null){
            comparacionFecha();
            verTurnosDia(dateSeleccion.getDatoFecha());
        } else {
            deshabilitarBotonCrear();
        }
        
        this.lblDuracionTurno.setText("");
    }//GEN-LAST:event_comboEspecialidadItemStateChanged

    private void comboDoctoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDoctoresItemStateChanged

        Medico m = (Medico) comboDoctores.getSelectedItem();
        if (m!=null){
            this.lblDuracionTurno.setText("Duración turno: " + m.getTiempoTurno() + " min");
            mostrarHorarioTurno();
            this.cita.setMedico(m);
            verTurnosDoctor(m);
        } else {
            deshabilitarBotonCrear();
            btnSeleccionarTurno.setEnabled(false);
            this.listaTurnos.setListData(new String[0]);    //limpia la lista
        }
        
    
    }//GEN-LAST:event_comboDoctoresItemStateChanged

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        deshabilitarBotonCrear();
        Medico m = (Medico)comboDoctores.getSelectedItem();
        if(comboEspecialidad.getSelectedIndex()!=-1 && comboDoctores.getSelectedIndex()!=-1){
            crearTurnos();
        }
        visualizarTurnos();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void dateSeleccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateSeleccionMouseEntered
        System.out.println("evento cambio + "+dateSeleccion.getDatoFecha());
        //deshabilitarBotonCrear();
    }//GEN-LAST:event_dateSeleccionMouseEntered

    private void listaTurnosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listaTurnosFocusGained
        // TODO add your handling code here:
        habilitarBotonSeleccionarTurno();
        visualizarTurnos();
        
    }//GEN-LAST:event_listaTurnosFocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
        visualizarTurnos();
        //System.out.println("visualizo turnos");
    }//GEN-LAST:event_formFocusGained

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        visualizarTurnos();
        //System.out.println("cambio de estado??");
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        comparacionFecha();
        
        Especialidad e = (Especialidad) comboEspecialidad.getSelectedItem();
        Medico m = (Medico) comboDoctores.getSelectedItem();
        mostrarDoctor();
        this.comboDoctores.setSelectedItem(m);
        if (e!=null){
            //verTurnosDia(dateSeleccion.getDatoFecha());
            deshabilitarBotonCrear();
            
        }
        visualizarTurnos();
        //System.out.println("GANO EL FOCO");
        //si es domingo no deberia aparecer el "crear"
        if(dateSeleccion.getDatoFecha().getDay() ==0)
            deshabilitarBotonCrear();
    }//GEN-LAST:event_formWindowGainedFocus

    
    
    public void mostrarDoctor(){
        Especialidad e = (Especialidad) comboEspecialidad.getSelectedItem();
        if (e != null){
            DefaultComboBoxModel modeloComboMedicos = new DefaultComboBoxModel(e.getMedico().toArray());
            this.comboDoctores.setModel(modeloComboMedicos);
            this.comboDoctores.setSelectedIndex(-1);
        }
        
    }

    private void verTurnosDia(Date d){
        //TURNOS POR DIA NO IMPORTA DOCTOR
        //System.out.println("imprime? verTurnosDia");
        this.listaTurnosDia= this.controlador.listarTurnos(d);
        //no muestro las citas
//        this.listaTurnos.setListData(this.listaTurnosDia);
    }
    
    private void verTurnosDoctor(Medico m){
        //System.out.println("imprime? verTurnosDoctor");
        Object[] aux = this.controlador.listarTurnos(m, this.listaTurnosDia);
        this.listaTurnos.setListData(aux);
        if (aux.length==0){
            comparacionFecha();
            deshabilitarBotonSeleccionarTurno();
        }
        
    }
    
    private void crearTurnos(){
    //ya tengo seleccionado el doctor y voy a crear citas vacias para ese doctor
        Date a = new Date();
        //System.out.println("imprime? crear"+a+"|"+dateSeleccion.getDatoFecha());
        if(dateSeleccion.getDatoFecha().getDay()!=0){
            if(dateSeleccion.getDatoFecha().compareTo(a) > 0 || dateSeleccion.getDatoFecha().getDate()==a.getDate()){
                //System.out.println("entro");
                Calendar dia = Calendar.getInstance();//crear una instancia de calendario se usa para hora empieza
                Calendar aux = Calendar.getInstance();//instancia para horatermina 
                dia.setTime(dateSeleccion.getDatoFecha()); //dia que seleccione en el combo
            //  System.out.println(dateSeleccion.getDatoFecha());
                dia.set(Calendar.HOUR_OF_DAY,this.cita.getMedico().getHorarioInicio().getHours());
                dia.set(Calendar.MINUTE,this.cita.getMedico().getHorarioInicio().getMinutes());
                aux.setTime(dateSeleccion.getDatoFecha()); //dia que seleccione en el combo
                aux.set(Calendar.HOUR_OF_DAY,this.cita.getMedico().getHorarioInicio().getHours());
                aux.set(Calendar.MINUTE,this.cita.getMedico().getHorarioInicio().getMinutes()+this.cita.getMedico().getTiempoTurno());
                int rango = (this.cita.getMedico().getHorarioFinal().getHours()
                            -this.cita.getMedico().getHorarioInicio().getHours())*60;
                int cantTurnosDia = rango/this.cita.getMedico().getTiempoTurno();
                for (int i=1;i<=cantTurnosDia;i++){
                    this.controlador.agregarTurno(this.cita.getMedico(), dia.getTime(), aux.getTime());
                    aux.add(Calendar.MINUTE, this.cita.getMedico().getTiempoTurno());
                    dia.add(Calendar.MINUTE, this.cita.getMedico().getTiempoTurno());
                }
            //se pueden crear duplicados
            }
        }
        
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnSeleccionarTurno;
    private javax.swing.JComboBox<String> comboDoctores;
    private javax.swing.JComboBox<String> comboEspecialidad;
    private rojeru_san.componentes.RSDateChooser dateSeleccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoctores;
    private javax.swing.JLabel lblDuracionTurno;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblHorarioTurno;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList listaTurnos;
    // End of variables declaration//GEN-END:variables

    private void limpiar(){
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(this.controlador.listarEspecialidades().toArray());
        this.comboEspecialidad.setModel(modeloCombo);
        this.comboEspecialidad.setSelectedIndex(-1);
        this.comboDoctores.setSelectedIndex(-1);
        this.dateSeleccion.setFormatoFecha("dd/MM/yyyy");
        this.dateSeleccion.setDatoFecha(new Date());
        deshabilitarBotonSeleccionarTurno();
        //deshabilitarBotonCrear();
        comparacionFecha();
        
    }
    
    private void comparacionFecha() {
        //System.out.println("imprime comparacion fecha");
        if ((this.dateSeleccion.getDatoFecha().getDate() < (new Date().getDate()) &&
            (this.dateSeleccion.getDatoFecha().getYear() <= (new Date().getYear()))
            ) ||
           (this.comboDoctores.getSelectedIndex() == -1 || 
            this.comboEspecialidad.getSelectedIndex() == -1)     
            ){
            deshabilitarBotonCrear();
        } else {
            habilitarBotonCrear();
        }
    }
    
    private void habilitarBotonCrear(){
        this.btnCrear.setEnabled(true);
    }
    
    private void deshabilitarBotonCrear(){
        this.btnCrear.setEnabled(false);
    }
    
    private void cerrar(){
        this.previo.setVisible(true);
        this.dispose();
    }
    
    private void deshabilitarBotonSeleccionarTurno(){
        this.btnSeleccionarTurno.setEnabled(false);
    }
    
    private void habilitarBotonSeleccionarTurno(){
        this.btnSeleccionarTurno.setEnabled(true);
    }

    public void visualizarTurnos() {
        Medico m = (Medico)comboDoctores.getSelectedItem();
        habilitarBotonSeleccionarTurno();
        
        verTurnosDia(dateSeleccion.getDatoFecha());
        //System.out.println(dateSeleccion.getDatoFecha());
        verTurnosDoctor(m);
        if(comboDoctores.getSelectedIndex()==-1){
            lblHorarioTurno.setText("");
        }
    }
    
    private void mostrarHorarioTurno(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
        Medico m = (Medico) comboDoctores.getSelectedItem();
        if (comboDoctores.getSelectedIndex()!= -1){
            lblHorarioTurno.setText("Turno: "+ formatoFecha.format(m.getHorarioInicio())
                + " - " + formatoFecha.format(m.getHorarioFinal()));
        }
    }
}