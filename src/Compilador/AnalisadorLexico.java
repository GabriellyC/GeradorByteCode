package Compilador;

import java.util.List;

public class AnalisadorLexico {

	public AnalisadorLexico() {
		
	}

	public boolean validar (List<String> programa, List<String> alfabeto) {
		
		char letra;
		boolean achou;
		//percorre o vetor de linha
		for(String linha: programa) {
			//percorre cada caracter da linha
			for (int i = 0; i < linha.length(); i++) {
				letra = linha.charAt(0);
				achou =estaNoAlfabeto(letra, alfabeto);
				
				if (!achou) {
					//System.out.println("Não encontrado: " + letra);
				} else {
				
					//System.out.println("Achou");
					
				}
					
		}
		}
		return true;
	}
			
			public boolean estaNoAlfabeto(char letra, List<String> alfabeto) {
				boolean resultado = false;
				String linha = alfabeto.get(0);
				
				for(int i=0;i<linha.length();i++) {
					if (letra == linha.charAt(i)) {
						return true;
					}
				}
				return resultado;
		
	
		}

}





//gabrielly colman