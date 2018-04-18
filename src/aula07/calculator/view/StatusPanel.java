package aula07.calculator.view;

import aula07.calculator.console.FieldView;
import aula07.calculator.console.View;
import isel.leic.pg.Console;

/**
 * /**
 * EQUAL CLASS TO POWERPLANT, JUST CHANGED THE NAMES
 */


public class StatusPanel extends View {
    public static final int HEIGHT = 7, WIDTH = 8;
    private FieldView result = new FieldView("Result",1,1,"---");
    private FieldView current = new FieldView("Current",4,0,"---");

    public StatusPanel(int left) {
        super(0,left, HEIGHT, WIDTH, Console.BLACK);
        addView(result);
        addView(current);

    }
    public void paint() {
        clear();
       result.paint();
       current.paint();
    }
    public void setResult(int s) { result.setValue(s); }
    public void setCurrent(int c) { current.setValue(c); }

}