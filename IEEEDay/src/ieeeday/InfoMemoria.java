/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeeday;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Swap;
import org.hyperic.sigar.SigarException;

public class InfoMemoria {

    private Sigar sigar = new Sigar();

    public void imprimirInfo() throws SigarException {
        Mem memoria = sigar.getMem();
        Swap intercambio = sigar.getSwap();
        System.out.println("Cantidad de memoria RAM: " + memoria.getRam() + "MB");
        System.out.println("Total: " + enBytes(memoria.getTotal()));
        System.out.println("Usada: " + enBytes(memoria.getUsed()));
        System.out.println("Disponible: " + enBytes(memoria.getFree()));
        System.out.println("Memoria SWAP total: " + enBytes(intercambio.getTotal()));
        System.out.println("Memoria SWAP usada: " + enBytes(intercambio.getUsed()));
        System.out.println("Memoria SWAP libre: " + enBytes(intercambio.getFree()));
    }
    
    public void getMemoriaTotal () throws SigarException {
        Mem mem = sigar.getMem();
        System.out.println(mem.getActualUsed());
    }

    private Long enBytes(long valor) {
        return new Long(valor / 1024);
    }
}
