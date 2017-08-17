package es.dg.avan.jtools.control.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class FileNameFilterUtil implements FilenameFilter {
	
	private static FileNameFilterUtil instance;
	//Logger de gestion de alojamientos
	static Logger log = Logger.getLogger(FileNameFilterUtil.class.getName());
    
    private FileNameFilterUtil(){}
     
    public static synchronized FileNameFilterUtil getInstance(){
        if(instance == null){
            instance = new FileNameFilterUtil();
        }
        return instance;
    }
	
	
	public static final String[] EXTENSIONS = new String[]{
        "gif", "png", "jpg"
    };
    
    @Override
    public boolean accept(final File dir, final String name) {
        for (final String ext : EXTENSIONS) {
            if (name.endsWith("." + ext)) {
                return (true);
            }
        }
        return (false);
    }
    
    //obtencion de las imagenes desde path del alojamiento
    public static String[] getUrlsOfImagesOnFolder(String urlInit,String codigoAlojamiento, Calendar fcreaaloja, File dirOrigen, String noimageName){
    	ArrayList<String> resultado = new ArrayList<String>();
    	if (dirOrigen.isDirectory()) { // make sure it's a directory
            for (final File f : dirOrigen.listFiles(getInstance())) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
                   log.debug("image: " + f.getName());
                   log.debug(" width : " + img.getWidth());
                   log.debug(" height: " + img.getHeight());
                   log.debug(" size  : " + f.length());
                   String mes = Integer.toString(fcreaaloja.get(Calendar.MONTH)+1);
                   if (mes.length()==1){mes = "0".concat(mes);}
                   String diames = Integer.toString(fcreaaloja.get(Calendar.DAY_OF_MONTH));
                   if (diames.length()==1){diames = "0".concat(diames);}
                    resultado.add(urlInit.concat("/").concat(String.valueOf(fcreaaloja.get(Calendar.YEAR))).concat("/").concat(mes).concat("/").concat(diames).concat("/").concat(codigoAlojamiento).concat("/").concat(f.getName()));
                } catch (final IOException e) {
                	log.error("Error en la lectura de imagen de alojamiento interno");
                }
            }
            if (resultado.size()==0){
            	//devolver la imagen por defecto pork no se han encontrado imagenes
            	 resultado.add(urlInit.concat("/").concat(noimageName));
            }
            return resultado.toArray(new String[resultado.size()]);
        } else {
        	return new String[]{};
        }
    }
};
