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

public class GestionarCarrito {
    
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarCarrito() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
    // INSERTAR
    public boolean insertarCarrito(Carrito car){
        
        boolean respuesta = false;
        
        try {
            
            cn = c.conectar();
            
            ps = cn.prepareStatement(
                "INSERT INTO carrito (producto,cantidad,precio,idusuario) VALUES (?,?,?,?)"
            );
            
            ps.setString(1, car.getProducto());
            ps.setInt(2, car.getCantidad());
            ps.setDouble(3, car.getPrecio());
            ps.setInt(4, car.getIdUsuario());
            
            int res = ps.executeUpdate();
            
            respuesta = res > 0;
            
        } catch (SQLException e) {
            
        } finally {
            
            try {
                
                if (ps != null) { ps.close(); }
                if (cn != null) { cn.close(); }
                
            } catch (SQLException e2) {
            }
        }
        
        return respuesta;
    }

    
    // BUSCAR TODOS
    public ArrayList<Carrito> BuscarColeccionCarrito(){
        
        ArrayList<Carrito> carrito = new ArrayList<>();
        
        try{
            
            cn = c.conectar();
            
            ps = cn.prepareStatement(
                "SELECT * FROM carrito"
            );
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                
                Carrito c1 = new Carrito();
                
                c1.setIdCarrito(rs.getInt(1));
                c1.setProducto(rs.getString(2));
                c1.setCantidad(rs.getInt(3));
                c1.setPrecio(rs.getDouble(4));
                c1.setIdUsuario(rs.getInt(5));
                
                carrito.add(c1);
            }
            
        } catch (SQLException e) {
            
        } finally {
            
            try {
                
                if (ps != null) { ps.close(); }
                if (cn != null) { cn.close(); }
                if (rs != null) { rs.close(); }
                
            } catch (SQLException e2) {
            }
        }
        
        return carrito;
    }

    
    // BUSCAR POR USUARIO
    public ArrayList<Carrito> BuscarCarrito(int idUsuario){
        
        ArrayList<Carrito> carrito = new ArrayList<>();
        
        try{
            
            cn = c.conectar();
            
            ps = cn.prepareStatement(
                "SELECT * FROM carrito WHERE idusuario=?"
            );
            
            ps.setInt(1, idUsuario);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                
                Carrito c1 = new Carrito();
                
                c1.setIdCarrito(rs.getInt(1));
                c1.setProducto(rs.getString(2));
                c1.setCantidad(rs.getInt(3));
                c1.setPrecio(rs.getDouble(4));
                c1.setIdUsuario(rs.getInt(5));
                
                carrito.add(c1);
            }
            
        } catch (SQLException e) {
            
        } finally {
            
            try {
                
                if (ps != null) { ps.close(); }
                if (cn != null) { cn.close(); }
                if (rs != null) { rs.close(); }
                
            } catch (SQLException e2) {
            }
        }
        
        return carrito;
    }

    
    // MODIFICAR
    public boolean modificarCarrito(Carrito car){
        
        boolean respuesta = false;
        
        try {
            
            cn = c.conectar();
            
            ps = cn.prepareStatement(
                "UPDATE carrito SET producto=?, cantidad=?, precio=?, idusuario=? WHERE idcarrito=?"
            );
            
            ps.setString(1, car.getProducto());
            ps.setInt(2, car.getCantidad());
            ps.setDouble(3, car.getPrecio());
            ps.setInt(4, car.getIdUsuario());
            ps.setInt(5, car.getIdCarrito());
            
            int res = ps.executeUpdate();
            
            respuesta = res > 0;
            
        } catch (SQLException e) {
            
        } finally {
            
            try {
                
                if (ps != null) { ps.close(); }
                if (cn != null) { cn.close(); }
                
            } catch (SQLException e2) {
            }
        }
        
        return respuesta;
    }

    
    // ELIMINAR
    public boolean eliminarCarrito(int id){
        
        boolean respuesta = false;
        
        try {
            
            cn = c.conectar();
            
            ps = cn.prepareStatement(
                "DELETE FROM carrito WHERE idcarrito=?"
            );
            
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            respuesta = res > 0;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if (ps != null) { ps.close(); }
                if (cn != null) { cn.close(); }
                
            } catch (SQLException e2) {
                
                e2.printStackTrace();
            }
        }
        
        return respuesta;
    }
}