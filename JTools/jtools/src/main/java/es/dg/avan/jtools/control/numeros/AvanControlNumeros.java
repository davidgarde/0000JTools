package es.dg.avan.jtools.control.numeros;

import java.util.Random;

public class AvanControlNumeros {

	public static int getEnteroEntreRango(int min, int max) {
		Random rand = new Random();
		return min + rand.nextInt(max);
	}
	
	public static String getCurrency(Float number) {
	  float epsilon = 0.004f; // 4 tenths of a cent
	  if (Math.abs(Math.round(number) - number) < epsilon) {
	     return String.format("%10.0f", number); // sdb
	  } else {
	     return String.format("%10.2f", number); // dj_segfault
	  }
	}


}
