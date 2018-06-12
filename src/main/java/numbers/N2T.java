package numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N2T {

	private long numb;

	public static String format(long number) {
		return new N2T(number).format();
	}
	
	public N2T(long numb){
		this.numb = numb;
	}
	
	public String format() {
		StringBuffer words = new StringBuffer();
		
		List<Integer> listNumbers = getIndividualNumbers();
		List<String> wordParts = new ArrayList<String>();
		boolean showZeros = listNumbers.size()==1;
		
		int exp = 0;
		for (Integer cientos: listNumbers) {
			String numberWords = convertToWords(cientos, exp++, showZeros);
			wordParts.add(numberWords);
		}
		Collections.reverse(wordParts);
		for (String part : wordParts) {
			words.append(part+' ');
		}
		return words.toString().trim();
	}
	
	@Override
	public String toString() {
		return numb +": "+ format();
	}
	

	private String convertToWords(int cientos, int exponencial, boolean showZeros) {
		String result = "";
		
		if (cientos == 0 && !showZeros) {
			return result;
		}
		
		int tempVal = cientos;
		
		if (exponencial>0 && tempVal == 1) {
			return EXPONENCIALES_SING.get(exponencial);
		}
		if (tempVal == 100) {
			result = CENTESIMOS.get(0);
		} else {
			if (tempVal >= 100) {
				int centena = tempVal / 100;
				result += CENTESIMOS.get(centena) + ' ';
				tempVal = tempVal % 100;
			}
			
			if ((tempVal==21 || tempVal == 1) && exponencial > 0) {
				result += EXCEPTION_DIGITS.get(tempVal);
			} else if (tempVal<30) {
				result += UNIDADES.get(tempVal);
			} else {
				int decimos = tempVal / 10;
				result += DECIMOS.get(decimos);
				
				tempVal = tempVal%10;
				if (tempVal==1 && exponencial > 0) {
					result += EXCEPTION_DIGITS.get(tempVal);
				} else 
				if (tempVal>0) {
					result+=" y "+ UNIDADES.get(tempVal);
				}
			}
		}		
		return result + EXPONENCIALES.get(exponencial);
	}
	
	private List<Integer> getIndividualNumbers() {
		List<Integer> listNumber = new ArrayList<Integer>();
		
		long tempVal = this.numb;
		
		if (tempVal == 0) {
			listNumber.add(0);
		}
		
		while (tempVal > 0) {
			int digit = (int)(tempVal % 1000);
			listNumber.add(digit);
			tempVal = tempVal / 1000;
		}
		
		//Collections.reverse(listNumber);
		
		return listNumber;
	}
	
	@SuppressWarnings("serial")
	public static Map<Integer,String> DECIMOS = new HashMap<Integer, String> (){{
		put(3, "treinta");
		put(4, "cuarenta");
		put(5, "cincuenta");
		put(6, "sesenta");
		put(7, "setenta");
		put(8, "ochenta");
		put(9, "noventa");	
	}};
	
	@SuppressWarnings("serial")
	public static Map<Integer,String> UNIDADES = new HashMap<Integer, String> (){{
		put(0, "cero");
		put(1, "uno");
		put(2, "dos");
		put(3, "tres");
		put(4, "cuatro");
		put(5, "cinco");
		put(6, "seis");
		put(7, "siete");
		put(8, "ocho");
		put(9, "nueve");
		put(10, "diez");
		
		put(11, "once");
		put(12, "doce");
		put(13, "trece");
		put(14, "catorce");
		put(15, "quince");
		put(16, "dieciseis");
		put(17, "diecisiete");
		put(18, "dieciocho");
		put(19, "diecinueve");
		put(20, "veinte");
		
		put(21, "veintiuno");
		put(22, "veintidos");
		put(23, "veintitres");
		put(24, "veinticuatro");
		put(25, "veinticinco");
		put(26, "veintiseis");
		put(27, "veintisiete");
		put(28, "veintiocho");
		put(29, "veintinueve");
	}};
	
	
	@SuppressWarnings("serial")
	public static Map<Integer,String> CENTESIMOS = new HashMap<Integer, String> (){{
		put(0, "cien");
		put(1, "ciento");
		put(2, "doscientos");
		put(3, "trescientos");
		put(4, "cuatrocientos");
		put(5, "quinientos");
		put(6, "seiscientos");
		put(7, "setesientos");
		put(8, "ochocientos");
		put(9, "novecientos");
	}};
	
	@SuppressWarnings("serial")
	public static Map<Integer,String> EXPONENCIALES = new HashMap<Integer, String> (){{
		put(0, "");
		put(1, " mil");
		put(2," millones");
		put(3, " billones");
		put(4, " trillones");
		put(5, " cuatrillones");
		put(6, " quintillones");
		put(7, " sextillones");
		put(8, " septillones");
	}};
	
	@SuppressWarnings("serial")
	public static Map<Integer,String> EXPONENCIALES_SING = new HashMap<Integer, String> (){{
		put(0, "");
		put(1, "un mil");
		put(2,"un millón");
		put(3, "un billón");
		put(4, "un trillón");
		put(5, "un cuatrillón");
		put(6, "un quintillón");
		put(7, "un sextillón");
		put(8, "un septillón");
	}};
	
	@SuppressWarnings("serial")
	public static Map<Integer,String> EXCEPTION_DIGITS = new HashMap<Integer, String>(){{
		put(1, "un");
		put(21, "ventiun");
	}};

}
