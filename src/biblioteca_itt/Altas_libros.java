/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_itt;

import ConecionBD.ConectarBiblioteca;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANA
 */
public class Altas_libros extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form Altas_libros
     */
    public Altas_libros() {
      
        initComponents();
        
          this.setTitle("Libros");
         this.setLocationRelativeTo(Altas_libros.this);
         Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("biblio.png"));
       setIconImage(icon);
setVisible(true);
        bloquear();
        cargar("");
       
    }
    
    
    ConectarBiblioteca cc= new ConectarBiblioteca ();
Connection cn= cc.conexion();

    void cargar(String valor){
 String [] titulos = {"Num Registro","Signatura","Fecha de registro","Titulo","Autor","Autor2","Otros Autores","Editorial", "ISBN","Colección", "Edición", 
     " Lugar de impresión", "Año de impresión", "Temas", "Idioma", "Soporte", "Link", "Prestado", "No_prestar","Baixa", "Lista_espera", "Notas", "Notas2"};
 String [] registros = new String [23];
 String sql = "SELECT * FROM libros where CONCAT (Num_Rex,'',Titulo,'',Autor)LIKE '%"+valor+"%'";
  model = new DefaultTableModel (null, titulos);
 
     
ConectarBiblioteca cc= new ConectarBiblioteca ();
Connection cn= cc.conexion();


    try {
     Statement    st = cn.createStatement();
         ResultSet rs =st.executeQuery(sql);
         while (rs.next()){
             registros [0]=rs.getString("Num_Rex");
             registros [1]=rs.getString("Sinatura");
             registros [2]=rs.getString("Data_Rex");
             registros [3]=rs.getString("Titulo");
             registros [4]=rs.getString("Autor");
             registros [5]=rs.getString("Autor2");
             registros [6]=rs.getString("OMR");
             registros [7]=rs.getString("Editorial");
             registros [8]=rs.getString("ISBN");
             registros [9]=rs.getString("Coleccion");
             registros [10]=rs.getString("Edicion");
             registros [11]=rs.getString("Lugar_Impr");
             registros [12]=rs.getString("Ano_Impr");
             registros [13]=rs.getString("Temas");
               registros [14]=rs.getString("Idioma");
             registros [15]=rs.getString("Soporte");
              registros [16]=rs.getString("Link");
             registros [17]=rs.getString("Prestado");
             registros [18]=rs.getString("No_Prestar");
              registros [19]=rs.getString("Baixa");
             registros [20]=rs.getString("ListaEspera");
                 registros [21]=rs.getString("Notas");
                  registros [22]=rs.getString("Notas2");
                
                  
                 
                  
                  
             
         model.addRow(registros);
         }
         T_datos.setModel(model);
    } catch (SQLException ex) {
     JOptionPane.showMessageDialog (null, ex);
    }
   
    }

    void limpiar (){
        
       txtnum.setText("");
    txtsignatura.setText("");    
     Jfecha.setDate(null);
     txtitulo.setText("");
     txtautor.setText("");
     txtautor2.setText("");
     txtotros.setText("");
      txteditorial.setText("");
     txtisbn.setText("");
     txtcoleccion.setText("");
     txtedicion.setText("");
      txtlugar.setText("");
     txtaño.setText("");
     txtemas.setText("");
     txtidioma.setText("");
     txtsopt.setText("");
     txtnotas.setText("");
      txtimagen.setText("");
     
     
     
}
     void desbloquear  (){
        
       txtnum.setEnabled(true);  
    txtsignatura.setEnabled(true);      
     Jfecha.setEnabled(true);  
     txtitulo.setEnabled(true);  
     txtautor.setEnabled(true);  
     txtautor2.setEnabled(true);  
     txtotros.setEnabled(true);  
      txteditorial.setEnabled(true);  
     txtisbn.setEnabled(true);  
     txtcoleccion.setEnabled(true);  
     txtedicion.setEnabled(true);  
      txtlugar.setEnabled(true);  
     txtaño.setEnabled(true);  
     txtemas.setEnabled(true);  
     txtidioma.setEnabled(true);  
     txtsopt.setEnabled(true);  
     txtnotas.setEnabled(true);
        
     modificar.setEnabled(false);
     jButton1.setEnabled(true);
     jButton2.setEnabled(true);
     btnuevo.setEnabled(false);
     
    
     
     
}
 
     void bloquear (){
        
       txtnum.setEnabled(false);  
    txtsignatura.setEnabled(false);      
     Jfecha.setEnabled(false);  
     txtitulo.setEnabled(false);  
     txtautor.setEnabled(false);  
     txtautor2.setEnabled(false);  
     txtotros.setEnabled(false);  
      txteditorial.setEnabled(false);  
     txtisbn.setEnabled(false);  
     txtcoleccion.setEnabled(false);  
     txtedicion.setEnabled(false);  
      txtlugar.setEnabled(false);  
     txtaño.setEnabled(false);  
     txtemas.setEnabled(false);  
     txtidioma.setEnabled(false);  
     txtsopt.setEnabled(false);  
     txtnotas.setEnabled(false);  
     modificar.setEnabled(false);  
    
     jButton1.setEnabled(false);
     jButton2.setEnabled(false);
     btnuevo.setEnabled(true);
     
     
     
}
  
 void modificar (){
        
       txtnum.setEnabled(true);  
    txtsignatura.setEnabled(true);      
     Jfecha.setEnabled(true);  
     txtitulo.setEnabled(true);  
     txtautor.setEnabled(true);  
     txtautor2.setEnabled(true);  
     txtotros.setEnabled(true);  
      txteditorial.setEnabled(true);  
     txtisbn.setEnabled(true);  
     txtcoleccion.setEnabled(true);  
     txtedicion.setEnabled(true);  
      txtlugar.setEnabled(true);  
     txtaño.setEnabled(true);  
     txtemas.setEnabled(true);  
     txtidioma.setEnabled(true);  
     txtsopt.setEnabled(true);  
     txtnotas.setEnabled(true);  
     modificar.setEnabled(true);
     
     jButton1.setEnabled(false);
     jButton2.setEnabled(true);
     btnuevo.setEnabled(false);
     
 
 
 }



   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel4 = new javax.swing.JLabel();
        txtsoporte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtsignatura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Jfecha = new com.toedter.calendar.JDateChooser();
        txtitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtautor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtautor2 = new javax.swing.JTextField();
        txtotros = new javax.swing.JTextField();
        txteditorial = new javax.swing.JTextField();
        txtisbn = new javax.swing.JTextField();
        txtcoleccion = new javax.swing.JTextField();
        txtedicion = new javax.swing.JTextField();
        txtlugar = new javax.swing.JTextField();
        txtnotas = new javax.swing.JTextField();
        txtaño = new javax.swing.JTextField();
        txtemas = new javax.swing.JTextField();
        txtidioma = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtsopt = new javax.swing.JTextField();
        txtnum = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        btnuevo = new javax.swing.JButton();
        btnseleccionar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtimagen = new javax.swing.JTextField();
        labelfoto = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_datos = new javax.swing.JTable();
        auxiliar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jLabel19.setText("jLabel19");

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

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Modificar Registro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/logoITT trans.png"))); // NOI18N

        txtsoporte.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gestión de Libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 153, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Signatura");

        txtsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsignaturaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Fecha de registro");

        Jfecha.setDateFormatString("yyyy/MM/dd");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Titulo");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Autor");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Autor 2");

        txteditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteditorialActionPerformed(evt);
            }
        });

        txtnotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnotasActionPerformed(evt);
            }
        });

        txtaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtañoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Otros Autores");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("ISBN");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Editorial");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Colección");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Edición");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText(" Lugar de impresión");
        jLabel22.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Año de impresión");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Temas");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Idioma");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Soporte");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Num. Registro");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/corect.png"))); // NOI18N
        jButton1.setText("Dar de Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/exis.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Notas");

        modificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/manual.png"))); // NOI18N
        modificar.setText("Modificar ");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        btnuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/new.png"))); // NOI18N
        btnuevo.setText("Nuevo");
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });

        btnseleccionar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnseleccionar.setText("Seleccionar");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Imagen");

        javax.swing.GroupLayout txtsoporteLayout = new javax.swing.GroupLayout(txtsoporte);
        txtsoporte.setLayout(txtsoporteLayout);
        txtsoporteLayout.setHorizontalGroup(
            txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtsoporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtsoporteLayout.createSequentialGroup()
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtsoporteLayout.createSequentialGroup()
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(txtsoporteLayout.createSequentialGroup()
                                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel21)
                                                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtautor2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(txteditorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(txtsoporteLayout.createSequentialGroup()
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtsoporteLayout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(jLabel8)
                                        .addGap(41, 41, 41))
                                    .addGroup(txtsoporteLayout.createSequentialGroup()
                                        .addComponent(txtedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtotros, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel16))
                                        .addGap(7, 7, 7)))
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17)
                                    .addComponent(txtaño))))
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtsoporteLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtsoporteLayout.createSequentialGroup()
                                            .addComponent(txtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18))
                                        .addGroup(txtsoporteLayout.createSequentialGroup()
                                            .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(txtsoporteLayout.createSequentialGroup()
                                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(txtsoporteLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel20))
                                            .addComponent(txtemas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtsoporteLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(269, 269, 269))
                                    .addGroup(txtsoporteLayout.createSequentialGroup()
                                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9)
                                            .addComponent(txtidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtsoporteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181))))
                    .addGroup(txtsoporteLayout.createSequentialGroup()
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtsoporteLayout.createSequentialGroup()
                                .addComponent(btnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtsoporteLayout.createSequentialGroup()
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsopt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addComponent(txtnotas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(txtsoporteLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        txtsoporteLayout.setVerticalGroup(
            txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtsoporteLayout.createSequentialGroup()
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtsoporteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtsoporteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtsoporteLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20)))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txteditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtautor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcoleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(3, 3, 3)
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtsoporteLayout.createSequentialGroup()
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(8, 8, 8)
                        .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsopt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnseleccionar))
                    .addGroup(txtsoporteLayout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(labelfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txtsoporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modificar)
                        .addComponent(btnuevo)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/books.png"))); // NOI18N

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/salir.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        auxiliar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxiliarKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca_itt/imagenes/search.png"))); // NOI18N
        jLabel14.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(auxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsoporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsignaturaActionPerformed

    private void txtnotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnotasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
administracion adm= new  administracion();
           adm.setVisible(true);
           this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
bloquear();      
        limpiar(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txteditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteditorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteditorialActionPerformed

    private void txtañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtañoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtañoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       try {
        
          PreparedStatement pst= cn.prepareStatement ("insert into libros (Num_Rex, Sinatura,Data_Rex, Titulo, Autor, Autor2, OMR, Editorial, ISBN, Coleccion, Edicion, Lugar_Impr, Ano_Impr, Temas, Idioma, Soporte, Notas) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           
          pst.setString(1, txtnum.getText());    
         pst.setString(2, txtsignatura.getText());  
       
            pst.setString(3, ((JTextField)Jfecha.getDateEditor().getUiComponent()).getText());
           pst.setString(4, txtitulo.getText());
            pst.setString(5,txtautor.getText());
            pst.setString(6, txtautor2.getText());
            pst.setString(7, txtotros.getText());
             pst.setString(8,  txteditorial.getText());
            pst.setString(9, txtisbn.getText());
            pst.setString(10,txtcoleccion.getText());
            pst.setString(11, txtedicion.getText());
            pst.setString(12, txtlugar.getText());
             pst.setString(13,   txtaño.getText());
            pst.setString(14,  txtemas.getText());
            pst.setString(15,txtidioma.getText());
            pst.setString(16,txtsopt.getText());
             pst.setString(17,txtnotas.getText());
       
           
          
           int n=pst.executeUpdate();
           if (n>0){
               JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
        
           cargar("");
           
           }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        
        Logger.getLogger(Altas_libros.class.getName()).log(Level.SEVERE, null, ex);
    }
   
    
        
       bloquear(); 
     limpiar();
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                  
int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el registro?");


if(JOptionPane.OK_OPTION==confirmar) { 
   
   Connection conexion = null;   
        
        int fila = T_datos.getSelectedRow();
    String cod="";
    cod=T_datos.getValueAt(fila, 0).toString();
    
    try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM libros WHERE  Num_Rex='"+cod+"'");
        pst.executeUpdate();
        cargar("");
        JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
         
    }   }
    limpiar();
   // TODO add your handling code here:
     

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void auxiliarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxiliarKeyReleased
cargar(auxiliar.getText());         // TODO add your handling code here:
    }//GEN-LAST:event_auxiliarKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
 
                
        int fila= T_datos.getSelectedRow();
    if(fila>=0){
      txtnum.setText(T_datos.getValueAt(fila, 0).toString());   
txtsignatura.setText(T_datos.getValueAt(fila, 1).toString());

            Jfecha.setDateFormatString(T_datos.getValueAt(fila, 2).toString());
            
            
  
   //Jfecha.setDate(T_datos.getValueAt(fila, 2).toString());
    txtitulo.setText(T_datos.getValueAt(fila, 3).toString());
     txtautor.setText(T_datos.getValueAt(fila, 4).toString());
     txtautor2.setText(T_datos.getValueAt(fila, 5).toString());
     txtotros.setText(T_datos.getValueAt(fila, 6).toString());
      txteditorial.setText(T_datos.getValueAt(fila, 7).toString());
     txtisbn.setText(T_datos.getValueAt(fila, 8).toString());
     txtcoleccion.setText(T_datos.getValueAt(fila, 9).toString());
     txtedicion.setText(T_datos.getValueAt(fila, 10).toString());
      txtlugar.setText(T_datos.getValueAt(fila, 11).toString());
     txtaño.setText(T_datos.getValueAt(fila, 12).toString());
     txtemas.setText(T_datos.getValueAt(fila, 13).toString());
     txtidioma.setText(T_datos.getValueAt(fila, 14).toString());
     txtsopt.setText(T_datos.getValueAt(fila, 15).toString());
     txtnotas.setText(T_datos.getValueAt(fila, 21).toString());
    
       
    }
    else{
    JOptionPane.showMessageDialog(null,"No selecciono la fila");
    }        // TODO add your handling code here:
    
       modificar(); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
          try {
            
        PreparedStatement pst =
                cn.prepareStatement("UPDATE libros SET Sinatura='"+txtsignatura.getText()+"',Titulo='"+txtitulo.getText()+"',Autor='"+txtautor.getText() +"',Autor2='"+txtautor2.getText()+"',OMR='"+txtotros.getText()+"',Editorial='"+ txteditorial.getText()+"',ISBN='"+ txtisbn.getText()+
                        "',Coleccion='"+txtcoleccion.getText()+ "',Edicion='"+ txtedicion.getText()+"',Lugar_Impr='"+ txtlugar.getText()+"', Ano_Impr='"+ txtaño.getText()+"',Temas='"+ txtemas.getText()+"',Idioma='"+ txtidioma.getText()+"',Soporte='"+ txtsopt.getText()+"',Notas='"+ txtnotas.getText()+"',nom_imagen='"+ txtimagen.getText()+"' WHERE Num_Rex='"+txtnum.getText()+"'");
        pst.executeUpdate();
       cargar("");
   
       JOptionPane.showMessageDialog(null, "El registro se ha modificado con éxito");
      
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
    
    
    
    }
            limpiar();
 bloquear();
     
    }//GEN-LAST:event_modificarActionPerformed

    private void T_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_datosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_T_datosMouseClicked

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
       limpiar();
       desbloquear();
    }//GEN-LAST:event_btnuevoActionPerformed

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
   
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter ("formatos de Archivo JPEG(*.JPG:*.JPEG)","jpg","jpeg");
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
       
     int ventana = archivo.showOpenDialog(null);
     if (ventana == JFileChooser.APPROVE_OPTION)
     {
         File file = archivo.getSelectedFile();
         txtimagen.setText(String.valueOf(file));
         Image  foto = getToolkit().getImage(txtimagen.getText());
         foto = foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
         labelfoto.setIcon(new ImageIcon(foto));
         
         
         
         
         
         
        
         
         
         
         
     }     
     
    }//GEN-LAST:event_btnseleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(Altas_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Altas_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Altas_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Altas_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Altas_libros().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Jfecha;
    private javax.swing.JTable T_datos;
    private javax.swing.JTextField auxiliar;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.JButton btnuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelfoto;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField txtautor;
    private javax.swing.JTextField txtautor2;
    private javax.swing.JTextField txtaño;
    private javax.swing.JTextField txtcoleccion;
    private javax.swing.JTextField txtedicion;
    private javax.swing.JTextField txteditorial;
    private javax.swing.JTextField txtemas;
    private javax.swing.JTextField txtidioma;
    private javax.swing.JTextField txtimagen;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtitulo;
    private javax.swing.JTextField txtlugar;
    private javax.swing.JTextField txtnotas;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtotros;
    private javax.swing.JTextField txtsignatura;
    private javax.swing.JPanel txtsoporte;
    private javax.swing.JTextField txtsopt;
    // End of variables declaration//GEN-END:variables

    
}
