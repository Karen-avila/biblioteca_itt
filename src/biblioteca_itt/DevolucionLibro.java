/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_itt;

import ConecionBD.ConectarBiblioteca;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANA
 */
public class DevolucionLibro extends javax.swing.JFrame {
  DefaultTableModel model;
    /**
     * Creates new form DevolucionLibro
     */
    public DevolucionLibro() {
        initComponents();
        cargar("");
        cerrar();
          this.setResizable(false);
         this.setTitle("Devolución de libros");
         this.setLocationRelativeTo(DevolucionLibro.this);
         Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("biblio.png"));
       setIconImage(icon);
setVisible(true);
        
        bloquear();
      
    }
    
    
    void bloquear(){
    txtmatricula.setEnabled(false);    
    
     txtapellidos.setEnabled(false);  
     txtcantidad.setEnabled(false);  
     txtentregado.setEnabled(false);   
     txtobservacion.setEnabled(false); 
     jButton2.setEnabled(false);
     jButton3.setEnabled(false);
}
    
   void modif (){
     txtmatricula.setEnabled(true);    
    
     txtapellidos.setEnabled(true);  
     txtcantidad.setEnabled(true);  
     txtentregado.setEnabled(true);   
     txtobservacion.setEnabled(true); 
     jButton2.setEnabled(true);
     jButton3.setEnabled(true); 
} 
    
void limpiar (){
    txtmatricula.setText("");     
    
     txtapellidos.setText("");  
     txtcantidad.setText("");  
     txtentregado.setText("");  ;
     txtobservacion.setText("");  
}  
     
  public void cerrar (){
        try {
            this.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
                public void windowClosing (WindowEvent e){
                    ConfirmarSalida();
                }
            });
            this.setVisible(true);
        }catch (Exception e){
        }
    
    }
    public void ConfirmarSalida(){
    
        int valor = JOptionPane.showConfirmDialog(this, "¿Estas seguro de cerrar la aplicacion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    
    if (valor == JOptionPane.YES_OPTION){
         String nl = System.getProperty("line.separator");

       JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa Biblioteca ITT" + nl + "Esta aplicación  fue realizada para servir de ayuda en la gestión de la biblioteca ITT"+ JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
    }
        
        }   
     
     
     

  void cargar(String valor){
 String [] titulos = {"Matricula","Apellidos","Nombre (s)","Observaciones del Libro","Tipo de usuario","Carrera","Fecha de salida", "Fecha de entrada","Num reg", "Num reg2", "Num de libros", "Entregado", "observacion_entrega"};
 String [] registros = new String [13];
 String sql = "SELECT * FROM préstamos where CONCAT (DNI,'',Apelidos,'',Nome)LIKE '%"+valor+"%'";
 model = new DefaultTableModel (null, titulos);
 
     
ConectarBiblioteca cc= new ConectarBiblioteca ();
Connection cn= cc.conexion();


    try {
     Statement    st = cn.createStatement();
         ResultSet rs =st.executeQuery(sql);
         while (rs.next()){
             registros [0]=rs.getString("DNI");
             registros [1]=rs.getString("Apelidos");
             registros [2]=rs.getString("Nome");
             registros [3]=rs.getString("Observacions");
             registros [4]=rs.getString("Cliente");
             registros [5]=rs.getString("Curso");
             registros [6]=rs.getString("Data_Inic");
             registros [7]=rs.getString("Data_Fin");
             registros [8]=rs.getString("Num_Rex");
             registros [9]=rs.getString("Num_rex2");
                 registros [10]=rs.getString("Devolto");
                  registros [11]=rs.getString("entregado");
                 registros [12]=rs.getString("observacion_entrega");
         model.addRow(registros);
         }
         T_datos.setModel(model);


    } catch (SQLException ex) {
     JOptionPane.showMessageDialog (null, ex);
    }
   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtobservacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtmatricula = new javax.swing.JTextField();
        txtentregado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_datos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenuItem1.setText("Cargar Registro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/logoITT trans.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Matricula");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Entregado");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Observaciones");

        T_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        T_datos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(T_datos);

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/search.png"))); // NOI18N
        jLabel7.setText("Buscar");

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/corect.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/exis.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtmatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(199, 199, 199)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtentregado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtentregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                
        int fila= T_datos.getSelectedRow();
    if(fila>=0){
      txtmatricula.setText(T_datos.getValueAt(fila, 0).toString());   
      txtapellidos.setText(T_datos.getValueAt(fila, 1).toString());     
   
    
   
    }
    else{
    JOptionPane.showMessageDialog(null,"No selecciono la fila");
    }        // TODO add your handling code here:
    modif();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          
         if (txtcantidad.getText().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Ingresa la cantidad de libros devueltos", "error", JOptionPane.ERROR_MESSAGE);
        }else if (txtentregado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingresa si los libros han sido entregados", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtobservacion.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Ingresa una observación del libro", "error", JOptionPane.ERROR_MESSAGE);
        } 
       
        else {
         if (JOptionPane.showConfirmDialog(null, "Esta seguro de guardar los datos", "Confirmar",1)==0){
        
        
        try {
        PreparedStatement pst =
                cn.prepareStatement("UPDATE préstamos SET Apelidos='"+txtapellidos.getText()+"',Devolto='"+txtcantidad.getText()+"',entregado='"+txtentregado.getText()+"',observacion_entrega='"+   txtobservacion.getText()+"' WHERE DNI='"+ txtmatricula.getText()+"'");
        pst.executeUpdate();
       cargar("");
       JOptionPane.showMessageDialog(null, "Actualizacion correcta");
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
    
    }
    
    } 
                limpiar ();
                bloquear();
    }//GEN-LAST:event_jButton2ActionPerformed
    }    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         limpiar ();
         bloquear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     Gestion_prestamos adm= new  Gestion_prestamos ();
           adm.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
         cargar(jTextField6.getText()); 
    }//GEN-LAST:event_jTextField6KeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DevolucionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevolucionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevolucionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevolucionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevolucionLibro().setVisible(true);
            }
        });
    }

    ConectarBiblioteca cc= new ConectarBiblioteca ();
Connection cn= cc.conexion();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable T_datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtentregado;
    private javax.swing.JTextField txtmatricula;
    private javax.swing.JTextField txtobservacion;
    // End of variables declaration//GEN-END:variables
}
