package br.com.codenation.calculadora;

/*
* 1 - Classe baixa renda até 1.500 - INSS 8%
* 2 - Classe média renda de 1.501 até 4.000 - INSS 9%
* 3 - Classe alta renda acima de 4.000 - INSS 11%
* */

public class CalculadoraSalario {
	final byte CATEGORIA_1 = 1;
	final byte CATEGORIA_2 = 2;
	final byte CATEGORIA_3 = 3;

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		return (salarioBase<1039)?(0):(Math.round(this.calcularIRRF(this.calcularINSS(salarioBase))));
	}

	//Método para calcular o desconto do IRRF
	private double calcularIRRF(double salario) {
		byte categoriaIRRF = (byte) this.classificaCategoaria(salario, 3000, 6000);

		//Aplicação do respectivo desconto
		if(categoriaIRRF == CATEGORIA_2)
			return salario *= 0.925;
		else if((categoriaIRRF == CATEGORIA_3))
			return salario *= 0.85;
		else //CATEGORIA 1
			return salario;
	}

	//Método para calcular o desconto do INSS
	private double calcularINSS(double salarioBase) {
		byte categoriaINSS = (byte) this.classificaCategoaria(salarioBase, 1500, 4000);

		//Aplicação do respectivo desconto
		if(categoriaINSS == CATEGORIA_1)
			return salarioBase *= 0.92;
		else if((categoriaINSS == CATEGORIA_2))
			return salarioBase *= 0.91;
		else
			return salarioBase *= 0.89;
	}

	//Classifica em categorias 1, 2 e 3 os salarios de acordo com os argumentos passado de min e medio
	private byte classificaCategoaria(double salario, double min, double medio) {
		if (salario <= min)	//Categoaria 1
			return (byte)CATEGORIA_1;
		else if (salario<=medio) //Categoria 2
			return (byte)CATEGORIA_2;
		else
			return (byte)CATEGORIA_3;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/