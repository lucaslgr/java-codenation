package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.setId(id);
        this.setIdTime(idTime);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setNivelHabilidade(nivelHabilidade);
        this.setSalario(salario);
    }

    //<SET's>
    public void setId(Long id) {
        if (this.validaId(id))
            this.id = id;
        else
            throw new NullPointerException("ID do jogador é obrigatório");
    }

    public void setIdTime(Long idTime) {
        if (this.validaId(id))
            this.idTime = idTime;
        else
            throw new NullPointerException("ID do time é obrigatório");
    }

    public void setNome(String nome) {
        if (this.validaNome(nome))
            this.nome = nome;
        else
            throw new NullPointerException("Nome do jogador é obrigatório");
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (this.validaData(dataNascimento))
            this.dataNascimento = dataNascimento;
        else
            throw new NullPointerException("Data de nascimento do jogador é obrigatório");
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        if (this.validaHabilidade(nivelHabilidade))
            this.nivelHabilidade = nivelHabilidade;
        else
            throw new NullPointerException("Nível de habilidade do jogador é obrigatório");
    }

    public void setSalario(BigDecimal salario) {
        if (this.validaSalario(salario))
            this.salario = salario;
        else
            throw new NullPointerException("Salário do jogador é obrigatório");
    }

    //<GET's>
    public Long getId() {
        return id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
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
    private boolean validaHabilidade(Integer i){
        return i!=null && (i.intValue()>=0 && i.intValue()<=100);
    }
    private boolean validaSalario(BigDecimal s) {
        return s!=null && s.doubleValue()>0.0;
    }

    //Métodos nativos sobreescritos
    @Override
    public boolean equals(Object obj) {
        if(this == obj
           || this == (Jogador)obj
           || this.id.equals(((Jogador)obj).getId()))
            return true;
        /*
        if((this.getClass() != obj.getClass())
                || (obj == null))
            return false;
        */
        return false; //Default
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", idTime=" + idTime +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nivelHabilidade=" + nivelHabilidade +
                ", salario=" + salario +
                '}';
    }
}
