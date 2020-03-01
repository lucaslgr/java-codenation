package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> estacionamento = new ArrayList<>();

    //Verifica se o carro e o motorista estão de acordo com as regras para que possa estacionar e caso estejam de acordo permite o carro ocupar uma vaga
    public void estacionar(Carro carro) {
        if(carro.getMotorista() == null || carro.getMotorista().getIdade()<18 || carro.getMotorista().getPontos()>20)
            throw new EstacionamentoException("Não cumpre um dos requesitos para estacionar");
        /*
        * O estacionamento não deverá comportar o número superior de vagas.
        * * Caso o estacionamento esteja lotado: * Chegue mais um novo carro, o primeiro que estacionou deverá sair
        * * Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos, será escolhido o próximo motorista abaixo dos 55 anos.
        * * Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista, ele não conseguirá estacionar.
        */
        else if(this.carrosEstacionados()>=10)
        {
            //Método 1
//            this.estacionamento
//                    .stream()
//                    .forEach(j -> {
//                        if(j.getMotorista().getIdade() <= 55){
//                            this.estacionamento.remove(j); //Pegar o index
//                            return;
//                        }
//                    });
            //Método 2
            int i = 0;
            for (Carro c: this.estacionamento){
                if(c.getMotorista().getIdade() <= 55)
                {
                    this.estacionamento.remove(i);
                    break;
                }
                i++;
            }

            if(this.estacionamento.size() == 9)
                this.estacionamento.add(carro);
            else
                throw new EstacionamentoException("Não há vagas. Todos os motoristas tem prioridade");
        }
        else
            this.estacionamento.add(carro);
    }

    //Retorna o número de carros estacionados no estacionamento
    public int carrosEstacionados() {
        return estacionamento.size();
    }

    //Retorna true ou false informando se determinado carro está estacionado ou não
    public boolean carroEstacionado(Carro carro) {
        return this.estacionamento.contains(carro);
    }
}
