/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

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
import vo.Caja;
import vo.Casilla;
import vo.Producto;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Caja {

    private Connection conexion;
    
    public Admin_Caja() {
        try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Admin_Caja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean CrearCaja(Caja caja) {
        boolean resultado = false;
        
        for (int i = 0; i < caja.getSaldo().length; i++) {
            
            try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Caja VALUES(?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, i);
            statement.setInt(2, caja.getSaldo()[i]);
            statement.setInt(3, caja.getEspacioMaxDinero()[i]);
            
            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
        

        return resultado;
    }
    
    public boolean modificarCaja(Caja caja) {
        boolean result = false;
        String query = "update Caja set ID = ?, Cantidad = ? where ID = ?";
        PreparedStatement preparedStmt = null;
        
        for (int i = 0; i < caja.getSaldo().length; i++) {
            
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setInt(1, i);
            preparedStmt.setInt(2, caja.getSaldo()[i]);
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        return result;
    }
    
    public int[] leerCajaSaldo() {
        //1.Consulta
        int[] respuesta = new int[9];
        int i = 0;
        String consulta = "SELECT cantidad FROM Caja";
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
                respuesta[i]= resultado.getInt(i);
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    
    public int[] leerCajaEspacio() {
        //1.Consulta
        int[] respuesta = new int[9];
        int i = 0;
        String consulta = "SELECT espacioMax FROM Caja";
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
                respuesta[i]= resultado.getInt(i);
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

}
