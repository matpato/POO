package aula07.calculator.model;

/**
 * Created by mpato on 09/04/2018.
 */
public class Number extends Cell {

    private int n;
    public Number(int n){ this.n = n; }

    public String toString(){ return "" + n; }

    @Override
    public void touch(int[] values) { values[0] = values[0]*10 + n; }
}
