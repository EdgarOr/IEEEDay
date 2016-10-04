/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeeday;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
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
            
            Interfaz i = new Interfaz();
            i.setVisible(true);
            HiloPrincipal hilo = new HiloPrincipal(i.getSlider(), i.getMemoriaActual(), i.getLimiteActual(), new InfoMemoria());
            hilo.run();
            /*System.out.println("====Informacion del sistema====");
             new InfoSO().imprimirInfo();
             System.out.println("\n==== Informacion de la CPU ====");
             new InfoCPU().imprimirInfoCPU();
             System.out.println("\n====Informacion del sistema de archivos====");
             new InfoSistemaArchivos().imprimirInfo();*/
//            System.out.println("\n====Informacion de la memoria====");
//            new InfoMemoria().imprimirInfo();
//            System.out.println(new InfoMemoria().getMemoriaTotal());
//            System.out.println(new InfoMemoria().getPorcentaje());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
