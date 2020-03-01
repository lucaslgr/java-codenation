package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculadorDeClasses implements Calculavel{
    @Override
    public BigDecimal somar(Object o) {
        List<Field> fieldsList = getFieldsWithAnnotation(o, Somar.class);
        if (fieldsList.isEmpty())
            return BigDecimal.ZERO;
        else
            return sumAllValuesOfFields(o, fieldsList);
    }

    @Override
    public BigDecimal subtrair(Object o) {
        List<Field> fieldsList = getFieldsWithAnnotation(o, Subtrair.class);
        if (fieldsList.isEmpty())
            return BigDecimal.ZERO;
        else
            return sumAllValuesOfFields(o, fieldsList);
    }

    @Override
    public BigDecimal totalizar(Object o) {
         return (this.somar(o).subtract(this.subtrair(o)));
    }

    //<Private Methods>
    //Retorna os campos do objeto passado no primeiro parâmetro com a notação especficada no segundo parâmetro
    private List<Field> getFieldsWithAnnotation(Object o, Class<? extends Annotation> annotation) {
        List<Field> fieldsWithAnnotion = new ArrayList<>();
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(f -> {
            f.setAccessible(true); //Tornando o campo acessível caso seja privado
            if(f.isAnnotationPresent(annotation))
                fieldsWithAnnotion.add(f);
        });
        return fieldsWithAnnotion;
    }

    //Retorna a soma dos valores dos campos para tipos BigDecimal
    private BigDecimal sumAllValuesOfFields(Object o, List<Field> fieldsList) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Field f: fieldsList){
            BigDecimal valueField = BigDecimal.ZERO;
            if(f.getType().isAssignableFrom(BigDecimal.class)) //Checando se o campo é do tipo BigDecimal
            {
                try {
                    f.setAccessible(true); //Tornando o campo acessível caso seja privado
                    valueField = (BigDecimal) f.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                sum = sum.add(valueField);
            }
        }
        return sum;
    }
}
