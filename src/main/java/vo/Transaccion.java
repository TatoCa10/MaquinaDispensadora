package vo;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Alberto
 */
public class Transaccion {
    
    public String id;
    public int entradaDinero;
    public int salidaDinero;
    public Date fecha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEntradaDinero() {
        return entradaDinero;
    }

    public void setEntradaDinero(int entradaDinero) {
        this.entradaDinero = entradaDinero;
    }

    public int getSalidaDinero() {
        return salidaDinero;
    }

    public void setSalidaDinero(int salidaDinero) {
        this.salidaDinero = salidaDinero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
