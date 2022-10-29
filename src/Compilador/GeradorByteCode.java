package Compilador;

import java.util.ArrayList;
import java.util.List;

public class GeradorByteCode {
	
	public List<String> bytecode;
	public List<String> fonte;
	public boolean jaExisteScanner;
	
	public GeradorByteCode (List<String> fonte) {
		this.fonte = fonte;
	}
	
	public boolean gerar() {
		bytecode = new ArrayList<>();
		for (String linha: fonte) {
			//System.out.println(linha);
			gerarInicio(linha);
			gerarFim(linha);
			gerarInteiro(linha);
			gerarLeia(linha);
			gerarOperadorAritmetica(linha);
			gerarEscreva(linha);
		}
		
		for (String code: bytecode) {
			System.out.println(code);
		}
		return true;
	}
	
	public void gerarInicio(String linha) {
		if (!linha.equals("inicio"))
			return;
	bytecode.add("import java.util.Scanner;");
	bytecode.add(" public class Nome {");
	bytecode.add(" public class static void main(String[] args) {");

	}
	public void gerarFim(String linha) {
		if(!linha.equals("fim"))
		return;
		bytecode.add("}");
		bytecode.add("}");
	}
	
	public void gerarInteiro(String linha) {
		if (!linha.trim().startsWith("inteiro"))
			return;
		
		bytecode.add(linha.replace("inteiro", "int")+";");
	}
	public void gerarLeia(String linha) {
		if(!linha.trim().startsWith("leia"))
			return;
		
		if(!jaExisteScanner) {
			bytecode.add("Scanner teclado = new Scanner();");
			jaExisteScanner = true;		
		}
		
		bytecode.add(linha.trim().replace("leia", "") + "= teclado.next()");
	}
	public void gerarOperadorAritmetica(String linha) {
		if (linha.contains("+") ||
			linha.contains("-") ||
			linha.contains("*") || 
			linha.contains("/") ) {
			bytecode.add(linha+";");
		}
	}
	
	public void gerarEscreva(String linha) {
		if (!linha.trim().startsWith("escreva"))
			return;
		
		bytecode.add(linha.replace("escreva", "System.out.println(")+" );");
		
	}
		
}
