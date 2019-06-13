package sm.pgp.biblioteca.Filtros;

import java.awt.image.ByteLookupTable;
import java.awt.image.LookupTable;
import static java.lang.Math.sin;

/**
 * Clase con un unico metodo que proporciona un LookupTable mediante una funcion seno.
 * @author gervi
 */
public class Seno {
    /**
     * Devuelve un LookupTable de una funcion seno.
     * @param w: angulo en grados.
     * @return un LookupTable de una funcion seno.
     */
    public static LookupTable filtroSeno(double w){
        w = Math.toRadians(w);
        double K = 255.0/sin(Math.toRadians(90.0));
        byte[] lt = new byte[256];

        for (int l = 0; l <= 255; ++l)
            lt[l] = (byte)(K * Math.abs(Math.sin(Math.toRadians((double) l * w))));
        ByteLookupTable slt = new ByteLookupTable(0, lt);
        return slt;
    }
}
