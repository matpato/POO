package aula07.observer2;

public class BarraObserver extends Observer {

    public BarraObserver(Subject dados) {
        super(dados);
    }

    @Override
    public void update() {
        String barraA = "", barraB = "", barraC = "";

        for (int i = 0; i < data.getState().valorA; i++) {
            barraA += '*';
        }

        for (int i = 0; i < data.getState().valorB; i++) {
            barraB += '*';
        }

        for (int i = 0; i < data.getState().valorC; i++) {
            barraC += '*';
        }

        System.out.println("Barras:\nValor A: " +
                barraA + "\nValor B: " +
                barraB + "\nValor C: " +
                barraC);
    }

}