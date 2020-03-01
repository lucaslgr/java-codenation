package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {
	public static List<Integer> serieF;

	public static List<Integer> fibonacci() {
		serieF = new ArrayList<Integer>();
		serieF.add(0);
		serieF.add(1);

		int index = 1;
		while(serieF.get(index) < 350){
			serieF.add(serieF.get(index) + serieF.get(index-1));
			index ++;
		}
		return serieF;
	}

	public static Boolean isFibonacci(Integer a) {
		return (serieF.contains(a));
	}
}