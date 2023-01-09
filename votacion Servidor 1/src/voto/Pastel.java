package voto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Pastel extends JLabel{
    private DefaultTableModel modelo;
    
    public Pastel(DefaultTableModel modelo){
        this.modelo=modelo;
    }
    @Override
    public void paint(Graphics g){
        int x =0;
        int suma=0;
        System.out.println("hola");
        if(modelo.getRowCount()>0){
            ArrayList<Integer> proms = new ArrayList();
            ArrayList<Integer> grados = new ArrayList();
            ArrayList<String> noms = new ArrayList();
            
            for (int k=0;k<modelo.getRowCount();k++){
                System.out.println(modelo.getRowCount());
                noms.add(modelo.getValueAt(k, 0).toString());
            }
            for(int i=0; i<modelo.getRowCount(); i++){               
                proms.add(Integer.parseInt(modelo.getValueAt(i, 1).toString()));              
                suma += proms.get(i);
            }    
                for(int j=0; j<proms.size();j++){
                    grados.add(proms.get(j)*360/suma);
                    g.setColor(colores().get(j));
                    
                    if (j != proms.size()-1) {
                        g.fillArc(50, 0, 250, 250,x, proms.get(j)*360/suma);                
                    }else{
                        g.fillArc(50, 0, 250, 250,x, proms.get(j)*360/suma); 
                    }

                    x += proms.get(j)*360/suma;                
                }
        }
    }
    
    public ArrayList<Color> colores(){
        ArrayList<Color> colores = new ArrayList();
        colores.add(Color.BLUE);
        colores.add(Color.WHITE);
        colores.add(Color.GREEN);
        colores.add(Color.CYAN);
        colores.add(Color.ORANGE);
        colores.add(Color.BLACK);
        
        colores.add(Color.PINK);
        
        
        colores.add(Color.DARK_GRAY);
        
        return colores;
    }
}
