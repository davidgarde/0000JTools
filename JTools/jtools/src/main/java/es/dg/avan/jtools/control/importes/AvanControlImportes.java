package es.dg.avan.jtools.control.importes;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class AvanControlImportes {
	
	public static String getDecimalFormat2DecimalPositions(float importe){
		BigDecimal bdecimal = new BigDecimal(importe);
		return getBigDecimalValue(bdecimal);
	}

	protected static String getBigDecimalValue(BigDecimal input) {
	    final NumberFormat numberFormat = NumberFormat.getNumberInstance();
	    numberFormat.setGroupingUsed(true);
	    numberFormat.setMaximumFractionDigits(2);
	    numberFormat.setMinimumFractionDigits(2);
	    return numberFormat.format(input);
	}
}
