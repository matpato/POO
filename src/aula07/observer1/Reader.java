package aula07.observer1;

public class Reader implements Observer {

    /**
     * Ultima mensage lida
     */
    private String message;

    /**
     * Identificador do leitor, apenas para distinguir os prints
     */
    private int id;

    public Reader(int id) {
        this.id = id;
        this.message = "";
    }

    /**
     * Actualiza a ultima mensagem lida e imprime a mensagem
     */
    public void update(Object obj) {
        this.message = (String)obj;
        readAndPrint();
    }

    /**
     * Imprime a ultima mensagem lida
     */
    public void readAndPrint(){
        System.out.println(String.format("Reader %d -> Message: %s",
                this.id, this.message));
    }
}