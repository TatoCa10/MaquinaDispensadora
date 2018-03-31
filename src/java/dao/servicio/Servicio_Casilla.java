/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicio;

/**
 *
 * @author Carlos Alberto
 */
import dao.admin.Admin_Casilla;
import java.util.ArrayList;
import vo.Casilla;

public class Servicio_Casilla {
    
    private Admin_Casilla casilla;  
    
    
    public Boolean entregarProducto(Casilla casillas){
    
        ArrayList<Casilla> productos =casilla.leerCasilla();
        Boolean respuesta = false;
        
        for (int i = 0; i < productos.size(); i++) {
            
            if (productos.get(i).getID().equals(casillas.getID())){
                
                casillas.setID(productos.get(i).getID());
                casillas.setEspacio(productos.get(i).getEspacio());                
                casillas.setCantidadProducto(productos.get(i).getCantidadProducto()-1);
                casillas.setProducto(productos.get(i).getProducto());
                
                casilla.modificarCasilla(casillas);
                
                respuesta=true;
                return respuesta;
            }
            
        }
        respuesta=false;
        return respuesta;
        
        
    
    }
    
    
    public Integer consultarPrecio(Casilla casillas){
    
    ArrayList<Casilla> productos =casilla.leerCasilla();
        int respuesta;
        
        for (int i = 0; i < productos.size(); i++) {
            
            if (productos.get(i).getID().equals(casillas.getID())){
                  
                if (productos.get(i).getCantidadProducto() != 0) {                   
                    
                    respuesta=productos.get(i).getProducto().getPrecio();
                    return respuesta;
                }
                
                
                respuesta=0;
                return respuesta;
            }
            
        }
        respuesta=1;
        return respuesta;

    }
    
    
}
