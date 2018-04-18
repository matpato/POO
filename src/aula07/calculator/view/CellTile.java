package aula07.calculator.view;

import aula07.calculator.console.tile.Tile;
import aula07.calculator.model.Cell;
import aula07.calculator.model.Operation;
import isel.leic.pg.Console;

/**
 * EQUAL CLASS TO POWERPLANT
 */

public abstract class CellTile extends Tile {
    public static final int SIDE = 3;
    Cell cell;

    CellTile(Cell cell) {
        this.cell=cell;
        setSize(SIDE, SIDE);
    }

    @Override
    public void paint() { Console.setForeground(Console.BLACK); }

    public static CellTile newInstance(Cell c){
        if (c instanceof Operation) return new OperationTile(c);
        return new NumberTile(c);
    }



}
