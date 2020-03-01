package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
    //Soma todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e retorna um BigDecimal
    public BigDecimal somar(Object o);

    //Soma todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e retorna um BigDecimal.
    public BigDecimal subtrair(Object o);

    //Subtrai todos atributos annotados com “Subtrair” dos atributos annotados com “Somar”
    public BigDecimal totalizar(Object o);
}
