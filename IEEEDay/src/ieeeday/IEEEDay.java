/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeeday;

import org.hyperic.sigar.SigarException;

/**
 *
 * @author Edgar
 */
public class IEEEDay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*System.out.println("====Informacion del sistema====");
            new InfoSO().imprimirInfo();
            System.out.println("\n==== Informacion de la CPU ====");
            new InfoCPU().imprimirInfoCPU();
            System.out.println("\n====Informacion del sistema de archivos====");
            new InfoSistemaArchivos().imprimirInfo();
            System.out.println("\n====Informacion de la memoria====");
            new InfoMemoria().imprimirInfo();*/
            new InfoMemoria().getMemoriaTotal();
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
}
