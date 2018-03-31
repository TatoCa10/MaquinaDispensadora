package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author USUARIO
 */
public class Servlet_Transacciones extends HttpServlet {

    JSONArray array;
    JSONObject json;

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
//        processRequest(request, response);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        array = new JSONArray();

        
        
        json = new JSONObject();
        json.put("Producto", "Producto de Prueba 111");
        json.put("Valor_Ingresado", "50.000");
        json.put("Vueltas", "48700");
        json.put("Fecha", "30/03/2018");
        json.put("Operacion", "1");
        array.put(json);

        
        
        json = new JSONObject();
        json.put("Producto", "Producto de Prueba 222");
        json.put("Valor_Ingresado", "50.000");
        json.put("Vueltas", "48700");
        json.put("Fecha", "30/03/2018");
        json.put("Operacion", "1");
        array.put(json);

        
        
        
        json = new JSONObject();
        json.put("Producto", "Producto de Prueba 333");
        json.put("Valor_Ingresado", "50.000");
        json.put("Vueltas", "48700");
        json.put("Fecha", "30/03/2018");
        json.put("Operacion", "1");
        array.put(json);
        
        
        JSONObject mainJson = new JSONObject();
        System.out.println("Leyendo...");
        mainJson.put("base", array);
        out.print(mainJson);

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
