package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
    //Soma todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e retorna um BigDecimal
    BigDecimal somar(Object o);

    //Soma todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e retorna um BigDecimal.
    BigDecimal subtrair(Object o);

    //Subtrai todos atributos annotados com “Subtrair” dos atributos annotados com “Somar”
    BigDecimal totalizar(Object o);
}
