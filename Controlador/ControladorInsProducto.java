/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Producto;
import Modelo.GestionarProducto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author vigli
 */
@WebServlet(name = "ControladorInsProducto", urlPatterns = {"/ControladorInsProducto"})
@MultipartConfig
public class ControladorInsProducto extends HttpServlet {

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
        //recibimos la info del formulario
         
        String nombre = request.getParameter("nombre");
        int stock = Integer.parseInt(request.getParameter("stock"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        Part foto = request.getPart("foto");
        String descripcion = request.getParameter("descripcion");
        
        //le cambiamos el nombre al archivo para que no haya duplicados
        String nombreOriginal = foto.getSubmittedFileName();
        String nombreImagen = System.currentTimeMillis() + "_" + nombreOriginal;
       //guardamos la ruta completa donde se va a guardar la imagen
        String ruta = getServletContext().getRealPath("") + "imagenes";
        //creamos la carpeta por si es la primera vez
        File carpeta = new File(ruta);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
        //guardamos el archivo en el servidor
        foto.write(ruta + File.separator + nombreImagen);
        //creamos una persona con la informacion que viene del formulario
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setStock(stock);
        p.setPrecio(precio);
        p.setFoto(nombreImagen);
        p.setDescripcion(descripcion);
           GestionarProducto gp = new GestionarProducto();
        boolean b = gp.insertarProducto(p);
        //seteamos la informacion que queremos enviar a la vista
        request.setAttribute("p", p);
        request.setAttribute("b", b);
        //guardamos en la base de datos a la persona.
        try (PrintWriter out = response.getWriter()) {
            /* enviamos la info a la vista */
            RequestDispatcher a = request.getRequestDispatcher("resultadoProducto.jsp");
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
