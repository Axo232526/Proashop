package Modelo;

public class Persona {
    private int IDPersona;
    private String Nombre;
    private String Apellido;
    private int DNI;
    private int Telefono;
    private String Direccion;
    private String Localidad;
    private String Provincia;

    //getter y setters
    public int getIDPersona() {
        return IDPersona;
    }
    public void setIDPersona(int IDPersona) {
        this.IDPersona = IDPersona;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public int getDNI() {
        return DNI;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    public int getTelefono() {
        return Telefono;
    }
    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    public String getDirecciion() {
        return Direccion;
    }
    public void setDirecciion(String Direccion) {
        this.Direccion = Direccion;
    }
    public String getLocalidad() {
        return Localidad;
    }
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }
    public String getProvincia() {
        return Provincia;
    }
    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }
    
    
    //constructor sin parametro
    public Persona() {
    }

    
    //Constructor con parametro
    public Persona(int IDPersona, String Nombre, String Apellido, int DNI, int Telefono, String Direccion, String Localidad, String Provincia) {
        this.IDPersona = IDPersona;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Localidad = Localidad;
        this.Provincia = Provincia;
    }
}
