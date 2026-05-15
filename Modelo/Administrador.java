package Modelo;
public class Administrador extends Persona{
      public Administrador() {
    }

    public Administrador(String ID_admin, String nombre_admin, int num_admin, int antiguedad_admin, String contraseña_admin) {
        this.ID_admin = ID_admin;
        this.nombre_admin = nombre_admin;
        this.num_admin = num_admin;
        this.antiguedad_admin = antiguedad_admin;
        this.contraseña_admin = contraseña_admin;
    }
    
    private String ID_admin;
    private String nombre_admin;
    private int num_admin;
    private int antiguedad_admin;
    private String contraseña_admin;

    public String getID_admin() {
        return ID_admin;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public int getNum_admin() {
        return num_admin;
    }

    public int getAntiguedad_admin() {
        return antiguedad_admin;
    }

    public String getContraseña_admin() {
        return contraseña_admin;
    }

    public void setID_admin(String ID_admin) {
        this.ID_admin = ID_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public void setNum_admin(int num_admin) {
        this.num_admin = num_admin;
    }

    public void setAntiguedad_admin(int antiguedad_admin) {
        this.antiguedad_admin = antiguedad_admin;
    }

    public void setContraseña_admin(String contraseña_admin) {
        this.contraseña_admin = contraseña_admin;
    }
   
}
