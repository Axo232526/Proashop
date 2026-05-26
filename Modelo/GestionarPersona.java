
package Modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionarPersona {
    
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarPersona() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
     public boolean insertarPersona(Persona p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO persona (Nombre,Apellido,DNI,Telefono,Direccion,Localidad,Provincia) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());    
            ps.setInt(3, p.getDni());           
            ps.setInt(4, p.getTelefono());           
            ps.setString(5, p.getDireccion());           
            ps.setString(6, p.getLocalidad());           
            ps.setString(7, p.getProvincia());           
            
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
    
    public ArrayList<Persona> BuscarColeccionPersona(){
        ArrayList<Persona> p = new ArrayList<>();
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM persona");            
            rs = ps.executeQuery();
            while (rs.next()){
                Persona p1 = new Persona();
                p1.setIdPersona (rs.getInt(1));
                p1.setNombre(rs.getString(2));
                p1.setApellido(rs.getString(3));
                p1.setDni(rs.getInt(4));
                p1.setTelefono(rs.getInt(5));
                p1.setDireccion(rs.getString(6));
                p1.setLocalidad(rs.getString(7));
                p1.setProvincia(rs.getString(8));
                p.add(p1);
            }            
        } catch (SQLException e) {
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
                if (rs!=null) {rs.close();}
            } catch (SQLException e2) {
            }
        }    
        return p;
    }
    
    public boolean modificarPersona(Persona p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE persona SET Nombre=?,Apellido=?,DNI=?,Telefono=?,Direccion=?,Localidad=?,Provincia=? WHERE ID_persona=?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getDni());           
            ps.setInt(4, p.getTelefono());           
            ps.setString(5, p.getDireccion());           
            ps.setString(6, p.getLocalidad());           
            ps.setString(7, p.getProvincia());
            ps.setInt(8, p.getIdPersona());    
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
    
    public boolean eliminarPersona(int id){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM persona WHERE ID_persona=?");           
            ps.setInt(1, id);
            int res = ps.executeUpdate(); 
            respuesta = res>0;
            System.out.println(res);
        } 
        catch (SQLException e) {
             e.printStackTrace();
        }
        finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } 
            catch (SQLException e2) {
                e2.printStackTrace();
            }
        }    
        return respuesta;
    }
    
}
