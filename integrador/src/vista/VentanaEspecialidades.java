/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author sebas
 */
public class VentanaEspecialidades extends javax.swing.JFrame {

    private final Controlador controlador;
    private final JFrame previo;
    private Set<Medico> lista;
    
    public VentanaEspecialidades(Controlador c, JFrame p) {
        this.controlador = c;
        this.previo = p;
        initComponents();
        limpiar();
        this.lista= new HashSet<>();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminarDoctor = new javax.swing.JButton();
        btnAgregarEspecialidad = new javax.swing.JButton();
        lblListado = new javax.swing.JLabel();
        comboEspecialidades = new javax.swing.JComboBox<>();
        btnEliminarEspecialidad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEspecialidades = new javax.swing.JList();
        lblEspecialidad = new javax.swing.JLabel();
        btnAgregarDoctor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Especialidades");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnEliminarDoctor.setText("Quitar Doctor");
        btnEliminarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDoctorActionPerformed(evt);
            }
        });

        btnAgregarEspecialidad.setText("Agregar Especialidad");
        btnAgregarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEspecialidadActionPerformed(evt);
            }
        });

        lblListado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListado.setText("Listado de Doctores");

        comboEspecialidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEspecialidadesItemStateChanged(evt);
            }
        });

        btnEliminarEspecialidad.setText("Quitar Especialidad");
        btnEliminarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEspecialidadActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaEspecialidades);

        lblEspecialidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEspecialidad.setText("Seleccione una especialidad");

        btnAgregarDoctor.setText("Agregar Doctor");
        btnAgregarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDoctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEspecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(lblListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregarDoctor)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarDoctor))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregarEspecialidad)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarEspecialidad)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEspecialidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarEspecialidad)
                    .addComponent(btnAgregarEspecialidad))
                .addGap(18, 18, 18)
                .addComponent(lblListado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarDoctor)
                    .addComponent(btnAgregarDoctor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.previo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnAgregarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEspecialidadActionPerformed
        // TODO add your handling code here:
        Object result = JOptionPane.showInputDialog(rootPane, "Ingrese:",
                "Agregar Especialidad",JOptionPane.PLAIN_MESSAGE);
        if(result!=null){
            this.controlador.agregarEspecialidades(result.toString());
        }
        limpiar();
    }//GEN-LAST:event_btnAgregarEspecialidadActionPerformed

    private void btnEliminarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDoctorActionPerformed
        // TODO add your handling code here:
        
        if (!this.listaEspecialidades.isSelectionEmpty()) {
            Especialidad e = (Especialidad) comboEspecialidades.getSelectedItem();
            Medico m = (Medico) listaEspecialidades.getSelectedValue();
            int eleccion = JOptionPane.showConfirmDialog(rootPane, 
                    "Desea quitar a este Doctor?",
                    "Quitar Doctor de Especialidad",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                if (eleccion == JOptionPane.YES_OPTION){
                    //aca va el metodo para elimiar doctor
                    this.controlador.eliminarEspecialidadDoctor(e, m);
                    //limpiar();
                }
        }
        mostrar();
    }//GEN-LAST:event_btnEliminarDoctorActionPerformed

    private void btnEliminarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEspecialidadActionPerformed
        // TODO add your handling code here:
        Especialidad e = (Especialidad) comboEspecialidades.getSelectedItem();
        if (e != null) {
            int eleccion = JOptionPane.showConfirmDialog(rootPane, 
                "Desea eliminar la especialidad?",
                "Eliminar Especialidad",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (eleccion == JOptionPane.YES_OPTION){
                this.controlador.eliminarEspecialidades(e);
                limpiar();
            }
            
        }
    }//GEN-LAST:event_btnEliminarEspecialidadActionPerformed

    private void comboEspecialidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEspecialidadesItemStateChanged
        mostrar();
    }//GEN-LAST:event_comboEspecialidadesItemStateChanged

    private void btnAgregarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDoctorActionPerformed
        // TODO add your handling code here:
        Especialidad e = (Especialidad) comboEspecialidades.getSelectedItem();
        if (e != null){
            //pop-up para seleccionar un doctor.
            Medico input = (Medico) JOptionPane.showInputDialog(null,"Elija un doctor: ",
                    "Agregar doctor a Especialidad",JOptionPane.QUESTION_MESSAGE, null,
                    this.controlador.listarDoctoresEspecialidad(e).toArray(),
                    null);
            //this.controlador.listarDoctoresEspecialidad(e).toArray()[0]
            if (input != null)
                this.controlador.agregarEspecialidadesDoctor(e, input);
        } else {
            JOptionPane.showMessageDialog(rootPane, 
                    "Debe seleccionar una especialidad",
                    "",
                    JOptionPane.WARNING_MESSAGE);
        }
        mostrar();
    }//GEN-LAST:event_btnAgregarDoctorActionPerformed

    public void limpiar(){
        // TODO add your handling code here:
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(this.controlador.listarEspecialidades().toArray());
        this.comboEspecialidades.setModel(modeloCombo);
        comboEspecialidades.setSelectedIndex(-1);
        this.listaEspecialidades.setListData(new String[0]); 
    }
    
    public void mostrar(){
        Especialidad e = (Especialidad) comboEspecialidades.getSelectedItem();
        Set<Medico> lista = new HashSet<>();
        //para ver que no pueda poner duplicados.
                
        if (e != null){
            this.listaEspecialidades.setListData(e.getMedico().toArray()); 
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDoctor;
    private javax.swing.JButton btnAgregarEspecialidad;
    private javax.swing.JButton btnEliminarDoctor;
    private javax.swing.JButton btnEliminarEspecialidad;
    private javax.swing.JComboBox<String> comboEspecialidades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblListado;
    private javax.swing.JList listaEspecialidades;
    // End of variables declaration//GEN-END:variables
}
