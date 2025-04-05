package io.github.lorimedeiros.Arquitetura.Spring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //runtime é a retention padrão
@Target({ElementType.FIELD, ElementType.METHOD}) //notation pode ser usada tanto em cima de campo quanto método
@Qualifier("motorAspirado") //aqui está especificando o qualified que a notation irá apontar
public @interface Aspirado {
}
