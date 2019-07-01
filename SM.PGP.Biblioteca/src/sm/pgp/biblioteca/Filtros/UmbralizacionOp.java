package sm.pgp.biblioteca.Filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase con un unico metodo para aplicar una umbralizacion a una imagen.
 * Extiende de la clase BufferedImageOpAdapter.
 * @author gervi
 */
public class UmbralizacionOp extends BufferedImageOpAdapter{
    private int umbral;
    /**
     * Constructor de la clase.
     * @param umbral: umbral por el que se guia la funcion para aplicar los cambios.
     */
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }
    /**
     * Devuelve una BufferedImage a la que se le a aplicado una umbralizacion.
     * @param src: imagen de origen.
     * @param dest: imagen de destino.
     * @return una BufferedImage a la que se le a aplicado una umbralizacion.
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
                int media = (c.getRed() + c.getBlue() + c.getGreen())/3;
                if (media > umbral){
                    dest.setRGB(x, y, Color.WHITE.getRGB());
                }
                else{
                    dest.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        return dest;
    }
}