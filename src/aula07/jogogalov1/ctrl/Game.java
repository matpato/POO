/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * Control
 * */
package aula07.jogogalov1.ctrl;

import aula07.jogogalov1.view.Ball;
import aula07.jogogalov1.view.Cross;
import aula07.jogogalov1.view.Space;
import aula07.jogogalov1.view.CellTile;
import aula07.jogogalov1.view.StatusPanel;

import isel.leic.pg.*;
import aula07.jogogalov1.console.Window;
import aula07.jogogalov1.console.tile.TilePanel;
import aula07.jogogalov1.model.Galo;
import aula07.jogogalov1.model.Symbol;

import java.awt.event.KeyEvent;


public class Game{

    private static final int WIN_HEIGHT = 30, WIN_WIDTH = 30;
    private StatusPanel status = new StatusPanel(WIN_WIDTH);
    private Window win = new Window(" Galo ",WIN_HEIGHT,
            WIN_WIDTH + StatusPanel.WIDTH);
    private Galo model;
    private TilePanel view;
    private Symbol firstPlayer = Symbol.CROSS;

    public static void main(String[] args) {
        new Game().init();
    }

    private class ModelListener implements Galo.Listener{
        @Override
        public void changedSymbol(int lin, int col, Symbol s) {
            status.setCurrent(model.getPlayer());
            status.setMoves(model.getTotalPlays());
            CellTile v;
            if (s == Symbol.CROSS) v = new Cross();
            else if(s == Symbol.BALL) v = new Ball();
            else v = new Space();
            view.setTile(lin, col, v );
        }
    }

    private ModelListener listener = new ModelListener();

    private void init() {
        view = new TilePanel(Galo.SIZE,Galo.SIZE,CellTile.SIZE);
        view.setOrig(1,1);

        while( playMatch() ) {
            if (model.hasWinner())
                win.message("Player: " + model.getPlayer()
                        + " is winner");
            else
                win.message("Tied");
            if (!win.question("New Game")) break;
        }
        exit("bye");
    }

    private boolean playMatch() {
        startMatch();
        for(;;) {
            int key = Console.waitKeyPressed(0);
            if (key == KeyEvent.VK_ESCAPE) return false;
            if (key == KeyEvent.VK_BACK_SPACE) {
                Console.waitKeyReleased(key);
                if (!model.undo()) win.message("No UNDO");
            }
            if (key == Console.MOUSE_EVENT) {
                MouseEvent me = Console.getMouseEvent();
                if (me.type == MouseEvent.DOWN) {
                    Location loc = view.getModelPosition(me.line,me.col);
                    if (loc != null && model.play(loc.line,loc.col)
                            && model.isOver())
                        return true;
                }
            }
        }
    }

    private void startMatch() {
        for (int l = 0; l < Galo.SIZE; l++)
            for (int c = 0; c < Galo.SIZE; c++)
                view.setTile(l,c,new Space());
        model = new Galo(firstPlayer);
        model.setListener(listener);
        status.setCurrent(model.getPlayer());
        status.setMoves(model.getTotalPlays());
        firstPlayer = firstPlayer.other();
    }

    private void exit(String msg) {
        win.message(msg);
        Console.waitKeyPressed(250);
        win.close();
    }
}
