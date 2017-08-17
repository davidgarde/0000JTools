package es.dg.avan.jtools.control.images;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import es.dg.avan.jtools.exceptions.AvanToolException;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class FileBidiGeneratorUtil {
	
	public static void generateBIDIReserve(String url, String realpath) throws AvanToolException {
		ByteArrayOutputStream out = QRCode.from(url).to(ImageType.PNG).withSize(180,180).stream();
		try {
			FileOutputStream fout = new FileOutputStream(new File(realpath));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close();
		} catch (Exception e){
			throw new AvanToolException("ERROR: generateBIDIReserve " + e.toString());
		}
	}

}
