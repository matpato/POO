/**
 * Jogo do Galo
 * author: matilde pato
 * date: 18-04-2018
 * lecture: POO
 *
 * Model
 * */
package aula07.jogogalov1.model;

public class Galo {
    public static final int SIZE = 3;

    private final Symbol[][] grid = new Symbol[SIZE][SIZE];
    private Symbol currPlayer;
    private State state = State.RUN;
    private int totalPlays = 0;

    private static class Pos {
        int lin;
        int col;
        Pos(int lin, int col) {
            this.lin = lin;
            this.col = col;
        }
    }
    private Pos[] plays = new Pos[SIZE*SIZE];

    public Galo(Symbol firstPlayer) {
        currPlayer = firstPlayer;
    }

    public int getTotalPlays(){ return totalPlays; }

    public boolean play(int lin, int col) {
        if (grid[lin][col] != null || state.isOver()) return false;
        grid[lin][col] = currPlayer;
        plays[totalPlays] = new Pos(lin,col);
        totalPlays++;
        verifyState(lin,col);
        if (listener != null)
            listener.changedSymbol(lin,col,currPlayer);
        if (!state.isOver())
            currPlayer = currPlayer.other();
        return true;
    }
    public Symbol getSymbol(int lin, int col) {
        return grid[lin][col];
    }

    public boolean isOver() { return state.isOver(); }

    public boolean undo() {
        if (totalPlays == 0 || state.isOver()) return false;
        Pos p = plays[--totalPlays];
        grid[p.lin][p.col] = null;
        currPlayer = currPlayer.other();
        currPlayer.getPlayer();
        if (listener!=null)
            listener.changedSymbol(p.lin,p.col,null);
        return true;
    }

    public boolean hasWinner() { return state == State.WIN; }

    public int getPlayer() {
        return currPlayer.getPlayer();
    }

    public interface Listener {
        void changedSymbol(int lin, int col, Symbol s);
    }

    Listener listener;

    public void setListener(Listener l) {  listener = l; }

    private void verifyState(int lin, int col) {
        if (winLine(lin) || winCol(col) || lin==col&&winDiag1()
                || lin+col==SIZE-1&&winDiag2())
            state = State.WIN;
        if (totalPlays == SIZE*SIZE)
            state = State.TIED;
    }

    private boolean winDiag1() {
        Symbol s = grid[0][0];
        for (int i = 1; i < SIZE; i++)
            if (grid[i][i] != s) return false;
        return true;
    }
    private boolean winDiag2() {
        Symbol s = grid[0][SIZE-1];
        for (int i = 1; i < SIZE; i++)
            if (grid[i][SIZE-1-i] != s) return false;
        return true;
    }
    private boolean winLine(int lin) {
        Symbol s = grid[lin][0];
        for (int c = 1; c < SIZE; c++)
            if (grid[lin][c] != s) return false;
        return true;
    }
    private boolean winCol(int col) {
        Symbol s = grid[0][col];
        for (int l = 1; l < SIZE; l++)
            if (grid[l][col] != s) return false;
        return true;
    }


    public static void main(String[] args) {
        Galo g = new Galo(Symbol.CROSS);
        g.play(0,0);
        g.play(0,1);
        if (g.play(0,0))
            System.out.println("Erro");
        System.out.println(g.totalPlays);
        System.out.println(g.state);
        g.play(1,1);
        g.play(0,2);
        g.play(2,2);
        System.out.println(g.state);
        if (g.play(2,1))
            System.out.println("Erro");
    }

}