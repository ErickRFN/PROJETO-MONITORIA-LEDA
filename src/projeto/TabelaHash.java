package projeto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class TabelaHash {
	
	// Criando os tipos de tabelas possíveis
	protected ArrayList<Integer>[] tabelaArrayList;
	protected LinkedList<Integer>[] tabelaLinkedList;
	protected TreeSet<Integer>[] tabelaTreeSet;
	
	// Determinando o tamanho
	protected int tamanho;
	
	// Determinando os construtores:
	// 1- Construtor da Tabela ArrayList
	@SuppressWarnings("unchecked")
	public TabelaHash(int tam, ArrayList<Integer> verificar) {
		this.tamanho = tam;
		this.tabelaArrayList = (ArrayList<Integer>[]) new ArrayList[tam];
		
		int i;
		for(i = 0; i < this.tamanho; i++) {
			this.tabelaArrayList[i] = new ArrayList<Integer>();
		}
	}
	
	
	// 
	public void insertTabArrayList(Integer numero) {
		tabelaArrayList[numero % this.tamanho].add(numero);
	}
	
	public int searchTabArrayList(Integer numero) throws Exception {
		int resposta = tabelaArrayList[numero % this.tamanho].indexOf(numero);
		
		if(resposta != -1) {
			System.out.println(numero);
			return resposta;
		}else {
			throw new Exception("ELEMENTO NÃO ENCONTRADO");
		}
		
	}
	
	
	
}
