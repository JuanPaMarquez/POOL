
package ventanas;

import DatosVisitantes.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class grafica extends JFrame{
    JPanel panel;
    JPanel panel2;
    Metodos met;
    public grafica(Metodos metod){
        met=metod;
         Dimension MINIM_DIM = new Dimension(800,600);  
        setTitle("Como Hacer Graficos con Java");
        setSize(MINIM_DIM);
        setLocationRelativeTo(null);
       this.setMinimumSize(MINIM_DIM);
      this.setMinimumSize( MINIM_DIM);
      this.setResizable(false); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
           ImageIcon icono = new ImageIcon("gota_agua.png") ;
  Image icono1 = icono.getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);        
setIconImage(icono1); 

         iniciarComponentesGrafica(MINIM_DIM);
    }

      private void iniciarComponentesGrafica(Dimension dim) {
          
        paneles();   
        setJButtonGrafica(dim) ;
         colocarfondo( dim);
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
  panel.add(fondo);     
    
}
    private void paneles() {
       
        panel = new JPanel();
       
       // panel.setBackground(Color.red);
      
         getContentPane().add(panel);
       int value1 =met.getConMembresia();
         int value2 =met.getSinMembresia();
         int total = value1+value2 ;
        
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
   data.setValue("Con Membresia " + (value1*100)/total+" %", value1);
   data.setValue("sin Membresia "  + (value2*100)/total+"%", value2);

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "DATOS DE LO MIEMBROS", 
         data, 
         false, 
         true, 
         true);
        chart.setBackgroundPaint(Color.WHITE);
       chart.setBorderVisible(false);
       ImageIcon back = new ImageIcon("fondo_mar.jpg") ;
       Image Back = back.getImage();
       chart.setBackgroundImage(Back);
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        
        Dimension maximumSize = new Dimension(400,250);  
        
        chartPanel.setMaximumSize(maximumSize);
        chartPanel.setOpaque(false);
        panel.add(chartPanel);
        
           
    }
    

     private void setJButtonGrafica( Dimension dim ){
    
    
    
    ImageIcon imagen = new ImageIcon("salir2.png") ;  
    ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(100, 100,Image.SCALE_AREA_AVERAGING )) ; 
    ActionListener salir = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose(); // se le agrega el evento en este caso cerrar ventana
           
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
    
       
    FinishButton.setBounds(0, 500 , 100, 100);
    FinishButton.setIcon(imagen2);
    FinishButton.setOpaque(false);
   // FinishButton.setHorizontalAlignment(SwingConstants.CENTER);
    FinishButton.setBackground(Color.white);
    FinishButton.setEnabled(true) ;
    FinishButton.addMouseListener(pass);
    FinishButton.addActionListener(salir); 
    FinishButton.setBorder(null); 
    panel.add(FinishButton);     
     
       
       
       
   }
    
}
