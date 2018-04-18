package aula07.calculator.model;

/**
 * Created by mpato on 09/04/2018.
 */
public class Sum extends Operation {
    public Sum() { super('+'); } // change to * and you multiply

    @Override
    public void touch(int[] values) {
        values[1] = values[1] + values[0];
//        values[1] = values[1] * values[0]; // for product
        values[0]=0;
    }
}

