package aula07.observer2;

public class TabelaObserver extends Observer {

    public TabelaObserver(Subject dados) {
        super(dados);
    }

    @Override
    public void update() {
        System.out.println("Tabela:\nValor A: " +
                data.getState().valorA
                + "\nValor B: " +
                data.getState().valorB +
                "\nValor C: "
                + data.getState().valorC);
    }

}