package Modelo;

import java.util.ArrayList;

public class Carrito {
    private int idcompra;
    private int cantidad;
    private int total;
    private ArrayList<Producto> productos;

    //CONSTRUCTOR SIN PARAMETRO 
    public Carrito() {
    }
    
    //CONSTRUCTOR CON PARAMETRO 
    public Carrito(int idcompra, int cantidad, int total,ArrayList<Producto> productos ) {
        this.idcompra = idcompra;
        this.cantidad = cantidad;
        this.total = total;
        this.productos = productos;
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

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    
    
}
