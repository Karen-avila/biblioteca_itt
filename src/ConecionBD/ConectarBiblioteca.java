
package ConecionBD;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ANA
 */
public class ConectarBiblioteca {
   Connection con= null;

  public Connection conexion (){
      try {
          //cargar driver
          Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection("jdbc:mysql://localhost/movedb","root","");
          
          
        //System.out.println("Conecion establecida");
        //JOptionPane.showMessageDialog(null, "Conecion establecida");
      } catch (ClassNotFoundException | SQLException e){
        System.out.print(e.getMessage());
        //JOptionPane.showMessageDialog(null, "error de conexion"+e);
  }
          
       return con;
  }
          
           
}
