
package voto;

import java.awt.Color;
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

public class VentanaGraficas extends javax.swing.JFrame {
        private int filas;
        int o=0;
        DefaultTableModel modelo;
        private Barras barras;
        private Pastel pastel;
        
    public VentanaGraficas() {
        //Para darle formato  a la tabla
        this.modelo = new DefaultTableModel();
        barras = new Barras(modelo);
        pastel = new Pastel(modelo);
        pastel.setBounds(700, 250, 300, 250);
        barras.setBounds(700, 180,300, 250);
        
        this.add(pastel);
        this.add(barras);
        //ventana
        this.setBackground(Color.yellow);
        initComponents();
        this.setTitle("ELECCIONES ESTUDIANTILES");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //tabla
        //TablaVotos();
        
        modelo.addColumn("CANDIDATO"); 
        TableColumn columna1 = jtabDatos.getColumn("CANDIDATO");
        columna1.setPreferredWidth(50);
        modelo.addColumn("TOTAL VOTOS");
        TableColumn columna2 = jtabDatos.getColumn("TOTAL VOTOS");
        columna2.setPreferredWidth(100);
        this.jtabDatos.setModel(modelo);  
        
        LlenarTabla();
        pastel.setVisible(false);
        barras.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Graficas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabDatos = new javax.swing.JTable();
        btnGraficar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbtnBarras = new javax.swing.JRadioButton();
        rbtnPastel = new javax.swing.JRadioButton();
        jlbEti = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel1.setText("RECUENTO DE VOTOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 560, 60));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 1269, -1));

        jtabDatos.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jtabDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANDIDATO", "TOTAL VOTOS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabDatos.setEnabled(false);
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
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 226, -1, 440));

        btnGraficar.setBackground(new java.awt.Color(102, 102, 255));
        btnGraficar.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        btnGraficar.setText("GRAFICAR");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGraficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 250, 70));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Graficas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("OCR A Extended", 1, 18))); // NOI18N
        jPanel1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N

        Graficas.add(rbtnBarras);
        rbtnBarras.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        rbtnBarras.setSelected(true);
        rbtnBarras.setText("Barras");

        Graficas.add(rbtnPastel);
        rbtnPastel.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        rbtnPastel.setText("Pastel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnPastel)
                    .addComponent(rbtnBarras))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(rbtnBarras)
                .addGap(18, 18, 18)
                .addComponent(rbtnPastel)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, 190, 140));

        jlbEti.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        getContentPane().add(jlbEti, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 96, 470, 120));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 204, 0));
        jTextField1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jTextField1.setText("Abstencion");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 540, 190, 50));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(51, 51, 255));
        jTextField2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jTextField2.setText("Sergio Giovany");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 540, 190, 50));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jTextField3.setText("Samuel Antonio");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, 190, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoPrev.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        // TODO add your handling code here:
        System.out.println(modelo.getRowCount());
        if(modelo.getRowCount()>0){
            o=1;
            if (rbtnBarras.isSelected()) {
                jlbEti.setText("Grafica de Barras");
                barras.repaint();
                pastel.setVisible(false);
                barras.setVisible(true);
            }
            if (rbtnPastel.isSelected()) {
                jlbEti.setText("Grafica de Pastel");
                pastel.repaint();
                barras.setVisible(false);
                pastel.setVisible(true);
            }
        }else {
                JOptionPane.showMessageDialog(null, "Error, la tabla esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void jtabDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabDatosMouseClicked
        // TODO add your handling code here:
        int filaSel = jtabDatos.getSelectedRow();
        System.out.println(filaSel);
    }//GEN-LAST:event_jtabDatosMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
//     public void TablaVotos(){
//        modelo = new DefaultTableModel(){ 
//            @Override 
//            public boolean isCellEditable(int row, int column) { 
//            //all cells false 
//            return false; } };
//        
//        modelo.addColumn("CANDIDATO"); 
//        TableColumn columna1 = jtabDatos.getColumn("CANDIDATO");
//        columna1.setPreferredWidth(100);
//        modelo.addColumn("TOTAL VOTOS");
//        TableColumn columna2 = jtabDatos.getColumn("TOTAL VOTOS");
//        columna2.setPreferredWidth(10);
//        this.jtabDatos.setModel(modelo);
//        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
//        TablaRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//        
//        jtabDatos.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);    
//        jtabDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        jtabDatos.getColumnModel().getColumn(0).setResizable(false);
//        
//    }
    
     public void LlenarTabla(){
         Registry register;
         
        try {
            register = LocateRegistry.getRegistry("192.168.1.79",4070);
            votos miInerfaz =(votos)register.lookup("urna");
            String [][]registro=miInerfaz.recuento();
            
            
                Object fila[] = new Object[jtabDatos.getColumnCount()];
            //System.out.println(registro.length);
            
                fila[0] = registro[0][0];
                fila[1] = registro[0][1];
                modelo.addRow(fila);
                fila[0] = registro[1][0];
                fila[1] = registro[1][1];
                modelo.addRow(fila);
                fila[0] = registro[2][0];
                fila[1] = registro[2][1];
                modelo.addRow(fila);
            DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
            TablaRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            
            jtabDatos.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);        
            jtabDatos.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
            
            this.jtabDatos.setModel(modelo);           
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
            java.util.logging.Logger.getLogger(VentanaGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGraficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGraficas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Graficas;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel jlbEti;
    private javax.swing.JTable jtabDatos;
    private javax.swing.JRadioButton rbtnBarras;
    private javax.swing.JRadioButton rbtnPastel;
    // End of variables declaration//GEN-END:variables
}
