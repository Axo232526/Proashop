
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionarAdministrador {
    
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarAdministrador() {
        this.c = new Conexion();
        this.ps = null;
        this.cn = null;
        this.rs = null;
    }
    

     public boolean insertarAdministrador(Administrador p, Persona p1){
        boolean respuesta = false;
        try {   
             cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO persona (Nombre,Apellido,DNI,Telefono,Direccion,Localidad,Provincia) VALUES (?,?,?,?,?,?,?)",  Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p1.getNombre());
            ps.setString(2, p1.getApellido());    
            ps.setInt(3, p1.getDni());           
            ps.setInt(4, p1.getTelefono());           
            ps.setString(5, p1.getDireccion());           
            ps.setString(6, p1.getLocalidad());           
            ps.setString(7, p1.getProvincia());           
            
            int res = ps.executeUpdate(); 
            respuesta = res>0;
              int id =0;
            rs= ps.getGeneratedKeys();
               if (rs.next()){
                id=rs.getInt(1);
            }
            
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO administrador (nombre, numero, antiguedad, usuario, contrasenia, fk_persona) VALUES (?,?,?,?,?,?)");
            ps.setString(1, p.getNombreAdmin());
            ps.setInt(2, p.getNumAdmin());   
            ps.setInt(3, p.getAntiguedadAdmin());  
            ps.setString(4, p.getUsuario());  
            ps.setString(5, p.getContraseniaAdmin());   
            ps.setInt(6, id);
            int res1 = ps.executeUpdate(); 
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
     
  /*  public ArrayList<Administrador> BuscarColeccionAdministrador(){
        ArrayList<Administrador> p = new ArrayList<>();
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM Administrador");            
            rs = ps.executeQuery();
            while (rs.next()){
                Administrador p = new Administrador();
                p.setNumAdmin(rs.getInt(3));
                p.setAntiguedadAdmin(rs.getInt(4));
                p.setContraseniaAdmin(rs.getString(5));
                p.setUsuario(rs.getString(6));
                p.add(p);
                
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
    } */
     public boolean modificarAdministrador(Administrador p, Persona p1){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE administrador SET nombre=?, numero=?, antiguedad=?, usuario=?, contrasenia=?  WHERE fk_persona=?");
            ps.setString(1, p.getNombreAdmin());
            ps.setInt(2, p.getNumAdmin());
            ps.setInt(3, p.getAntiguedadAdmin()); 
            ps.setString(4, p.getUsuario());
            ps.setString(5, p.getContraseniaAdmin());
            ps.setInt(6, p1.getIdPersona());
            System.out.println("id administrador " + p.getid_administrador());
            System.out.println("id persona " + p1.getIdPersona());
            int res = ps.executeUpdate(); 
            respuesta = res>0;
            
             cn = c.conectar();
            ps = cn.prepareStatement("UPDATE persona SET Nombre=?,Apellido=?,DNI=?,Telefono=?,Direccion=?,Localidad=?,Provincia=? WHERE ID_persona=?");
            ps.setString(1, p1.getNombre());
            ps.setString(2, p1.getApellido());
            ps.setInt(3, p1.getDni());           
            ps.setInt(4, p1.getTelefono());           
            ps.setString(5, p1.getDireccion());           
            ps.setString(6, p1.getLocalidad());           
            ps.setString(7, p1.getProvincia());
            ps.setInt(8, p1.getIdPersona());    
            res = ps.executeUpdate(); 
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
      public boolean eliminarAdministrador(int id){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM Administrador WHERE id_administrador=?");           
            ps.setInt(1, id);
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