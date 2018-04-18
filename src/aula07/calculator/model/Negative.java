package aula07.calculator.model;

/**
 * Created by mpato on 09/04/2018.
 */
public class Negative extends Operation {
    Negative() { super('\u00B1'); }

    @Override
    public void touch(int[] values) {
        values[0] *= -1;
        values[1] = values[0];
        values[0] = 0;
    }
}
