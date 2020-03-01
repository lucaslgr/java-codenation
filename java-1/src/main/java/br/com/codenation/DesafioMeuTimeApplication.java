package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	List<Time> times = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();

	//Realiza a inclusão de um novo time.
	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		//Caso o identificador já exista, retornar br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException
		if(this.buscaTimePeloId(id).isPresent())
			throw new IdentificadorUtilizadoException();
		else
			this.times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	//Realiza a inclusão de um novo jogador.
	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		//Caso o identificador já exista, retornar br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException
		if(this.buscaJogadorPeloId(id).isPresent())
			throw new IdentificadorUtilizadoException();
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		Time t = this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		Jogador j = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		this.jogadores.add(j);
		t.addJogador(j);
	}

	//Define um jogador como capitão do seu time. Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.
	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		//Caso o jogador informado não exista, retornar br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException
		Jogador j = this.buscaJogadorPeloId(idJogador).orElseThrow(JogadorNaoEncontradoException::new);

		Time t = this.buscaTimePeloId(j.getIdTime()).orElseThrow(TimeNaoEncontradoException::new);
		t.setIdCapitao(idJogador);
	}

	//Mostra o identificador do capitão do time
	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		Time t =  this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		//Caso o time informado não tenha um capitão, retornar br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException
		if (t.getIdCapitao()==null)
			throw new CapitaoNaoInformadoException();
		return t.getIdCapitao();
	}

	//Retorna o nome do jogador.
	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		//Caso o jogador informado não exista, retornar br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException
		return this.buscaJogadorPeloId(idJogador).orElseThrow(JogadorNaoEncontradoException::new).getNome();
	}

	//Retorna o nome do time.
	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		return this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new).getNome();
	}

	//Retorna a lista com o identificador de todos os jogadores do time, ordenada pelo id
	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		Time t = this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		/*return jogadores
				.stream()
				.filter(j -> j.getIdTime().equals(idTime))
				.map(Jogador::getId)
				.collect(Collectors.toList());
		 */

		return t.getJogadores()
				.stream()
				.sorted(Comparator.comparingLong(Jogador::getId))
				.map(j -> j.getId())
				.collect(Collectors.toList());
	}

	//Retorna o identificador do melhor jogador do time.
	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		Time t = this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return t.getJogadores()
				.stream()
				.max(Comparator.comparingInt(Jogador::getNivelHabilidade))
				.get()
				.getId();
	}

	//Retorna o identificador do jogador mais velho do time. Usar o menor identificador como critério de desempate.
	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		Time t = this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		//Critério de comparação
		//Comparator<Jogador> compararIdadeThenId = Comparator.comparing(Jogador::getDataNascimento).thenComparingLong(Jogador::getId);

		/*return t.getJogadores()
				.stream()
				.min(Comparator.comparing(Jogador::getDataNascimento)
						.thenComparingLong(Jogador::getId))
				.get()
				.getId();
		*/


		return t.getJogadores()
				.stream()
				.min(Comparator.comparing(Jogador::getDataNascimento)
						.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.orElse(null);

//		return t.getJogadores()
//				.stream()
//				.sorted(Comparator.comparing(Jogador::getDataNascimento)
//				.thenComparing(Jogador::getId))
//				.findFirst()
//				.get()
//				.getId();
	}

	//Retorna uma lista com o identificador de todos os times cadastrado, ordenada pelo identificador. Retornar uma lista vazia caso não encontre times cadastrados.
	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return this.times
				.stream()
				.sorted(Comparator.comparingLong(Time::getId))
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	//Retorna o identificador do jogador com maior salário do time. Usar o menor identificador como critério de desempate.
	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		//Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
		Time t = this.buscaTimePeloId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return t.getJogadores()
				.stream()
				.sorted(Comparator.comparing(Jogador::getId))
				.max(Comparator.comparing(Jogador::getSalario))
				.get()
				.getId();
	}

	//Retorna o salário do jogador.
	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		//Caso o jogador informado não exista, retornar br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException
		Jogador j  = this.buscaJogadorPeloId(idJogador).orElseThrow(JogadorNaoEncontradoException::new);

		return j.getSalario();
	}

	//Retorna uma lista com o identificador dos top melhores jogadores, utilizar o menor identificador como critério de desempate.
	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		return this.jogadores
				.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
						.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.limit(top)
				.collect(Collectors.toList());
	}

	//Retorna a cor da camisa do time adversário. Caso a cor principal do time da casa seja igual a cor principal do time de fora, retornar cor secundária do time de fora. Caso a cor principal do time da casa seja diferente da cor principal do time de fora, retornar cor principal do time de fora.
	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time t_casa = this.buscaTimePeloId(timeDaCasa).orElseThrow(TimeNaoEncontradoException::new);
		Time t_fora = this.buscaTimePeloId(timeDeFora).orElseThrow(TimeNaoEncontradoException::new);

		return (t_casa.getCorUniformePrincipal().equals(t_fora.getCorUniformePrincipal()))?
				(t_fora.getCorUniformeSecundario())
				:
				(t_fora.getCorUniformePrincipal());
	}

	private Optional<Time> buscaTimePeloId(Long idTime) {
		return this.times
					.stream()
					.filter(t -> t.getId().equals(idTime)).findFirst();
	}

	private Optional<Jogador> buscaJogadorPeloId(Long idJogador) {
		return this.jogadores
					.stream()
					.filter(j -> j.getId().equals(idJogador)).findFirst();
	}
}
