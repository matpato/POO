/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * View
 * */
package aula07.jogogalov1.view;

import isel.leic.pg.Console;

public class Cross extends CellTile {
    @Override
    public void paint() {
        Console.setBackground(Console.RED);
        for (int i = 0; i < SIZE-2; i++) {
            print(i + 1, i + 1, ' ');
            print(i+1, SIZE-2-i,' ');
        }
    }
}
