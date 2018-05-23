package aula11.reflection;
/**
 * Subject: Intro to Reflection concept
 * Consideremos a classe String, uma classe nativa do Java, para capturar o
 * seu nome e o nome da sua superclasse o seguinte codigo mostrado no exemplo
 * abaixo poderia ser executado
 *  Author: Matilde Pato
 *  Date: 2018, May
 *  Lecture: POO
 * */

public class ReflectionExample1 {
    public static void main(String[] args) {

        // Obtendo o objecto Class
        Class clazz = String.class;

        // Obtendo o nome da classe, incluindo o pacote que pertence
        String nome = clazz.getName();

        // Obtendo a Super Classe
        Class superClasse = clazz.getSuperclass();

        System.out.println("Nome da classe: " + nome);
        System.out.println("Super classe: " + superClasse);

        System.out.print("\n");

        // Obtendo o objecto Class
        clazz = Pessoa.class;

        // Obtendo o nome da classe, incluindo o pacote que pertence
         nome = clazz.getName();

        // Obtendo a Super Classe
        superClasse = clazz.getSuperclass();

        System.out.println("Nome da classe: " + nome);
        System.out.println("Super classe: " + superClasse);

    }

}


/*
* Examinando as classes. Existem diversas maneiras de se obter
* um objeto Class, dentre eles podemos destacar:

1. Executando o método getClass() do objeto:
    Class clazz = null;
    Teste teste = new Teste();
    clazz = teste.getClass();
2. Através do sufixo da classe usando o .class
    Class clazz = Teste.class;

3. Usando o método estático forName da classe Class.
    Class clazz = Class.forName("java.lang.String");

* Examinando atributos, métodos e construtores da classe
 */