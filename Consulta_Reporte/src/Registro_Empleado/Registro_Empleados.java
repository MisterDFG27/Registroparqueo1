package Registro_Empleado;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Registro_Empleados extends javax.swing.JFrame {

    int cont;

    public Registro_Empleados() {
        initComponents();
        setLocationRelativeTo(null);

        lblRequeridoCedula.setVisible(false);
        lblRequeridoNombre.setVisible(false);
        lblRequeridoAP1.setVisible(false);
        lblRequeridoAP2.setVisible(false);
        lblRequeridoCE.setVisible(false);
        lblRequeridoUsuario.setVisible(false);
        lblRequeridoContraseña.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrimerP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSegundoP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblRequeridoCedula = new javax.swing.JLabel();
        lblRequeridoNombre = new javax.swing.JLabel();
        lblRequeridoAP1 = new javax.swing.JLabel();
        lblRequeridoCE = new javax.swing.JLabel();
        lblRequeridoUsuario = new javax.swing.JLabel();
        lblRequeridoContraseña = new javax.swing.JLabel();
        lblRequeridoAP2 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        chVerContra = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Registro de Empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 180, 30));

        btnmenu.setText("Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 577, -1, -1));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 145, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel3.setText("Cédula");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 145, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 141, -1));

        jLabel7.setText("Primer Apellido");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));
        jPanel1.add(txtPrimerP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 145, -1));

        jLabel6.setText("Correo electrónico");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        jLabel8.setText("Segundo Apellido");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));
        jPanel1.add(txtSegundoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 145, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Datos de Usuario");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabel10.setText("Usuario");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 103, -1));

        jLabel11.setText("Contraseña");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        jLabel12.setText("Tipo de usuario");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, -1));

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2" }));
        jPanel1.add(cmbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 103, -1));

        jLabel4.setText("Administración");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, -1));

        jLabel5.setText("Empleado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Datos Personales");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        lblRequeridoCedula.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoCedula.setText("Requerido");
        jPanel1.add(lblRequeridoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        lblRequeridoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoNombre.setText("Requerido");
        jPanel1.add(lblRequeridoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        lblRequeridoAP1.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoAP1.setText("Requerido");
        jPanel1.add(lblRequeridoAP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        lblRequeridoCE.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoCE.setText("Requerido");
        jPanel1.add(lblRequeridoCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        lblRequeridoUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoUsuario.setText("Requerido");
        jPanel1.add(lblRequeridoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, -1));

        lblRequeridoContraseña.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoContraseña.setText("Requerido");
        jPanel1.add(lblRequeridoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, -1, -1));

        lblRequeridoAP2.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoAP2.setText("Requerido");
        jPanel1.add(lblRequeridoAP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 100, -1));

        chVerContra.setText("Ver contraseña");
        chVerContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chVerContraActionPerformed(evt);
            }
        });
        jPanel1.add(chVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        cont = 0;

        if (txtcedula.getText().equals("")) {
            lblRequeridoCedula.setVisible(true);
            cont++;
        } else {
            lblRequeridoCedula.setVisible(false);

        }

        if (txtnombre.getText().equals("")) {
            lblRequeridoNombre.setVisible(true);
            cont++;
        } else {
            lblRequeridoNombre.setVisible(false);

        }

        if (txtPrimerP.getText().equals("")) {
            lblRequeridoAP1.setVisible(true);
            cont++;
        } else {
            lblRequeridoAP1.setVisible(false);

        }

        if (txtSegundoP.getText().equals("")) {
            lblRequeridoAP2.setVisible(true);
            cont++;
        } else {
            lblRequeridoAP2.setVisible(false);

        }

        if (txtEmail.getText().equals("")) {
            lblRequeridoCE.setVisible(true);
            cont++;
        } else {
            lblRequeridoCE.setVisible(false);

        }

        if (txtUsuario.getText().equals("")) {
            lblRequeridoUsuario.setVisible(true);
            cont++;
        } else {
            lblRequeridoUsuario.setVisible(false);

        }

        if (txtContraseña.getText().equals("")) {
            lblRequeridoContraseña.setVisible(true);
            cont++;
        } else {
            lblRequeridoContraseña.setVisible(false);

        }

        if (cont == 0) {

            try {
                datosP cc = new datosP();
                Connection cn = cc.conexion();

                PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario(nombreUsuario,"
                        + "contraseña,Cedula,nombre,primerApellido,segundoApellido,email,fk_tipoUsuario) VALUES (?,?,?,?,?,?,?,?)");
                pst.setString(1, txtUsuario.getText());
                pst.setString(2, txtContraseña.getText());
                pst.setString(3, txtcedula.getText());
                pst.setString(4, txtnombre.getText());
                pst.setString(5, txtPrimerP.getText());
                pst.setString(6, txtSegundoP.getText());
                pst.setString(7, txtEmail.getText());
                pst.setString(8, (String) cmbTipoUsuario.getSelectedItem());

                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e);
            }

            txtUsuario.setText("");
            txtContraseña.setText("");
            txtcedula.setText("");
            txtnombre.setText("");
            txtPrimerP.setText("");
            txtSegundoP.setText("");
            txtEmail.setText("");
            JOptionPane.showMessageDialog(this, "Guardado con exito");

        }


    }//GEN-LAST:event_btnguardarActionPerformed


    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed

        dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void chVerContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chVerContraActionPerformed

        if (chVerContra.isSelected()) {
            txtContraseña.setEchoChar((char) 0);
        } else {
            txtContraseña.setEchoChar('*');
        }


    }//GEN-LAST:event_chVerContraActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JCheckBox chVerContra;
    private javax.swing.JComboBox cmbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRequeridoAP1;
    private javax.swing.JLabel lblRequeridoAP2;
    private javax.swing.JLabel lblRequeridoCE;
    private javax.swing.JLabel lblRequeridoCedula;
    private javax.swing.JLabel lblRequeridoContraseña;
    private javax.swing.JLabel lblRequeridoNombre;
    private javax.swing.JLabel lblRequeridoUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPrimerP;
    private javax.swing.JTextField txtSegundoP;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
