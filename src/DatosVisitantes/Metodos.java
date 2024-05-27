
package DatosVisitantes;

import java.util.ArrayList;

public class Metodos {
    
public static ArrayList<Visitante> list = new ArrayList();    
    
 
    public void addToList(Visitante datosPersona) {
        list.add(datosPersona);
    }
    
    
    public Visitante buscarName(String name){
        boolean existe = existeName(name);
        
        if (existe == true){
            int posi = getPosicionName(name);
            Visitante persona = list.get(posi);
            return persona;
        }else{
            return null;
        }    
    }
    
    public Visitante buscarID(String Id){
        int ID = Integer.parseInt(Id);
        
        boolean existe = existe(ID);
        
        if (existe == true){
            int posi = getPosicion(ID);
            Visitante persona = list.get(posi);
            return persona;
        }else{
            return null;
        }    
    }
    
    
    //Metodo: Total de ganancias
    public double getTotal(){
        double total = 0;
        double total1 = 0;
        double total2 = 0;
        int cont1 = 0;
        int cont2 = 0;
        
        for (int i = 0; i < list.size(); i++) {
            Visitante productoEnlaLista = list.get(i);
            if(productoEnlaLista.isMember()){
                cont1++;                
            }else{
                cont2++;
            }
        }
        
        total1 = cont1 * 5000;
        total2 = cont2 * 12000;
        
        total = total1 + total2;
        
        return total;
    }

    public void Listar() {
        for (int i = 0; i < list.size(); i++) {
            Visitante productoEnlaLista = list.get(i);
            System.out.println("Nombre: " + productoEnlaLista.getName());
            System.out.println("APELLIDO :" + productoEnlaLista.getLastname());
            System.out.println("EDAD :" + productoEnlaLista.getAge());
            System.out.println("SEXO :" + productoEnlaLista.getSexo());
            System.out.println("ID :" + productoEnlaLista.getID()); 
            String mem ; if(productoEnlaLista.isMember()){mem="si";}else{mem="no"; }
            System.out.println("MIEMBRO : " + mem);
            System.out.println("NUMERO DE VISITANTE :" + (productoEnlaLista.getNumeroVisitante()+1)); 
            
            
        }
    }
    
    public boolean existe(int id) {
        boolean existe = false;
        for (int i = 0; i < list.size(); i++) {
            Visitante visitaListada = list.get(i);
            if (visitaListada.getID() == id) {
                existe = true;
                break;
            }
        }
        return existe;
    }  
    
    public boolean existeName(String name) {
        boolean existe = false;
        
        for (int i = 0; i < list.size(); i++) {
            Visitante visitaListada = list.get(i);
            if (visitaListada.getName().equals(name)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    public int getPosicionName(String name) {
        int posicion = 0;
        for (int i = 0; i < list.size(); i++) {
            Visitante visitaListada = list.get(i);
            if (visitaListada.getName().equals(name)) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    
    public int getPosicion(int id) {
        int posicion = 0;
        for (int i = 0; i < list.size(); i++) {
            Visitante visitaListada = list.get(i);
            if (visitaListada.getID() == id) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

       public int getConMembresia() { 
         int count=0;
         for (int i = 0; i < list.size(); i++) {
            Visitante visitaListada = list.get(i);
            if (visitaListada.isMember()) {
                 count++;
                
            }
        }
         
         
           return count;
       }
       public int getSinMembresia() { 
         int count=0;
         
          for (int i = 0; i < list.size(); i++) {
            Visitante visitaListada = list.get(i);
            if (visitaListada.isMember()) {     
            }else{
              count++;  
            } 
       }
        return count;
       }
       
       
}
