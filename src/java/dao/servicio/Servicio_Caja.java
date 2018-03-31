/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicio;

import dao.admin.Admin_Caja;
import vo.Caja;

/**
 *
 * @author Carlos Alberto
 */
public class Servicio_Caja {

    private Admin_Caja caja;
    

    public Integer entradaDinero(Caja cajas) {
        int[] saldo = caja.leerCajaSaldo();
        int[] espacio = caja.leerCajaEspacio();
        int respuesta=0;
        
        for (int i = 0; i < saldo.length; i++) {
            
            cajas.getSaldo()[i] = cajas.getSaldo()[i] + saldo[i];
            
            if (cajas.getSaldo()[i] > espacio[i]) {
                respuesta=1;
                return respuesta;
            }
            
        }
        
        caja.modificarCaja(cajas);
        
        
        return respuesta;
    }

    public int[] salidaDinero(int numero) {

        int[] vueltas = new int[9];
        int[] vueltasMenoresAMil = new int[9];
        int[] vueltasCompletas = new int[9];

        int[] saldoCaja = caja.leerCajaSaldo();

        int quinto;
        int cuarto;
        int tercero;
        int segundo;
        int primero;

        for (int i = 0; i < vueltas.length; i++) {
            vueltas[i] = 0;
            vueltasMenoresAMil[i] = 0;
        }

        if (numero >= 1000) {

            quinto = numero % 10;

            numero = numero / 10;
            cuarto = numero % 10;

            numero = numero / 10;
            tercero = numero % 10;

            numero = numero / 10;
            segundo = numero % 10;

            numero = numero / 10;
            primero = numero % 10;

            if (cuarto != 0 || tercero != 0) {
                cuarto = cuarto * 10;
                tercero = tercero * 100;

                int numeroMenorAMil = cuarto + tercero;

                vueltasMenoresAMil = salidaDinero(numeroMenorAMil);

            }

            switch (segundo) {
                case 1:
                    vueltas[4] = vueltas[4] + 1;
                    break;
                case 2:
                    vueltas[5] = vueltas[5] + 1;
                    break;
                case 3:
                    vueltas[4] = vueltas[4] + 1;
                    vueltas[5] = vueltas[5] + 1;
                    break;
                case 4:
                    vueltas[5] = vueltas[5] + 2;
                    break;
                case 5:
                    vueltas[6] = vueltas[6] + 1;
                    break;
                case 6:
                    vueltas[4] = vueltas[4] + 1;
                    vueltas[6] = vueltas[6] + 1;
                    break;
                case 7:
                    vueltas[5] = vueltas[5] + 1;
                    vueltas[6] = vueltas[6] + 1;
                    break;
                case 8:
                    vueltas[4] = vueltas[4] + 1;
                    vueltas[5] = vueltas[5] + 1;
                    vueltas[6] = vueltas[6] + 1;
                    break;
                case 9:
                    vueltas[5] = vueltas[5] + 2;
                    vueltas[6] = vueltas[6] + 1;
                    break;
                default:
                    break;
            }

            switch (primero) {
                case 1:
                    vueltas[7] = vueltas[7] + 1;
                    break;
                case 2:
                    vueltas[8] = vueltas[8] + 1;
                    break;
                case 3:
                    vueltas[7] = vueltas[7] + 1;
                    vueltas[8] = vueltas[8] + 1;
                    break;
                case 4:
                    vueltas[8] = vueltas[8] + 2;
                    break;
                case 5:
                    vueltas[9] = vueltas[9] + 1;
                    break;
                case 6:
                    vueltas[7] = vueltas[7] + 1;
                    vueltas[9] = vueltas[9] + 1;
                    break;
                case 7:
                    vueltas[8] = vueltas[8] + 1;
                    vueltas[9] = vueltas[9] + 1;
                    break;
                case 8:
                    vueltas[7] = vueltas[7] + 1;
                    vueltas[8] = vueltas[8] + 1;
                    vueltas[9] = vueltas[9] + 1;
                    break;
                case 9:
                    vueltas[8] = vueltas[8] + 2;
                    vueltas[9] = vueltas[9] + 1;
                    break;
                default:
                    break;
            }

        } else if (numero < 1000) {

            quinto = numero % 10;

            numero = numero / 10;
            cuarto = numero % 10;

            numero = numero / 10;
            tercero = numero % 10;

            numero = numero / 10;
            segundo = numero % 10;

            numero = numero / 10;
            primero = numero % 10;

            switch (cuarto) {

                case 5:
                    vueltas[0] = vueltas[0] + 1;
                    break;

                default:
                    break;
            }

            switch (tercero) {
                case 1:
                    vueltas[1] = vueltas[1] + 1;
                    break;
                case 2:
                    vueltas[2] = vueltas[2] + 1;
                    break;
                case 3:
                    vueltas[1] = vueltas[1] + 1;
                    vueltas[2] = vueltas[2] + 1;
                    break;
                case 4:
                    vueltas[2] = vueltas[2] + 2;
                    break;
                case 5:
                    vueltas[3] = vueltas[3] + 1;
                    break;
                case 6:
                    vueltas[1] = vueltas[1] + 1;
                    vueltas[3] = vueltas[3] + 1;
                    break;
                case 7:
                    vueltas[2] = vueltas[2] + 1;
                    vueltas[3] = vueltas[3] + 1;
                    break;
                case 8:
                    vueltas[1] = vueltas[1] + 1;
                    vueltas[2] = vueltas[2] + 1;
                    vueltas[3] = vueltas[3] + 1;
                    break;
                case 9:
                    vueltas[2] = vueltas[2] + 2;
                    vueltas[3] = vueltas[3] + 1;
                    break;
                default:
                    break;
            }

        }

        for (int i = 0; i < vueltas.length; i++) {
            vueltasCompletas[i] = vueltas[i] + vueltasMenoresAMil[i];
        }

        for (int i = 0; i < vueltas.length; i++) {

            if (vueltasCompletas[i] > 0 && saldoCaja[i] < vueltasCompletas[i]) {
                int[] vueltasIncompletas = new int[1];
                return vueltasIncompletas;
            }
        }

        return vueltasCompletas;
    }

}
