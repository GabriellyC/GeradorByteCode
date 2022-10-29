package Compilador;

import java.util.List;

public class AnalisadorSintatico {


	public AnalisadorSintatico () {
		
	}
	
	public Boolean validar (
			List<String> cod,
			List<String> gramatica) 
	{
		
		Boolean valido;
		Boolean res = true;
		
		int numeroLinha = 1;
		for ( String linha: cod) {
			
			
			if (validarLinha(linha, gramatica)) {
				//System.out.println("Analisando linha: " + numeroLinha + ": "+linha);
				valido = true;
				
			} else {
				valido = false;
			}
			if(!valido) {
				//System.out.println("Erro de syntax na linha: " + numeroLinha + ": "+linha);
				res = false;
			}
			
			numeroLinha++;
		}
		return res;
		
	
}
	public Boolean validarLinha(String linha, List<String> gramatica) 
	{
		for (String regra: gramatica) 
		{
			if(linha.trim().matches(regra)) {
				return true;
			}
		}
	
		return false;
	}
}