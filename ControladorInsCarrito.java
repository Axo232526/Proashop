/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrito;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.GestionarCarrito;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ControladorInsPersona", urlPatterns = {"/ControladorInsPersona"})
public class ControladorInsCarrito extends HttpServlet {

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
        
        /*Recibimos la info y la procesamos*/
        /*CANTIDAD*/
        int cantidad =Integer.parseInt(request.getParameter("Cantidad"));
        int total = Integer.parseInt(request.getParameter("Total"));
        
    //creamos carrito con la informacion que viene del formulario
       Carrito c = new Carrito();
        c.setCantidad(cantidad);
        c.setTotal(total);
        
    //guardamos en la base de datos al carrito.
         GestionarCarrito gc = new GestionarCarrito();
        boolean b = gc.insertarCarito(c);

    //seteamos la informacion que queremos enviar a la vista
         request.setAttribute("c", c);
        request.setAttribute("b", b);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
       RequestDispatcher a = request.getRequestDispatcher("vista.jsp");
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
