package br.com.tarefas;

public class Tarefa {
    String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public void exibirDescricao(){
        System.out.println(this.descricao);
    }
}
