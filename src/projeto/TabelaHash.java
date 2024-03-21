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
	
	// 2- Construtor da Tabela LinkedList
	@SuppressWarnings("unchecked")
	public TabelaHash(int tam, LinkedList<Integer> verificar) {
		this.tamanho = tam;
		this.tabelaLinkedList = (LinkedList<Integer>[]) new LinkedList[tam];
		
		int i;
		for(i = 0; i < this.tamanho; i++) {
			this.tabelaLinkedList[i] = new LinkedList<Integer>();
		}
	}
	
	// 3- Construtor da Tabela TreeSet
	@SuppressWarnings("unchecked")
	public TabelaHash(int tam, TreeSet<Integer> verificar) {
		this.tamanho = tam;
		this.tabelaTreeSet = (TreeSet<Integer>[]) new TreeSet[tam];
		
		int i;
		for(i = 0; i < this.tamanho; i++) {
			this.tabelaTreeSet[i] = new TreeSet<Integer>();
		}
	}
	
	/*
	 * MÉTODOS INSERT E SEARCH DE CADA ESTRUTURA
	 */
	
	// Insert e Search ArrayList
	public void insertTabArrayList(Integer numero) {
		this.tabelaArrayList[numero % this.tamanho].add(numero);
	}
	
	public int searchTabArrayList(Integer numero) throws Exception {
		int resposta = this.tabelaArrayList[numero % this.tamanho].indexOf(numero);
		
		if(resposta != -1) {
			return numero;
		}else {
			throw new Exception("ELEMENTO NÃO ENCONTRADO");
		}
		
	}
	
	// Insert e Search LinkedList
	public void insertTabLinkedList(Integer numero) {
		this.tabelaLinkedList[numero % this.tamanho].add(numero);
	}
	
	public int searchTabLinkedList(Integer numero) throws Exception {
		int resposta = this.tabelaLinkedList[numero % this.tamanho].indexOf(numero);
		
		if(resposta != -1) {
			return numero;
		}else {
			throw new Exception("ELEMENTO NÃO ENCONTRADO");
		}
		
	}
	
	// Insert e Search TreeSet
	public void insertTabTreeSet(Integer numero) {
		this.tabelaTreeSet[numero % this.tamanho].add(numero);
	}
	
	public int searchTabTreeSet(Integer numero) throws Exception {
		boolean resposta = this.tabelaTreeSet[numero % this.tamanho].contains(numero);
		
		if(resposta) {
			System.out.println(numero);
			return numero;
		}else {
			throw new Exception("ELEMENTO NÃO ENCONTRADO");
		}
		
	}
	
}
