package sm.pgp.biblioteca.Filtros;

import java.awt.Color;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;

/**
 * Clase con un unico metodo que proporciona un LookupTable mediante una funcion seno.
 * @author gervi
 */
public class TempMixOp {
    /**
     * Devuelve un LookupTable de una seleccion de colores por "temperatura".
     * @return un LookupTable de una seleccion de colores por "temperatura".
     */
    public static LookupTable filtroTempMix(boolean invertido){
        
        byte[] lt = new byte[256];
        
        for (int l = 0; l <= 255; ++l){
            if (l < 43){
                if (invertido)
                    lt[l] = (byte)Color.WHITE.getRGB();
                else
                    lt[l] = (byte)Color.BLACK.getRGB();
            }
            if (l >= 43 && l < 86){
                if (invertido)
                    lt[l] = (byte)Color.YELLOW.getRGB();
                else
                    lt[l] = (byte)Color.BLUE.getRGB();
            }
            if (l >= 86 && l < 129){
                if (invertido)
                    lt[l] = (byte)Color.RED.getRGB();
                else
                    lt[l] = (byte)-6750055;//morado
            }
            if (l >= 129 && l < 172){
                if (invertido)
                    lt[l] = (byte)-6750055;//morado
                else
                    lt[l] = (byte)Color.RED.getRGB();
            }
            if (l >= 172 && l < 215){
                if (invertido)
                    lt[l] = (byte)Color.BLUE.getRGB();
                else
                    lt[l] = (byte)Color.YELLOW.getRGB();
            }
            if (l >= 215){
                if (invertido)
                    lt[l] = (byte)Color.BLACK.getRGB();
                else
                    lt[l] = (byte)Color.WHITE.getRGB();
            }
        }
        ByteLookupTable slt = new ByteLookupTable(0, lt);
        return slt;
    }
}
