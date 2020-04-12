package Registro_Vehiculos;

import Conexion.datosP;
import Menu.Menu_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Registro_Vehiculos extends javax.swing.JFrame {

    String CantidV;
    String placa;
    int cont;
    String date;

    public Registro_Vehiculos() {
        initComponents();
        setLocationRelativeTo(null);
        txtRequeridoID.setVisible(false);
        txtRequeridoPlaca.setVisible(false);
        txtRequeridoHora.setVisible(false);
        txtRequeridoFecha.setVisible(false);

    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
        date = dateFormat.format(txtFechaI.getDate());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoraEntrada = new javax.swing.JTextField();
        cmbTipoV = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtmenu = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbtotal = new javax.swing.JTable();
        txtCantiTotal = new javax.swing.JTextField();
        txtRequeridoPlaca = new javax.swing.JLabel();
        txtRequeridoFecha = new javax.swing.JLabel();
        txtRequeridoHora = new javax.swing.JLabel();
        txtRequeridoID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbUsuarioIDV = new javax.swing.JTable();
        txtIDparametroV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtFechaI = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 150, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Información del vehículo ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        jLabel4.setText("Número Placa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 120, -1));

        jLabel5.setText("Fecha de ingreso");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jLabel6.setText("Hora de entrada");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));
        jPanel1.add(txtHoraEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 120, -1));

        cmbTipoV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jPanel1.add(cmbTipoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 120, -1));

        jLabel7.setText("Tipo de vehículo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        jLabel8.setText("Pesado");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

        jLabel9.setText("Moto");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, -1, -1));

        jLabel10.setText("Liviano");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, -1, -1));

        txtmenu.setText("Menu");
        txtmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmenuActionPerformed(evt);
            }
        });
        jPanel1.add(txtmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel11.setText("Estado");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, -1, -1));

        txtEstado.setText("D");
        txtEstado.setEnabled(false);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Ingrese su ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));
        jPanel1.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("INGRESO DE VEHICULO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        tbtotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbtotal);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 249, 80));

        txtCantiTotal.setEnabled(false);
        jPanel1.add(txtCantiTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 95, 35));

        txtRequeridoPlaca.setText("Requerido");
        jPanel1.add(txtRequeridoPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, -1, -1));

        txtRequeridoFecha.setText("Requerido");
        jPanel1.add(txtRequeridoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, -1));

        txtRequeridoHora.setText("Requerido");
        jPanel1.add(txtRequeridoHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, -1, -1));

        txtRequeridoID.setText("Requerido");
        jPanel1.add(txtRequeridoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jLabel3.setText("Total de vehículos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, -1, -1));

        tbUsuarioIDV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbUsuarioIDV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbUsuarioIDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbUsuarioIDV);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 249, 60));

        txtIDparametroV.setEnabled(false);
        jPanel1.add(txtIDparametroV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 160, -1));

        jLabel13.setText("Usuario");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));
        jPanel1.add(txtFechaI, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrardatosTotalVehiculosDiaregistro(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Placa de vehículos");

        tbtotal.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT númeroPlaca FROM registro WHERE fk_estado = 'D'";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbtotal.setModel(modelo);

            txtCantiTotal.setText("" + tbtotal.getRowCount());

            //Bloquear la opcion a los 15
            CantidV = txtCantiTotal.getText();

            if (Integer.parseInt(CantidV) == 15) {

                txtPlaca.setEnabled(false);
                txtFechaI.setEnabled(false);
                txtHoraEntrada.setEnabled(false);
                txtIdUsuario.setEnabled(false);

            } else {
                txtPlaca.setEnabled(true);
                txtFechaI.setEnabled(true);
                txtHoraEntrada.setEnabled(true);
                txtIdUsuario.setEnabled(true);

            }
            //-----------------------

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbtotal.setVisible(true);

    }


    private void txtmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmenuActionPerformed

        dispose();
    }//GEN-LAST:event_txtmenuActionPerformed


    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        cont = 0;

        if (txtIdUsuario.getText().equals("")) {
            txtRequeridoID.setVisible(true);
            cont++;
        } else {
            txtRequeridoID.setVisible(false);

        }

        if (txtPlaca.getText().equals("")) {
            txtRequeridoPlaca.setVisible(true);
            cont++;
        } else {
            txtRequeridoPlaca.setVisible(false);
        }

        if (txtHoraEntrada.getText().equals("")) {
            txtRequeridoHora.setVisible(true);
            cont++;
        } else {
            txtRequeridoHora.setVisible(false);
        }

        if (cont == 0) {

            try {
                datosP cc = new datosP();
                Connection cn = cc.conexion();
                processCalendar();

                PreparedStatement pst = cn.prepareStatement("INSERT INTO registro(númeroPlaca,"
                        + "fecha,horaEntrada,fk_tipoVehiculo,fk_usuario,fk_estado) VALUES (?,?,?,?,?,?)");
                pst.setString(1, txtPlaca.getText());
                pst.setString(2, date);
                pst.setString(3, txtHoraEntrada.getText());
                pst.setString(4, (String) cmbTipoV.getSelectedItem());
                pst.setString(5, txtIdUsuario.getText());
                pst.setString(6, txtEstado.getText());

                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e);
            }

            txtPlaca.setText("");
            txtHoraEntrada.setText("");

            txtRequeridoID.setVisible(false);
            txtRequeridoPlaca.setVisible(false);
            txtRequeridoHora.setVisible(false);
            txtRequeridoFecha.setVisible(false);

            mostrardatosTotalVehiculosDiaregistro("");

            JOptionPane.showMessageDialog(this, "Registro agregado");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    public void mostrarIDTrabajadorV(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");

        tbUsuarioIDV.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT id_usuario, nombre, primerApellido FROM usuario WHERE nombreUsuario =  '" + txtIDparametroV.getText() + "'";

        }
        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);
            }
            tbUsuarioIDV.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbUsuarioIDV.setVisible(true);

    }

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
            java.util.logging.Logger.getLogger(Registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Vehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox cmbTipoV;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTable tbUsuarioIDV;
    public javax.swing.JTable tbtotal;
    public javax.swing.JTextField txtCantiTotal;
    private javax.swing.JTextField txtEstado;
    private com.toedter.calendar.JDateChooser txtFechaI;
    private javax.swing.JTextField txtHoraEntrada;
    public javax.swing.JTextField txtIDparametroV;
    public javax.swing.JTextField txtIdUsuario;
    public javax.swing.JTextField txtPlaca;
    private javax.swing.JLabel txtRequeridoFecha;
    private javax.swing.JLabel txtRequeridoHora;
    private javax.swing.JLabel txtRequeridoID;
    private javax.swing.JLabel txtRequeridoPlaca;
    private javax.swing.JButton txtmenu;
    // End of variables declaration//GEN-END:variables
  datosP cc = new datosP();
    Connection cn = cc.conexion();
}
