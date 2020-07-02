package br.com;

import br.com.tarefas.ArrayTarefas;
import br.com.tarefas.ListaTarefas;
import br.com.tarefas.Tarefa;

import java.lang.reflect.Array;

public class Principal {

    public static void main(String[] args) {
        /*
        ArrayTarefas array_tasks =  new ArrayTarefas(3);
        array_tasks.add( new Tarefa("Aguar as plantas"));
        array_tasks.add( new Tarefa("Podar as plantas"));
        array_tasks.add( new Tarefa("Cortar as plantas"));
        */

        ListaTarefas list_taks = new ListaTarefas();
        list_taks.add(new Tarefa("Aguar as plantas"));
        list_taks.add(new Tarefa("Cortar as plantas"));
        list_taks.add(new Tarefa("Podar as plantas"));
        list_taks.add(new Tarefa("Plantar as plantas"));
        list_taks.add(new Tarefa("Plantar as plantas depois do jantar"));

        list_taks.showTasks();

        list_taks.buscar("Aguar as plantas").exibirDescricao();


        list_taks.remover(0);
        list_taks.showTasks();
    }
}
