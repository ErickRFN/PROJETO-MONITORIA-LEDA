package projeto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
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

	public static void main(String[] args) {
		
		// Definindo tamanho da cartela do bingo
		int cartelaBingo = 500_000;
		
		/*
		 * Considerando os conceitos estudados nas disciplinas “Estrutura de Dados” e
		 * “Laboratório de Estrutura de Dados”, elabore um projeto em Java que utilize uma 
		 * tabela hash com tratamento de colisão via endereçamento fechado. Varie a maneira 
		 * de tratamento de colisão, utilizando implementações disponíveis em Java: ArrayList, 
		 * LinkedList e TreeSet.
		 */
		
		/*
		 * No tamanho das tabelas defini o número primo 211, na expectativa de que a tabela cumpra
		 * sua característica de dividir os números quase que igualmente entre todas as suas
		 * células, o que ficaria cerca de 2.370 números para cada uma.
		 */
		int tamanhoTab = 211;
		
		/*
		 * OBS: Utilizei uma instância do tipo da tabela hash em cada construtor apenas para
		 * eles serem criados da maneira certa, de acordo com o seu tipo, e fazer apenas uma
		 * classe de TabelaHash
		 */
		
		// CRIAÇÃO DE TABELA HASH DE ARRAYLIST
		ArrayList<Integer> verificarAL = new ArrayList<Integer>();
		TabelaHash tabelaArrayList = new TabelaHash(tamanhoTab, verificarAL);
		
		// CRIAÇÃO DE TABELA HASH DE LINKEDLIST
		LinkedList<Integer> verificarLL = new LinkedList<Integer>();
		TabelaHash tabelaLinkedList = new TabelaHash(tamanhoTab, verificarLL);
		
		// CRIAÇÃO DE TABELA HASH DE LINKEDLIST
		TreeSet<Integer> verificarTS = new TreeSet<Integer>();
		TabelaHash tabelaTreeSet = new TabelaHash(tamanhoTab, verificarTS);
		
		// INÍCIO DA EXECUÇÃO
		System.out.println("<---> EXECUÇÃO <--->\n");
		
		// INÍCIO INSERT
		System.out.println("*** INSERINDO 500.000 NÚMEROS ALEATÓRIOS NA\n CARTELA"
				+ " EM UM INTERVALO DE 1 A 100 MILHÕES ***\n");
		
		/*
		 * Implementação abaixo garante que todos os números da tabela
		 * serão randômicos e únicos, além de os mesmos para todas as tabelas
		 */
		// Classe Random
		Random random = new Random();
		
		ArrayList<Integer> cartelaCompleta = new ArrayList<Integer>();
		
		while(cartelaCompleta.size() < cartelaBingo) {
			cartelaCompleta.add(random.nextInt(100_000_000) + 1);
		}
		
		// Insert tabela de ArrayList
		long inicio, fim;
		double tempo = 0;
		int i = 0;
		for(i = 0; i < cartelaBingo; i++) {
			inicio = System.nanoTime();
			tabelaArrayList.insertTabArrayList(cartelaCompleta.get(i));
			fim = System.nanoTime();
			tempo += (fim-inicio) / 1_000_000_000.0;
		}
		
		System.out.println("# TABELA HASH - INSERT ARRAYLIST");
		System.out.printf("-> Tempo total em segundos: %.10f\n",tempo);
		System.out.printf("-> Tempo médio em segundos: %.10f\n\n",tempo / cartelaBingo);
		
		// Insert tabela de LinkedList
		tempo = 0;
		for(i = 0; i < cartelaBingo; i++) {
			inicio = System.nanoTime();
			tabelaLinkedList.insertTabLinkedList(cartelaCompleta.get(i));
			fim = System.nanoTime();
			tempo += (fim-inicio) / 1_000_000_000.0;
		}
		
		System.out.println("# TABELA HASH - INSERT LINKEDLIST");
		System.out.printf("-> Tempo total em segundos: %.10f\n",tempo);
		System.out.printf("-> Tempo médio em segundos: %.10f\n\n",tempo / cartelaBingo);
		
		// Insert tabela de TreeSet
		tempo = 0;
		for(i = 0; i < cartelaBingo; i++) {
			inicio = System.nanoTime();
			tabelaTreeSet.insertTabTreeSet(cartelaCompleta.get(i));
			fim = System.nanoTime();
			tempo += (fim-inicio) / 1_000_000_000.0;
		}
		
		System.out.println("# TABELA HASH - INSERT TREESET");
		System.out.printf("-> Tempo total em segundos: %.10f\n",tempo);
		System.out.printf("-> Tempo médio em segundos: %.10f\n\n",tempo / cartelaBingo);
		
		// INÍCIO SEARCH
		System.out.println("*** PROCURANDO 2.000.000 DE NÚMEROS SORTEADOS NA\n CARTELA"
				+ " EM UM INTERVALO DE 1 A 100 MILHÕES ***\n");
		int quantNumSorteados = 2_000_000;
		
		/*
		 * Implementação abaixo garante que todos os números sorteados
		 * serão randômicos e únicos, além de os mesmos para todas as tabelas
		 */
		// Classe Random
		
		ArrayList<Integer> numerosSorteadosList = new ArrayList<Integer>();
		
		while(numerosSorteadosList.size() < quantNumSorteados) {
			numerosSorteadosList.add(random.nextInt(100_000_000) + 1);
		}
		
		// Search tabela de ArrayList
		tempo = 0;
		for(i = 0; i < quantNumSorteados; i++) {
			inicio = System.nanoTime();
			tabelaArrayList.searchTabArrayList(numerosSorteadosList.get(i));
			fim = System.nanoTime();
			tempo += (fim-inicio) / 1_000_000_000.0;
		}
		
		System.out.println("# TABELA HASH - SEARCH ARRAYLIST");
		System.out.printf("-> Tempo total em segundos: %.10f\n",tempo);
		System.out.printf("-> Tempo médio em segundos: %.10f\n\n",tempo / quantNumSorteados);
		
		// Search tabela de LinkedList
		tempo = 0;
		for(i = 0; i < quantNumSorteados; i++) {
			inicio = System.nanoTime();
			tabelaLinkedList.searchTabLinkedList(numerosSorteadosList.get(i));
			fim = System.nanoTime();
			tempo += (fim-inicio) / 1_000_000_000.0;
		}
		
		System.out.println("# TABELA HASH - SEARCH LINKEDLIST");
		System.out.printf("-> Tempo total em segundos: %.10f\n",tempo);
		System.out.printf("-> Tempo médio em segundos: %.10f\n\n",tempo / quantNumSorteados);
		
		// Search tabela de TreeSet
		tempo = 0;
		for(i = 0; i < quantNumSorteados; i++) {
			inicio = System.nanoTime();
			tabelaTreeSet.searchTabTreeSet(numerosSorteadosList.get(i));
			fim = System.nanoTime();
			tempo += (fim-inicio) / 1_000_000_000.0;
		}
		
		System.out.println("# TABELA HASH - SEARCH TREESET");
		System.out.printf("-> Tempo total em segundos: %.10f\n",tempo);
		System.out.printf("-> Tempo médio em segundos: %.10f\n\n",tempo / quantNumSorteados);
		
	}

}
