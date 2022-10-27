package br.com.treinamento.conveter;

import org.springframework.stereotype.Component;

import jakarta.persistence.Converter;

@Component
public class MathConverter {
	
	
	
  public static Double convertToDouble(String numberOne) {
		if(numberOne ==  null) return 0D;
		
		String number = numberOne.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
		
	}

	public static boolean isNumeric(String numberOne) {
	 if(numberOne == null) return false;
	 String number = numberOne.replaceAll(",", ".");
	 return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}

	
}
