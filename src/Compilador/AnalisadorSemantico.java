package Compilador;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorSemantico {
	public List<String> tbSimbolos;
	
	public AnalisadorSemantico () {
		tbSimbolos = new ArrayList();
	}

// do professor em aula 
	
	public Boolean validar2(List<String> programa, List<String> dicionario)
	{
		Boolean res = true;
		
		for(String linha: programa) 
		{
			if (!validarlinha(linha, dicionario))
				return false;
			
		}
		
		
		return res;
	}
	
	public Boolean validarlinha(String linha, List<String> dicionario)
	{
		boolean resultado = true;
		
		String[] tokens = linha.trim().split(" ");
		
		for (String token: tokens)
		{
			if(token.equals("inteiro"))
			{
				adicionartbSimbolos(tokens[1]);				
			}else if (token.startsWith("\"")|| token.startsWith("'")) 
			{
				return true;
			}
			else 
			{
				if(!estaNoDicionario(token, dicionario))
				{
					if(token.matches("^[a-z][0-9a-z]{0,30}$"))
					{
						if(!estaNaTabelaSimbolos(token))
						{
							System.out.println("Variavel nao declarada:"+token);
						}
					}
				}
			}
			
		}
		
		return resultado;
	}
	
	public Boolean estaNoDicionario(String token, List<String> dicionario)
	{
		return dicionario.contains(token);
	}
	
	public void adicionartbSimbolos(String token)
	{
		 this.tbSimbolos.add(token);
	}
	
	public Boolean estaNaTabelaSimbolos(String token)
	{
		return tbSimbolos.contains(token);
	}
	
}
	//MEU
	
	//public Boolean validar(List<String> programa, List<String> dicionario)
	//{
		//Boolean res = true;
		
		//for(String linha: programa)
		//{
			//String[] linhaSeparada = linha.trim().split(" ");
			
			//for(String token: linhaSeparada)
			//{
				//if(dicionario.contains(token))
			//	{
				//	System.out.println("Palavra Reservada: " + token);
			//	}
			//	else
			//	{
			//		System.out.println("Variavel: " + token);
				//	res = false;
				//}
			//}
		//}
	///	return res;
	//}
	
	//}
