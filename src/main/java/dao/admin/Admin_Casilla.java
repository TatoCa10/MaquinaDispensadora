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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;
import vo.Casilla;



public class Admin_Casilla {
    
    private Connection conexion;
    
    public Admin_Casilla() {
       try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Admin_Casilla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean crearCasilla(Casilla casilla) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Casilla VALUES(?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, casilla.getID());
            statement.setInt(2, casilla.getEspacio());
            statement.setString(3, casilla.getProducto().getNombre());
            statement.setInt(4, casilla.getCantidadProducto());
            
            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    public boolean modificarCasilla(Casilla casilla) {
        boolean result = false;
        String query = "update Casilla set ID = ?, Espacio = ?, Producto = ?, CantidadProducto= ? where ID = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, casilla.getID());
            preparedStmt.setInt(2, casilla.getEspacio());
            preparedStmt.setString(3, casilla.getProducto().getNombre());
            preparedStmt.setInt(4, casilla.getCantidadProducto());
            
            
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public ArrayList<Casilla> leerCasilla() {
        

        //1.Consulta
        ArrayList<Casilla> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Casilla";
        Casilla casilla = new Casilla();
        try {
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            int i=0;
            while (resultado.next()) {
                respuesta.add((Casilla) resultado);
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    public boolean borrarCasilla(Casilla casilla) {
        boolean result = false;
        String query = "delete from Casilla where ID = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, casilla.getID());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
