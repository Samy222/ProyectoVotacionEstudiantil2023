package voto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Barras extends JLabel{
    private DefaultTableModel modelo;
    private Border borde;
    
    public Barras(DefaultTableModel modelo){ 
        this.modelo=modelo;
    }
 
    @Override
    public void paint(Graphics g){
        if(modelo.getRowCount()>0){
        int ancho = this.getWidth()/modelo.getRowCount();
        ArrayList<Integer> proms = new ArrayList();
        for(int i=0; i<modelo.getRowCount(); i++){
            proms.add(Integer.parseInt(modelo.getValueAt(i, 1).toString()));
            g.setColor(colores().get(i));
            g.fillRect((i*ancho), this.getHeight()-(proms.get(i)*this.getHeight()/100), ancho,proms.get(i)*this.getHeight()/100);
            }
        }
       
    }
    public ArrayList<Color> colores(){
        ArrayList<Color> colores = new ArrayList();
        colores.add(Color.BLUE);
        colores.add(Color.WHITE);
        colores.add(Color.GREEN);
        colores.add(Color.MAGENTA);
        colores.add(Color.CYAN);
        colores.add(Color.ORANGE);
        colores.add(Color.BLACK);
        colores.add(Color.WHITE);
        colores.add(Color.PINK);
        colores.add(Color.RED);
        colores.add(Color.BLUE);
        colores.add(Color.DARK_GRAY);
        colores.add(Color.GREEN);
        return colores;
    }
    
}
