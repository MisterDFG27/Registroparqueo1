package consulta_reporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Reporte1 extends javax.swing.JFrame {

    /**
     *
     * Creates new form Reporte1
     */
    public Reporte1() {
        initComponents();
        setLocationRelativeTo(null);
    }

    //cantidad vehiculo liviano
    void mostrardatosVL(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantliv.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT count(*) From registro WHERE fk_tipovehiculo= '1' ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantliv.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //cantidad vehiculo Pesado
    void mostrardatosVP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantp.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT count(*) From registro WHERE fk_tipovehiculo= '2' ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantp.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //cantidad Moto
    void mostrardatosM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantm.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT count(*) From registro WHERE fk_tipovehiculo= '3' ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbcantm.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //monto liviano
    void mostrardatosML(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbmont1.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Sum(montototal), fk_tipoVehiculo From registro a INNER JOIN factura b on b.fk_registro = a.id_registro where fk_tipoVehiculo = 1 ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmont1.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //monto de pesados
    void mostrardatosMP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbmont2.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Sum(montototal), fk_tipoVehiculo From registro a INNER JOIN factura b on b.fk_registro = a.id_registro where fk_tipoVehiculo = 2 ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmont2.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Monto de motos
    void mostrardatosMM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbmont3.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Sum(montototal), fk_tipoVehiculo From registro a INNER JOIN factura b on b.fk_registro = a.id_registro where fk_tipoVehiculo = 3 ";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbmont3.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void limpiartabla() {
        int filas = tbmont1.getRowCount();
        tbmont2.getRowCount();
        tbmont3.getRowCount();
        tbcantliv.getRowCount();
        tbcantp.getRowCount();
        tbcantm.getRowCount();
        for (int i = 0; i < filas; i++) {
         /*   tbmont1.getRowCount(0);
             tbmont2.getRowCount(0);
        tbmont3.getRowCount(0);
        tbcantliv.getRowCount(0);
        tbcantp.getRowCount(0);
        tbcantm.getRowCount(0);*/
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnreporte = new javax.swing.JButton();
        btncierre = new javax.swing.JButton();
        btnsalir3 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnlimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmont3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcantm = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbmont2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbcantp = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbmont1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbcantliv = new javax.swing.JTable();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("            Reporte General Parqueo Guapileño S.A.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 250, 42));

        jLabel3.setText("Motocicletas:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 80, 20));

        jLabel4.setText("Fecha");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        btnreporte.setText("Reporte 2");
        getContentPane().add(btnreporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 640, -1, -1));

        btncierre.setText("Cierre caja");
        btncierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncierreActionPerformed(evt);
            }
        });
        getContentPane().add(btncierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 590, 90, -1));

        btnsalir3.setText("Salir");
        btnsalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, -1, -1));

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 120, 30));

        jLabel5.setText("Vehiculo Pesado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 90, 20));

        jLabel6.setText("Vehiculo Liviano:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 80, 20));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 570, 110, 30));

        jLabel9.setText("Tipo vehiculo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 80, 20));

        jLabel10.setText("Total Monto:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 70, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 420, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 420, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 420, 10));

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, -1, -1));

        tbmont3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbmont3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbmont3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbmont3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 60, 60));

        tbcantm.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbcantm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbcantm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbcantm);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 60, 60));

        tbmont2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbmont2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbmont2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbmont2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 60, 60));

        tbcantp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbcantp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbcantp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbcantp);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 60, 60));

        tbmont1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbmont1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbmont1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbmont1);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 60, 60));

        tbcantliv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbcantliv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbcantliv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tbcantliv);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 60, 60));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 112, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        mostrardatosVL("");
        mostrardatosVP("");
        mostrardatosM("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btncierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncierreActionPerformed
        /* int liv = Integer.parseInt(tbcantliv.get);
        int pes = Integer.parseInt(txtmon_pes.getText());
        int mot = Integer.parseInt(txtmon_mot.getText());

        int suma=liv+pes+mot;
        

         txttotal.setText("" + suma);*/
    }//GEN-LAST:event_btncierreActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiartabla();

        /* txttotal.setText("");
       txtmon_liv.setText("");
       txtmon_mot.setText("");
       txtmon_pes.setText("");
       txtcant_liv.setText("");
       txtcant_mot.setText("");
       txtcant_pes.setText("");*/
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnsalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir3ActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalir3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncierre;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnreporte;
    private javax.swing.JButton btnsalir3;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbcantliv;
    private javax.swing.JTable tbcantm;
    private javax.swing.JTable tbcantp;
    private javax.swing.JTable tbmont1;
    private javax.swing.JTable tbmont2;
    private javax.swing.JTable tbmont3;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
 datosP cc = new datosP();
    Connection cn = cc.conexion();
}
