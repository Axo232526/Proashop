/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrito;
import Modelo.GestionarCarrito;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorBuscarCoCarrito",
            urlPatterns = {"/ControladorBuscarCoCarrito"})
public class ControladorBuscarCoCarrito extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(
                request.getParameter("idUsuario"));

        GestionarCarrito gc = new GestionarCarrito();

        ArrayList<Carrito> lista = gc.BuscarCarrito(idUsuario);

        if (lista == null || lista.isEmpty()) {
            request.setAttribute("mensaje", "Carrito vacío");
        } else {
            request.setAttribute("carritos", lista);
        }

        request.getRequestDispatcher("ResultadoCarrito.jsp")
               .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}