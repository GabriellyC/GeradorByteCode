package Compilador;

import java.util.ArrayList;
import java.util.List;

public class Compilar {
	
	public List<String> programa;
	public List<String> alfabeto;
	public List<String> dicionario;
	public List<String> gramatica;
	
	public Compilar() {
		programa  = new ArrayList();
		alfabeto = new ArrayList();
		dicionario = new ArrayList();	
		gramatica = new ArrayList();	
	}
	
	public void executar() {
		LeitorArquivo leitor = new LeitorArquivo();
		try {
			
			String currentPath = new java.io.File(".").getCanonicalPath();
			System.out.println("Current dir:" + currentPath);
			
			programa = leitor.lerArquivo("arquivos\\cod.txt");
			alfabeto = leitor.lerArquivo("arquivos\\alfabeto.txt");
  		    dicionario = leitor.lerArquivo("arquivos\\dicionario.txt");
  		    gramatica = leitor.lerArquivo("arquivos\\gramatica.txt");
  		    
  		   // leitor.Imprimir(alfabeto);
  		    
  		    AnalisadorLexico lexico = new AnalisadorLexico();
  		    AnalisadorSintatico sintatico = new AnalisadorSintatico();
  		    AnalisadorSemantico semantico = new AnalisadorSemantico();
  		    		
  		    if (lexico.validar(programa, alfabeto)) {
  		    	System.out.println("\nAn�lise L�xica sem erros...");
  		    	
  		    } else {
  		    	System.out.println("\nErro na An�lise L�xica...");
  		    }
  		    	
  		    if (sintatico.validar(programa, gramatica)) {
  			 System.out.println("\nAn�lise Sint�tica sem erros...");
  		    	
  		    } else {
  		    	System.out.println("\nExistem erros na An�lise Sint�tica...");
  		   
  		    }
  		    
  		   if (semantico.validar2(programa, dicionario)) {
   			 System.out.println("\nAn�lise Sem�ntica sem erros...\n");
   		   
   			GeradorByteCode gerador = new GeradorByteCode(programa);
   		   gerador.gerar();
   		    	
		   }  else {
   		    	System.out.println("\nExistem erros na An�lise Sem�ntica...\n");
   		    	return;
   		    }
  		    
  		 
				
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	}





//gabrielly colman