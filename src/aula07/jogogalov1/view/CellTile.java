/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * View
 * */
package aula07.jogogalov1.view;

import aula07.jogogalov1.console.tile.Tile;

public abstract class CellTile extends Tile {
    public static final int SIZE = 7;

    protected CellTile() {
        setSize(SIZE,SIZE);
    }
}
