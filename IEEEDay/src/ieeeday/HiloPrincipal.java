/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeeday;

import java.awt.Toolkit;
import java.io.File;
import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author Edgar
 */
public class HiloPrincipal implements Runnable {
    private JSlider slider;
    private JLabel memoriaActual;
    private JLabel limiteActual;
    private DataBaseHelper dbh;
    private InfoMemoria infoMem;
    private int limite;

    public HiloPrincipal(JSlider slider, JLabel memoriaActual, JLabel limiteActual, InfoMemoria infoMem) {
        this.slider = slider;
        this.memoriaActual = memoriaActual;
        this.limiteActual = limiteActual;
        this.infoMem = infoMem;
        this.dbh = new DataBaseHelper("root", "root");
        
    }      

    @Override
    public void run() {
        String porcentaje;
         
          
        while (true) {
            try {
                
                slider.addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        limite = slider.getValue();          
                        limiteActual.setText(limite + "%");
                    }
                });
                
                porcentaje = infoMem.getPorcentaje();
                memoriaActual.setText(porcentaje +"%");
                dbh.iniciarConexion();
                dbh.query(porcentaje);
                dbh.cerrarConexion();
                
                if (Double.parseDouble(porcentaje) > (double)limite) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Se está pasando del límite", "¡ALERTA!", JOptionPane.ERROR_MESSAGE);                    
                } 
                
                Thread.sleep(2000);
            } catch (SQLException |ClassNotFoundException |
                    InterruptedException | UnknownHostException |
                    SigarException e) {
                System.out.println("ERROR!:  " + e.getMessage());  
                //System.out.println(e);
            }
        }
    }
    
    public  void reproducirMusica() throws BasicPlayerException{
         
          
    }
    
    
}
