
package ventanas;

import DatosVisitantes.Metodos;
import static DatosVisitantes.Metodos.list;
import DatosVisitantes.Visitante;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import pool.Validacion;

/**
 *
 * @author JUNIOR SILVA
 */
public class Finalizado extends JFrame{
 JPanel panel2;
JPanel panelFinalizado;
private JRadioButton RbotonBuscarID;
private JRadioButton RbotonBuscarNombre;
private JButton buscarButton;
private JButton ButtonListar;
private JButton graficButton;
private JTextArea areaInfo;
private JTextField ventanaBus;
Validacion vali = new Validacion();
int click = 0;
Font fuente = new Font("Times New Roman", 3 , 16);
Dimension dimPantalla = new Dimension(Toolkit.getDefaultToolkit().getScreenSize()) ;

    Metodos metod ;
    public Finalizado( Metodos met) { // para que use el mismo arrayList pasa el objeto como parametro
       metod = met;   
 //Dimension MINIM_DIM = new Dimension(1000,800);   
   //   this.setUndecorated(true); // quita el borde de la ventana
      this.setSize(dimPantalla);
      this.setTitle("EL POOL");       
      this.setLocationRelativeTo(null);
      this.setMinimumSize(dimPantalla);
      this.setMinimumSize( dimPantalla);
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
     // this.setResizable(false); 
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
  
   ImageIcon icono = new ImageIcon("gota_agua.png") ;
  Image icono1 = icono.getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);        
setIconImage(icono1);        
        
  iniciarcomponentesFinalizado(dimPantalla) ;     
        
     metod.Listar();
    }
    
    
    
    
    
  private void iniciarcomponentesFinalizado( Dimension dim){
  setJPanelFinalizado(dim);    
  setJLabelFinalizado(dim); 

  setButtonFinalizado(dim);
  setRButton();
  setTextArea();
  setJTextField();

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
  panelFinalizado.add(fondo);     
    
}

private void setJPanelFinalizado(Dimension dim){
       
    // el panel 
     panelFinalizado = new JPanel();
     panelFinalizado.setOpaque(true);
    
    panelFinalizado.setLayout(null); 
    panelFinalizado.setSize(dim);
   
    this.getContentPane().add(panelFinalizado);
   panelFinalizado.setBackground(Color.red);
    
   

   
}  

  
 private void setJLabelFinalizado( Dimension dim ){
     
        int pocix = (int) dim.getWidth()/2 ;   
      Font fuente = new Font("Times New Roman", 3 , 30); 
       Font fuente1 = new Font("Pencil", 3 , 16); 
       
     
     
     
      JLabel   TITLE = new  JLabel ("DIA FINALIZADO");
 
   TITLE.setOpaque(true); //
   TITLE.setHorizontalAlignment(SwingConstants.CENTER);//
   TITLE.setBounds(((pocix)-125), 5, 250, 30); 
   TITLE.setFont(fuente); 
   TITLE.setForeground(Color.black);
   TITLE.setBackground(Color.white); 
   TITLE.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
    panelFinalizado.add(TITLE);   
    
    
    
  JLabel   recaudo = new  JLabel ("EL RECAUDO ESTIMADO DEL DÍA ES:  " + metod.getTotal());
  recaudo.setOpaque(true); //
   recaudo.setHorizontalAlignment(SwingConstants.LEFT);//
   recaudo.setBounds(10, 60, 400, 30); 
   recaudo.setFont(fuente1); 
   recaudo.setForeground(Color.white);
   recaudo.setBackground(Color.DARK_GRAY); 
   recaudo.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
    panelFinalizado.add(recaudo);  
    
   JLabel   visitas = new  JLabel ("LAS VISITAS TOTAL ESTIMADA DEL DÍA SON :  " + metod.list.size());
  visitas.setOpaque(true); //
   visitas.setHorizontalAlignment(SwingConstants.LEFT);//
   visitas.setBounds(10, 90, 400, 30); 
   visitas.setFont(fuente1); 
   visitas.setForeground(Color.white);
   visitas.setBackground(Color.DARK_GRAY); 
   visitas.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
    panelFinalizado.add(visitas);     
    
    
    
      
 }
 
private void setButtonFinalizado( Dimension dim ){
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
    CasaButton.setBounds((dimPantalla.width/2)-50, dimPantalla.height-200 , 100, 100);
    CasaButton.setIcon(imagenCasa2);
    CasaButton.setOpaque(false);
    CasaButton.setHorizontalAlignment(SwingConstants.CENTER);
    CasaButton.setBackground(Color.white);
    CasaButton.setEnabled(true) ;
    CasaButton.addMouseListener(pass2);
    CasaButton.addActionListener(casa); 
    CasaButton.setBorder(null); 
    panelFinalizado.add(CasaButton);
    ImageIcon imagen = new ImageIcon("salir2.png") ;  
    ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING )) ; 
    ActionListener salir = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // se le agrega el evento en este caso cerrar ventana
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            System.exit(0);
        }
    };  
        
        JButton FinishButton =new JButton(); 
       MouseListener pass = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { } // solo presiona 
        @Override
        public void mouseReleased(MouseEvent e) { } // presionar y soltarfuera 
        @Override
        public void mouseEntered(MouseEvent e) {  FinishButton.setOpaque(true);} // pasa la flecha por encima de boton u objeto
        @Override
        public void mouseExited(MouseEvent e) {FinishButton.setOpaque(false);} // cuando sale la flecha del boton 
    }  ; 
    
       
    FinishButton.setBounds(30,  dimPantalla.height-200 , 100, 100);
    FinishButton.setIcon(imagen2);
    FinishButton.setOpaque(false);
    FinishButton.setHorizontalAlignment(SwingConstants.CENTER);
    FinishButton.setBackground(Color.white);
    FinishButton.setEnabled(true) ;
    FinishButton.addMouseListener(pass);
    FinishButton.addActionListener(salir); 
    FinishButton.setBorder(null); 
    panelFinalizado.add(FinishButton);     
   
    ActionListener buscar = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Visitante persona;
        boolean stand;
        
        if(RbotonBuscarID.isSelected()){
            if("si".equals(vali.valiID(ventanaBus.getText(), click))){
                int id = Integer.parseInt(ventanaBus.getText());
                stand = metod.existe(id);
                if(stand == true){
                    persona = metod.buscarID(ventanaBus.getText());
                    ImprimirIdBuscado(persona);
                }else{
                    JOptionPane.showMessageDialog(null, "PERSONA NO ENCONTRADA", "AVISO", 3); 
                }
            }else{
                if("no".equals(vali.valiID(ventanaBus.getText(), click))){
                    JOptionPane.showMessageDialog(null, "DIGITE UNA ID", "AVISO", 3);
                }
                if("no1".equals(vali.valiID(ventanaBus.getText(), click))){
                    JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO ENTRE 8 Y 10 DÍGITOS", "AVISO", 3); 
                }
                if("no2".equals(vali.valiID(ventanaBus.getText(), click))){JOptionPane.showMessageDialog(null, "LA CASILLA del ID DEBE SER UN NÚMERO", "AVISO", 3);} 
            }
        }else{
            if("si".equals(vali.valiDatoString(ventanaBus.getText(), click))){
                stand = metod.existeName(ventanaBus.getText());
                if(stand == true){
                    persona = metod.buscarName(ventanaBus.getText());
                    ImprimirIdBuscado(persona);
                }else{
                    JOptionPane.showMessageDialog(null, "PERSONA NO ENCONTRADA", "AVISO", 3);
                }
            }else{
                JOptionPane.showMessageDialog(null, "LA CASILLA DEBE SER UN TEXTO", "AVISO", 3);
            }
        }
    }
    };
        
    
 buscarButton =new JButton();
    buscarButton.setSize(280, 50);
    buscarButton.setLocation(50, 380);
    buscarButton.setBackground(Color.darkGray);
    buscarButton.setText("Buscar");
    buscarButton.setFont(new Font("Times New Roman", 3 , 16));
    buscarButton.setForeground(Color.WHITE);
    buscarButton.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
    buscarButton.setEnabled(true);
    buscarButton.addActionListener(buscar);
    panelFinalizado.add(buscarButton);  
    
   ActionListener list = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ImprimirLista();
    }   
    };
   ButtonListar =new JButton();
    ButtonListar.setSize(280, 50);
    ButtonListar.setLocation(50,280);
    ButtonListar.setBackground(Color.darkGray);
    ButtonListar.setText("Listar");
    ButtonListar.setFont(new Font("Times New Roman", 3 , 16));
    ButtonListar.setForeground(Color.WHITE);
    ButtonListar.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
    ButtonListar.setEnabled(true);
    ButtonListar.addActionListener(list);
    panelFinalizado.add(ButtonListar);     
    
    
     ActionListener graf = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (metod.list.isEmpty()){
           JOptionPane.showMessageDialog(null, "no hay datos para mostrar", "AVISO", 3);      
        }else{
           grafica g = new grafica(metod);
       g.setVisible(true);   
        }
            
     
    }   
    };

    
    
   graficButton =new JButton();
    graficButton.setSize(280, 50);
    graficButton.setLocation(50, 480);
    graficButton.setBackground(Color.darkGray);
    graficButton.setText("mostrar grafica");
    graficButton.setFont(new Font("Times New Roman", 3 , 16));
    graficButton.setForeground(Color.WHITE);
    graficButton.setBorder(BorderFactory.createLineBorder(Color.white, 4, false));
    graficButton.setEnabled(true);
    graficButton.addActionListener(graf);
    panelFinalizado.add(graficButton); 
    
 }

private void setRButton(){
    RbotonBuscarID =new JRadioButton("Por Id", true);  
    RbotonBuscarID.setFont(new Font("Times New Roman", 3 , 16));
    RbotonBuscarID.setBounds(50, 430 , 150, 30);    
    RbotonBuscarID.setEnabled(true); //define si se puede usar o no
    RbotonBuscarID.setOpaque(false);
    panelFinalizado.add(RbotonBuscarID);
 
    RbotonBuscarNombre =new JRadioButton("Por Nombre", false);  
    RbotonBuscarNombre.setFont(new Font("Times New Roman", 3 , 16));
    RbotonBuscarNombre.setOpaque(false);
    RbotonBuscarNombre.setBounds(200, 430 , 150, 30);     
    panelFinalizado.add(RbotonBuscarNombre);

    

    


    

    ButtonGroup GrupoRBoton = new ButtonGroup();
    GrupoRBoton.add(RbotonBuscarID);
    GrupoRBoton.add(RbotonBuscarNombre);
} 

public void setJTextField(){
    ventanaBus = new JTextField();
    ventanaBus.setSize(150, 30);
    ventanaBus.setLocation(50, 340);
    ventanaBus.setText("Dato a Buscar");
    ventanaBus.setForeground(Color.GRAY);
    MouseListener escribir1 = new MouseListener() {
        @Override
         public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) { 
         ventanaBus.setForeground(Color.BLACK);
        if(click==0){ ventanaBus.setText("");}
         ventanaBus.setFont(new Font("arial", Font.PLAIN , 16));
        click=1;
        }
        @Override
        public void mouseReleased(MouseEvent e) { } 
        @Override
        public void mouseEntered(MouseEvent e) {} 
        @Override
        public void mouseExited(MouseEvent e) {} 
    };
    ventanaBus.addMouseListener(escribir1);
    
    panelFinalizado.add(ventanaBus);
}

public void setTextArea(){
    areaInfo = new JTextArea();
    areaInfo.setSize(400,600);
    areaInfo.setLocation(dimPantalla.width-450, 100);
    areaInfo.setOpaque(true);
    areaInfo.setEditable(false);
    areaInfo.setFont(fuente);
    panelFinalizado.add(areaInfo);
}

public void ImprimirIdBuscado(Visitante persona){
    String cadena = " ID: "+persona.getID()+"\n Nombre: "+persona.getName()+"\n Apellido: "+persona.getLastname()+"\n Edad: "+persona.getAge()+"\n Sexo: "+persona.getSexo();
    areaInfo.setText(cadena);
}

public void ImprimirLista(){
    
 for (int i = 0; i < list.size(); i++) {
            Visitante persona = list.get(i);
                    
     String cadena = "\n    VISITANTE NUMERO: "+(i+1)+"\n ID: "+persona.getID()+"\n Nombre: "+persona.getName()+"\n Apellido: "+persona.getLastname()+"\n Edad: "+persona.getAge()+"\n Sexo: "+persona.getSexo();
    areaInfo.append(cadena);
}
}


}
