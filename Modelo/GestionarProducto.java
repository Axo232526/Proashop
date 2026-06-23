/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vigli
 */
public class GestionarProducto {
   
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarProducto() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
    public boolean insertarProducto(Producto p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO producto (stock,nombre,precio,descripcion,foto) VALUES (?,?,?,?,?)");
            ps.setInt(1, p.getStock());
            ps.setString(2, p.getNombre());
             ps.setInt(3, p.getPrecio()); 
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getFoto());         
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
                 System.out.println(e2);
            }
        }    
        return respuesta;
    }
    
   public ArrayList<Producto> BuscarProducto() {

    ArrayList<Producto> p = new ArrayList<>();

    try {

        cn = c.conectar();
        ps = cn.prepareStatement("SELECT * FROM producto");
        rs = ps.executeQuery();

        while (rs.next()) {

            Producto p1 = new Producto();

            p1.setIdproducto(rs.getInt("id_producto"));
            p1.setStock(rs.getInt("stock"));
            p1.setNombre(rs.getString("nombre"));
            p1.setPrecio(rs.getInt("precio"));
            p1.setDescripcion(rs.getString("descripcion"));
            p1.setFoto(rs.getString("foto"));

            p.add(p1);
        }

    } catch (SQLException e) {
        System.out.println(e);
    } finally {

        try {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
            if (rs != null) rs.close();
        } catch (SQLException e2) {
        }

    }

    return p;
}
    public boolean modificarProducto(Producto p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE producto SET stock=?,nombre=?,precio=?,descripcion=?,foto=? WHERE id_producto=?");
            ps.setInt(1, p.getStock());
            ps.setString(2, p.getNombre());
             ps.setInt(3, p.getPrecio()); 
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getFoto());
             ps.setInt(6, p.getIdproducto());  
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            System.out.println(e2);}
        }    
        return respuesta;
    }
    
    public boolean eliminarProducto(int idproducto){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM producto WHERE id_producto=?");           
            ps.setInt(1, idproducto);
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
            
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
                
            }
        }    
        return respuesta;
    }
}

