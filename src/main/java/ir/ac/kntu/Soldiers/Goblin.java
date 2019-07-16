package ir.ac.kntu.Soldiers;

import ir.ac.kntu.Soldier;

/**
 * The type Goblin.
 */
public class Goblin extends Soldier {
    /**
     * Instantiates a new Goblin.
     *
     * @param x     the x
     * @param y     the y
     * @param team  the team
     * @param board the board
     */
    public Goblin(int x, int y,int team,int[][]board) {
        super(10, -250, 200, 3, 1,team,x,y,board);
    }
}
