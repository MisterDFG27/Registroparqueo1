package Menu;

import Conexion.datosP;
import Registro_Vehiculos.facturaSalida;
import Reportes.Reporte1;
import Reportes.Reporte_2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Menu_Principal extends javax.swing.JFrame {

    String CantidV;

    public Menu_Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void mostrardatosVL(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantliv.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='1' and fk_estado = 'D'";

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
    public void mostrardatosVP(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantp.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='2' and fk_estado = 'D'";

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
    public void mostrardatosM(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");

        tbcantm.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT COUNT(*) AS Cantidad FROM registro WHERE fk_tipoVehiculo='3' and fk_estado = 'D'";

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

    public void mostrardatosTotalVehiculosDia(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Placa de vehículos");

        tbTotal.setModel(modelo);
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
            tbTotal.setModel(modelo);

            txtCantiTotal.setText("" + tbTotal.getRowCount());

            //Bloquear la opcion a los 15
            CantidV = txtCantiTotal.getText();

            if (Integer.parseInt(CantidV) == 15) {

                Vehiculo.setVisible(false);
            } else {

                Vehiculo.setVisible(true);
            }
            //-----------------------

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbTotal.setVisible(true);

    }

    public void mostrarIDTrabajador(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");

        tbUsuarioID.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT id_usuario, nombre, primerApellido FROM usuario WHERE nombreUsuario =  '" + txtIDparametro.getText() + "'";

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
            tbUsuarioID.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbUsuarioID.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTotal = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbUsuarioID = new javax.swing.JTable();
        txtCantiTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDparametro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcantm = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbcantp = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbcantliv = new javax.swing.JTable();
        btnActualizar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        EmpleadoR = new javax.swing.JMenu();
        Vehiculo = new javax.swing.JMenu();
        Factura = new javax.swing.JMenu();
        Mantenimiento = new javax.swing.JMenu();
        Reporte1Menu = new javax.swing.JMenu();
        Reporte2Menu = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbTotal);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 249, 140));

        tbUsuarioID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbUsuarioID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbUsuarioID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbUsuarioID);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 249, 60));

        txtCantiTotal.setEnabled(false);
        jPanel1.add(txtCantiTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 202, 130, 30));

        jLabel4.setText("Total de vehículos en el momento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel5.setText("Usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));

        txtIDparametro.setEnabled(false);
        jPanel1.add(txtIDparametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 160, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, 51));

        jLabel3.setText("Motos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jLabel2.setText("Pesados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 90, 50));

        jLabel1.setText("Livianos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        tbcantliv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbcantliv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbcantliv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tbcantliv);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 90, 50));

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 400));

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));

        EmpleadoR.setBackground(new java.awt.Color(255, 255, 255));
        EmpleadoR.setText("Registrar Empleado");
        EmpleadoR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpleadoR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadoRMouseClicked(evt);
            }
        });
        jMenuBar1.add(EmpleadoR);

        Vehiculo.setText("Registrar Vehículo");
        Vehiculo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VehiculoMouseClicked(evt);
            }
        });
        jMenuBar1.add(Vehiculo);

        Factura.setText("Facturar");
        Factura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturaMouseClicked(evt);
            }
        });
        jMenuBar1.add(Factura);

        Mantenimiento.setText("Mantenimiento");
        Mantenimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MantenimientoMouseClicked(evt);
            }
        });

        Reporte1Menu.setText("Reporte General");
        Reporte1Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Reporte1Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reporte1MenuMouseClicked(evt);
            }
        });
        Mantenimiento.add(Reporte1Menu);

        Reporte2Menu.setText("Reporte Específico");
        Reporte2Menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Reporte2Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reporte2MenuMouseClicked(evt);
            }
        });
        Mantenimiento.add(Reporte2Menu);

        jMenuBar1.add(Mantenimiento);

        CerrarSesion.setForeground(new java.awt.Color(255, 0, 0));
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarSesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(CerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmpleadoRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpleadoRMouseClicked
        Registro_Empleado.Registro_Empleados m = new Registro_Empleado.Registro_Empleados();
        m.setVisible(true);

    }//GEN-LAST:event_EmpleadoRMouseClicked

    private void VehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehiculoMouseClicked
        Registro_Vehiculos.Registro_Vehiculos m = new Registro_Vehiculos.Registro_Vehiculos();
        m.setVisible(true);
        Vehiculo.setVisible(false);

        m.txtIDparametroV.setText(txtIDparametro.getText());
        m.mostrarIDTrabajadorV("");

        m.mostrardatosTotalVehiculosDiaregistro("");


    }//GEN-LAST:event_VehiculoMouseClicked

    private void FacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacturaMouseClicked
        facturaSalida m = new facturaSalida();
        m.setVisible(true);
    }//GEN-LAST:event_FacturaMouseClicked

    private void Reporte1MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reporte1MenuMouseClicked
        Reporte1 m = new Reporte1();
        m.setVisible(true);
    }//GEN-LAST:event_Reporte1MenuMouseClicked

    private void Reporte2MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reporte2MenuMouseClicked
        Reporte_2 m = new Reporte_2();
        m.setVisible(true);
    }//GEN-LAST:event_Reporte2MenuMouseClicked

    private void CerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarSesionMouseClicked
        Login.Login m = new Login.Login();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        mostrardatosVL("");
        mostrardatosVP("");
        mostrardatosM("");
        mostrardatosTotalVehiculosDia("");
        mostrarIDTrabajador("");


    }//GEN-LAST:event_btnActualizarMouseClicked

    private void MantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MantenimientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MantenimientoMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CerrarSesion;
    public javax.swing.JMenu EmpleadoR;
    private javax.swing.JMenu Factura;
    public javax.swing.JMenu Mantenimiento;
    public javax.swing.JMenu Reporte1Menu;
    public javax.swing.JMenu Reporte2Menu;
    public javax.swing.JMenu Vehiculo;
    public javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JTable tbTotal;
    public javax.swing.JTable tbUsuarioID;
    public javax.swing.JTable tbcantliv;
    public javax.swing.JTable tbcantm;
    public javax.swing.JTable tbcantp;
    public javax.swing.JTextField txtCantiTotal;
    public javax.swing.JTextField txtIDparametro;
    // End of variables declaration//GEN-END:variables
   datosP cc = new datosP();
    Connection cn = cc.conexion();
}
