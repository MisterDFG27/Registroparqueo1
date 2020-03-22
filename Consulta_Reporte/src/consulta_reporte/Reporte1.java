package consulta_reporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class Reporte1 extends javax.swing.JFrame {

    /**
     * Creates new form Reporte1
     */
    public Reporte1() {
        initComponents();  
    }
    
    datosP cc = new datosP();
    Connection cn = cc.conexion();

    void mostrarregistro(String valor) {
      
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM registro1";
        } else {
            sql = "SELECT * FROM registro1 WHERE Idregistro='" + valor + "'";
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
        btnsalir2 = new javax.swing.JButton();
        btnsalir3 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtcant_mot = new javax.swing.JTextField();
        txtmon_mot = new javax.swing.JTextField();
        txtcant_pes = new javax.swing.JTextField();
        txtmon_pes = new javax.swing.JTextField();
        txtmon_liv = new javax.swing.JTextField();
        txtcant_liv = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("            Reporte General Parqueo Guapileño S.A.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 250, 42));

        jLabel3.setText("Motocicletas:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 80, 20));

        jLabel4.setText("Fecha");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        btnreporte.setText("Reporte 2");
        getContentPane().add(btnreporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, -1, -1));

        btnsalir2.setText("Cierre caja");
        getContentPane().add(btnsalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 90, -1));

        btnsalir3.setText("Salir");
        getContentPane().add(btnsalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, -1, -1));

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 120, 30));

        jLabel5.setText("Vehiculo Pesado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 90, 20));

        jLabel6.setText("Vehiculo Liviano:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 80, 20));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 50, 30));

        jLabel8.setText("Cantidad");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 50, 20));

        jLabel9.setText("Tipo vehiculo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 80, 20));

        jLabel10.setText("Total Monto");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 80, 20));

        jLabel11.setText("Monto");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 40, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 420, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 420, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 420, 10));
        getContentPane().add(txtcant_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 50, 30));
        getContentPane().add(txtmon_mot, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 50, 30));
        getContentPane().add(txtcant_pes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 50, 30));
        getContentPane().add(txtmon_pes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 50, 30));
        getContentPane().add(txtmon_liv, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 50, 30));
        getContentPane().add(txtcant_liv, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 50, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel2.setText("Prueba");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        
         mostrarregistro("");
    }//GEN-LAST:event_btnbuscarActionPerformed

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
    private javax.swing.JButton btnreporte;
    private javax.swing.JButton btnsalir2;
    private javax.swing.JButton btnsalir3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtcant_liv;
    private javax.swing.JTextField txtcant_mot;
    private javax.swing.JTextField txtcant_pes;
    private javax.swing.JTextField txtmon_liv;
    private javax.swing.JTextField txtmon_mot;
    private javax.swing.JTextField txtmon_pes;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
