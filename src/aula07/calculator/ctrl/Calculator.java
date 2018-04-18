package aula07.calculator.ctrl;

import aula07.calculator.console.Window;
import aula07.calculator.model.CalculatorModel;
import aula07.calculator.console.tile.TilePanel;
import aula07.calculator.view.CellTile;
import aula07.calculator.view.StatusPanel;
import isel.leic.pg.Console;
import isel.leic.pg.Location;
import isel.leic.pg.MouseEvent;

import java.awt.event.KeyEvent;

/**
 * Created by mpato on 09/04/2018.
 */
public class Calculator {

    private static final int WIN_HEIGHT = 30, WIN_WIDTH = 30;
    private CalculatorModel model;  // Model of current level
    private TilePanel view;         // View of cells
    private StatusPanel status = new StatusPanel(WIN_WIDTH);
    private Window win = new Window("Power Plant",WIN_HEIGHT, WIN_WIDTH +StatusPanel.WIDTH);


    public static void main(String[] args) {
        Calculator game = new Calculator();
        game.init();
    }

    private class ModelListener implements CalculatorModel.CalculatorListener {

        public void accumulate(int[] values, int lin, int col) {
            view.getTile(lin,col).repaint();
            status.setCurrent(values[0]);
            status.setResult(values[1]);
        }
    }
    private ModelListener listener = new ModelListener();


    private void init() {
        model = new CalculatorModel();
        model.setListener( listener ); // Set the listener of modifications
        model.init();
        view = new TilePanel(model.getHeight(),model.getWidth(), CellTile.SIDE);
        win.clear();
        status.setResult(0);
        status.setCurrent(0);
        view.center(WIN_HEIGHT,WIN_WIDTH);
        for (int l = 0; l < model.getHeight(); l++)
            for (int c = 0; c < model.getWidth(); c++)
                view.setTile(l,c, CellTile.newInstance(model.getCell(l,c) ));
        if(!calculate()){
            exit("bye");
        }
    }

    private boolean calculate() {
        for (; ; ) {
            int key = Console.waitKeyPressed(250); // Wait for mouse event or a key
            if (key == KeyEvent.VK_ESCAPE)         // Escape key -> abort game
                return false;
            if (key == Console.MOUSE_EVENT) {      // Is a mouse event
                MouseEvent me = Console.getMouseEvent();
                if (me != null && me.type == MouseEvent.DOWN) {
                    Location pos = view.getModelPosition(me.line, me.col); // Convert mouse position to cell coordinates
                    if (pos != null && model.touch(pos.line, pos.col))
                        if(model.isFinished()) return false;
                }
            }
        }
    }
    private void exit(String msg) {
        win.message(msg);
        Console.waitKeyPressed(250);
        win.close();
    }
}
