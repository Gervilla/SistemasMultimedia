package sm.pgp.biblioteca;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que hereda de FileFilter y que nos permite filtar archivos por su extension.
 * @author gervi
 */
public class FileFilterExtension extends FileFilter{
    
    private final String extension;
    private final String descripcion;
    /**
     * Constructor por defecto de la clase.
     * @param extension: extension del archivo.
     * @param description: descripcion del tipo de extension.
     */
    public FileFilterExtension(String extension, String description){
        this.extension = extension;
        this.descripcion = description;
    }
    /**
     * Acepta las carpetas y los archivos de la extension del objeto.
     * @param file: archico a comprobar.
     * @return si se acepta o no el archivo.
     */
    @Override
    public boolean accept(File file){
        if (file.isDirectory()){
            return true;
        }

        return file.getName().endsWith(extension);
    }
    /**
     * Devuelve un String con la descripcion del archivo junto a su extension.
     * @return la descripcion del archivo junto a su extension.
     */
    @Override
    public String getDescription(){
        return descripcion + String.format(" (*%s)", extension);
    }
    /**
     * Devuelve un String con la extension del objeto.
     * @return la extension del objeto.
     */
    public String getExtension(){
        return extension;
    }
}
