package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long idCapitao;
    private List<Jogador> jogadores = new ArrayList<>();

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.setId(id);
        this.setNome(nome);
        this.setDataCriacao(dataCriacao);
        this.setCorUniformePrincipal(corUniformePrincipal);
        this.setCorUniformeSecundario(corUniformeSecundario);
        this.jogadores = new ArrayList<>(); //0 jogadores
    }

    public void addJogador(Jogador j){
        this.jogadores.add(j);
    }

    //<SET's>
    public void setId(Long id) {
        if (this.validaId(id))
            this.id = id;
        else
            throw new NullPointerException("ID do time é obrigatório");
    }

    public void setNome(String nome) {
        if (this.validaNome(nome))
            this.nome = nome;
        else
            throw new NullPointerException("Nome do time é obrigatório");
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        if (this.validaData(dataCriacao))
            this.dataCriacao = dataCriacao;
        else
            throw new NullPointerException("Data de criação do time é obrigatório");
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        if(this.validaCorUniforme(corUniformePrincipal))
            this.corUniformePrincipal = corUniformePrincipal;
        else
            throw new NullPointerException("Cor do uniforme principal do time é obrigatório");
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        if(this.validaCorUniforme(corUniformeSecundario))
            this.corUniformeSecundario = corUniformeSecundario;
        else
            throw new NullPointerException("Cor do uniforme secundário do time é obrigatório");
    }

    public void setIdCapitao(Long idCapitao) {
        if (this.validaId(idCapitao))
            this.idCapitao = idCapitao;
        else
            throw new NullPointerException("ID do capitão é obrigatório");
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    //<GET's>
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public Long getIdCapitao() {
        return idCapitao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    //<MÉTODOS DE VALIDAÇÃO>
    private boolean validaId(Long id){
        return id!=null && !id.toString().isEmpty();
    }
    private boolean validaNome(String nome) {
        return nome!=null && !nome.isEmpty();
    }
    private boolean validaData(LocalDate d){
        return d!=null && !d.toString().isEmpty() && d.isBefore(LocalDate.now());
    }
    private boolean validaCorUniforme(String cor){
        return cor!=null && !cor.isEmpty() && cor.length()>2;
    }

    //Métodos nativos sobreescritos
    public boolean equals(Object obj) {
        if(this == obj
                || this == (Time)obj
                || this.id.equals(((Time)obj).getId()))
            return true;
        /*
        if((this.getClass() != obj.getClass())
                || (obj == null))
            return false;
        */
        return false; //Default
    }
}
