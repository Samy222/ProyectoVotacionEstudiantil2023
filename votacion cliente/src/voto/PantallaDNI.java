
package voto;
import java.awt.event.KeyEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PantallaDNI extends javax.swing.JFrame {
    public PantallaDNI() {
        initComponents();    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoDNI = new javax.swing.JTextField();
        btnAceptarDNI = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Por favor ingresa tu No. Control: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        campoDNI.setBackground(new java.awt.Color(255, 255, 255));
        campoDNI.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        campoDNI.setForeground(new java.awt.Color(0, 0, 0));
        campoDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDNIKeyPressed(evt);
            }
        });
        jPanel1.add(campoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 250, 40));

        btnAceptarDNI.setBackground(new java.awt.Color(0, 0, 255));
        btnAceptarDNI.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        btnAceptarDNI.setText("Aceptar");
        btnAceptarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarDNIActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 180, 50));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("BIENVENIDO AL SISTEMA DE VOTACION ESTUDIANTIL 2023");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1170, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarDNIActionPerformed
        System.out.println("aceptar");
        if(campoDNI.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "EL DNI NO DEBE DE ESTAR VACIO", "Mensaje de Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            entrar();
        }
    }//GEN-LAST:event_btnAceptarDNIActionPerformed

    private void campoDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDNIKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            //System.out.println("Presionó Enter");
            if (!campoDNI.getText().isEmpty()){
                entrar();
            }
        }
    }//GEN-LAST:event_campoDNIKeyPressed
    public void entrar(){
        if(campoDNI.getText().length()==8){
          try {
              System.out.println(campoDNI.getText());
              Registry register=LocateRegistry.getRegistry("192.168.1.79",1099);
              
               Validar_Cliente validarInterfaz = (Validar_Cliente)register.lookup("validar_cliente");
                 if((validarInterfaz.verificar_dni(Integer.parseInt(campoDNI.getText()))) != 0){
                     System.out.println("El votante si existe!!");
                     String datos[]=new String[1];
                    datos = validarInterfaz.verificar_Dni(Integer.parseInt(campoDNI.getText()));
                    
                    //PantallaElectoral electoral = new PantallaElectoral();
                    PantallaVotar electoral = new PantallaVotar();
                    electoral.setLocationRelativeTo(null);
                    this.setVisible(false);
                    electoral.campoDNI.setText(campoDNI.getText());//SE MANDA EL CAMPO DEL DNI INGRESADO A LA PantallaVotar
                    campoDNI.setText(datos[0]);
                    String datosP[]=new String[4];
                    
                    datosP = validarInterfaz.verificar_votante(Integer.parseInt(campoDNI.getText()));
                                        
                    //SE MANDAN LOS DATOS PERSONALES COMPLETOS A LA PantallaVotar
                    electoral.txtnombre.setText(datosP[0]);
                    electoral.txtAP.setText(datosP[1]);
                    electoral.txtAM.setText(datosP[2]);
                    electoral.txtDireccion.setText(datosP[3]);
                    //SE HACE VISIBLE LA PantallaVotar
                    electoral.setVisible(true);

                    //System.out.println("Dni correcto");
                    if(campoDNI.getText().length()==0){
                       electoral.setVisible(false);
                        JOptionPane.showMessageDialog(null, "DNI INCORRECTO", "¡Mensaje de Error!", JOptionPane.ERROR_MESSAGE);
                      System.out.println("Dni incorrecto");
                        this.setVisible(true);   
                    } 
                 }else{
                     JOptionPane.showMessageDialog(null, "EL DNI: "+campoDNI.getText()+" NO PUDO SER ENCONTRADO ", "¡Mensaje de Error!", JOptionPane.ERROR_MESSAGE);
                     campoDNI.setText("");
                 }
          } catch (RemoteException ex) {
              Logger.getLogger(PantallaElectoral.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println(ex.getMessage());
          } catch (NotBoundException ex) {
                Logger.getLogger(PantallaDNI.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        else{
            System.out.println("DNI DE LONGITUD incorecta");
            JOptionPane.showMessageDialog(null, "DNI DE LONGITUD INCORRECTA", "Mensaje de Error!", JOptionPane.ERROR_MESSAGE);
            campoDNI.setText("");
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
            java.util.logging.Logger.getLogger(PantallaDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaDNI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaDNI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarDNI;
    private javax.swing.JTextField campoDNI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
