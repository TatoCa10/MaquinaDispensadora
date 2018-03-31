/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.servicio.Servicio_Caja;
import dao.servicio.Servicio_Casilla;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import vo.Caja;
import vo.Casilla;

/**
 *
 * @author Carlos Alberto
 */
public class ServletTest extends HttpServlet {

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
        response.setContentType("json/application");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
        PrintWriter out = response.getWriter();
        //processRequest(request, response);
        response.setContentType("application/json");

        Servicio_Casilla casillaDAO = new Servicio_Casilla();
        Servicio_Caja cajaDAO = new Servicio_Caja();

        Casilla casillaVO = new Casilla();
        Caja cajaVO = new Caja();
        int precio;

        String ubicacion = request.getParameter("ubicacion");
        String denominaciones = request.getParameter("denominaciones");
        int Suma = 0;

        casillaVO.setID(ubicacion);

        String partes[] = denominaciones.split(",");
        int Arreglo[] = new int[partes.length];

        System.out.println("Partes:" + partes.length);
        for (int i = 0; i < partes.length; i++) {
            Arreglo[i] = Integer.parseInt(partes[i]);
        }

        for (int i = 0; i < Arreglo.length; i++) {
            switch (i) {
                case 0:
                    Suma = Suma + Arreglo[i] * 50;
                    break;
                case 1:
                    Suma = Suma + Arreglo[i] * 100;
                    break;
                case 2:
                    Suma = Suma + Arreglo[i] * 200;
                    break;
                case 3:
                    Suma = Suma + Arreglo[i] * 500;
                    break;
                case 4:
                    Suma = Suma + Arreglo[i] * 1000;
                    break;
                case 5:
                    Suma = Suma + Arreglo[i] * 2000;
                    break;
                case 6:
                    Suma = Suma + Arreglo[i] * 5000;
                    break;
                case 7:
                    Suma = Suma + Arreglo[i] * 10000;
                    break;
                case 8:
                    Suma = Suma + Arreglo[i] * 20000;
                    break;
                case 9:
                    Suma = Suma + Arreglo[i] * 50000;
                    break;
            }
        }

        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Arreglo: " + denominaciones);
        System.out.println("Total Ingresado: " + Suma);

        precio = casillaDAO.consultarPrecio(casillaVO);

        JSONObject json = new JSONObject();

        if (precio != 0 || precio != 1) {

            if ((Suma - precio) == 0) {
                casillaDAO.entregarProducto(casillaVO);

            } else if ((Suma - precio) < 0) {
                json.put("confirmacion", "FAIL");
            } else if ((Suma - precio) > 0) {
                int[] res = cajaDAO.salidaDinero(Suma - precio);

                if (res.length > 2) {

                    cajaVO.setSaldo(Arreglo);
                    int ent = cajaDAO.entradaDinero(cajaVO);

                    if (ent == 0) {
                        casillaDAO.entregarProducto(casillaVO);
                    } else {
                        json.put("confirmacion", "FAIL");
                    }
                } else {
                    json.put("confirmacion", "FAIL");
                }
            }
        } else {
            json.put("confirmacion", "FAIL");
        }

        json.put("confirmacion", denominaciones);

        out.print(json);

//        JSONObject json = new JSONObject();
//        json.put("confirmacion", denominaciones);
//
//        out.print(json);

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
