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
public class DaltonismoOp extends BufferedImageOpAdapter{
    /**
     * Componente rojo del pixel.
     */
    int r;
    /**
     * Componente verde del pixel.
     */
    int g;
    /**
     * Componente azul del pixel.
     */
    int b;
    /**
     * Componente rojo con efecto daltonico.
     */
    int DaltR;
    /**
     * Componente verde con efecto daltonico.
     */
    int DaltG;
    /**
     * Componente azul con efecto daltonico.
     */
    int DaltB;
    /**
     * Tipo de daltonismo
     */
    int tipo;
    /**
     * Constructor de la clase.
     */
    public DaltonismoOp (int tipo) {
        this.tipo = tipo;
    }
        
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
                switch (tipo){
                    case 0://Deuteranopia
                        DaltR = (int) min(255, 0.625*r + 0.375*g + 0.0*b);
                        DaltG = (int) min(255, 0.7*r + 0.3*g + 0.0*b);
                        DaltB = (int) min(255, 0.0*r + 0.3*g + 0.7*b);
                        break;
                    case 1://Protanopia
                        DaltR = (int) min(255, 0.567*r + 0.433*g + 0.0*b);
                        DaltG = (int) min(255, 0.558*r + 0.442*g + 0.0*b);
                        DaltB = (int) min(255, 0.0*r + 0.242*g + 0.758*b);
                        break;
                    case 2://Tritanopia
                        DaltR = (int) min(255, 0.95*r + 0.05*g + 0.0*b);
                        DaltG = (int) min(255, 0.0*r + 0.433*g + 0.567*b);
                        DaltB = (int) min(255, 0.0*r + 0.475*g + 0.525*b);
                        break;
                }
                c = new Color(DaltR, DaltG, DaltB);
                src.setRGB(x,y,c.getRGB());
            }
        }
        return dest;
    }
}