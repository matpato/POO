package aula07.jogogalov1.console.tile;

import aula07.jogogalov1.console.View;
import isel.leic.pg.Console;
import isel.leic.pg.Location;
/**
 * ALREADY EXISTENT
 */
public class TilePanel extends View {
    private final Tile[][] tiles;
    private final int side;

    public TilePanel(int tilesHeight, int tilesWidth, int tileSide) {
        super(0,0, Console.BLACK);
        tiles = new Tile[tilesHeight][tilesWidth];
        side = tileSide;
        height = tilesHeight * side;
        width = tilesWidth * side;
    }

    public void paint() {
        for (int l = 0; l < tiles.length; l++)
            for (int c = 0; c < tiles[l].length; c++)
                tiles[l][c].repaint();
    }

    public Location getModelPosition(int line, int col) {
        assert(parent==null);
        line -= top; col -= left;
        int l = line / side;
        int c = col / side;
        return  (line<0 || col<0 || l >= tiles.length || c>= tiles[0].length) ? null : new Location(l , c);
    }

    public void setTile(int l, int c, Tile t) {
        tiles[l][c] = t;
        addTile(l, c, t);
        t.repaint();
    }

    private void addTile(int l, int c, Tile t) {
        super.addView(t);
        t.setOrig(l * side, c * side);
        t.setSize(side,side);
        t.setBackground(l%2==0 && c%2!=0 || l%2!=0 && c%2==0 ? Console.GRAY:Console.LIGHT_GRAY);
    }

    public Tile getTile(int l, int c) {
        return tiles[l][c];
    }
}
