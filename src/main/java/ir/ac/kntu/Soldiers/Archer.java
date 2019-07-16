package ir.ac.kntu.Soldiers;

import ir.ac.kntu.Soldier;

/**
 * The type Archer.
 */
public class Archer extends Soldier {
    /**
     * Instantiates a new Archer.
     *
     * @param x     the x
     * @param y     the y
     * @param team  the team
     * @param board the board
     */
    public Archer(int x, int y, int team,int[][]board) {
        super(15, -200, 300, 1, 2, team, x, y,board);
    }
}
