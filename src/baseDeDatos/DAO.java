package baseDeDatos;

import ventanas.Finalizado;
import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JUNIOR SILVA
 */
public class DAO {

    private ResultSet RS;
    conexion cc = new conexion();
    Connection con = cc.getConnection();
    private PreparedStatement PS;

    public void registrarpersonas(long codigo, String Lastname, String Age, String cedula, String nombre, String member, String sexo) {
        System.out.println("" + nombre);
        System.out.println("" + cedula);
        System.out.println("" + Age);
        System.out.println("" + Lastname);
        System.out.println("" + codigo);
        System.out.println("" + member);
        System.out.println("" + sexo);

        String i2 = Long.toString(codigo);
        //   String Age2=Integer.toString(Age);

        String SQL = "INSERT INTO visitas(cedula, LastName, Age, member, nombre, sexo) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);
           pst.setString(1, cedula);
            pst.setString(2, Lastname);
            pst.setString(3, Age);
            pst.setString(4, member);
            pst.setString(5, nombre);
            pst.setString(6, sexo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se inserto con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar en la base" + e.getMessage());
        }

        /*
          System.out.println(""+telefono);
          System.out.println(""+direccion);
          System.out.println(""+ciudad);
          System.out.println(""+pais);*/

 /*   String SQL = "INSERT INTO personas (pers_cedula,pers_nombre_completo, pers_email, pers_numero_telefono, pers_direccion, pers_ciudad, pers_pais) VALUES (?,?,?,?,?,?,?)";

    +  
        
        
        
        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, cedula);
            pst.setString(2, nombrecompleto);
            pst.setString(3, email);
            pst.setString(4, telefono);
            pst.setString(5, direccion);
            pst.setString(6, ciudad);
            pst.setString(7, pais);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se inserto con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar en la base" + e.getMessage());
        }
 */
 
 
    }

    public void eliminarpersona(String cedula) {

        String SQL = "DELETE FROM personas WHERE pers_cedula = '" + cedula + "'";
        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino con exito");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar en la base" + e.getMessage());

        }
        
    }

  
    public void buscar(String cedula) {

        int resultado = 0;

        String SQL = "SELECT * FROM personas WHERE pers_cedula ='" + cedula + "'";

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(null, "Se encontro el usuario");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar en la base el usuario" + e.getMessage());

        }

        if (resultado == 0) {
            JOptionPane.showMessageDialog(null, "No encontro el usuario");
        }

    }
/*
    public void modificar(String cedula, String nombrecompleto, String email, String telefono, String direccion, String ciudad, String pais) {

        String SQL = "UPDATE personas SET pers_nombre_completo='" + nombrecompleto + "',pers_email='" + email + "',pers_numero_telefono='" + telefono + "',pers_direccion='" + direccion + "',pers_ciudad='" + ciudad + "',pers_pais ='" + pais + "' WHERE pers_cedula ='" + cedula + "'";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            int resultado = pst.executeUpdate();
            if (resultado != 0) {

                JOptionPane.showMessageDialog(null, "Se actualizo el usuario");
                 String r="0",t="0";
                Ventana tec1 = new Ventana(r,t);
                tec1.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No se actualizo el usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario" + e.getMessage());

        }

    }
     */
    public DAO() {

    }

}
