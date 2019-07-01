/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.pgp.biblioteca.Filtros;

import java.awt.Color;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author gervi
 */
public class ColorizacionOp extends BufferedImageOpAdapter{
    private int color;
    /**
     * Constructor de la clase.
     * @param color: umbral por el que se guia la funcion para aplicar los cambios.
     */
    public ColorizacionOp(int color) {
        this.color = color;
    }
    /**
     * Devuelve una BufferedImage a la que se le han eliminado los colores menos el seleccionado y se le ha aplicado una umbralizacion del 50%.
     * @param src: imagen de origen.
     * @param dest: imagen de destino.
     * @return una BufferedImage a la que se le a la que se le han eliminado los colores menos el seleccionado y se le ha aplicado una umbralizacion del 50%.
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

        for(int i=0; i < src.getRaster().getNumBands(); i++){
            int bandaActual[] = {i}; 
            WritableRaster bandRaster = (WritableRaster)src.getRaster().createWritableChild(0, 0, src.getWidth(), src.getHeight(), 0, 0, bandaActual);
            BufferedImage imgBanda = new BufferedImage(cm, bandRaster, false, null);
            
            if (i != color){
                for (int x = 0; x < imgBanda.getWidth(); x++) {
                    for (int y = 0; y < imgBanda.getHeight(); y++)
                        imgBanda.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
            else{
                for (int x = 0; x < imgBanda.getWidth(); x++) {
                    for (int y = 0; y < imgBanda.getHeight(); y++) {
                        Color c = new Color(imgBanda.getRGB(x, y));
                        int media = (c.getRed() + c.getBlue() + c.getGreen())/3;
                        if (media > 155){
                            imgBanda.setRGB(x, y, Color.WHITE.getRGB());
                        }
                        else{
                            imgBanda.setRGB(x, y, Color.BLACK.getRGB());
                        }
                    }
                }
            }
        }
        return src;
    }
}
