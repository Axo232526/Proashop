package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionarUsuario {
    //copiar el insertar y modificarlo poniendo el usuario
  //cambiar solo la consulta de los ejemplos.  
private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarUsuario () {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
    //INSERTAR
    public boolean insertarUsuario(Usuario u){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO usuario (correo, contraseña, fk_persona) VALUES (?,?,?)");
            ps.setString(1, u.getEmailUs());
            ps.setString(2, u.getContUs());
            ps.setInt(3, u.getIDPersona());           
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e2) {
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            }
        }    
        return respuesta;
    }
    
    //BUSCAR
     public ArrayList<Usuario> BuscarColeccionUsuario(){
        ArrayList<Usuario> u = new ArrayList<>();
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM usuario");            
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario u1 = new Usuario();
                u1.setEmailUs(rs.getString(1));
                u1.setContUs(rs.getString(2));
                u1.setIdUs(rs.getInt(3));
                u.add(u1);
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
        return u;
    }
     
     //MODIFICAR
     public boolean modificarUsuario(Usuario u){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE usuario SET correo=?,contraseña=?,fk_persona=? WHERE Id_usuario=?");
            ps.setString(1,u.getEmailUs());
            ps.setString(2,u.getContUs());
            ps.setInt(3,u.getIDPersona());
            ps.setInt(4,u.getIdUs()); 
             
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
     
     //ELIMINAR
     public boolean eliminarUsuario(int idUs){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM usuario WHERE Id_usuario=?");           
            ps.setInt(1, idUs);
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
