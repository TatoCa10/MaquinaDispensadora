package controlador;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author USUARIO
 */
public class ServletCajas extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

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
//        processRequest(request, response);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        String moneda50 = request.getParameter("moneda50");
        String moneda100 = request.getParameter("moneda100");
        String moneda200 = request.getParameter("moneda200");
        String moneda500 = request.getParameter("moneda500");
        String moneda1000 = request.getParameter("moneda1000");
        String billete2000 = request.getParameter("billete2000");
        String billete5000 = request.getParameter("billete5000");
        String billete10000 = request.getParameter("billete10000");
        String billete20000 = request.getParameter("billete20000");
        String billete50000 = request.getParameter("billete50000");
        String Full = "[" + moneda50 + "," + moneda100 + "," + moneda200 + "," + moneda500 + "," + moneda1000 + "," + billete2000 + "," + billete5000 + "," + billete10000 + "," + billete20000 + "," + billete50000 + "]";
        
        int[] Denominaciones = new int[10];
        Denominaciones[0] = Integer.parseInt(moneda50);
        Denominaciones[1] = Integer.parseInt(moneda100);
        Denominaciones[2] = Integer.parseInt(moneda200);
        Denominaciones[3] = Integer.parseInt(moneda500);
        Denominaciones[4] = Integer.parseInt(moneda1000);
        Denominaciones[5] = Integer.parseInt(billete2000);
        Denominaciones[6] = Integer.parseInt(billete5000);
        Denominaciones[7] = Integer.parseInt(billete10000);
        Denominaciones[8] = Integer.parseInt(billete20000);
        Denominaciones[9] = Integer.parseInt(billete50000);
        
        
        JSONObject json = new JSONObject();
        json.put("confirmacion", Full);
        System.out.println(Full);
        out.print(json);
        
        for (int i = 0; i < Denominaciones.length; i++) {
            System.out.println(Denominaciones[i]);
        }
        
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
