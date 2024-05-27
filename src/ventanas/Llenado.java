
package ventanas;

import DatosVisitantes.Metodos;
import DatosVisitantes.Visitante;
import baseDeDatos.DAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import pool.Validacion;

/**
 *
 * @author JUNIOR SILVA
 */
public class Llenado extends JFrame{

 private JPanel panelLlenado ;
 private JLabel lab1;
 private JTextField name ;
 private JTextField ID;
 private JTextField Age;
 private JTextField Lastname;
 private JRadioButton RbotonMen ;
 private JRadioButton RbotonWomen ;
 private JRadioButton RbotonOther ;
  private JRadioButton Rboton1;
 private JRadioButton Rboton2;
 private ButtonGroup GrupoRBoton1 ;

 Validacion vali = new Validacion();
 public String name1 ;
 public int i=0; 
    int click=0 , click1=0 , click2=0, click3=0, click4=0;
    Metodos met = new Metodos() ;
    int fecha;
    
     Dimension dimPantalla = new Dimension(Toolkit.getDefaultToolkit().getScreenSize()) ;
    public Llenado(int fecha) {
        
        
        this.fecha=fecha;
     // Dimension MINIM_DIM = new Dimension(1000,800);  
   //   this.setUndecorated(true); // quita el borde de la ventana
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setSize(dimPantalla);
      this.setTitle("EL POOL");       
      this.setLocationRelativeTo(null);
      this.setMinimumSize(dimPantalla);
      this.setMinimumSize( dimPantalla);
    //  this.setResizable(false); 
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
  
      ImageIcon icono = new ImageIcon("gota_agua.png") ;
      Image icono1 = icono.getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);        
      setIconImage(icono1);
        
      iniciarcomponentesLlenado(dimPantalla);   
    }
    
  private void iniciarcomponentesLlenado( Dimension dim){
 
  setJPanelLlenado(dim) ;

  setJLabelLlenado(  dim ) ;
  setJTextField( ) ;
  setButtonLlenado(  dim  ) ;
  setRadiobotones( ) ;

  colocarfondo(dim);  
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
  panelLlenado.add(fondo);     
    
}       
    
private void setJPanelLlenado(Dimension dim){
    // el panel 
     panelLlenado = new JPanel();
     panelLlenado.setOpaque(false);
    
    panelLlenado.setLayout(null); 
    panelLlenado.setSize(dim);
   
    this.getContentPane().add(panelLlenado);
   panelLlenado.setBackground(Color.red);
      
    
}     
    
private void setJLabelLlenado( Dimension dim ){

       int pocix = (int) dim.getWidth()/2 ;   
      Font fuente = new Font("Times New Roman", 3 , 30); 
       Font fuente2 = new Font("Americana BT", 3 , 25); 
      
      
        lab1 = new  JLabel ("VISITANTE N° "+(i+1));
 
   lab1.setOpaque(true); //
   lab1.setHorizontalAlignment(SwingConstants.CENTER);//
   lab1.setBounds(((pocix)-125), 5, 250, 30); 
   lab1.setFont(fuente); 
   lab1.setForeground(Color.black);
   lab1.setBackground(Color.white); 
   lab1.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
    panelLlenado.add(lab1); 
    
    
   JLabel labName = new  JLabel ("NOMBRE");
   labName.setBounds(30, 100, 250, 30); 
   labName.setFont(fuente2);  
   panelLlenado.add(labName); 
    
   JLabel labLastName = new  JLabel ("APELLIDOS");
   labLastName.setBounds(30, 180, 250, 30); 
   labLastName.setFont(fuente2);  
   panelLlenado.add(labLastName); 
   
   
   JLabel labSex = new  JLabel ("SEXO");
   labSex.setBounds(30, 260, 250, 30); 
   labSex.setFont(fuente2);  
   panelLlenado.add(labSex);    
   
   
   JLabel labAge = new  JLabel ("EDAD");
   labAge.setBounds(30, 340, 250, 30); 
   labAge.setFont(fuente2);  
   panelLlenado.add(labAge);   
   
   JLabel labID = new  JLabel ("DOCUMENTO ID");
   labID.setBounds(30, 420, 250, 30); 
   labID.setFont(fuente2);  
   panelLlenado.add(labID);    
   
     
   
   JLabel labMember = new  JLabel ("CLIENTE CON MEMBRESIA");
   labMember.setBounds(30, 500, 350, 30); 
   labMember.setFont(fuente2);  
   panelLlenado.add(labMember);    
   
   
  
    ImageIcon imagen1 = new ImageIcon("parque_acuatico.jpeg");
    Image imagen1_1 = imagen1.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT );
    ImageIcon imagen1_2 = new ImageIcon(imagen1_1);

    JLabel lab2 = new  JLabel ();  
    lab2.setOpaque(false);
    lab2.setBounds(pocix,130, 400, 250);
    lab2.setBackground(Color.red); 
    lab2.setIcon(imagen1_2);
    lab2.setHorizontalAlignment(SwingConstants.CENTER);
    lab2.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
   panelLlenado.add(lab2);   
   
   

   
}    
  







   private void setJTextField( ){
    
      name = new JTextField();     
      name.setBounds(30,130, 250, 30);
      name.setText("digite nombre...");
      name.setFont(new Font("Times New Roman", 3 , 16));
      name.setForeground(Color.LIGHT_GRAY); 
      name.setEditable(true); //para permitir cambiar texto esmopcional
      
            MouseListener  escribir = new MouseListener() {
            @Override
             public void mouseClicked(MouseEvent e) { }// cuando se clikea dentro del boton o texto 
            @Override
            public void mousePressed(MouseEvent e) { 
            name.setForeground(Color.BLACK);// se pone el negro 
            if(click==0){ name.setText("");}// se quita el texto
             name.setFont(new Font("arial",Font.PLAIN , 16));
            click=1;
            } // solo presiona 
            @Override
            public void mouseReleased(MouseEvent e) { } // presionar y soltarfuera 
            @Override
            public void mouseEntered(MouseEvent e) {} // pasa la flecha por encima de boton u objeto
            @Override
            public void mouseExited(MouseEvent e) {} // cuando sale la flecha del boton 
        } ;   
      name.addMouseListener(escribir); // se crea evento de raton
   
      panelLlenado.add(name);
    
  
         Lastname = new JTextField();   
         MouseListener escribir1 = new MouseListener() {
            @Override
             public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) { 
             Lastname.setForeground(Color.BLACK);
            if(click1==0){ Lastname.setText("");}
             Lastname.setFont(new Font("arial", Font.PLAIN , 16));
            click1=1;
            }
            @Override
            public void mouseReleased(MouseEvent e) { } 
            @Override
            public void mouseEntered(MouseEvent e) {} 
            @Override
            public void mouseExited(MouseEvent e) {} 
        } ;   
         
      Lastname.setBounds(30,210, 250, 30);
      Lastname.setText("digite apellido...");
      Lastname.setFont(new Font("Times New Roman", 3 , 16));
      Lastname.setForeground(Color.LIGHT_GRAY); 
      Lastname.setEditable(true); 
      Lastname.addMouseListener(escribir1); 
      panelLlenado.add(Lastname);
       
       
    Age = new JTextField();   
         MouseListener escribir2 = new MouseListener() {
            @Override
             public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
             Age.setForeground(Color.BLACK);
            if(click2==0){ Age.setText("");}
             Age.setFont(new Font("arial", Font.PLAIN , 16));
            click2=1;    
            }
            @Override
            public void mouseReleased(MouseEvent e) { } 
            @Override
            public void mouseEntered(MouseEvent e) {} 
            @Override
            public void mouseExited(MouseEvent e) {} 
        } ;   
         
      Age.setBounds(30,370, 250, 30);
      Age.setText("digite edad...");
      Age.setFont(new Font("Times New Roman", 3 , 16));
      Age.setForeground(Color.LIGHT_GRAY); 
      Age.setEditable(true); 
      Age.addMouseListener(escribir2); 
      panelLlenado.add(Age);   
      
      
    ID = new JTextField();   
         MouseListener escribir3 = new MouseListener() {
            @Override
             public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { 
             ID.setForeground(Color.BLACK);
            if(click3==0){ ID.setText("");}
             ID.setFont(new Font("arial", Font.PLAIN , 16));
            click3=1;
            }
            @Override
            public void mouseReleased(MouseEvent e) { } 
            @Override
            public void mouseEntered(MouseEvent e) {} 
            @Override
            public void mouseExited(MouseEvent e) {} 
        } ;   
         
      ID.setBounds(30,450, 250, 30);
      ID.setText("digite numero de ID...");
      ID.setFont(new Font("Times New Roman", 3 , 16));
      ID.setForeground(Color.LIGHT_GRAY); 
      ID.setEditable(true); 
      ID.addMouseListener(escribir3); 
      panelLlenado.add(ID);       
      
      
   

   }

private void setRadiobotones( ){
    
   RbotonMen =new JRadioButton("HOMBRE", true);       
 RbotonMen.setBounds(30, 290 , 100, 30);    
RbotonMen.setEnabled(true); //define si se puede usar o no
RbotonMen.setOpaque(false);
panelLlenado.add(RbotonMen);
 
  RbotonWomen =new JRadioButton("MUJER", false);  
 RbotonWomen.setOpaque(false);
 RbotonWomen.setBounds(130, 290 , 70, 30);     
panelLlenado.add(RbotonWomen);

  RbotonOther =new JRadioButton("OTROS", false);
 RbotonOther.setOpaque(false);
 RbotonOther.setBounds(230, 290 , 70, 30);     
panelLlenado.add(RbotonOther);

 GrupoRBoton1 = new ButtonGroup();
GrupoRBoton1.add(RbotonMen);
GrupoRBoton1.add(RbotonWomen);
GrupoRBoton1.add(RbotonOther);     
    
    
    
    
   Rboton1 =new JRadioButton("SI", false);       
 Rboton1.setBounds(50, 530 , 50, 30);    
Rboton1.setEnabled(true); //define si se puede usar o no
Rboton1.setOpaque(false);
panelLlenado.add(Rboton1);
 
  Rboton2 =new JRadioButton("NO", true);  
 Rboton2.setOpaque(false);
 Rboton2.setBounds(200, 530 , 50, 30);     
panelLlenado.add(Rboton2);



ButtonGroup GrupoRBoton = new ButtonGroup();
GrupoRBoton.add(Rboton1);
GrupoRBoton.add(Rboton2);
  
}

private void setButtonLlenado( Dimension dim ){
    
   
        ActionListener ev = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            name1=name.getText();// pasa el nombre a la variable global
        String ID1 = ID.getText();
        String Lastname1 = Lastname.getText();
        String Age1 = Age.getText();

        if("si".equals(vali.valiDatoString(name1, click))  && "si".equals(vali.valiID(ID1, click3))  && "si".equals(vali.valiDatoString(Lastname1, click1))   && "si".equals(vali.valiAge(Age1, click2))) {  
         setDataVisitante();
        click=0 ; click1=0 ;click2=0 ; click3=0 ; 
        i++;
        
        //System.out.println(".."+ name.getText());
        Next() ;
       }else{
            
             if("no".equals(vali.valiID(ID1, click3)) || "no".equals(vali.valiDatoString(name1, click)) || "no".equals(vali.valiDatoString(Lastname1, click1))  || "no".equals(vali.valiAge(Age1, click2))){ // se pone en un solo condicional para que se imprima un solo mensaje
              setJOptionPanel(dim) ; 
             }else{
               if("no1".equals(vali.valiID(ID1, click3))){
             JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO ENTRE 8 Y 10 DÍGITOS", "AVISO", 3);    
            }
             if("no2".equals(vali.valiID(ID1, click3))){
              JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO", "AVISO", 3);
             } 
             
             if("no1".equals(vali.valiAge(Age1, click2))){
             JOptionPane.showMessageDialog(null, "LA EDAD DEBE SER UN NÚMERO ENTRE 1 y 100", "AVISO", 3);    
            }
             }
             
              
             if("no2".equals(vali.valiAge(Age1, click2))){
              JOptionPane.showMessageDialog(null, "LA CASILLA DE LA EDAD  DEBE SER UN NÚMERO", "AVISO", 3);
             } 
             
             
             
           
         }
   
            
        }
    };
    
    
    
     JButton NextButton =new JButton(); 
     NextButton.setSize(300, 50);
     NextButton.setLocation((dim.width/2)+50, 450);
     NextButton.setBackground(Color.darkGray);
     NextButton.setText("GUARDAR Y SIGUIENTE VISITANTE");
     NextButton.setFont(new Font("Times New Roman", 3 , 16));
     NextButton.setForeground(Color.WHITE);
     NextButton.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
     NextButton.setEnabled(true);// 
     NextButton.addActionListener(ev);
     panelLlenado.add(NextButton);    
    
     
     ActionListener clickeo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         name1=name.getText();
        String ID1 = ID.getText();
        String Lastname1 = Lastname.getText();
        String Age1 = Age.getText();
            if("si".equals(vali.valiDatoString(name1, click))  && "si".equals(vali.valiID(ID1, click3))  && "si".equals(vali.valiDatoString(Lastname1, click1))   && "si".equals(vali.valiAge(Age1, click2))) {  
                setDataVisitante();
                click=0 ; click1=0 ;click2=0 ; click3=0 ; 
                i++;
                Next() ;
                setVisible(false) ;
                Finalizado f = new Finalizado(met);
                f.setVisible(true) ;
        
            }else if("no".equals(vali.valiDatoString(name1, click))  && "no".equals(vali.valiID(ID1, click3))  && "no".equals(vali.valiDatoString(Lastname1, click1))   && "no".equals(vali.valiAge(Age1, click2))) {  
                setVisible(false) ;
                Finalizado f = new Finalizado(met);
                f.setVisible(true) ;
              
       }else{
            
             if("no".equals(vali.valiID(ID1, click3)) || "no".equals(vali.valiDatoString(name1, click)) || "no".equals(vali.valiDatoString(Lastname1, click1))  || "no".equals(vali.valiAge(Age1, click2))){ // se pone en un solo condicional para que se imprima un solo mensaje
              setJOptionPanel(dim) ; }else{
            if("no1".equals(vali.valiID(ID1, click3))){JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO ENTRE 8 Y 10 DÍGITOS", "AVISO", 3); }
            if("no2".equals(vali.valiID(ID1, click3))){JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO", "AVISO", 3);} 
            if("no1".equals(vali.valiAge(Age1, click2))){JOptionPane.showMessageDialog(null, "LA EDAD DEBE SER UN NÚMERO ENTRE 1 y 100", "AVISO", 3); }} 
            if("no2".equals(vali.valiAge(Age1, click2))){JOptionPane.showMessageDialog(null, "LA CASILLA DE LA EDAD  DEBE SER UN NÚMERO", "AVISO", 3);} 
         }    
              
            }
        } ;
     
     
     
     
     JButton FinishButton =new JButton(); 
     FinishButton.setSize(250, 50);
     FinishButton.setLocation((dim.width/2)+50, 520);
     FinishButton.setBackground(Color.darkGray);
     FinishButton.setText("GUARDAR Y FINALIZAR");
     FinishButton.setFont(new Font("Times New Roman", 3 , 16));
     FinishButton.setForeground(Color.WHITE);
     FinishButton.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
     FinishButton.setEnabled(true);// 
     FinishButton.addActionListener(clickeo);
     panelLlenado.add(FinishButton);      
     
     
   
    
        ActionListener salir1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
    
        exit() ;
        
     

     
        }

    }; 
     
         ImageIcon imagen = new ImageIcon("salir2.png") ;  
      ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING )) ; 
     JButton ExitButton =new JButton();
     
     MouseListener pass = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { } // solo presiona 
        @Override
        public void mouseReleased(MouseEvent e) { } // presionar y soltarfuera 
        @Override
        public void mouseEntered(MouseEvent e) {  ExitButton.setOpaque(true);} // pasa la flecha por encima de boton u objeto
        @Override
        public void mouseExited(MouseEvent e) {ExitButton.setOpaque(false);} // cuando sale la flecha del boton 
    }  ;  
    ExitButton.setBounds(dimPantalla.width-150, dimPantalla.height-200  , 100, 100);
    ExitButton.setIcon(imagen2);
    ExitButton.setOpaque(false);
    ExitButton.setHorizontalAlignment(SwingConstants.CENTER);
    ExitButton.setBackground(Color.white);
    ExitButton.setEnabled(true) ;
    ExitButton.addMouseListener(pass);
    ExitButton.addActionListener(salir1); 
    ExitButton.setBorder(null); 
    panelLlenado.add(ExitButton);   
     
     
     
   ImageIcon imagen_atras = new ImageIcon("atrás.png");   
  Image imagen1 = imagen_atras.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING );
   ImageIcon ImAtras = new ImageIcon(imagen1); 
   
    ActionListener ClickBot1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       setVisible(false); // cierra la ventana 2
      
     new Inicio().setVisible(true); // abre la 1
        }
    }; 
   
  JButton BachButton = new  JButton (ImAtras);  
  BachButton.setOpaque(false);
  BachButton.setBounds(30, dimPantalla.height-200 , 100, 100);  
  BachButton.setHorizontalAlignment(SwingConstants.CENTER);
  BachButton.setBackground(null);
  BachButton.setBorder(null);
  BachButton.setEnabled(true);
  BachButton.addActionListener(ClickBot1);
   panelLlenado.add(BachButton);     
     
}


private void exit(){
    
    this.getDefaultCloseOperation()  ;
    this.dispose();
    System.exit(0);
}    



private void Next(){    
   lab1.setText("VISITANTE N° "+(i+1));

      name.setText("digite nombre...");
      name.setFont(new Font("Times New Roman", 3 , 16));
      name.setForeground(Color.LIGHT_GRAY);  
 
      Lastname.setText("digite apellido...");
      Lastname.setFont(new Font("Times New Roman", 3 , 16));
      Lastname.setForeground(Color.LIGHT_GRAY); 
    
      Age.setText("digite edad...");
      Age.setFont(new Font("Times New Roman", 3 , 16));
      Age.setForeground(Color.LIGHT_GRAY);      
      
      
      ID.setText("digite numero de ID...");
      ID.setFont(new Font("Times New Roman", 3 , 16));
      ID.setForeground(Color.LIGHT_GRAY);     
           
    RbotonMen.setSelected(true);
    Rboton2.setSelected(true);
    
}


private void setJOptionPanel(Dimension dim){JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS DATOS", "AVISO", 1);} // EL 1 ES EL SIMBOLO !

private void setDataVisitante(){
     
  
    
    
  int age1 = Integer.parseInt(Age.getText()) ;    
 int ID1 = Integer.parseInt(ID.getText()); 
 
 ID1++;
 
 String sexo  ; 
    if (RbotonOther.isSelected()) {
            sexo=RbotonOther.getText();
        } else if (RbotonMen.isSelected()) {
            sexo=RbotonMen.getText();
        } else   {
            sexo=RbotonWomen.getText();
        }
   
    

boolean member=false  ;  
  if (Rboton1.isSelected()) {
            member=true;
        } else if (RbotonMen.isSelected()) {
            sexo=RbotonMen.getText();
        } else   {
           member=false;
        }
 
  //  System.out.println("member.... " + member );
 String name2=name.getText();// pasa el nombre a la variable global
 
 String Lastname1 = Lastname.getText(); 
 
 
 String member2 ;
  if (this.Rboton1.isSelected()) {
            member2="si" ;
        
        } else   {
         member2="no" ;
        }
  
   String Id = ID.getText() ;
    String age = Age.getText() ;
  DAO DatteBase = new DAO();
    DatteBase.registrarpersonas(getNewID(), Lastname1,age ,Id, name2, member2, sexo);
  
 Visitante persona =new  Visitante(name2 ,Lastname1 , sexo ,age1 , getNewID(), member,  ID1 );
  
  met.addToList(persona);
  //met.Listar();
}

private int getNewID(){
   
int id_definitiva= (fecha*1000);  
 
return id_definitiva;
}
        

}
