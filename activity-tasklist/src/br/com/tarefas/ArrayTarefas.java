package br.com.tarefas;

public class ArrayTarefas {
    Tarefa[] tarefas;
    int cont;

    public ArrayTarefas(int tam) {
        this.tarefas = new Tarefa[tam];
    }

    public void add(Tarefa t) {
        this.tarefas[cont] = t;
        cont++;
    }

    public void remove(int index) {
        this.tarefas[index] = null;
    }

    public void showTasks() {
        for(Tarefa t : this.tarefas){
            System.out.println("Tarefa: " + t.descricao);
        }
    }
}
