package sm.pgp.biblioteca.Filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase con un unico metodo para obtener el negativo de una imagen.
 * Extiende de la clase BufferedImageOpAdapter.
 * @author gervi
 */
public class NegativoOp extends BufferedImageOpAdapter{
    int r;
    int g;
    int b;
    /**
     * Constructor de la clase.
     */
    public NegativoOp(){}
    /**
     * Devuelve una BufferedImage en colores en negativo a la original.
     * @param src: imagen de origen.
     * @param dest: imagen de destino.
     * @return una BufferedImage a la que se le an invertido los colores.
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
                r = 255 - c.getRed();
                g = 255 - c.getGreen();
                b = 255 - c.getBlue();
                c = new Color(r, g, b);
                src.setRGB(x,y,c.getRGB());
            }
        }
        return dest;
    }
}
