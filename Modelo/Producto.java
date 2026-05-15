package Modelo;
public class Producto {
    private int idcompra;
    private int cantidad;
    private int total;

    //CONSTRUCTOR SIN PARAMETRO 
    public Producto() {
    }
//CONSTRUCTOR CON PARAMETRO 
    public Producto(int idcompra, int cantidad, int total) {
        this.idcompra = idcompra;
        this.cantidad = cantidad;
        this.total = total;
    }

    //GET Y SET DEL ID DE LA COMPRA
    public int getIdcompra() {
        return idcompra;
    }
    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    //GET Y SET DE LA CANTIDAD
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //GET Y SET DEL TOTAL
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}

