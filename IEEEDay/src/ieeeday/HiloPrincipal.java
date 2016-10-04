/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeeday;

import java.net.UnknownHostException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author Edgar
 */
public class HiloPrincipal implements Runnable {
    private JSlider valor_slider;
    private DataBaseHelper dbh;
    private InfoMemoria infoMem;

    public HiloPrincipal(JSlider slider, InfoMemoria infoMem) {
        this.valor_slider = slider;
        this.infoMem = infoMem;
        this.dbh = new DataBaseHelper("root", "root");
        
    }      

    @Override
    public void run() {
        String porcentaje;
        while (true) {
            try {
                
               
                valor_slider.addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                
                 dbh.iniciarConexion();
                porcentaje = infoMem.getPorcentaje();
                if (Double.parseDouble(porcentaje) > (double)valor_slider.getValue()) {
                    JOptionPane.showMessageDialog(null, "Se está pasando de verga");
                }
                dbh.query(porcentaje);
                dbh.cerrarConexion();
                Thread.sleep(2000);
            } catch (SQLException |ClassNotFoundException |
                    InterruptedException | UnknownHostException |
                    SigarException e) {
                System.out.println("WEA " + e.getMessage());  
                //System.out.println(e);
            }
        }
    }
    
    
}
