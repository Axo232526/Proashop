package Modelo;
public class Usuario extends Persona{
    private String idUs;
    private String emailUs;
    private String contUs;
    private Carrito carrito;

     public Usuario() {
    }

    public Usuario(String idUs, String emailUs, String contUs, Carrito carrito) {
        this.idUs = idUs;
        this.emailUs = emailUs;
        this.contUs = contUs;
        this.carrito = carrito;
    }

    public Usuario(String ID_us, String email_us, String cont_us, Carrito carrito, int IDPersona, String Nombre, String Apellido, int DNI, int Telefono, String Direccion, String Localidad, String Provincia) {
        super(IDPersona, Nombre, Apellido, DNI, Telefono, Direccion, Localidad, Provincia);
        this.idUs = idUs;
        this.emailUs = emailUs;
        this.contUs = contUs;
        this.carrito = carrito;
    }

    public String getIdUs() {
        return idUs;
    }
    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }

    public String getEmailUs() {
        return emailUs;
    }
    public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }

    public String getContUs() {
        return contUs;
    }
    public void setContUs(String contUs) {
        this.contUs = contUs;
    }

    public Carrito getCarrito() {
        return carrito;
    }
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
     
}
