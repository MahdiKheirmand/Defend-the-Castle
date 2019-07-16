package ir.ac.kntu.Soldiers;

import ir.ac.kntu.Soldier;

/**
 * The type Dragon.
 */
public class Dragon extends Soldier {
    /**
     * Instantiates a new Dragon.
     *
     * @param x     the x
     * @param y     the y
     * @param team  the team
     * @param board the board
     */
    public Dragon(int x, int y,int team,int[][]board) {
        super(35, -350, 500, 2, 3,team,x,y,board);
    }
}
