package modelo;
public class Usuario extends Persona {
    
    //en usuario un atributo q sea carrito
    private int idUs;
    private String emailUs;
    private String contUs;
    private Carrito carrito;
    
    //CONSTRUCTOR SIN PARAMETRO
    public Usuario() {
    }
    //CONSTRUCTOR CON PARAMETRO
    public Usuario(int idUs, String emailUs, String contUs, Carrito carrito) {
        this.idUs = idUs;
        this.emailUs = emailUs;
        this.contUs = contUs;
        this.carrito = carrito;
    }

    //GET
    public int getIdUs() {
        return idUs;
    }
      public String getEmailUs() {
        return emailUs;
    }
    public String getContUs() {
        return contUs;
    }
    public Carrito getCarrito() {
        return carrito;
    }
    
    //SET
    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }
 public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }
public void setContUs(String contUs) {
        this.contUs = contUs;
    }
public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
