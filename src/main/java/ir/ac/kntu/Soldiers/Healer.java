package ir.ac.kntu.Soldiers;

import ir.ac.kntu.Soldier;

/**
 * The type Healer.
 */
public class Healer extends Soldier {
    /**
     * Instantiates a new Healer.
     *
     * @param team  the team
     * @param x     the x
     * @param y     the y
     * @param board the board
     */
    public Healer(int team, int x, int y, int[][] board) {
        super(30, 200, 300, 1, 3, team, x, y, board);
    }
}
