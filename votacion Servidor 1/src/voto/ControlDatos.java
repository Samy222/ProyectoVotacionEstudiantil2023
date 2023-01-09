
package voto;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ControlDatos {
    private Conectar conectar;
    private ModeloDatos modelo;
    private Connection con;
    
    public ControlDatos(){
        conectar = new Conectar();
        modelo = new ModeloDatos();
}
    public void insertar(int DNI, String nombre, String apellidoP, String apellidoM, String direccion, String voto){
           
        PreparedStatement ps;
        String sql;
        //String sqll;
        modelo.setDNI(DNI);
        modelo.setNombre(nombre);
        modelo.setApellidoP(apellidoP);
        modelo.setApellidoM(apellidoM);
        modelo.setDireccion(direccion);
        modelo.setVoto(voto);

 try{
            con = conectar.getConexion();
            sql = "insert into electores(dni,nombre, apellido_paterno, apellido_materno, direccion, voto) values(?,?,?,?,?,?)";
            //sqll="insert into electores (dni, nombre, apellido_paterno, apellido_materno, direccion, voto) values (?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, modelo.getDNI());
            ps.setString(2, modelo.getNombre());
            ps.setString(3, modelo.getApellidoP());
            ps.setString(4, modelo.getApellidoM());
            ps.setString(5, modelo.getDireccion());
            ps.setString(6, modelo.getVoto());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se han insertado correctamente los datos del votante","MENSAJE DE CONFIRMACION",JOptionPane.INFORMATION_MESSAGE);
            
            
    }catch(SQLException e){
       JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
    }
}
    public void recolectar(){
          PreparedStatement ps;
        String sql;
        try{
         con = conectar.getConexion();
            sql = "select * from electores";
            //sqll="insert into electores (dni, nombre, apellido_paterno, apellido_materno, direccion, voto) values (?,?,?,?,?,?);";
            ps = con.prepareStatement(sql);
                        
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Se han recolectado los datos de los votante","MENSAJE DE CONFIRMACION",JOptionPane.INFORMATION_MESSAGE);   
        }catch(SQLException e){
       JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
}
