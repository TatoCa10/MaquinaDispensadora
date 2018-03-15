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
//import java.util.logging.Level;
//import java.util.logging.Logger;
import util.Conexion;
import vo.Producto;

public class Admin_Producto {
    
     private Connection conexion;
    
    public Admin_Producto() {
       try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Admin_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public boolean crearProducto(Producto producto) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Productos VALUES(?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getPrecio());
            statement.setString(3, producto.getRuta());
            
            
            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    public boolean modificarProducto(Producto producto) {
        boolean result = false;
        String query = "update Producto set Nombre = ?,Precio = ?, Ruta = ? where Nombre = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, producto.getNombre());
            preparedStmt.setInt(2, producto.getPrecio());
            
            
            
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public ArrayList<Producto> leerProducto() {
        //1.Consulta
        ArrayList<Producto> respuesta = new ArrayList<Producto>();
        String consulta = "SELECT * FROM Productos";
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
                respuesta.add((Producto) resultado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    public boolean borrarProducto(Producto producto) {
        boolean result = false;
        String query = "delete from Producto where Nombre = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, producto.getNombre());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    

}
