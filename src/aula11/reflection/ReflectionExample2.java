package aula11.reflection;
/**
 *  Subject: Recovering declared fields in the class
 *  Author: Matilde Pato
 *  Date: 2018, May
 *  Lecture: POO
 *  */
import java.lang.reflect.Field;

public class ReflectionExample2 {

    public static void main(String[] args) {

        Class clazz = Pessoa.class;

        for (Field field : clazz.getDeclaredFields()) {

            String nomeTipo = field.getName();
            Class tipo = field.getType();

            System.out.println("Field: " + nomeTipo + " ,  Type: " + tipo);

        }

    }

}

// getDeclaredFields: Retorna um array somente com os métodos declarados na classe
// getName: Retorna o nome do atributo.
// getType: Retorna um objeto Class para o tipo do atributo.