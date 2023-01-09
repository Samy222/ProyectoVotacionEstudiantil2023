package voto;


import java.sql.*;
import javax.swing.JOptionPane;
public class CONEXION_MYSQL {

    private Connection conexion;

    private final String BD = "votantes";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/"+BD+"?useUnicode=true&useJDBC"
            + "CompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String usuario = "root";
    //private final String pass = "199925";
    private final String pass = "root123";
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public CONEXION_MYSQL conectar() {
        try {
            //String BaseDeDatos = "jdbc:mysql://localhost/votantes?user=root&password=199925";
            
            setConexion(DriverManager.getConnection(url,usuario,pass));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }

        return this;
    }

    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return resultado;
    }

    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e,"MOVIE PLANET",JOptionPane.ERROR_MESSAGE);
   
            return false;
        }
        return true;
    }
}
