/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * View
 * */
package aula07.jogogalov1.view;
import aula07.jogogalov1.console.FieldView;
import aula07.jogogalov1.console.View;
import isel.leic.pg.Console;
/**
 * /**
 * EQUAL CLASS TO POWERPLANT, JUST CHANGED THE NAMES
 */


public class StatusPanel extends View {
    public static final int HEIGHT = 7, WIDTH = 8;
    private FieldView current = new FieldView("Player",2,1,"---");
    private FieldView moves = new FieldView("Moves",5,2,"---");


    public StatusPanel(int left) {
        super(0,left, HEIGHT, WIDTH, Console.BLACK);
        addView(current);
        addView(moves);

    }
    public void paint() {
        clear();
        current.paint();
        moves.paint();
    }
    public void setCurrent(int c) { current.setValue(c); }
    public void setMoves(int c) { moves.setValue(c); }

}