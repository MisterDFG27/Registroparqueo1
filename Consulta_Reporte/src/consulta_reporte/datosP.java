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
   
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3308/parqueo","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
}
