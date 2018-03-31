package controlador;


//import dao.TiendaDAO;
import dao.admin.Admin_Casilla;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import vo.Casilla;
//import vo.TiendaVO;

/**
 *
 * @author Nicolas
 */
public class ServletCargaLista extends HttpServlet {

    //private ArrayList<ProductoVO> productos;
    //private DAOProducto prodDAO;

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
        response.setContentType("application/json");
//        try (PrintWriter out = response.getWriter()) {
//            
//            
//            
//            Admin_Casilla casilla = new Admin_Casilla();
//            Casilla casillaVO = new Casilla();
//            
//            ArrayList<Casilla> casillas = new ArrayList<Casilla>();
//            casillas=casilla.leerCasilla();
//            
//            //this.prodDAO=new DAOProducto();
//
//            //this.productos = prodDAO.listarTodo();
//            JSONArray array = new JSONArray();
//            JSONObject json = new JSONObject();
//
//            for (Casilla producto : casillas) {
//
//            json.put("source",casillaVO.getProducto().getRuta());
//            //json.put("alt", producto.getNombre());
//            json.put("ubicacion", casillaVO.getID());
//            json.put("precio", casillaVO.getProducto().getPrecio());
//            array.put(json);
//            }
//            JSONObject mainJson = new JSONObject();
//            mainJson.put("casillas",array);
//
//            mainJson.put("test", "CORRECTO");
//            out.print(mainJson);
//        }
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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            
            
            
            Admin_Casilla casilla = new Admin_Casilla();
            Casilla casillaVO = new Casilla();
            
            ArrayList<Casilla> casillas = new ArrayList<Casilla>();
            casillas=casilla.leerCasilla();
            
            //this.prodDAO=new DAOProducto();

            //this.productos = prodDAO.listarTodo();
            JSONArray array = new JSONArray();
            JSONObject json = new JSONObject();

            for (Casilla producto : casillas) {

            json.put("source",casillaVO.getProducto().getRuta());
            json.put("ubicacion", casillaVO.getID());
                System.out.println(casillaVO.getID());
            json.put("precio", casillaVO.getProducto().getPrecio());
            array.put(json);
            }
            JSONObject mainJson = new JSONObject();
            mainJson.put("casillas",array);

            //mainJson.put("test", "CORRECTO");
            out.print(mainJson);
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
