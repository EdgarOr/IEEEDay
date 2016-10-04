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
            reproducirMusica();
            Interfaz i = new Interfaz();
            i.setVisible(true);
            HiloPrincipal hilo = new HiloPrincipal(i.getNivel_slider(), new InfoMemoria());
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
    
    public static void reproducirMusica() throws BasicPlayerException{
          BasicPlayer bp = new BasicPlayer();
          bp.open(new File("music/eliza.mp3"));
          bp.play();
    }
}
