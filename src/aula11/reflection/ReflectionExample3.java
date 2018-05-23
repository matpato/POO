package aula11.reflection;
/**
 * Subject: Recovering declared methods in the class
 *  Author: Matilde Pato
 *  Date: 2018, May
 *  Lecture: POO
 */

import java.lang.reflect.Method;

public class ReflectionExample3 {

    public static void main(String[] args) {

        Class clazz = Pessoa.class;

        for (Method method : clazz.getDeclaredMethods()) {

            String nome = method.getName();
            Class tipoRetorno = method.getReturnType();

            System.out.println("Método : " + nome + "  Tipo de retorno: " + tipoRetorno);

            //Recuperandos os parâmetros do método
            Class parametros[] = method.getParameterTypes();

            for (Class c : parametros)
                System.out.println("\t" + (c!= null? "Parâmetros: " + c.getName(): ""));

            System.out.println();

        }

    }

}