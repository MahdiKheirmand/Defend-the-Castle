package ir.ac.kntu.Soldiers;

/**
 * The type Swords man.
 */
public class SwordsMan extends Soldier {
    /**
     * Instantiates a new Swords man.
     *
     * @param x     the x
     * @param y     the y
     * @param team  the team
     * @param board the board
     */
    public SwordsMan(int x, int y, int team, int[][] board) {
        super(20, -350, 500, 1, 1, team, x, y, board);
    }
}
