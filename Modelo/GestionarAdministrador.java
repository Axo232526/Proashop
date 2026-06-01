
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    

     public boolean insertarAdministrador(Administrador p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO administrador (nombre, numero, antiguedad, usuario, contrasenia, fk_persona) VALUES (?,?,?,?,?,?)");
            ps.setString(1, p.getNombreAdmin());
            ps.setInt(2, p.getNumAdmin());   
            ps.setInt(3, p.getAntiguedadAdmin());  
            ps.setString(4, p.getUsuario());  
            ps.setString(5, p.getContraseniaAdmin());   
            ps.setInt(6, 1);
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
     
    public ArrayList<Administrador> BuscarColeccionAdministrador(){
        ArrayList<Administrador> p = new ArrayList<>();
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM Administrador");            
            rs = ps.executeQuery();
            while (rs.next()){
                Administrador p1 = new Administrador();
                p1.setId_administrador(rs.getInt(1));
                p1.setNombreAdmin(rs.getString(2));
                p1.setNumAdmin(rs.getInt(3));
                p1.setAntiguedadAdmin(rs.getInt(4));
                p1.setContraseniaAdmin(rs.getString(5));
                p1.setUsuario(rs.getString(6));
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
     public boolean modificarAdministrador(Administrador p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE administrador SET nombre=?, numero=?, antiguedad=?, usuario=?, contrasenia=?, fk_persona=? WHERE id_administrador=?");
            ps.setString(1, p.getNombreAdmin());
            ps.setInt(2, p.getNumAdmin());
            ps.setInt(3, p.getAntiguedadAdmin()); 
            ps.setString(4, p.getUsuario());
            ps.setString(5, p.getContraseniaAdmin());
            ps.setInt(6, p.getIdPersona());
            ps.setInt(7,p.getid_administrador());
            System.out.println("id administrador" + p.getid_administrador());
            System.out.println("id persona" + p.getIdPersona());
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