package projeto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
	
	/*
	 * Você foi designado para implementar um sistema de registro de números sorteados 
	 * em um jogo de bingo. Para isso, deve-se desenvolver uma estrutura de dados que 
	 * permita armazenar eficientemente os números sorteados em determinado sorteio, 
	 * considerando que cada cartela de bingo contém uma quantidade específica de 
	 * números (por exemplo, 100 ou 1000 números). O sistema deve ser capaz de lidar 
	 * com um grande volume de números que podem ser sorteados no bingo (de 1 a 100
	 * milhões) e permitir consultas rápidas para verificar se um número já foi sorteado.
	 */

	public static void main(String[] args) throws Exception {
		
		// Definindo 100 milhões de números para serem armazenados e procurados
		int quantNumSort = 100_000_000;
		
		/*
		 * Considerando os conceitos estudados nas disciplinas “Estrutura de Dados” e
		 * “Laboratório de Estrutura de Dados”, elabore um projeto em Java que utilize uma 
		 * tabela hash com tratamento de colisão via endereçamento fechado. Varie a maneira 
		 * de tratamento de colisão, utilizando implementações disponíveis em Java: ArrayList, 
		 * LinkedList e TreeSet.
		 */
		
		/*
		 * OBS: Utilizei uma instância do tipo da tabela hash em cada construtor apenas para
		 * eles serem criados da maneira certa, de acordo com o seu tipo, e fazer apenas uma
		 * classe de TabelaHash
		 */
		
		// CRIAÇÃO DE TABELA HASH DE ARRAYLIST
		ArrayList<Integer> verificarAL = new ArrayList<Integer>();
		TabelaHash tabelaArrayList = new TabelaHash(11, verificarAL);
		
		// CRIAÇÃO DE TABELA HASH DE LINKEDLIST
		LinkedList<Integer> verificarLL = new LinkedList<Integer>();
		TabelaHash tabelaLinkedList = new TabelaHash(11, verificarLL);
		
		// CRIAÇÃO DE TABELA HASH DE LINKEDLIST
		TreeSet<Integer> verificarTS = new TreeSet<Integer>();
		TabelaHash tabelaTreeSet = new TabelaHash(11, verificarTS);
		
	}

}
