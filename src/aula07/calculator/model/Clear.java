package aula07.calculator.model;

/**
 * Created by mpato on 09/04/2018.
 */
public class Clear extends Operation {
    public Clear() {  super('C'); }

    @Override
    public void touch(int[] values) {
       // values[0] = 0; values[1] = 1; if product operation
        values[0] = 0; values[1] = 0;
    }
}
