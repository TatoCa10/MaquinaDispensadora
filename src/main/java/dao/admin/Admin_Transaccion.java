/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

/**
 *
 * @author Carlos Alberto
 */
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import util.Conexion;
import vo.Transaccion;

public class Admin_Transaccion {

    private Connection conexion;

    public Admin_Transaccion() {

        try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Admin_Transaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean crearTransaccion(Transaccion transaccion) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Transaccion VALUES(?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, transaccion.getId());
            statement.setInt(2, transaccion.getEntradaDinero());
            statement.setInt(3, transaccion.getSalidaDinero());
            statement.setDate(4, (Date) transaccion.getFecha());
            
            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    
    public ArrayList<Transaccion> leerTransaccion() {
        //1.Consulta
        ArrayList<Transaccion> respuesta = new ArrayList<Transaccion>();
        String consulta = "SELECT * FROM Transaccion";
        try {
            //----------------------------
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                respuesta.add((Transaccion) resultado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
}
