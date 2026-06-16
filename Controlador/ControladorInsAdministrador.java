/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;
import modelo.GestionarAdministrador;
import modelo.Persona;


/**
 *
 * @author User
 */
@WebServlet(name = "ControladorInsAdministrador", urlPatterns = {"/ControladorInsAdministrador"})
public class ControladorInsAdministrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /* aca recibimos la informacion y la procesamos */
        String nombre = request.getParameter("Nombre");
        String apellido = request.getParameter("Apellido");
        int dni = Integer.parseInt(request.getParameter("Dni"));
        int telefono = Integer.parseInt(request.getParameter("Telefono"));
        String direccion = request.getParameter("Direccion");
        String localidad = request.getParameter("Localidad");
        String provincia = request.getParameter("Provincia");
        int antiguedad = Integer.parseInt(request.getParameter ("Antiguedad"));
        int numero = Integer.parseInt(request.getParameter ("Numero"));
        String contrasenia =  request.getParameter("Contraseña");
        String usuario = request.getParameter("Usuario");
        
        Persona p = new Persona ();
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDni(dni);
        p.setTelefono(telefono);
        p.setDireccion(direccion);
        p.setLocalidad(localidad);
        p.setProvincia(provincia);
        Administrador p1= new Administrador();
        p1.setNumAdmin(numero);
        p1.setAntiguedadAdmin(antiguedad);
        p1.setContraseniaAdmin(contrasenia);
        p1.setUsuario(usuario);
        
        //guardamos en la base de datos a la persona.
        GestionarAdministrador gp = new GestionarAdministrador();
        boolean b = gp.insertarAdministrador(p1, p);
        request.setAttribute("p", p);
        request.setAttribute("p1", p1);
        request.setAttribute("b", b);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           //enviamos la informacion a la vista
            RequestDispatcher a = request.getRequestDispatcher("resultadoAdministrador.jsp");
            a.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
