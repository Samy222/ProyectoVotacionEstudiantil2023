
package voto;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Votantes extends javax.swing.JFrame {
        private int filas;
        int o=0;
        DefaultTableModel modelo;
        
    public Votantes() {
        //Para darle formato  a la tabla
        this.modelo = new DefaultTableModel();
        
        //ventana
        initComponents();
        this.setTitle("VOTANTES ESTUDIANTILES");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //tabla
        //TablaVotos();
        
        modelo.addColumn("DNI"); 
        TableColumn columna1 = jtabDatos.getColumn("DNI");
        columna1.setPreferredWidth(50);
        
        modelo.addColumn("NOMBRE");
        TableColumn columna2 = jtabDatos.getColumn("NOMBRE");
        columna2.setPreferredWidth(100);
        
        modelo.addColumn("A_PATERNO");
        TableColumn columna3 = jtabDatos.getColumn("A_PATERNO");
        columna3.setPreferredWidth(100);
        
        modelo.addColumn("A_MATERNO");
        TableColumn columna4 = jtabDatos.getColumn("A_MATERNO");
        columna4.setPreferredWidth(100);
        
        modelo.addColumn("VOTO");
        TableColumn columna5 = jtabDatos.getColumn("VOTO");
        columna5.setPreferredWidth(100);
        
        
        this.jtabDatos.setModel(modelo);  
        
        LlenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Graficas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("RECUENTO DE VOTANTES");

        jtabDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "A_PATERNO", "A_MATERNO", "VOTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabDatos.getTableHeader().setReorderingAllowed(false);
        jtabDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabDatos);
        if (jtabDatos.getColumnModel().getColumnCount() > 0) {
            jtabDatos.getColumnModel().getColumn(0).setResizable(false);
            jtabDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtabDatos.getColumnModel().getColumn(1).setResizable(false);
            jtabDatos.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtabDatos.getColumnModel().getColumn(2).setResizable(false);
            jtabDatos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtabDatos.getColumnModel().getColumn(3).setResizable(false);
            jtabDatos.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtabDatos.getColumnModel().getColumn(4).setResizable(false);
            jtabDatos.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtabDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabDatosMouseClicked
        // TODO add your handling code here:
        int filaSel = jtabDatos.getSelectedRow();
        System.out.println(filaSel);
    }//GEN-LAST:event_jtabDatosMouseClicked
        
     public void LlenarTabla(){
         Registry register;
         
        try {
            register = LocateRegistry.getRegistry("192.168.1.79",4070);
            votos miInerfaz =(votos)register.lookup("votantes");
            String [][]registro=miInerfaz.selectVotantes();
            System.out.println(registro.length);
        } catch (RemoteException ex) {
            System.out.println(""+ex.getMessage());
        }catch(NotBoundException ex){
            System.out.println(""+ex.getMessage());
        } 
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Votantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Votantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Votantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Votantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Votantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Graficas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtabDatos;
    // End of variables declaration//GEN-END:variables
}
