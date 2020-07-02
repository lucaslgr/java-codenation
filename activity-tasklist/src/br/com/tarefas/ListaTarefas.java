package br.com.tarefas;

import java.util.ArrayList;

public class ListaTarefas {
    ArrayList<Tarefa> list_tarefas = new ArrayList<>();

    public Tarefa buscar(String descricao) {
        for (Tarefa t : this.list_tarefas)
            if (descricao.equals(t.descricao))
                return t;
        System.out.println("Tarefa não encontrada!");
        return null;
    }

    public void add(Tarefa t) {
        if(t.descricao.length() < 20)
                this.list_tarefas.add(t);
        else
            System.out.println("Tarefa deve ter no máximo 20 caracteres!");
    }

    public void remover(int index){
        if (index<this.list_tarefas.size() && index>=0)
            this.list_tarefas.remove(index);
        else
            System.out.println("Tarefa não existe, indice inválido!");
    }

    //Sobrecarga
    public void remover(Tarefa t){
        this.list_tarefas.remove(t);
    }

    public void showTasks() {
        for(Tarefa t : this.list_tarefas){
            System.out.println("Descricao: "+ t.descricao);
        }
    }
}
