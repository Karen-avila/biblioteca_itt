
package biblioteca_itt;

import ConecionBD.ConectarBiblioteca;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class Administrador extends javax.swing.JFrame {
DefaultTableModel model;
 
    public Administrador() {
        initComponents();
        this.setResizable(false);
         this.setTitle("Gestión de usuario");
         this.setLocationRelativeTo(Administrador.this);
         Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("biblio.png"));
       setIconImage(icon);
setVisible(true);
        limpiar();
     bloquear();
   
        cargar("");
        cerrar();
        
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
 String [] titulos = {"Matricula","Apellidos","Nombre (s)","Curp","Curso","Tipo de usuario","Ultimo prestamo"};
 String [] registros = new String [7];
 String sql = "SELECT * FROM usuarios where CONCAT (DNI,'',Nombre,'',Apellidos)LIKE '%"+valor+"%'";
 model = new DefaultTableModel (null, titulos);
 
     
ConectarBiblioteca cc= new ConectarBiblioteca ();
Connection cn= cc.conexion();


    try {
     Statement    st = cn.createStatement();
         ResultSet rs =st.executeQuery(sql);
         while (rs.next()){
             registros [0]=rs.getString("DNI");
             registros [1]=rs.getString("Apellidos");
             registros [2]=rs.getString("Nombre");
             registros [3]=rs.getString("Curp");
             registros [4]=rs.getString("Curso");
             registros [5]=rs.getString("Tipo_usuario");
             registros [6]=rs.getString("UltimoPrestamo");
         model.addRow(registros);
         }
         T_datos.setModel(model);
    } catch (SQLException ex) {
     JOptionPane.showMessageDialog (null, ex);
    }
   
    }
    
    void bloquear (){
    T_matricula.setEnabled(false);    
     T_apellidos.setEnabled(false);
     T_nombre.setEnabled(false);
     T_curp.setEnabled(false);
     T_curso.setEnabled(false);
     T_tip.setEnabled(false);
    BtnNuevo.setEnabled(true);
    jButton2.setEnabled(false);
     BtnAgregar.setEnabled(false);
     btneliminar.setEnabled(false);
     
     
}
    
     void desbloquear (){
    T_matricula.setEnabled(true);    
     T_apellidos.setEnabled(true);
     T_nombre.setEnabled(true);
     T_curp.setEnabled(true);
     T_curso.setEnabled(true);
     T_tip.setEnabled(true);
     BtnNuevo.setEnabled(false);
     jButton2.setEnabled(false);
     BtnAgregar.setEnabled(true);
     btneliminar.setEnabled(true);
     
}
    void modific (){
    T_matricula.setEnabled(true);    
     T_apellidos.setEnabled(true);
     T_nombre.setEnabled(true);
     T_curp.setEnabled(true);
     T_curso.setEnabled(true);
     T_tip.setEnabled(true);
     BtnNuevo.setEnabled(false);
     jButton2.setEnabled(true);
     BtnAgregar.setEnabled(false);
     btneliminar.setEnabled(true);
     
}
    
   
   
    
    
void limpiar (){
    T_matricula.setText("");    
     T_apellidos.setText("");
     T_nombre.setText("");
     T_curp.setText("");
     T_curso.setText("");
     T_tip.setText("");
     
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        T_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        T_apellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        T_curp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BtnNuevo = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        aux = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_datos = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        T_matricula = new javax.swing.JTextField();
        T_tip = new javax.swing.JTextField();
        T_curso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        jMenuItem1.setText("Modificar Registro");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/admin.png"))); // NOI18N
        jLabel2.setText("Gestión de usuarios");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nombre (S):");

        T_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_nombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        T_apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_apellidosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("CURP:");

        T_curp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_curpActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tipo de Usuario");

        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/new.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/corect.png"))); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/exis.png"))); // NOI18N
        btneliminar.setText("Cancelar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        aux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auxActionPerformed(evt);
            }
        });
        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });

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
        T_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_datosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(T_datos);

        jButton5.setBackground(new java.awt.Color(102, 255, 102));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/salir.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Carrera");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Matricula o DNI");

        T_matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_matriculaActionPerformed(evt);
            }
        });

        T_tip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_tipActionPerformed(evt);
            }
        });

        T_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_cursoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/search.png"))); // NOI18N
        jLabel7.setText("Buscar");
        jLabel7.setToolTipText("");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/manual.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/logoITT trans.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(T_curp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(T_tip, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(T_curso)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(aux, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(22, 22, 22))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(172, 172, 172))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(T_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(T_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(132, 132, 132))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel1))
                                                    .addComponent(T_apellidos))
                                                .addGap(22, 22, 22))))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T_curp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo)
                    .addComponent(btneliminar)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aux, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
      
         if (T_matricula.getText().isEmpty())  {
            JOptionPane.showMessageDialog(null, "Ingresa la Matricula o DNI", "error", JOptionPane.ERROR_MESSAGE);
        }else if (T_nombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingresa el nombre", "error", JOptionPane.ERROR_MESSAGE);
        }
        else if(T_apellidos.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Ingresa los apellidos", "error", JOptionPane.ERROR_MESSAGE);
        } 
         else if(T_tip.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Ingresa el tipo de usuario", "error", JOptionPane.ERROR_MESSAGE);
        } 
       
        else {
         if (JOptionPane.showConfirmDialog(null, "Esta seguro de guardar los datos", "Confirmar",1)==0){
              
    try {
            
         PreparedStatement pst= cn.prepareStatement ("insert into usuarios (DNI,Apellidos,Nombre,Curp,Curso,Tipo_usuario)values(?,?,?,?,?,?)");
                pst.setString(1,T_matricula.getText());    
            pst.setString(2,T_apellidos.getText());
            pst.setString(3,T_nombre.getText());
            pst.setString(4,T_curp.getText());
            pst.setString(5,T_curso.getText());
            pst.setString(6,T_tip.getText());
           int n=pst.executeUpdate();
           if (n>0){
               JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
        
           cargar("");
           }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
        
         }}
     limpiar();
     bloquear();
    
     
      
      
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
desbloquear();
limpiar();

T_matricula.requestFocus();


    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
bloquear();
        limpiar();      // TODO add your handling code here:
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         administracion adm= new  administracion();
           adm.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void T_matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_matriculaActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_T_matriculaActionPerformed

    private void T_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_nombreActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_T_nombreActionPerformed

    private void T_apellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_apellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_apellidosActionPerformed

    private void T_curpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_curpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_curpActionPerformed

    private void T_tipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_tipActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_T_tipActionPerformed

    private void T_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_cursoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_T_cursoActionPerformed

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
cargar(aux.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_auxKeyReleased

   

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          try {
        PreparedStatement pst =
                cn.prepareStatement("UPDATE usuarios SET Apellidos='"+T_apellidos.getText()+"',Nombre='"+T_nombre.getText()+"',Curp='"+T_curp.getText() +"',Curso='"+T_curso.getText()+"',Tipo_usuario='"+T_tip.getText()+"' WHERE DNI='"+T_matricula.getText()+"'");
        pst.executeUpdate();
       cargar("");
       JOptionPane.showMessageDialog(null, "El registro se ha modificado con éxito");
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
    
}   
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void T_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_datosMouseClicked
        
       
    }//GEN-LAST:event_T_datosMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
int fila= T_datos.getSelectedRow();
    if(fila>=0){
        T_matricula.setText(T_datos.getValueAt(fila, 0).toString());
        T_apellidos.setText(T_datos.getValueAt(fila, 1).toString());
        T_nombre.setText(T_datos.getValueAt(fila, 2).toString());
        
        T_curp.setText(T_datos.getValueAt(fila, 3).toString());
        T_tip.setText(T_datos.getValueAt(fila, 4).toString());
        T_curso.setText(T_datos.getValueAt(fila, 5).toString());

        
    }
    else{
    JOptionPane.showMessageDialog(null,"No selecciono la fila");
    }        // TODO add your handling code here:
    modific ();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

     
int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el registro?");


if(JOptionPane.OK_OPTION==confirmar) { 
   
   Connection conexion = null;   
        
        int fila = T_datos.getSelectedRow();
    String cod="";
    cod=T_datos.getValueAt(fila, 0).toString();
    
    try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM usuarios WHERE  DNI='"+cod+"'");
        pst.executeUpdate();
        cargar("");
        JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
         
    }   }
    limpiar();
    bloquear();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void auxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_auxActionPerformed
    
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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }
    
ConectarBiblioteca cc= new ConectarBiblioteca ();
Connection cn= cc.conexion ();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTextField T_apellidos;
    private javax.swing.JTextField T_curp;
    private javax.swing.JTextField T_curso;
    private javax.swing.JTable T_datos;
    private javax.swing.JTextField T_matricula;
    private javax.swing.JTextField T_nombre;
    private javax.swing.JTextField T_tip;
    private javax.swing.JTextField aux;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
