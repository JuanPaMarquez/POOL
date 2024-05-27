
package ventanas;

import baseDeDatos.conexion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import pool.Validacion;

/**
 *
 * @author JUNIOR SILVA
 */
public final class CrudBD extends JFrame {
    
 private  panelFondo panelFondo = new panelFondo() ;    
 private JPanel panelCrudBD;
 int click = 0;
 String [] operacion =   {"Nombre","Apellido","Edad","Sexo","Membresia"};
 JComboBox comInf= new  JComboBox(operacion);
 String[] vecP = new String[7];
 JTextField caja22 = new JTextField();
 JTextField caja33 = new JTextField();
 JTextArea infoA = new JTextArea();
  DefaultTableModel tab = new DefaultTableModel();
    JTable table; 
    conexion cc = new conexion();
    Connection con = cc.getConnection();
    
    
    
   
 
 Dimension dimPantalla = new Dimension(Toolkit.getDefaultToolkit().getScreenSize()) ;// toma el tamaño de la pantalla
 
 
    public CrudBD()  {
        panelFondo.setOpaque(false);
       this.getContentPane().add(panelFondo);  
        
     
     
    this.setSize(dimPantalla);
    this.setTitle("EL POOL");       
   // this.setUndecorated(true); // quita el borde de la ventana
    this.setLocationRelativeTo(null);
    this.setMinimumSize(dimPantalla);
    this.setMaximumSize(dimPantalla);

     this.setExtendedState(JFrame.MAXIMIZED_BOTH);
   // this.setResizable(false); 
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 this.add(panelFondo, BorderLayout.CENTER);
    ImageIcon icono = new ImageIcon("gota_agua.png") ;
    Image icono1 = icono.getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);        
    setIconImage(icono1);
 
    getContentPane().setBackground(Color.gray);
       
    iniciarcomponentesCrudBD(dimPantalla);

    }
    
 public void iniciarcomponentesCrudBD(Dimension dim){
     

 

 setJLabelCrudBD(  dim ) ;
 
 
 setJTable(dim); 
 
 desplegable(); 

 setButtomCrudBD(  dim  ) ;
 
 //colocarfondo(dim);  
      
 }
    

private void setJLabelCrudBD(Dimension dim){
   int pocix = (int) dimPantalla.width/2 ;  
    JLabel fecha = new  JLabel ();  
    fecha.setSize(400, 60);
     fecha.setLocation(pocix-200, 50);
     fecha.setBackground(Color.white);
     fecha.setText( " BASE DE DATOS ");
     fecha.setFont(new Font("Times New Roman", 3 , 30));
     fecha.setForeground(Color.black);
     fecha.setHorizontalAlignment(SwingConstants.CENTER);
     fecha.setOpaque(true);
     fecha.setBorder(BorderFactory.createLineBorder(Color.black, 4, false));
     panelFondo.add(fecha);
     
     
    JLabel buscarinf = new JLabel();
    
    buscarinf.setBounds(50, 100, 180, 40);
    buscarinf.setBackground(Color.white);
    buscarinf.setText("Digite Cedula:");
    buscarinf.setOpaque(true);
    buscarinf.setForeground(Color.BLACK);
    buscarinf.setFont(new Font("Times New Roman", Font.BOLD, 25));
    panelFondo.add(buscarinf);
    
    JLabel modificar = new JLabel();
    
    modificar.setBounds(50, 320, 240, 40);
    modificar.setBackground(Color.white);
    modificar.setText("Campo a Modificar:");
    modificar.setOpaque(true);
    modificar.setForeground(Color.BLACK);
    modificar.setFont(new Font("Times New Roman", Font.BOLD, 25));
    panelFondo.add(modificar);
    
    caja22.setBounds(50, 150, 280, 40);
    caja22.setBackground(Color.white);
    caja22.setOpaque(true);
    caja22.setForeground(Color.black);
    caja22.setFont(new Font("Times New Roman", 3, 16));
    panelFondo.add(caja22);
    
    JLabel campoMod = new JLabel();
    
    campoMod.setBounds(50, 410, 180, 40);
    campoMod.setBackground(Color.white);
    campoMod.setText("Dato a Insertar:");
    campoMod.setOpaque(true);
    campoMod.setForeground(Color.BLACK);
    campoMod.setFont(new Font("Times New Roman", Font.BOLD, 25));
    panelFondo.add(campoMod);
    
    caja33.setBounds(50, 460, 280, 40);
    caja33.setBackground(Color.white);
    caja33.setOpaque(true);
    caja33.setForeground(Color.black);
    caja33.setFont(new Font("Times New Roman", 3, 16));
    panelFondo.add(caja33);
    
    JLabel enconP = new JLabel();
    
    enconP.setBounds(1000, 170, 290, 40);
    enconP.setBackground(Color.white);
    enconP.setText("Informacion Encontrada:");
    enconP.setOpaque(true);
    enconP.setForeground(Color.BLACK);
    enconP.setFont(new Font("Times New Roman", Font.BOLD, 25));
    panelFondo.add(enconP);
    
    infoA.setBounds(1000,220,300,120);
    infoA.setBackground(Color.white);
    infoA.setOpaque(true);
    infoA.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    infoA.setForeground(Color.BLACK);
    panelFondo.add(infoA);
    
} 

public int buscarA(String cedula) {

        int resultado = 0;

        String SQL = "SELECT * FROM visitas WHERE cedula ='" + cedula + "'";

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    return resultado;
               //JOptionPane.showMessageDialog(null, "Se encontro el usuario");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar en la base el usuario" + e.getMessage());

        }

        if (resultado == 0) {
            return resultado;
            //JOptionPane.showMessageDialog(null, "No encontro el usuario");
        }
       return resultado;
    }

private void buscarID(String cedula, String vecP[]){
    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM visitas WHERE cedula ='" + cedula + "'");

        while(rs.next()){
        vecP[0] = rs.getString(2);
        vecP[1] = rs.getString(3);
        vecP[2] = rs.getString(4);
        vecP[3] = rs.getString(5);
        vecP[4] = rs.getString(6);
        vecP[5] = rs.getString(7);

    }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar en la base de datos" + e.getMessage());
    }
}

public void eliminar(String cedula) {

        String SQL = "DELETE FROM visitas WHERE cedula = '" + cedula + "'";
        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.executeUpdate();

        }catch(Exception e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar en la base" + e.getMessage());
        }
    }

public void modificar(String vecP[], String cedula) {

        String SQL = "UPDATE visitas SET LastName='" + vecP[1] + "',Age='" + vecP[2] + "',member='" + vecP[3] + "',nombre='" + vecP[4] + "',sexo='" + vecP[5] + "' WHERE cedula ='" + cedula + "'";

        try {
            PreparedStatement pst = con.prepareStatement(SQL);
            int resultado = pst.executeUpdate();
            if (resultado != 0) {
                JOptionPane.showMessageDialog(null, "Se actualizo el usuario");
            }else{
                JOptionPane.showMessageDialog(null, "No se actualizo el usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario" + e.getMessage());

        }

    }

private void desplegable(){
    comInf.setBounds(50, 370, 200, 30);      
    comInf.setFont(new Font("Times New Roman", 3 , 22));
    comInf.setSelectedItem(null); // para decidir con que item inicia seleccionado
    panelFondo.add(comInf);
    
    
}
 
 
private void setButtomCrudBD( Dimension dim ){
    
    Validacion vali = new Validacion();
    JButton ButtonListar  =new JButton();
    ActionListener list = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       //setJTable(dim); 

        if("si".equals(vali.valiID(caja22.getText(), click))){
            String cedula = caja22.getText();
            buscarID(cedula, vecP);
            int res = buscarA(cedula);
            if(res == 0){
                JOptionPane.showMessageDialog(null, "No encontro el usuario");
            }else{
                JOptionPane.showMessageDialog(null, "Se encontro el usuario");
                String cadena = "Cedula: "+vecP[0]+"\nNombre: "+vecP[4]+"\nApellido: "+vecP[1]+"\nEdad: "+vecP[2]+"\nSexo: "+vecP[5]+"\nMembresia: "+vecP[3];
                infoA.append(cadena);
            }
            
            
        }else{
            if("no".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "DIGITE UNA ID", "AVISO", 3);
            }
            if("no1".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO ENTRE 8 Y 10 DÍGITOS", "AVISO", 3); 
            }
            if("no2".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO", "AVISO", 3);
            }
        }
    }   
    };

    ButtonListar.setSize(280, 50);
    ButtonListar.setLocation(50,200);
    ButtonListar.setBackground(Color.darkGray);
    ButtonListar.setText("Buscar");
    ButtonListar.setFont(new Font("Times New Roman", 3 , 16));
    ButtonListar.setForeground(Color.WHITE);
    ButtonListar.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
    ButtonListar.setEnabled(true);
    ButtonListar.addActionListener(list);
    
    MouseListener escribir1 = new MouseListener() {
        @Override
         public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { 
         caja22.setForeground(Color.BLACK);
        if(click==0){ caja22.setText("");}
         caja22.setFont(new Font("arial", Font.PLAIN , 16));
        click=1;
        }
        @Override
        public void mouseReleased(MouseEvent e) { } 
        @Override
        public void mouseEntered(MouseEvent e) {} 
        @Override
        public void mouseExited(MouseEvent e) {} 
    };
    caja22.addMouseListener(escribir1);
    panelFondo.add(ButtonListar);     
        
    
    //Boton Eliminar
    
    JButton ButtonElimin  =new JButton();
    ActionListener Elimin = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       //setJTable(dim); 

        if("si".equals(vali.valiID(caja22.getText(), click))){
            String cedula = caja22.getText();
            int res = buscarA(cedula);
            if(res == 0){
                JOptionPane.showMessageDialog(null, "No encontro el usuario");
            }else{
                eliminar(cedula);
                JOptionPane.showMessageDialog(null, "Se Elimino el usuario");
                
            }
            
            
        }else{
            if("no".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "DIGITE UNA ID", "AVISO", 3);
            }
            if("no1".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO ENTRE 8 Y 10 DÍGITOS", "AVISO", 3); 
            }
            if("no2".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO", "AVISO", 3);
            }
        }
    }   
    };

    ButtonElimin.setSize(280, 50);
    ButtonElimin.setLocation(50,260);
    ButtonElimin.setBackground(Color.darkGray);
    ButtonElimin.setText("Eliminar");
    ButtonElimin.setFont(new Font("Times New Roman", 3 , 16));
    ButtonElimin.setForeground(Color.WHITE);
    ButtonElimin.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
    ButtonElimin.setEnabled(true);
    ButtonElimin.addActionListener(Elimin);
    
    MouseListener escribir2 = new MouseListener() {
        @Override
         public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { 
         caja22.setForeground(Color.BLACK);
        if(click==0){ caja22.setText("");}
         caja22.setFont(new Font("arial", Font.PLAIN , 16));
        click=1;
        }
        @Override
        public void mouseReleased(MouseEvent e) { } 
        @Override
        public void mouseEntered(MouseEvent e) {} 
        @Override
        public void mouseExited(MouseEvent e) {} 
    };
    caja22.addMouseListener(escribir2);
    panelFondo.add(ButtonElimin);  
    
    
    //Boton Modificar
    
    JButton ButtonModif  =new JButton();
    ActionListener Modif = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       //setJTable(dim); 

        if("si".equals(vali.valiID(caja22.getText(), click))){
            String cedula = caja22.getText();
            int ope = comInf.getSelectedIndex();
            if(ope >= 0 && ope <=4){
                buscarID(cedula, vecP);
                int res = buscarA(cedula);
                if (res != 0) {
                    if ("si".equals(vali.valiDatoString(caja33.getText(), click))) {
                        //Aqui es donde se hace la modificacion
                        if(ope == 0){
                            //Nombre
                            String nom = caja33.getText();
                            vecP[4] = nom;
                            modificar(vecP, cedula);
                            
                        }
                        if(ope == 1){
                            //Apellido
                            String ape = caja33.getText();
                            vecP[1] = ape;
                            modificar(vecP, cedula);
                            
                        }
                        if(ope == 2){
                            //Edad
                            String eda = caja33.getText();
                            
                            if ("si".equals(vali.valiAge(eda, click))) {
                                vecP[2] = eda;
                                modificar(vecP, cedula);
                            }else{
                                if("no1".equals(vali.valiAge(eda, click))){JOptionPane.showMessageDialog(null, "LA EDAD DEBE SER UN NÚMERO ENTRE 1 y 120", "AVISO", 3); }
                                if("no2".equals(vali.valiAge(eda, click))){JOptionPane.showMessageDialog(null, "LA CASILLA DE LA EDAD  DEBE SER UN NÚMERO", "AVISO", 3);} 
                            }
                            
                        }
                        if(ope == 3){
                            //Sexo
                            String seo = caja33.getText();
                            if("si".equals(vali.valiSexo(seo))){
                                if (seo.equalsIgnoreCase("m")) {
                                    seo = "HOMBRE";
                                }
                                if (seo.equalsIgnoreCase("f")) {
                                    seo = "MUJER";
                                }
                                if (seo.equalsIgnoreCase("o")) {
                                    seo = "OTROS";
                                }
                                vecP[5] = seo;
                                modificar(vecP, cedula);
                            }else{
                                if("no".equals(vali.valiSexo(seo))){
                                    JOptionPane.showMessageDialog(null, "EL SEXO DEBE SER 'M', 'F' o 'O'", "AVISO", 3);
                                }
                            }
                        }
                        if(ope == 4){
                            //Membresia
                            String mem = caja33.getText();
                            if ("si".equals(vali.valiMem(mem))) {
                                vecP[3] = mem;
                                modificar(vecP, cedula);
                            }else{
                                if ("no".equals(vali.valiMem(mem))) {
                                    JOptionPane.showMessageDialog(null, "LA MEMBRESIA DEBE SER 'SI' o 'NO'", "AVISO", 3);
                                }
                            }
                            
                        }
                        
                    }else{
                        if("no".equals(vali.valiID(caja33.getText(), click))){
                            JOptionPane.showMessageDialog(null, "DIGITE EL DATO A INSERTAR", "AVISO", 3);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "PERSONA NO ENCONTRADA", "AVISO", 3);
                }
            }else{
                JOptionPane.showMessageDialog(null, "SELECCIONE UN CAMPO", "AVISO", 3);
            }
            
        }else{
            if("no".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "DIGITE UNA ID", "AVISO", 3);
            }
            if("no1".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO ENTRE 8 Y 10 DÍGITOS", "AVISO", 3); 
            }
            if("no2".equals(vali.valiID(caja22.getText(), click))){
                JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO", "AVISO", 3);
            }
        }
    }   
    };

    ButtonModif.setSize(280, 50);
    ButtonModif.setLocation(50,510);
    ButtonModif.setBackground(Color.darkGray);
    ButtonModif.setText("Modificar");
    ButtonModif.setFont(new Font("Times New Roman", 3 , 16));
    ButtonModif.setForeground(Color.WHITE);
    ButtonModif.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
    ButtonModif.setEnabled(true);
    ButtonModif.addActionListener(Modif);
    
    MouseListener escribir3 = new MouseListener() {
        @Override
         public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { 
         caja22.setForeground(Color.BLACK);
        if(click==0){ caja22.setText("");}
         caja22.setFont(new Font("arial", Font.PLAIN , 16));
        click=1;
        }
        @Override
        public void mouseReleased(MouseEvent e) { } 
        @Override
        public void mouseEntered(MouseEvent e) {} 
        @Override
        public void mouseExited(MouseEvent e) {} 
    };
    caja22.addMouseListener(escribir3);
    panelFondo.add(ButtonModif); 
    
    
    
    
    ActionListener salir = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         dispose(); // se le agrega el evento en este caso cerrar ventana
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         System.exit(0);
        }
    };

  ImageIcon imagen = new ImageIcon("salir2.png") ;  
      ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING )) ; 
      
  JButton boton2 =new JButton();
      MouseListener pass = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { } // solo presiona 
        @Override
        public void mouseReleased(MouseEvent e) { } // presionar y soltarfuera 
        @Override
        public void mouseEntered(MouseEvent e) {  boton2.setOpaque(true);} // pasa la flecha por encima de boton u objeto
        @Override
        public void mouseExited(MouseEvent e) {boton2.setOpaque(false);} // cuando sale la flecha del boton 
    }  ; 
    boton2.setBounds(dimPantalla.width-150, dimPantalla.height-200 , 100, 100);
    boton2.setIcon(imagen2);
    boton2.setOpaque(false);
    boton2.setHorizontalAlignment(SwingConstants.CENTER);
    boton2.setBackground(Color.white);
    boton2.setEnabled(true) ;
    boton2.addMouseListener(pass);
    boton2.addActionListener(salir); 
    boton2.setBorder(null); 
    panelFondo.add(boton2);   
    
    
  ActionListener casa = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false); 
           Inicio ini = new Inicio();
       ini.setVisible(true); 
            
        }
    }; 
     ImageIcon imagenCasa = new ImageIcon("casa.png") ;  
    ImageIcon imagenCasa2 = new ImageIcon(imagenCasa.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING )) ; 
    JButton CasaButton =new JButton(); 
     MouseListener pass2 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { } // solo presiona 
        @Override
        public void mouseReleased(MouseEvent e) { } // presionar y soltarfuera 
        @Override
        public void mouseEntered(MouseEvent e) {  CasaButton.setOpaque(true);} // pasa la flecha por encima de boton u objeto
        @Override
        public void mouseExited(MouseEvent e) {CasaButton.setOpaque(false);} // cuando sale la flecha del boton 
    }  ; 
    CasaButton.setBounds(50, dimPantalla.height-200 , 100, 100);
    CasaButton.setIcon(imagenCasa2);
    CasaButton.setOpaque(false);
    CasaButton.setHorizontalAlignment(SwingConstants.CENTER);
    CasaButton.setBackground(Color.white);
    CasaButton.setEnabled(true) ;
    CasaButton.addMouseListener(pass2);
    CasaButton.addActionListener(casa); 
    CasaButton.setBorder(null); 
    panelFondo.add(CasaButton);   
    
    

}

 public void fillColumns(){
     
     
     
     
     tab.addColumn("Cédula");
     tab.addColumn("Nombre");
     tab.addColumn("Apellido");
     tab.addColumn("Edad");
     tab.addColumn("Sexo");
     tab.addColumn("Membresía");      
     
      table = new JTable(tab);
    } 
private void setJTable(Dimension dim){
   
     
        fillColumns();
     String data[] = new String[7];
                    
                String SQL = "SELECT * FROM visitas ";

        try {

            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
          
            while(rs.next()) {  
            data[0]= rs.getString(2);
            data[1]= rs.getString(6);
            data[2]= rs.getString(3);
            data[3]= rs.getString(4);
            data[4]= rs.getString(7);
            data[5]= rs.getString(5);
            
            
            
             tab.addRow(data);     
             
            }
            //JOptionPane.showMessageDialog(null, "Hola Prueba", "Informacion",1);
        
            
            table.setModel(tab);

        } catch (Exception e) {
          
         JOptionPane.showMessageDialog(null, "Error al buscar en la base el usuario" + e.getMessage());
        }
                  
                    
       JScrollPane scroll = new JScrollPane(table);
       scroll.setBounds((dim.width/2)-300,150, 600, 600);
       panelFondo.add(scroll);            
    
    
    
}

}
