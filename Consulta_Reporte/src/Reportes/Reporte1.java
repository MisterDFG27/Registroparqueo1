package Reportes;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Reporte1 extends javax.swing.JFrame {
   
    DefaultTableModel modelo;
    
    String date;
   
   
    public Reporte1() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Calendario
    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(txtfecha.getDate());

    }

    //cantidad vehiculo liviano
    void mostrardatosVL(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        processCalendar();
        tbcantliv.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='1' AND fecha='"+date+"' and fk_estado ='F'";

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
        tbcantliv.setVisible(true);
    }

    //cantidad vehiculo Pesado
    void mostrardatosVP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");
        processCalendar();
        tbcantp.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='2' AND fecha='"+date+"' and fk_estado ='F'";

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
        tbcantp.setVisible(true);
    }

    //cantidad Moto
    void mostrardatosM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");
        processCalendar();
        tbcantm.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='3' AND fecha='"+date+"' and fk_estado ='F'";

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
        tbcantm.setVisible(true);
    }

    //monto liviano
    void mostrardatosML(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto");
        processCalendar();
        tbmont1.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql ="SELECT Sum(montototal) From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"' and fk_tipoVehiculo = 1 and fk_estado ='F'";


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
         tbmont1.setVisible(true);
    }

    //monto de pesados
    void mostrardatosMP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto");
        processCalendar();
        tbmont2.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql ="SELECT Sum(montototal) From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"' and fk_tipoVehiculo = 2 and fk_estado ='F'";


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
         tbmont2.setVisible(true);
    }
    
    //Monto de motos
    void mostrardatosMM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto");
        processCalendar();
        tbmont3.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql ="SELECT Sum(montototal) From registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"' and fk_tipoVehiculo = 3 and fk_estado ='F'";


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
         tbmont3.setVisible(true);
    }
    
    //Monto Total
    void mostrarMontoTotal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto total");
        
        tbMontoR.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT sum(montoTotal) FROM registro a INNER JOIN factura b on b.fk_registro = a.id_registo where fecha= '"+date+"'";

        }

        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbMontoR.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
         tbMontoR.setVisible(true);
    }
    
    //limpiar
    void limpiartabla() {
          tbcantliv.setVisible(false);
         tbcantp.setVisible(false);
         tbcantm.setVisible(false);
        tbmont1.setVisible(false);
         tbmont2.setVisible(false);
        tbmont3.setVisible(false);
         tbMontoR.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnsalir3 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
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
        jScrollPane7 = new javax.swing.JScrollPane();
        tbMontoR = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("            Reporte General Parqueo Guapileño S.A.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 630, 42));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Fecha");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 70, -1));

        btnsalir3.setBackground(new java.awt.Color(0, 0, 0));
        btnsalir3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnsalir3.setText("Facturar");
        btnsalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        btnbuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnbuscar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 120, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Vehiculo Pesado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("Vehiculo Liviano:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 140, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Tipo vehiculo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 130, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 430, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 430, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 420, 10));

        tbmont3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbmont3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbmont3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbmont3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 90, 60));

        tbcantm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbcantm);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 90, 60));

        tbmont2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbmont2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbmont2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbmont2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 90, 60));

        tbcantp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbcantp);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 90, 60));

        tbmont1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbmont1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbmont1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbmont1);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 90, 60));

        tbcantliv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantliv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantliv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tbcantliv);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 90, 60));

        tbMontoR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbMontoR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbMontoR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tbMontoR);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 100, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("Cierre de caja");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, -1, -1));

        txtfecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfecha.setMaxSelectableDate(new java.util.Date(253370790075000L));
        getContentPane().add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 180, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Motocicletas:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 110, 20));

        btnlimpiar.setBackground(new java.awt.Color(0, 0, 0));
        btnlimpiar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, 100, 30));

        btnmenu.setText("Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel3.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        mostrardatosVL("");
        mostrardatosVP("");
        mostrardatosM("");
        mostrardatosML("");
        mostrardatosMP("");
        mostrardatosMM("");
        mostrarMontoTotal("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
      limpiartabla();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnsalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir3ActionPerformed
     
    }//GEN-LAST:event_btnsalir3ActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
       
        dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnsalir3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tbMontoR;
    private javax.swing.JTable tbcantliv;
    private javax.swing.JTable tbcantm;
    private javax.swing.JTable tbcantp;
    private javax.swing.JTable tbmont1;
    private javax.swing.JTable tbmont2;
    private javax.swing.JTable tbmont3;
    private com.toedter.calendar.JDateChooser txtfecha;
    // End of variables declaration//GEN-END:variables
 datosP cc = new datosP();
    Connection cn = cc.conexion();
}
