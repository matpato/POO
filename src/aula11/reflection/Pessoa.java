package aula11.reflection;

/**
 * Subject: Examinando atributos, métodos e construtores da classe
 * Author: Matilde Pato
 * Date: 2018, May
 * Lecture: POO
 * */
public class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}