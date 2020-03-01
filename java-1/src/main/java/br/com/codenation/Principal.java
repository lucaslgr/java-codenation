package br.com.codenation;

import br.com.codenation.DesafioMeuTimeApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        System.out.println("Times cadastrados: "+ desafio.buscarTimes());

//        desafio.incluirTime(1L, "Flamengo", LocalDate.now(), "Azul", "Amarelo");
//        desafio.incluirTime(2L, "Palmeiras", LocalDate.now(), "Azul", "Verde");
//        System.out.println("TESTE incluir time com id que ja'existe!!!");
//        try{
//            desafio.incluirTime(2L,"Corintias", LocalDate.now(), "Preto com uma Lista Rosa", "Preta com Lista Branca");
//        } catch (IdentificadorUtilizadoException e) {
//            System.out.println(e.getMessage());
//        }
        //Time 01
//        desafio.incluirJogador(4L, 1L, "Pelezera", LocalDate.parse("2014-11-15"), 100, new BigDecimal(2.00));
//        desafio.incluirJogador(3L, 1L, "Ronaucho", LocalDate.parse("2015-11-15"), 60, new BigDecimal(1.00));
//        desafio.incluirJogador(5L, 1L, "Meniney", LocalDate.parse("2013-11-15"), 100, new BigDecimal(2.00));
//
//        //Time 02
//        desafio.incluirJogador(11L,2L, "Juturu", LocalDate.parse("2011-03-15"), 30, new BigDecimal(2.00));
//        desafio.incluirJogador(6L, 2L, "Carraeta", LocalDate.parse("2014-03-15"), 100, new BigDecimal(2.00));
//        desafio.incluirJogador(1L, 2L, "Zébigol", LocalDate.parse("2014-03-15"), 30, new BigDecimal(2.00));
//        desafio.incluirJogador(2L, 2L, "Bruzenriqui", LocalDate.parse("2014-03-15"), 80, new BigDecimal(2.00));
//        System.out.println("TESTE, incluir jogador com um id que já existe!");
//        try{
//            desafio.incluirJogador(5L, 1L, "Chapolim", LocalDate.parse("2014-11-15"),  100, new BigDecimal(3.00));
//        } catch (IdentificadorUtilizadoException e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println("TESTE, incluir jogador em time que não existe!");
//        try{
//            desafio.incluirJogador(6L, 3L, "Chapolim", LocalDate.parse("2014-11-15"),  100, new BigDecimal(3.00));
//        } catch (IdentificadorUtilizadoException | TimeNaoEncontradoException e) {
//            System.out.println(e.getMessage());
//        }
//
        //desafio.definirCapitao(3L);
        //desafio.definirCapitao(1L);

//        System.out.println("TESTE, definir capitão para um jogador que não existe!");
//        try{
//            desafio.definirCapitao(8L);
//        } catch ( JogadorNaoEncontradoException e) {
//            System.out.println(e.getMessage());
//        }
        //System.out.println("Capitão do time 01: " + desafio.buscarCapitaoDoTime(1L));
        //System.out.println("Capitão do time 02: " +desafio.buscarCapitaoDoTime(2L));

//        System.out.println("TESTE, buscar capitão do time para um time que não existe e para um time que não possui capitão!");
//        try{
//            desafio.buscarCapitaoDoTime(2L);
//        } catch ( TimeNaoEncontradoException | CapitaoNaoInformadoException e) {
//            System.out.println(e.getMessage());//Time 01
//        }

//        System.out.println("Nome do jogador 01: "+ desafio.buscarNomeJogador(1L));
//
//        System.out.println("TESTE, buscar nome de um jogador cujo id não existe!");
//        try{
//            desafio.buscarNomeJogador(7L);
//        } catch ( JogadorNaoEncontradoException e) {
//            System.out.println(e.getMessage());
//        }
//		System.out.println(desafio.buscarNomeJogador(1L));

//        System.out.println("Nome do time 01: "+desafio.buscarNomeTime(1L));
//		System.out.println(desafio.buscarNomeTime(1L));

//        System.out.println("TESTE, buscar nome de um time cujo id não existe!");
//        try{
//            desafio.buscarNomeTime(7L);
//        } catch ( TimeNaoEncontradoException e) {
//            System.out.println(e.getMessage());
//        }

//          System.out.println("Jogadores do time 02: "+ desafio.buscarJogadoresDoTime(2L));

//        System.out.println("TESTE, buscar lista com id de todos os jogadores do time cujo id não existe!");
//        try{
//            System.out.println(desafio.buscarJogadoresDoTime(7L));
//        } catch ( TimeNaoEncontradoException e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println("Melhor jogador do time 01: " + desafio.buscarMelhorJogadorDoTime(1L));
//        System.out.println("Melhor jogador do time 02: " + desafio.buscarMelhorJogadorDoTime(2L));
//        System.out.println("TESTE, buscar id do melhor jogador do time cujo id não existe!");
//        try{
//            desafio.buscarMelhorJogadorDoTime(2L);
//        } catch ( TimeNaoEncontradoException e) {
//            System.out.println(e.getMessage());
//        }


//        System.out.println("Buscando jogador mais velho do time 02: ");
//        try{
//            System.out.println(desafio.buscarJogadorMaisVelho(2L));
//        }catch(RuntimeException e){
//            System.out.println(e.getMessage());
//        }

//        System.out.println("Jogador mais velho do time 01: "+ desafio.buscarJogadorMaisVelho(1L));
//        System.out.println("Todos os times: "+ desafio.buscarTimes());
//        System.out.println("Jogador com maior salário do time 01: "+desafio.buscarJogadorMaiorSalario(1L));
//        System.out.println("Salário do jogador 04: "+desafio.buscarSalarioDoJogador(4L));
//        System.out.println("Top 1 jogadores: "+desafio.buscarTopJogadores(4));
//        System.out.println("Camisa do time adversário(TimeCasa 01, TimeFora 02): "+desafio.buscarCorCamisaTimeDeFora(1L, 2L));

    }
}
