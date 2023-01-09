package voto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTable;


public interface votos extends Remote{
    
 public String[][] recuento()throws RemoteException;
 
 public void votar(String candidato)throws RemoteException;
    
}
