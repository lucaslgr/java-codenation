package challenge;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	List<Jogador> jogadores = this.loadCSV2ListJogadores();

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return this.jogadores
				.stream()
				.collect(Collectors.groupingBy(Jogador::getNationality))
				.size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return this.jogadores
				.stream()
				.filter(j -> !j.getClub().isEmpty()) //O grupo de club vazio conta como +1, logo poderia apenas subtrair 1 no final
				.collect(Collectors.groupingBy(Jogador::getClub))
				.size();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return this.jogadores
					.stream()
					.limit(20)
					.map(Jogador::getFullname)
					.collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4(){
		return this.jogadores
					.stream()
					.sorted(Comparator.comparing(Jogador::getEur_release_clause).reversed())
					.limit(10)
					.map(Jogador::getFullname)
					.collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return this.jogadores
					.stream()
					.sorted(Comparator.comparing(Jogador::getBirth_date)
						.thenComparing(Comparator.comparing(Jogador::getEur_wage)))
					.limit(10)
					.map(Jogador::getFullname)
					.collect(Collectors.toList());

	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return this.jogadores
				.stream()
				.map(j -> j.getAge())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.collect(Collectors.toMap(
						e -> Integer.parseInt(e.getKey().toString()),
						e -> Integer.parseInt(e.getValue().toString())
				));
	}

	private List<Jogador> loadCSV2ListJogadores(){
		List<Jogador> jogadores = new ArrayList<>();
		try {
			//Instanciando um File
			File file = new File(getClass().getClassLoader().getResource("data.csv").getFile());
			//pula o cabeçalho do .csv e vai adicionando instancia dos jogadores
			Files.lines(file.toPath()).skip(1).forEach(l -> {
				String[] col = l.split(",");
				jogadores.add(	new Jogador(
										col[14],
										col[3],
										col[2],
										new BigDecimal(col[18].length() > 0 ? col[18] : "0.0"),
										LocalDate.parse(col[8]),
										new BigDecimal(col[17]),
										Integer.parseInt(col[6]))
				);
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jogadores;
	}

	//Método principal para teste
	public static void main(String[] agrs){
		Main core = new Main();
//		core.jogadores.stream().limit(10).forEach(j -> {
//			System.out.println(j.toString());
//		});

//		System.out.println("Challenge Tasks: ");
//		System.out.println("Q1: "+ core.q1());
		System.out.println("Q2: "+ core.q2());
//		System.out.println("Q3: "+ core.q3());
//		System.out.println("Q4: "+ core.q4());
//		System.out.println("Q5: "+ core.q5());
//		System.out.println("Q6: "+ core.q6());
//		core.q3().stream().forEach(j ->
//		{
//			System.out.println(j);
//		});
	}
}
