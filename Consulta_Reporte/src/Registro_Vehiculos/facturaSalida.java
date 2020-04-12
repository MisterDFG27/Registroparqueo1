package Registro_Vehiculos;

import Conexion.datosP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class facturaSalida extends javax.swing.JFrame {

    //----------------En proceso----------------//
    String date;

    String fechacalendario;

    public facturaSalida() {
        initComponents();
        setLocationRelativeTo(null);
         Timer tiempo=new Timer(100, new facturaSalida.horas());
        tiempo.start();
    }
    class horas implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
            Date sistHora=new Date();
            String pmAm="HH:MM";
            SimpleDateFormat format=new SimpleDateFormat(pmAm);
            Calendar hoy=Calendar.getInstance();
            txtHoraSalida.setText(String.format(format.format(sistHora),hoy));
            
                  
        }
    }

    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
        fechacalendario = dateFormat.format(txtFecha.getDate());

    }

    public void mostrarVehiculoFacturar(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Registro");
        modelo.addColumn("Placa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora Entrada");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Tipo de vehículo");
        modelo.addColumn("Estado");

        tbFactura.setModel(modelo);
        processCalendar();
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT id_registo, númeroPlaca, fecha, horaEntrada, fk_tipoVehiculo, horaSalida, fk_estado FROM registro "
                    + "WHERE fk_estado ='D' and fecha = '" + fechacalendario + "'";

        }
        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tbFactura.setVisible(true);

    }

    public void CalcularHoras() {

        int horaE = Integer.parseInt(txtHEntrada.getText());
        int horaS = Integer.parseInt(txtHSalida.getText());
        int minE = Integer.parseInt(txtMEntrada.getText());
        int minS = Integer.parseInt(txtMSalida.getText());

        int th = horaS - horaE;
        int tm = minS - minE;

        int tt = th;

        int horas1;

        int minP;

        if (tm > 0) {

            if (tt < 0 && (tm < 30)) {

                horas1 = 24 + tt;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt < 0 && (tm >= 30)) {

                horas1 = (24 + tt) + 1;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt >= 0 && (tm >= 30)) {

                tt = tt + 1;
                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);

            } else if (tt >= 0 && (tm < 30)) {

                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);
            }
        } else  {// menor a cero

            minP = horaE - horaS;

            if (tt < 0 && (minP < 30)) {

                horas1 = 24 + tt;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt < 0 && (minP >= 30)) {

                horas1 = (24 + tt) + 1;

                txtTotHoras.setText("" + horas1);
                txtCantHoras.setText("" + horas1);

            } else if (tt >= 0 && (minP >= 30)) {

                tt = tt + 1;
                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);

            } else if (tt >= 0 && (minP < 30)) {

                txtTotHoras.setText("" + tt);
                txtCantHoras.setText("" + tt);
            }

        }

    }

    public void CalcularMontoExtra() {

        String tipoVehiculo = cbVehiculos.getSelectedItem().toString();
        String tipoHorario = cbHorario.getSelectedItem().toString();

        int horas = Integer.parseInt(txtCantHoras.getText());
        int canMin = Integer.parseInt(txtCantmin.getText());

        int monto = 1000;

        int montoExtra = 0;

        int montoTotal;

        if (tipoHorario == "Diurno") {

            if (tipoVehiculo == "1") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1300 + ((horas - 2) * 600));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if ((horas > 2)) {

                    montoTotal = 1000 + ((horas - 2) * 600);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "2") {
                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1375 + ((horas - 2) * 750));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 750);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "3") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1250 + ((horas - 2) * 500));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 500);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
        } else if (tipoHorario == "Nocturno") {

            if (tipoVehiculo == "1") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1325 + ((horas - 2) * 650));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 650);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "2") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1400 + ((horas - 2) * 800));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 800);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "3") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1275 + ((horas - 2) * 550));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 550);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
        }else if(tipoHorario == "Especial"){
            
            if (tipoVehiculo == "1") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1275 + ((horas - 2) * 550));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if ((horas > 2)) {

                    montoTotal = 1000 + ((horas - 2) * 550);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "2") {
                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1325 + ((horas - 2) * 650));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 650);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            if (tipoVehiculo == "3") {

                if ((horas > 2) && (canMin < 30 && canMin > 0)) {

                    montoTotal = (1225 + ((horas - 2) * 450));

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                } else if (horas <= 2) {

                    txtTP.setText("" + monto);

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + monto);

                } else if (horas > 2) {

                    montoTotal = 1000 + ((horas - 2) * 450);

                    montoExtra = montoTotal - 1000;

                    txtMT.setText("" + monto);
                    txtMTX.setText("" + montoExtra);
                    txtTP.setText("" + montoTotal);

                }
            }
            
            
        }

    }
    
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtIDRegistroBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        txtHoraSalida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEstadoSalida = new javax.swing.JTextField();
        BtnSalidaregistro = new javax.swing.JButton();
        txtCantHoras = new javax.swing.JTextField();
        txtMT = new javax.swing.JTextField();
        txtMTX = new javax.swing.JTextField();
        txtTP = new javax.swing.JTextField();
        Calcular = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtHEntrada = new javax.swing.JTextField();
        txtMEntrada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtHSalida = new javax.swing.JTextField();
        txtMSalida = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnCarlcularHoras = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbVehiculos = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cbHorario = new javax.swing.JComboBox<>();
        txtTotHoras = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCantmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMontoExtra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        btnInsertarF = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtIDregistro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscarRegistro = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Salida del vehiculo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel19.setText("ID registro:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));
        jPanel1.add(txtIDRegistroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 90, -1));

        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFactura.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 774, 110));
        jPanel1.add(txtHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 90, -1));

        jLabel5.setText("Hora de Salida:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jLabel10.setText("Estado:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        txtEstadoSalida.setText("F");
        txtEstadoSalida.setEnabled(false);
        jPanel1.add(txtEstadoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 82, -1));

        BtnSalidaregistro.setText("Sacar registro");
        BtnSalidaregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalidaregistroActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalidaregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        txtCantHoras.setEnabled(false);
        jPanel1.add(txtCantHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 70, -1));

        txtMT.setEnabled(false);
        jPanel1.add(txtMT, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 100, -1));

        txtMTX.setEnabled(false);
        jPanel1.add(txtMTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 100, -1));

        txtTP.setEnabled(false);
        jPanel1.add(txtTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 100, -1));

        Calcular.setText("Calcular Montos");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });
        jPanel1.add(Calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, -1, -1));

        jLabel17.setText("Total a pagar");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, -1, -1));

        jLabel16.setText("Montro extra");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, -1, -1));

        jLabel15.setText("Monto");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));

        jLabel4.setText("Horas a pagar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, -1, -1));

        jLabel20.setText("Entrada:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        jLabel21.setText("Total Horas:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));
        jPanel1.add(txtHEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 40, -1));
        jPanel1.add(txtMEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 40, -1));

        jLabel22.setText(":");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 10, -1));

        jLabel23.setText("Horas de inicio y final");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));
        jPanel1.add(txtHSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 40, -1));
        jPanel1.add(txtMSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 40, -1));

        jLabel24.setText(":");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 10, -1));

        btnCarlcularHoras.setText("Calcular horas ");
        btnCarlcularHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarlcularHorasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarlcularHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, -1, -1));

        jLabel3.setText("Tipo Vehiculo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        cbVehiculos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        jPanel1.add(cbVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 100, -1));

        jLabel25.setText("Horario:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diurno", "Nocturno", "Especial" }));
        jPanel1.add(cbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 100, -1));

        txtTotHoras.setEnabled(false);
        jPanel1.add(txtTotHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 70, -1));

        jLabel26.setText("Minutos excedidos");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        txtCantmin.setEnabled(false);
        txtCantmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantminActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 70, -1));

        jLabel7.setText("Monto:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 380, -1, -1));
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 90, -1));

        jLabel8.setText("Monto Extra:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, -1, -1));
        jPanel1.add(txtMontoExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, 90, -1));

        jLabel9.setText("Total a Pagar:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, -1, 20));
        jPanel1.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 460, 90, -1));

        btnInsertarF.setText("Guardar pago");
        btnInsertarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarFActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, -1, -1));

        jLabel14.setText("ID registro");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));
        jPanel1.add(txtIDregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 90, -1));

        jLabel11.setText("Guardar el pago");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, -1, -1));

        jLabel18.setText("Calcular montos");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        txtFecha.setMaxSelectableDate(new java.util.Date(253370790087000L));
        txtFecha.setMinSelectableDate(new java.util.Date(-62135744313000L));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        jLabel6.setText("Despues de 8 o más horas:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        jLabel27.setText("Liviano: 550, Pesado: 650, Motos: 450 ");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        jLabel1.setText("Fecha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel28.setText("Salida:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 1030, 20));

        btnBuscarRegistro.setText("Buscar");
        btnBuscarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 350, -1));

        jLabel12.setText("Buscar el vehiculo");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 30, 320));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 10, 320));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 30, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarFActionPerformed

        try {
                                                      /*INSERT INTO `factura` (`id_factura`, `monto`, `montoextra`, `montoTotal`, `fk_registro`, `totalHoras`) VALUES ('10', '1500', '1200', '1600', '10', '5');*/
            PreparedStatement pst = cn.prepareStatement("INSERT INTO `factura`(`id_factura`, `monto`, `montoextra`, `montoTotal`, `fk_registro`, `totalHoras`) VALUES (?,?,?,?,?,?)");

            pst.setString(1, txtIDregistro.getText());
            pst.setString(2, txtMonto.getText());
            pst.setString(3, txtMontoExtra.getText());
            pst.setString(4, txtTotalPagar.getText());
            pst.setString(5, txtIDregistro.getText());
            pst.setString(6, txtTotHoras.getText());
            
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.print(e);
        }

        //Guardar pago
        txtMonto.setText("");
        txtMontoExtra.setText("");
        txtTotalPagar.setText("");
        txtIDregistro.setText("");

        //Salida del vehiculo
        txtIDRegistroBusqueda.setText("");
        txtHoraSalida.setText("");

        //calcular horas
        txtHEntrada.setText("");
        txtMEntrada.setText("");
        txtHSalida.setText("");
        txtMSalida.setText("");
        txtTotHoras.setText("");

        //calcular montos
        txtCantHoras.setText("");
        txtCantmin.setText("");
        txtMT.setText("");
        txtMTX.setText("");
        txtTP.setText("");

        DefaultTableModel tb = (DefaultTableModel) tbFactura.getModel();
        int a = tbFactura.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        JOptionPane.showMessageDialog(this, "Factura guardada");


    }//GEN-LAST:event_btnInsertarFActionPerformed

    private void BtnSalidaregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalidaregistroActionPerformed

        txtIDregistro.setText(txtIDRegistroBusqueda.getText());

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE registro SET horaSalida='" + txtHoraSalida.getText() + "',"
                    + "fk_estado='" + txtEstadoSalida.getText() + "' WHERE id_registo='" + txtIDRegistroBusqueda.getText() + "'");
            pst.executeUpdate();
            mostrarVehiculoFacturar("");
            JOptionPane.showMessageDialog(this, "Seguir con la factura");

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_BtnSalidaregistroActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnBuscarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistroActionPerformed

        mostrarVehiculoFacturar("");

    }//GEN-LAST:event_btnBuscarRegistroActionPerformed

    private void btnCarlcularHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarlcularHorasActionPerformed

        CalcularHoras();

        int minE = Integer.parseInt(txtMEntrada.getText());
        int minS = Integer.parseInt(txtMSalida.getText());
        int horas = Integer.parseInt(txtTotHoras.getText());

        int tm = (minS - minE);

        int minP;

        if (horas > 2) {
            if ((tm < 0)) {
                minP = (minE - minS);

                txtCantmin.setText("" + minP);

                CalcularHoras();
            } else {

                txtCantmin.setText("" + tm);

                CalcularHoras();

            }
        } else {

            txtCantmin.setText("0");

        }

    }//GEN-LAST:event_btnCarlcularHorasActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        CalcularMontoExtra();

        txtMonto.setText(txtMT.getText());
        txtMontoExtra.setText(txtMTX.getText());
        txtTotalPagar.setText(txtTP.getText());

    }//GEN-LAST:event_CalcularActionPerformed

    private void txtCantminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantminActionPerformed

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
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalidaregistro;
    private javax.swing.JButton Calcular;
    private javax.swing.JButton btnBuscarRegistro;
    private javax.swing.JButton btnCarlcularHoras;
    private javax.swing.JButton btnInsertarF;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox cbVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtCantHoras;
    private javax.swing.JTextField txtCantmin;
    private javax.swing.JTextField txtEstadoSalida;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtHEntrada;
    private javax.swing.JTextField txtHSalida;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtIDRegistroBusqueda;
    private javax.swing.JTextField txtIDregistro;
    private javax.swing.JTextField txtMEntrada;
    private javax.swing.JTextField txtMSalida;
    private javax.swing.JTextField txtMT;
    private javax.swing.JTextField txtMTX;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoExtra;
    private javax.swing.JTextField txtTP;
    private javax.swing.JTextField txtTotHoras;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
  datosP cc = new datosP();
    Connection cn = cc.conexion();
}
