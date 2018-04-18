/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * Model
 * */
package aula07.jogogalov1.model;

public enum Symbol {
    CROSS, BALL;

    private static final int player = 1;
    public Symbol other() {
        return this == CROSS ? BALL : CROSS;
    }

    public boolean isCross() {
        return this == CROSS;
    }

    public int getPlayer(){ return this == CROSS ? player : player + 1; }

}
