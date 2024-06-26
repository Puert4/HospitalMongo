package presentation;

import appointment.system.ExistentAppointmentDTO;
import appointment.system.IAppointmentManager;
import factory.Factory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import patient.system.ExistentPatientDTO;
import user.system.ExistentUserDTO;

public class JFrameInitialPatient extends javax.swing.JFrame {

    private ArrayList<ObjectId> listaDeLongs = new ArrayList<>();
    private ExistentUserDTO existentUserDTO;

    /**
     * Creates new form InicioPaciente
     */
    public JFrameInitialPatient(ExistentUserDTO existentUserDTO) {
        this.existentUserDTO = existentUserDTO;

        initComponents();
        //   IPatientDAO patientSystem = Factory.getPatientDAO();
        //   paciente = patientSystem.EntityToDto(patientSystem.serachPatientById(idPatient));
        cargarCitasPaciente();
    }

    private void cargarCitasPaciente() {
//        DefaultTableModel tblModel = (DefaultTableModel) jTableAppointment.getModel();
//        tblModel.setRowCount(0); // Limpiar la tabla antes de cargar los nuevos datos
//
//        IAppointmentManager appointmentManager = Factory.getAppointmentManager();
//
//        List<ExistentAppointmentDTO> appointments = appointmentManager.getAppointmentsByCurp(existentUserDTO.getPatientDTO().getCurp());
//
//        for (ExistentAppointmentDTO appointment : appointments) {
//            tblModel.addRow(new Object[]{
//                appointment.getAppointmentDate().getTime(),
//                appointment.getDoctor().getName(),
//                appointment.getNote(),
//                appointment.getStatus()
//            });
//            listaDeLongs.add(appointment.getId());
//        }

        DefaultTableModel tblModel = (DefaultTableModel) jTableAppointment.getModel();
        tblModel.setRowCount(0); // Limpiar la tabla antes de cargar los nuevos datos

        IAppointmentManager appointmentManager = Factory.getAppointmentManager();

        List<ExistentAppointmentDTO> appointments = appointmentManager.getAppointmentsByCurp(existentUserDTO.getPatientDTO().getCurp());

        // Formato de fecha personalizado
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());

        for (ExistentAppointmentDTO appointment : appointments) {
            // Formatear la fecha
            String formattedDate = dateFormat.format(appointment.getAppointmentDate());

            tblModel.addRow(new Object[]{
                formattedDate,
                appointment.getDoctor().getName(),
                appointment.getNote(),
                appointment.getStatus()
            });
            listaDeLongs.add(appointment.getId());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        FondoPanel = new javax.swing.JPanel();
        FondoAzul = new javax.swing.JPanel();
        Hospital_General = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAppointment = new javax.swing.JTable();
        btn_cancelAppointment = new javax.swing.JButton();
        btnCreateAppointment = new javax.swing.JButton();
        txtCloseSesion = new javax.swing.JButton();

        jButton2.setText("AgendarCita");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FondoPanel.setBackground(new java.awt.Color(255, 255, 255));
        FondoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FondoAzul.setBackground(new java.awt.Color(0, 153, 255));
        FondoAzul.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FondoAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Hospital_General.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Hospital_General.setText("General Hospital");
        FondoAzul.add(Hospital_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 39));

        FondoPanel.add(FondoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        jTableAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Doctor", "Note", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAppointment);

        FondoPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 157, 840, 320));

        btn_cancelAppointment.setText("Cancel Appointment");
        btn_cancelAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelAppointmentActionPerformed(evt);
            }
        });
        FondoPanel.add(btn_cancelAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        btnCreateAppointment.setText("Create Appointment");
        btnCreateAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAppointmentActionPerformed(evt);
            }
        });
        FondoPanel.add(btnCreateAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        txtCloseSesion.setText("Signout");
        txtCloseSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCloseSesionActionPerformed(evt);
            }
        });
        FondoPanel.add(txtCloseSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        getContentPane().add(FondoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 880, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCreateAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAppointmentActionPerformed
        // TODO add your handling code here:
        JFrameRegisterAppointment register = new JFrameRegisterAppointment(existentUserDTO);
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCreateAppointmentActionPerformed

    private void txtCloseSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCloseSesionActionPerformed
        // TODO add your handling code here:
        JFrameLogin frameLogin = new JFrameLogin();
        frameLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtCloseSesionActionPerformed

    private void btn_cancelAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelAppointmentActionPerformed
        // TODO add your handling code here:

        IAppointmentManager appointmentManager = Factory.getAppointmentManager();
        int selectedIndex = jTableAppointment.getSelectedRow();

        // Asegurarse de que la fila seleccionada esté dentro de los límites
        if (selectedIndex >= 0 && selectedIndex < listaDeLongs.size()) {
            ObjectId valorCorrespondiente = listaDeLongs.get(selectedIndex);

            if (appointmentManager.cancelAppointment(valorCorrespondiente)) {

                JOptionPane.showMessageDialog(this, "The appointment has been Successfully removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                cargarCitasPaciente();

            }

        } else {
            JOptionPane.showMessageDialog(null, "Index not valid", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_cancelAppointmentActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JFInitialPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFInitialPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFInitialPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFInitialPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFInitialPatient().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoAzul;
    private javax.swing.JPanel FondoPanel;
    private javax.swing.JLabel Hospital_General;
    private javax.swing.JButton btnCreateAppointment;
    private javax.swing.JButton btn_cancelAppointment;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAppointment;
    private javax.swing.JButton txtCloseSesion;
    // End of variables declaration//GEN-END:variables
}
