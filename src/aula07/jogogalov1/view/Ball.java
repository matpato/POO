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

public class Ball extends CellTile {
    @Override
    public void paint() {
        Console.setBackground(Console.GREEN);
        print(1,2,"OOO");
        print(SIZE-2,2,"OOO");
        for (int i = 0; i < SIZE-4; i++) {
            print(i+2,1,'O');
            print(i+2,SIZE-2,'O');
        }
    }
}
