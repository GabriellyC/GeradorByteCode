package Compilador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

	public LeitorArquivo() {
		
		}
				


	public List<String> lerArquivo (String nomeArquivo){
	
		
		List<String> conteudo = new ArrayList();
		String linha;
		
		try {
		FileReader leitor = new FileReader (nomeArquivo);
		BufferedReader buffer = new BufferedReader(leitor);
		
		while ((linha = buffer.readLine()) != null) {
			conteudo.add(linha);
		}
		buffer.close();
		leitor.close();
		
	} catch (Exception e){
		System.out.println("Erro:" + e.getMessage());
	}
		return conteudo;
}

		public void Imprimir( List<String> conteudo) {
			for ( int i = 0; i < conteudo.size(); i++) {
				System.out.println(conteudo.get(i));
				
			}
		}					
}








//gabrielly colman