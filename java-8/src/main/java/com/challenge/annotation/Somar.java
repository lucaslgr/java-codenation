package com.challenge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) //Onde essa annotation pode ser colocada
@Retention(RetentionPolicy.RUNTIME) //Em que política essa annotation será utilziada, EX: Neste caso será em tempo de execução
public @interface Somar {
}
