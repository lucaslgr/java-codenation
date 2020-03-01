package challenge;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	static List<Jogador> jogadores = new ArrayList<>();

	//Construtor
	public Main(){
		this.loadCSV2ListJogadores();
	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return Main.jogadores
				.stream()
				.collect(Collectors.groupingBy(Jogador::getNationality))
				.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return 0;
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return null;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return null;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}


	private void loadCSV2ListJogadores(){
		try {
			//Instanciando um File
			File file = new File(getClass().getClassLoader().getResource("data.csv").getFile());
			//pula o cabeçalho do .csv e vai adicionando instancia dos jogadores
			Files.lines(file.toPath()).skip(1).limit(10).forEach(l -> {
				String[] col = l.split(",");
				Main.jogadores.add(	new Jogador(
										col[14], col[13], col[2],
										new BigDecimal(col[18].length() > 0 ? col[18] : "0.0"),
										LocalDate.parse(col[8]) , new BigDecimal(col[17]),
										Integer.parseInt(col[6]))
				);
			});
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	//Método principal para teste
	public static void main(String[] agrs){
		Main core = new Main();
		Main.jogadores.stream().limit(10).forEach(j -> {
			System.out.println(j.toString());
		});
	}
}
