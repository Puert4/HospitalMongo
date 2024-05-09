package presentation;

import JPAEntities.DoctorEntity;
import JPAEntities.PatientEntity;
import JPAEntities.Specialization;
import appointment.system.AppointmentStatus;
import appointment.system.IAppointmentManager;
import appointment.system.NewAppointmentDTO;
import doctor.system.ExistentDoctorDTO;
import doctor.system.IDoctorDAO;
import factory.Factory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import patient.system.ExistentPatientDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Point;
import patient.system.IPatientDAO;

public class JFrameRegisterAppointment extends javax.swing.JFrame {

    private ExistentPatientDTO paciente;
    private ExistentDoctorDTO doctorP1;
    private List<ExistentDoctorDTO> doctores;
    private ExistentDoctorDTO existentDoctorDTO;
    private ExistentPatientDTO existentPateintDTO;
    private JDateChooser dateChooser;
    private List<Calendar> limitDaysSelected;
    private List<Calendar> limitDaysParner;

    public JFrameRegisterAppointment(NewAppointmentDTO appointmentDTO, ExistentDoctorDTO doctorDTO) {

        this.doctorP1 = doctorDTO;
        initComponents();
        dateChooser();
//        limitarFecha();
        
        lblSpecilaization.setVisible(false);
        cbxSpecialization.setVisible(false);
        lblDate.setVisible(false);
        cmbDoctor.setVisible(false);
        lblDoctors1.setVisible(false);
        lblPatient.setText("Patients");
        
        limitDaysSelected = new ArrayList<>();
        patientList();
        for(int i = 0; i < cmbPatient.getItemCount(); i ++){
            cmbPatient.setSelectedIndex(i);
            if(appointmentDTO.getPatient().equals((ExistentPatientDTO)cmbPatient.getSelectedItem())){
                
                cmbPatient.setSelectedIndex(i);
                break;
            }
            
        }
//        cmbPatient.setSelectedItem(patientDTO);
        txtNota.setText(appointmentDTO.getNote());
        dateChooser.setCalendar(appointmentDTO.getAppointmentDate());
        cmbTime.setSelectedIndex(indexComboBox(dateChooser.getCalendar().get(Calendar.HOUR_OF_DAY)));
        

    }
    

    public JFrameRegisterAppointment(NewAppointmentDTO appointmentDTO, ExistentPatientDTO patientDTO) {
        this.paciente = patientDTO;
        initComponents();
        dateChooser();
//        limitarFecha();
        txtNota.setText(appointmentDTO.getNote());
        
        cbxSpecialization.setSelectedItem(appointmentDTO.getDoctor().getSpecialization());
        cmbDoctor.setSelectedItem(appointmentDTO.getDoctor());
        
        
        
        dateChooser.setCalendar(appointmentDTO.getAppointmentDate());
        
        lblDate.setVisible(false);
        cmbPatient.setVisible(false);
        lblPatient.setVisible(false);
        for(int i = 0; i < cbxSpecialization.getItemCount(); i ++){
            cbxSpecialization.setSelectedIndex(i);
            Specialization specialization = Specialization.StringToEnum((String)cbxSpecialization.getSelectedItem());
            if(appointmentDTO.getDoctor().getSpecialization().equals(specialization)){
                
                cbxSpecialization.setSelectedIndex(i);
                break;
            }
            
        }
        for(int i = 0; i < cmbDoctor.getItemCount(); i ++){
            cmbDoctor.setSelectedIndex(i);
            if(appointmentDTO.getDoctor().equals((ExistentDoctorDTO)cmbDoctor.getSelectedItem())){
                
                cmbDoctor.setSelectedIndex(i);
                break;
            }
            
        }
        cmbTime.setSelectedIndex(indexComboBox(dateChooser.getCalendar().get(Calendar.HOUR_OF_DAY)));
        
    }

    public JFrameRegisterAppointment(ExistentPatientDTO paciente) {
        this.paciente = paciente;
        initComponents();
        dateChooser();
//        limitarFecha();
        limitDaysSelected = new ArrayList<>();
        cmbPatient.setVisible(false);
        lblDate.setVisible(false);
        lblPatient.setVisible(false);
        
    }

    public JFrameRegisterAppointment(ExistentDoctorDTO doctor) {
        this.doctorP1 = doctor;
        initComponents();
        dateChooser();
//        limitarFecha();
        cmbDoctor.setVisible(false);
        lblSpecilaization.setVisible(false);
        cbxSpecialization.setVisible(false);
        lblDoctors1.setVisible(false);
        
        lblPatient.setText("Patients");
        limitDaysSelected = new ArrayList<>();
        patientList();
        lblDate.setVisible(false);
    }

    public void patientList() {

        IPatientDAO patientDAO = Factory.getPatientDAO();
        List<ExistentPatientDTO> patientList = patientDAO.findAllPatient();
        cmbPatient.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbPatient.setModel(model);
        for (ExistentPatientDTO patient : patientList) {
            model.addElement(patient);
        }
        this.cmbPatient.setVisible(true);

    }

    public void dateChooser() {

        this.dateChooser = new JDateChooser();
        this.dateChooser.setBounds(this.lblDate.getBounds());
        this.FondoPanel.add(dateChooser);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoPanel = new javax.swing.JPanel();
        FondoAzul = new javax.swing.JPanel();
        Hospital_General = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbDoctor = new javax.swing.JComboBox<>();
        lblPatient = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lblTime = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        cbxSpecialization = new javax.swing.JComboBox<>();
        lblSpecilaization = new javax.swing.JLabel();
        lblDoctors1 = new javax.swing.JLabel();
        cmbPatient = new javax.swing.JComboBox<>();
        lblDate = new javax.swing.JLabel();
        cmbTime = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FondoPanel.setBackground(new java.awt.Color(255, 255, 255));
        FondoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FondoAzul.setBackground(new java.awt.Color(0, 153, 255));
        FondoAzul.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Hospital_General.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Hospital_General.setText("General Hospital");

        javax.swing.GroupLayout FondoAzulLayout = new javax.swing.GroupLayout(FondoAzul);
        FondoAzul.setLayout(FondoAzulLayout);
        FondoAzulLayout.setHorizontalGroup(
            FondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Hospital_General, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        FondoAzulLayout.setVerticalGroup(
            FondoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Hospital_General, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Register Appointment");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        cmbDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbDoctorMouseClicked(evt);
            }
        });
        cmbDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDoctorActionPerformed(evt);
            }
        });

        lblPatient.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPatient.setText("Patients");

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTime.setText("Time");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Note...");

        txtNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaActionPerformed(evt);
            }
        });

        cbxSpecialization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FAMILY",   "PEDIATRIC",
            "SURGERY",
            "PSYCHIATRY",
            "ANESTHIOLOGY",
            "CARDIOLOGY"}));
cbxSpecialization.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbxSpecializationActionPerformed(evt);
    }
    });

    lblSpecilaization.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    lblSpecilaization.setText("Specialization");

    lblDoctors1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    lblDoctors1.setText("Doctors");

    cmbPatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

    cmbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel14.setText("Date ");

    javax.swing.GroupLayout FondoPanelLayout = new javax.swing.GroupLayout(FondoPanel);
    FondoPanel.setLayout(FondoPanelLayout);
    FondoPanelLayout.setHorizontalGroup(
        FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(FondoPanelLayout.createSequentialGroup()
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)
                    .addComponent(FondoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel1))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(260, 260, 260)
                    .addComponent(lblSpecilaization)
                    .addGap(12, 12, 12)
                    .addComponent(lblPatient)
                    .addGap(18, 18, 18)
                    .addComponent(lblDoctors1))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(260, 260, 260)
                    .addComponent(cbxSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FondoPanelLayout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(cmbDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(280, 280, 280)
                    .addComponent(jLabel14)
                    .addGap(120, 120, 120)
                    .addComponent(lblTime))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(280, 280, 280)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(136, 136, 136)
                    .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(280, 280, 280)
                    .addComponent(jLabel13))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(280, 280, 280)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jButton2)
                    .addGap(518, 518, 518)
                    .addComponent(jButton1)))
            .addGap(2, 2, 2))
    );
    FondoPanelLayout.setVerticalGroup(
        FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(FondoPanelLayout.createSequentialGroup()
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(FondoPanelLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(FondoAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(17, 17, 17)
            .addComponent(jLabel1)
            .addGap(68, 68, 68)
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblSpecilaization)
                .addComponent(lblPatient)
                .addComponent(lblDoctors1))
            .addGap(8, 8, 8)
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(cbxSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmbDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel14)
                .addComponent(lblTime))
            .addGap(8, 8, 8)
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(cmbTime, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(20, 20, 20)
            .addComponent(jLabel13)
            .addGap(8, 8, 8)
            .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(50, 50, 50)
            .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton2)
                .addComponent(jButton1)))
    );

    getContentPane().add(FondoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 880, 490));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public int hour(){
        
        int index = cmbTime.getSelectedIndex();
        
        return switch (index) {
            case 0 -> 10;
            case 1 -> 11;
            case 2 -> 12;
            case 3 -> 13;
            case 4 -> 14;
            case 5 -> 15;
            case 6 -> 16;
            case 7 -> 17;
            case 8 -> 18;
            case 9 -> 19;
            case 10 -> 20;
            case 11 -> 21;
            case 12 -> 22;
            case 13 -> 23;
            default -> 4444;
        };
        
    }
    
    public int indexComboBox(int hour){
        
        return switch (hour) {
            case 10 -> 0;
            case 11 -> 1;
            case 12 -> 2;
            case 13 -> 3;
            case 14 -> 4;
            case 15 -> 5;
            case 16 -> 6;
            case 17 -> 7;
            case 18 -> 8;
            case 19 -> 9;
            case 20 -> 10;
            case 21 -> 11;
            case 22 -> 12;
            case 23 -> 13;
            default -> 4554;
        };
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        
        limitDaysSelected();
        
        Calendar dateWithTime = dateChooser.getCalendar();
        
        int date = dateWithTime.get(Calendar.DATE);
        dateWithTime.set(Calendar.HOUR_OF_DAY, hour());
        dateWithTime.set(Calendar.MINUTE, 0);
        dateWithTime.set(Calendar.SECOND, 0);
        dateWithTime.set(Calendar.DATE, date);
        dateChooser.setCalendar(dateWithTime);
        
        
        for (Calendar calendar : limitDaysSelected) {

            if (dateChooser.getCalendar().get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {

                if (dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {

                    if (dateChooser.getCalendar().get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                        
                        if(dateChooser.getCalendar().get(Calendar.HOUR) == calendar.get(Calendar.HOUR)){
                            
                            JOptionPane.showMessageDialog(this, "This date has already been set aside");
                            return;
                        }
                    }
                }
            }
            
        }
        limitDaysParner();
        for (Calendar calendar : limitDaysParner) {

            if (dateChooser.getCalendar().get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {

                if (dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {

                    if (dateChooser.getCalendar().get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                        
                        if(dateChooser.getCalendar().get(Calendar.HOUR) == calendar.get(Calendar.HOUR)){
                            
                            JOptionPane.showMessageDialog(this, "You already have an appointment that day");
                            return;
                        }
                    }
                }
            }
            
        }
        if (doctorP1 == null) {

            createUser();
            NewAppointmentDTO newAppointmentDTO = new NewAppointmentDTO();
            newAppointmentDTO.setDoctor(existentDoctorDTO);
            newAppointmentDTO.setPatient(paciente);
            newAppointmentDTO.setStatus(AppointmentStatus.ACTIVE);
            newAppointmentDTO.setAppointmentDate(dateChooser.getCalendar());
            newAppointmentDTO.setNote(txtNota.getText());

            JFrameConfirmAppointment confirm = new JFrameConfirmAppointment(newAppointmentDTO, paciente);
            confirm.setVisible(true);
            this.dispose();

        } else {

            createUser();
            NewAppointmentDTO newAppointmentDTO = new NewAppointmentDTO();
            newAppointmentDTO.setDoctor(doctorP1);
            newAppointmentDTO.setPatient(existentPateintDTO);
            newAppointmentDTO.setStatus(AppointmentStatus.ACTIVE);
            newAppointmentDTO.setAppointmentDate(dateChooser.getCalendar());
            newAppointmentDTO.setNote(txtNota.getText());

            JFrameConfirmAppointment confirm = new JFrameConfirmAppointment(newAppointmentDTO, doctorP1);
            confirm.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (doctorP1 == null) {

            JFrameInitialPatient pat = new JFrameInitialPatient(paciente.getId());
            pat.setVisible(true);
            this.dispose();

        } else {

            JFrameInitialMedicos medic = new JFrameInitialMedicos(doctorP1.getId());
            medic.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void createUser(){
        
        if (doctorP1 == null) {
            existentDoctorDTO = (ExistentDoctorDTO) cmbDoctor.getSelectedItem();
        } else {
            existentPateintDTO = (ExistentPatientDTO) cmbPatient.getSelectedItem();
        }
        
    }
    
    private void cmbDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDoctorActionPerformed

        createUser();
    }//GEN-LAST:event_cmbDoctorActionPerformed

    private void cbxSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSpecializationActionPerformed

        if (doctorP1 == null) {
            Specialization specializationEnum = Specialization.PEDIATRIC;
            IDoctorDAO doctorDAO = Factory.getDoctorDAO();

            String selectedSpecialization = (String) cbxSpecialization.getSelectedItem();
            doctores = doctorDAO.searchBySpecialization(specializationEnum.StringToEnum(selectedSpecialization));
            cmbDoctor.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            cmbDoctor.setModel(model);
            for (ExistentDoctorDTO doctor : doctores) {
                model.addElement(doctor);
            }
            this.cmbDoctor.setVisible(true);
        }
    }//GEN-LAST:event_cbxSpecializationActionPerformed

    public void limitDaysParner(){
        
        IAppointmentManager appointmentManager = Factory.getAppointmentManager();
        
        if(doctorP1 == null){
            
            IPatientDAO patientDAO = Factory.getPatientDAO();
            PatientEntity patientEntity = patientDAO.ExistentDtoToEntity(paciente);
            if(appointmentManager.findLimitDays(patientEntity) != null){
                
                limitDaysParner = appointmentManager.findLimitDays(patientEntity);
                
            }
            
        }else{
            
            IDoctorDAO doctorDAO = Factory.getDoctorDAO();
            DoctorEntity doctorEntity = doctorDAO.ExistentDtoToEntity(doctorP1);
            if(appointmentManager.findLimitDays(doctorEntity) != null){
                
                limitDaysParner = appointmentManager.findLimitDays(doctorEntity);
                
            }
            
        }
        
    }
    
    public void limitDaysSelected() {

        IAppointmentManager appointmentManager = Factory.getAppointmentManager();
        if (doctorP1 == null) {
            IDoctorDAO doctorDAO = Factory.getDoctorDAO();
            ExistentDoctorDTO existentDoctor = (ExistentDoctorDTO) cmbDoctor.getSelectedItem();
            DoctorEntity doctorEntity = doctorDAO.ExistentDtoToEntity(existentDoctor);
            if (appointmentManager.findLimitDays(doctorEntity) != null) {
                limitDaysSelected = appointmentManager.findLimitDays(doctorEntity);
            }
        } else {
            IPatientDAO patientDAO = Factory.getPatientDAO();
            ExistentPatientDTO existentPatientDTO = (ExistentPatientDTO) cmbPatient.getSelectedItem();
            PatientEntity patientEntity = patientDAO.findPatient(existentPatientDTO.getId());
            if (appointmentManager.findLimitDays(patientEntity) != null) {
                limitDaysSelected = appointmentManager.findLimitDays(patientEntity);
            }
        }
    }

    private void cmbDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbDoctorMouseClicked
        // TODO add your handling code 
        if (doctorP1 == null) {
            if (cmbDoctor.getSize() != null) {
                limitDaysSelected();
            }
        }
    }//GEN-LAST:event_cmbDoctorMouseClicked

    private void txtNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaActionPerformed

//    public void limitarFecha() {
//        Calendar fechaMinima = Calendar.getInstance();
//        fechaMinima.set(Calendar.DATE, 1);
//        Date minimo = fechaMinima.getTime();
//
//        Calendar fechaMaxima = Calendar.getInstance();
//        fechaMaxima.add(Calendar.YEAR, 2);
//        Date maximo = fechaMaxima.getTime();
//
//        dateChooser.setSelectableDateRange(minimo, maximo);
//
//    }

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
//            java.util.logging.Logger.getLogger(JFrameConfirmAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameConfirmAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameConfirmAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameConfirmAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameConfirmAppointment().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoAzul;
    private javax.swing.JPanel FondoPanel;
    private javax.swing.JLabel Hospital_General;
    private javax.swing.JComboBox<String> cbxSpecialization;
    private javax.swing.JComboBox<String> cmbDoctor;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JComboBox<String> cmbTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDoctors1;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblSpecilaization;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
