package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StatisticUtil {

	//Cálcula e retorna a média do vetor de inteiros
	public static int average(int[] elements) {
		int sum = 0;
		int qtd = elements.length;
		for(int i =0; i < qtd; i++)
			sum += elements[i];
		return sum/qtd;
	}

	//Cálcula e retorna a moda do vetor de inteiros
	public static int mode(int[] elements) {
		int qtd = elements.length;
		//Calcula a frequencia de repetição dos elementos
		int[] frequency = new int[qtd];
		for (int i = 0; i < qtd; i++) {
			for (int j = 0; j < qtd; j++) {
				if (elements[i] == elements[j])
					frequency[i] += 1;
			}
		}
		//Identifica e qual valor tem a maior frequência de repetição e o retorna como resposta
		int indexAsnwer = 0;
		int highteste = frequency[0];
		for (int i = 0; i < qtd; i++) {
			if (frequency[i] > highteste) {
				highteste = frequency[i];
				indexAsnwer = i;
			}
		}
		return elements[indexAsnwer];
	}

	//Cálcula e retorna a mediana do vetor de inteiros
	public static int median(int[] elements) {
		//Ordena os elementos do vetor de inteiros
		int[] elementsOrdered = Arrays.stream(elements).sorted().toArray();
		if (ArrayLenghIsOdd(elementsOrdered)) //if Odd
			return elementsOrdered[(elementsOrdered.length/2)];
		else {//If pair
			return (elementsOrdered[((elementsOrdered.length/2)-1)]+elementsOrdered[(elementsOrdered.length/2)])/2;
		}
	}

	//Rtorna true se o vetor for ímpar e false se o vetor for par
	private static boolean ArrayLenghIsOdd(int[] array){
		int length = array.length;
		return (length%2!=0)?(true):(false);
	}
}