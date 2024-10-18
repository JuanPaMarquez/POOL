
package pool;



/**
 *
 * @author JUNIOR SILVA
 */
public class Validacion {
 
    
public String  valiDatoString(String Dato, int click){
    
    if( click==0 ) {

        return "no";
    }
    if (Dato.isEmpty()){  ////SUPER OJO EL "" Y EL NULL SON DIFERENTES
        return "no";
    } else{  
        return "si";
    }
}

public String valiMem(String dato){
    
    if (dato.equalsIgnoreCase("si")) {
        return "si";
    }
    
    if (dato.equalsIgnoreCase("no")) {
        return "si";
    }
    return "no";
}

public String valiSexo(String dato){
    
    if(dato.equalsIgnoreCase("m")){
        return "si";
    }
    if (dato.equalsIgnoreCase("f")) {
        return "si";
    }
    if (dato.equalsIgnoreCase("o")) {
        return "si";
    }
    return "no";
}
        
public String  valiID(String Dato, int click){
   long n ; 
if( click==0 ) {
    
    return "no";
}
    if ( Dato.equals("")){
        ////SUPER OJO EL "" Y EL NULL SON DIFERENTES
       
      return "no";
} else{  
     
      boolean isNumeric = true;
              
       for (int i = 0; i < Dato.length(); i++) {
            if (!Character.isDigit(Dato.charAt(i))) {
                isNumeric = false;
            }
        }         
              
              
       if(isNumeric){
            n = Long.parseLong(Dato) ;
         //  System.out.println("n.."+ n);
             
              if(n>9999999 && n<= 1999999999){
                  return "si";  
              }else{
                  return "no1";   
              }
              
       } else{
       
              return "no2";  
       }
   
}  

}    
    
 public String  valiAge(String Dato, int click){
   int n ; 
if( click==0 ) {
    
    return "no";
}
    if (Dato.isEmpty()){
        ////SUPER OJO EL "" Y EL NULL SON DIFERENTES
       
      return "no";
} else{  
     
        boolean isNumeric = true;
              
       for (int i = 0; i < Dato.length(); i++) {
            if (!Character.isDigit(Dato.charAt(i))) {
                isNumeric = false;
            }
        }    
       if(isNumeric){
           //  System.out.println("n.."+ Dato);
            n = Integer.parseInt(Dato) ;
         
             
              if(n>0 && n<=120){
                  return "si";  
              }else{
                  return "no1";   
              }
              
       } else{
       
              return "no2";  
       }
   
}  

}    
    
    
    
}
