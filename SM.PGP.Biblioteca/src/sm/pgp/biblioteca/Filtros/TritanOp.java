package sm.pgp.biblioteca.Filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase con un unico metodo para obtener una imagen en color sepia.
 * Extiende de la clase BufferedImageOpAdapter.
 * @author gervi
 */
public class TritanOp extends BufferedImageOpAdapter{
    int r;
    int g;
    int b;
    int TritanR;
    int TritanG;
    int TritanB;
    /**
     * Constructor de la clase.
     */
    public TritanOp () {}
    /**
     * Devuelve una BufferedImage a la que se le a aplicado un filtro sepia.
     * @param src: imagen de origen.
     * @param dest: imagen de destino.
     * @return una BufferedImage a la que se le a aplicado un filtro sepia.
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                Color c = new Color(src.getRGB(x, y));
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();
                
                TritanR = (int) min(255, 0.95*r + 0.05*g + 0.0*b);
                TritanG = (int) min(255, 0.0*r + 0.433*g + 0.567*b);
                TritanB = (int) min(255, 0.0*r + 0.475*g + 0.525*b);
                
                /*TritanG = (int) min(255, 0.95*r + 0.05*g + 0.0*b);//Morado y verde
                TritanR = (int) min(255, 0.0*r + 0.433*g + 0.567*b);
                TritanB = (int) min(255, 0.0*r + 0.475*g + 0.525*b);
                
                TritanB = (int) min(255, 0.95*r + 0.05*g + 0.0*b);//Protanopia, azul y amarillo
                TritanG = (int) min(255, 0.0*r + 0.433*g + 0.567*b);
                TritanR = (int) min(255, 0.0*r + 0.475*g + 0.525*b);*/
                c = new Color(TritanR, TritanG, TritanB);
                src.setRGB(x,y,c.getRGB());
            }
        }
        return dest;
    }
}