
package DatosVisitantes;

/**
 *
 * @author JUNIOR SILVA
 */
public class Visitante {
  
private String name ;
private String lastname ;
private String sexo ;
private int age ;    
private int Codigo ; 
private boolean member ;
private int ID ; 

    public Visitante(String name, String lastname, String sexo, int age, int Codigo, boolean member , int ID) {
        this.name = name;
        this.lastname = lastname;
        this.sexo = sexo;
        this.age = age;
        this.Codigo = Codigo;
        this.member = member;
        this.ID =  ID; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public int getNumeroVisitante() {
        return Codigo;
    }

    public void seCodigo(int Codigo) {
        this.Codigo = Codigo;
    }
 





}
