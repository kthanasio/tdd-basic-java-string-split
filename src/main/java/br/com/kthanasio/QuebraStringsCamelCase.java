package br.com.kthanasio;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuebraStringsCamelCase {
	private final static String regexPattern = "(?=\\p{Lu})|(?=1)";
	
	public static List<String> converterCamelCase(String original) {
		List<String> result = new ArrayList<String>();
		original = validate(original);
		for (String row : original.split(regexPattern)) {
			result.add(generateResult(row));
		}
		return result;
	}
	
	private static String generateResult(String row) {
		if (row.equals("Cpf")) { 
			return row.toUpperCase();
		}
		else  {
			return row.toLowerCase();
		}
	}
	
	private static String validate(String original) {
		original = original.replace("CPF", "Cpf");
		if (Character.isDigit(original.charAt(0))) {
			throw new InvalidInputException("Não pode iniciar com números."); 
		}
		Pattern specialCharPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher specialCharMacher = specialCharPattern.matcher(original);
		if (specialCharMacher.find())
		   throw new InvalidInputException("Não pode conter caracteres especiais.");
		return original;
	}

}
