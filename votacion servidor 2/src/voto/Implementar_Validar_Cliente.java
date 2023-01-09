
package voto;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Implementar_Validar_Cliente extends UnicastRemoteObject implements Validar_Cliente{

    public Implementar_Validar_Cliente()throws RemoteException{}
    
    @Override
    public String[] verificar_votante(int dni) throws RemoteException {
        
        CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
        
        String sql = "select nombre, apellido_paterno, apellido_materno, direccion from electores where dni = "+dni+";";
              
        ResultSet resultado= mysql.consultar(sql);
        
        String datos[]=new String[4];
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    datos[0]=resultado.getString("nombre");
                    datos[1]=resultado.getString("apellido_paterno");                           
                    datos[2]=resultado.getString("apellido_materno");
                    datos[3]=resultado.getString("direccion");
       
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Validar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
      
             }
              
          
        return datos;
    }
    
    @Override
    public boolean verificar_voto(int dni)throws RemoteException{
    CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
        
        
        
        
        String sql = "select voto from electores where dni = "+dni;
              
        ResultSet resultado=mysql.consultar(sql);
        
        boolean voto=false;
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    voto = resultado.getBoolean("voto");
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Validar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }
          
        return voto;
    }

    @Override
    public void enviar_voto(String voto,int dni) throws RemoteException {
     
        
        Registry register;
        try {
            register = LocateRegistry.getRegistry("localhost",4070);
            votos miInerfaz =(votos)register.lookup("urna");
            miInerfaz.votar(voto);
            
            CONEXION_MYSQL mysql = new CONEXION_MYSQL();
              mysql.conectar();
        
              mysql.ejecutar("update electores set voto = true where dni ="+dni);
        
            
        } catch (RemoteException ex) {
            Logger.getLogger(Implementar_Validar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NotBoundException ex){
            System.out.println(""+ex.getMessage());
        }
        
    }

    //@Override
    public int verificar_dni(int dni) throws RemoteException {
        CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
        
            
        String sql = "select dni, nombre from electores where dni = "+dni;
              
        ResultSet resultado=mysql.consultar(sql);
        
        int Dni=0;
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    Dni = resultado.getInt("dni");
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Validar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }
          
        return Dni;
    }

    @Override
    public String[] verificar_Dni(int dni) throws RemoteException {
        CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
        
        String sql = "select dni from electores where dni = "+dni+";";
              
        ResultSet resultado= mysql.consultar(sql);
        
        String datos[]=new String[1];
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    datos[0]=resultado.getString("dni");
                         
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Validar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
      
             }
              
          
        return datos;
    }

    @Override
    public String[] registrar_votante(int dni, String nombre, String aP, String aM, String direccion) throws RemoteException {
        CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
        
        String sql = "insert into electores (dni, nombre, apellido_paterno, apellido_materno, direccion, voto) values (?,?,?,?,',false);";
        //String sql = "select nombre, apellido_paterno, apellido_materno, direccion from electores where dni = "+dni+";";
              
        ResultSet resultado= mysql.consultar(sql);
        
        String datos[]=new String[5];
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    datos[0]=resultado.getString("nombre");
                    datos[1]=resultado.getString("apellido_paterno");                           
                    datos[2]=resultado.getString("apellido_materno");
                    datos[3]=resultado.getString("direccion");
       
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Validar_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
      
             }
              
          
        return datos;
    }

 

    
    
}
