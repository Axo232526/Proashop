package Modelo;
public class Administrador extends Persona{
   
    private String idAdmin;
    private String nombreAdmin;
    private int numAdmin;
    private int antiguedadAdmin;
    private String contraseniaAdmin;
    private String usuario;

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public int getNumAdmin() {
        return numAdmin;
    }

    public void setNumAdmin(int numAdmin) {
        this.numAdmin = numAdmin;
    }

    public int getAntiguedadAdmin() {
        return antiguedadAdmin;
    }

    public void setAntiguedadAdmin(int antiguedadAdmin) {
        this.antiguedadAdmin = antiguedadAdmin;
    }

    public String getContraseniaAdmin() {
        return contraseniaAdmin;
    }

    public void setContraseniaAdmin(String contraseniaAdmin) {
        this.contraseniaAdmin = contraseniaAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
//CONSTRUCTOR SIN PARAMETRO
 public Administrador() {
    }


    public Administrador(String idAdmin, String nombreAdmin, int numAdmin, int antiguedadAdmin,String usuario, String contraseniaAdmin, int IDPersona, String Nombre, String Apellido, int DNI, int Telefono, String Direccion, String Localidad, String Provincia) {
        super(IDPersona, Nombre, Apellido, DNI, Telefono, Direccion, Localidad, Provincia);
        this.idAdmin = idAdmin;
        this.nombreAdmin = nombreAdmin;
        this.numAdmin = numAdmin;
        this.antiguedadAdmin = antiguedadAdmin;
        this.contraseniaAdmin = contraseniaAdmin;
        this.usuario = usuario;
    }

}


