package br.com.kthanasio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestQuebraStringsCamelCase {

	@Test
	void testSimpleString () {
		String input = "nome";
		String expected = "nome";
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result.get(0));
	}
	
	@Test
	void testSimpleStringCapitalizedStart () {
		String input = "Nome";
		String expected = "nome";
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result.get(0));
	}

	@Test
	void testCompoundString () {
		String input = "nomeComposto";
		List<String> expected = new ArrayList<String>();
		expected.add("nome");
		expected.add("composto");
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result);
	}

	@Test
	void testCompoundStringCapitalStarts () {
		String input = "NomeComposto";
		List<String> expected = new ArrayList<String>();
		expected.add("nome");
		expected.add("composto");
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result);
	}
	@Test
	void testCPF () {
		String input = "CPF";
		List<String> expected = new ArrayList<String>();
		expected.add("CPF");
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result);
	}
	
	@Test
	void testStringAndCPF () {
		String input = "numeroCPF";
		List<String> expected = new ArrayList<String>();
		expected.add("numero");
		expected.add("CPF");
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result);
	}
	@Test
	void testStringAndCPFContribuinte () {
		String input = "numeroCPFContribuinte";
		List<String> expected = new ArrayList<String>();
		expected.add("numero");
		expected.add("CPF");
		expected.add("contribuinte");
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result);
	}
	
	@Test
	void testRecupera10Primeiros () {
		String input = "recupera10Primeiros";
		List<String> expected = new ArrayList<String>();
		expected.add("recupera");
		expected.add("10");
		expected.add("primeiros");
		List<String> result = QuebraStringsCamelCase.converterCamelCase(input);
		assertEquals(expected, result);
	}
	@Test
	void testInvalidInputException () {
		String input = "10Primeiros";
		
		InvalidInputException thrown = Assertions.assertThrows(InvalidInputException.class, () -> {
			QuebraStringsCamelCase.converterCamelCase(input);
		});

		Assertions.assertEquals("Não pode iniciar com números.", thrown.getMessage());
	}
	
	@Test
	void testInvalidInputExceptionSpecial () {
		String input = "nome#Composto";
		
		InvalidInputException thrown = Assertions.assertThrows(InvalidInputException.class, () -> {
			QuebraStringsCamelCase.converterCamelCase(input);
		});

		Assertions.assertEquals("Não pode conter caracteres especiais.", thrown.getMessage());
	}
	

}
