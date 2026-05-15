package Modelo;
public class Usuario extends Persona{
    private String ID_us;
    private String email_us;
    private String cont_us;
    private String contUs;
    private Carrito carrito;

     public Usuario() {
    }

    public Usuario(String ID_us, String email_us, String cont_us, String contUs, Carrito carrito) {
        this.ID_us = ID_us;
        this.email_us = email_us;
        this.cont_us = cont_us;
        this.contUs = contUs;
        this.carrito = carrito;
    }

    public String getID_us() {
        return ID_us;
    }

    public void setID_us(String ID_us) {
        this.ID_us = ID_us;
    }

    public String getEmail_us() {
        return email_us;
    }

    public void setEmail_us(String email_us) {
        this.email_us = email_us;
    }

    public String getCont_us() {
        return cont_us;
    }

    public void setCont_us(String cont_us) {
        this.cont_us = cont_us;
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
