package ir.ac.kntu.Soldiers;

import ir.ac.kntu.Soldier;

/**
 * The type Knight.
 */
public class Knight extends Soldier {

    /**
     * Instantiates a new Knight.
     *
     * @param x     the x
     * @param y     the y
     * @param team  the team
     * @param board the board
     */
    public Knight(int x, int y,int team,int[][]board) {
        super(30, -400, 600, 2, 1,team,x,y,board);
    }
}
