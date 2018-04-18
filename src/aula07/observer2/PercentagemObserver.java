package aula07.observer2;

import java.text.DecimalFormat;

public class PercentagemObserver extends Observer {

    public PercentagemObserver(Subject d) { super(d);  }

    @Override
    public void update() {
        int sumOfVal = data.getState().valorA +
                data.getState().valorB +
                data.getState().valorC;

        DecimalFormat form = new DecimalFormat("#.##");
        String perA = form.format(
                (double) data.getState().valorA / sumOfVal);
        String perB = form.format(
                (double) data.getState().valorB / sumOfVal);
        String perC = form.format(
                (double) data.getState().valorC / sumOfVal);

        System.out.println("Percentagem:\nValor A: " + perA
                + "%\nValor B: " + perB +
                "%\nValor C: " + perC + "%");
    }
}