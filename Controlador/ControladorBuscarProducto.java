/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.GestionarProducto;
import Modelo.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorBuscarProducto", urlPatterns = {"/ControladorBuscarProducto"})
public class ControladorBuscarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        GestionarProducto gp = new GestionarProducto();

        ArrayList<Producto> lista = gp.BuscarProducto();

        Producto p = null;
        if(!lista.isEmpty()){
      p = lista.get(0);
     }

request.setAttribute("p", p);
request.setAttribute("b", true);

        RequestDispatcher rd = request.getRequestDispatcher("resultadoProducto.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador Buscar Coleccion Producto";
    }
}