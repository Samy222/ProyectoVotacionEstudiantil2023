package voto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Implementar_Voto extends UnicastRemoteObject implements votos{

    public Implementar_Voto()throws RemoteException{}
    
    
    
@Override
    public String[][] recuento() throws RemoteException {

        CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
      
        String sql;
        
        DefaultTableModel model;
        String[] titulos={"CANDIDATOS","VOTOS"};
        String[][] registro=new String[3][2];
       // model=new DefaultTableModel(null,titulos);
       // recuento_de_votos.setModel(model);
        
       sql = "select candidato CANDIDATO ,count(candidato) VOTOS from urna group by(candidato)";
              ResultSet resultado=mysql.consultar(sql);
        int cont=0;
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    registro[cont][0]=resultado.getString("CANDIDATO");
                    registro[cont][1]=Integer.toString(resultado.getInt("VOTOS"));
                           cont++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Voto.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }           
        return registro;        
    }

    @Override
    public void votar(String candidato) throws RemoteException {
    CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
        
        mysql.ejecutar("INSERT INTO urna VALUES ('"+candidato+"')");
        
    }
public String[][] selectVotantes()throws RemoteException{
    CONEXION_MYSQL mysql = new CONEXION_MYSQL();
        mysql.conectar();
         String sql;
        
        DefaultTableModel model;
        String[] titulos={"DNI","NOMBRE,A_PATERNO","A_MATERNO","VOTO"};
        String[][] registrov=new String[1000][1000];
        
       sql = "SELECT * FROM ELECTORES";
              ResultSet resultado=mysql.consultar(sql);
        int cont=0;
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    registrov[cont][0]=resultado.getString("DNI");
                    registrov[cont][0]=resultado.getString("NOMBRE");
                    registrov[cont][0]=resultado.getString("A_PATERNO");
                    registrov[cont][0]=resultado.getString("A_MATERNO");
                    registrov[cont][0]=resultado.getString("DIRECCION");
                    registrov[cont][0]=resultado.getString("VOTO");
                    cont++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Implementar_Voto.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }           
        return registrov; 
}      
}
