/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * Model
 * */
package aula07.jogogalov1.model;

public enum State {
    RUN, WIN, TIED;

    public boolean isOver() {
        return this!=RUN;
    }
}
