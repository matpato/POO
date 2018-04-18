package aula07.observer1;

public class Main {

    public static void main(String args []){
        MessageBoard board = new MessageBoard();
        Reader r1 = new Reader(1);
        Reader r2 = new Reader(2);
        Reader r3 = new Reader(3);

        /**
         * Adiciona os objectos a notificar
         */
        board.addObserver(r1);
        board.addObserver(r2);
        board.addObserver(r3);

        /**
         * Actualiza a ultima mensagem o que faz com que os Observers
         * sejam notificados da ocorrencia.
         */
        board.setMessage("Message 0001");
        board.setMessage("Message 0002");

        /**
         * Remove o Observer r2 da lista de Observers a registar.
         */
        board.delObserver(r2);

        /**
         * Actualiza novamente a utima mensagem.
         */
        board.setMessage("Message 0003");

        /**
         * Imprime a ultima mensagem lida pelo Observer r2
         */
        r2.readAndPrint();
    }
}