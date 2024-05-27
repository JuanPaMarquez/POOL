
package ventanas;


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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author JUNIOR SILVA
 */
public class Inicio extends JFrame {
    
 private panelFondo panelFondo = new panelFondo() ;    
 private JPanel panelInicio;
DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // no tocar
DateTimeFormatter date2 = DateTimeFormatter.ofPattern("yy/MM/dd");
String date1 = date2.format(LocalDateTime.now());

 
 Dimension dimPantalla = new Dimension(Toolkit.getDefaultToolkit().getScreenSize()) ;// toma el tamaño de la pantalla
    public Inicio()  {
        panelFondo.setOpaque(false);
       this.getContentPane().add(panelFondo);  
        
        System.out.println(" FECHA : " + this.getFecha());
  Dimension MINIM_DIM = new Dimension(1000,800);       
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
    iniciarcomponentesInicio(dimPantalla);

    }
    
    
private void iniciarcomponentesInicio( Dimension dim){
 
 //setJPanelInicio(dim) ;
 setJLabelInicio(  dim ) ;

 setButtomInicio(  dim  ) ;
 
 //colocarfondo(dim);  
}       
     
 private void colocarfondo(Dimension dim){
    
    ImageIcon imagen2 = new ImageIcon("fondo_mar.jpg") ;
    JLabel fondo = new  JLabel ();
  
 
    fondo.setOpaque(true);

    fondo.setPreferredSize(dim);
    fondo.setSize(dim);
    fondo.setBackground(Color.BLUE);
    Image fondo1 = imagen2.getImage().getScaledInstance(fondo.getWidth() ,  fondo.getHeight(),Image.SCALE_DEFAULT );
    ImageIcon Fondo = new ImageIcon(fondo1) ;

    fondo.setIcon(Fondo);
    fondo.setHorizontalAlignment(SwingConstants.CENTER);
    panelFondo.add(fondo);     
    
}   
    
private void setJPanelInicio(Dimension dim){
    // el panel 
    panelInicio = new JPanel();// se crea el panel 
    panelInicio.setOpaque(false);
    
    panelInicio.setLayout(null); // desavilitar los diseños de defecto
    panelInicio.setSize(dim);
   
    this.getContentPane().add(panelInicio); // se agrega el panel o JPanel a la ventana 
    panelInicio.setBackground(Color.red);
      
    
}    
 
private void setJLabelInicio( Dimension dim ){
       int pocix = (int) dimPantalla.width/2 ;  
    JLabel fecha = new  JLabel ();  
    fecha.setSize(200, 60);
     fecha.setLocation(pocix-100, 50);
     fecha.setBackground(Color.white);
     fecha.setText( "FECHA : "+date1);
     fecha.setFont(new Font("Times New Roman", 3 , 16));
     fecha.setForeground(Color.black);
     fecha.setHorizontalAlignment(SwingConstants.CENTER);
     fecha.setOpaque(true);
     fecha.setBorder(BorderFactory.createLineBorder(Color.black, 4, false));
     panelFondo.add(fecha);
    //  JLabel lab1 = new  JLabel ();
      
    ImageIcon imagen1 = new ImageIcon("pool.png");
  
    JLabel lab2 = new  JLabel ();  
    lab2.setOpaque(false);
    lab2.setBounds((pocix-200),200, 400, 250);
    Image imagen1_1 = imagen1.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT );
    ImageIcon imagen1_2 = new ImageIcon(imagen1_1);
    lab2.setBackground(Color.red); 
    lab2.setIcon(imagen1_2);
    lab2.setHorizontalAlignment(SwingConstants.CENTER);
    // lab2.setBorder(BorderFactory.createLineBorder(Color.cyan, 4, false));
    panelFondo.add(lab2);
}



private void setButtomInicio( Dimension dim ){
    
    ActionListener salir = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         dispose(); // se le agrega el evento en este caso cerrar ventana
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         System.exit(0);
        }
    };
      
          ActionListener ClickIniciar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       setVisible(false); // cierra la ventana 1
           

      Llenado v = new Llenado( getFecha() );
      v.setVisible(true); // abre la 2
        }
    }; 
      JButton boton1 =new JButton();  
       int x = ((int) dim.width/2)-100; 
     boton1.setSize(200, 60);
     boton1.setLocation(x, 500);
     boton1.setBackground(Color.white);
     boton1.setText("INICIAR DíA");
     boton1.setFont(new Font("Times New Roman", 3 , 16));
     boton1.setForeground(Color.black); 
     boton1.setOpaque(false);
     boton1.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
     boton1.addActionListener(ClickIniciar);
     panelFondo.add(boton1); 
     
     
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

     
   ImageIcon imagenBD = new ImageIcon("IconoBD.png") ;  
      ImageIcon imagenBD2 = new ImageIcon(imagenBD.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING )) ;   
    
      
      ActionListener ClickBD = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       
           // setVisible(false); 
           

      CrudBD v = new CrudBD(  );
      v.setVisible(true); 
            
        }
    };  
      
  JButton BDJButton =new JButton();  
 MouseListener pass2 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { } // solo presiona 
        @Override
        public void mouseReleased(MouseEvent e) { } // presionar y soltarfuera 
        @Override
        public void mouseEntered(MouseEvent e) {  BDJButton.setOpaque(true);} // pasa la flecha por encima de boton u objeto
        @Override
        public void mouseExited(MouseEvent e) {BDJButton.setOpaque(false);} // cuando sale la flecha del boton 
    }  ;   
    BDJButton.setBounds(50, dimPantalla.height-200 , 100, 100);
    BDJButton.setIcon(imagenBD2);
    BDJButton.setOpaque(false);
    BDJButton.setHorizontalAlignment(SwingConstants.CENTER);
    BDJButton.setBackground(Color.white);
    BDJButton.setEnabled(true) ;
    BDJButton.addMouseListener(pass2);
    BDJButton.addActionListener(ClickBD); 
    BDJButton.setBorder(null); 
    panelFondo.add(BDJButton);   
    
     
     
}

private int  getFecha(){
    

String date2 = date1.replace("/", "") ;
                   
            
int date_n =Integer.parseInt(date2);    
 
return date_n ;
}


}
