package ir.ac.kntu.Soldiers;

/**
 * The type Shield.
 */
public class Shield extends Soldier {
    /**
     * Instantiates a new Shield.
     *
     * @param x     the x
     * @param y     the y
     * @param team  the team
     * @param board the board
     */
    public Shield(int x, int y,int team,int[][]board) {
        super(10, -150, 1000, 1, 1, team,x, y,board);
    }
}
