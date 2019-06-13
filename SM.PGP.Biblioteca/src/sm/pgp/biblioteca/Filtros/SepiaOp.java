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
public class SepiaOp extends BufferedImageOpAdapter{
    int r;
    int g;
    int b;
    int sepiaR;
    int sepiaG;
    int sepiaB;
    /**
     * Constructor de la clase.
     */
    public SepiaOp () {}
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
                sepiaR = (int) min(255, 0.393*r + 0.769*g + 0.189*b);
                sepiaG = (int) min(255, 0.349*r + 0.686*g + 0.168*b);
                sepiaB = (int) min(255, 0.272*r + 0.534*g + 0.131*b);
                c = new Color(sepiaR, sepiaG, sepiaB);
                src.setRGB(x,y,c.getRGB());
            }
        }
        return dest;
    }
}