package consulta_reporte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class datosP {
    
    Connection conectar=null;

    datosP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/clinica_personas","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
    
    private Connection con;
    private ResultSet rs;
    private ResultSetMetaData mtd;
    private String[] columnas;
    private String consulta,error;
    
    public datosP (Connection c , String sql){
        this.con=c;
        this.consulta=sql;
        
        try{
        
            Statement st = con.createStatement();
        
            rs = st.executeQuery(consulta);
            
            mtd = rs.getMetaData();
            
            error = null;
        
        } catch (SQLException ex) {
           error = ex.getMessage();
        }
    }
    
    public String getError(){
        return this.error;
    }
    
    public ResultSet getResultado(){
        return this.rs;
    }
    
    public String [] getNombresColumnas(){
        try{
            int numColumnas = mtd.getColumnCount();
            this.columnas = new String [numColumnas];
            
            for(int a=0;a<numColumnas;a++){
                columnas [a]=mtd.getColumnLabel(a+1);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(datosP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnas;
    }
    
}
