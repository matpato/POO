package aula07.calculator.view;

import aula07.calculator.model.Cell;
import isel.leic.pg.Console;

/**
 * Created by mpato on 09/04/2018.
 */

    public class NumberTile extends CellTile {

        public NumberTile(Cell c){ super(c); }
        public void paint() {
            Console.setForeground(Console.BROWN);
            this.print(1,1, cell.toString());
        }

    }