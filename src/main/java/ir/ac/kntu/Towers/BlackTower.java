package ir.ac.kntu.Towers;

import ir.ac.kntu.Tower;

/**
 * The type Black tower.
 */
public class BlackTower extends Tower {


    /**
     * Instantiates a new Black tower.
     *
     * @param x    the x
     * @param y    the y
     * @param team the team
     */
    public BlackTower(int x, int y,int team) {
        super(40, 2000, -300, 2,team,x,y);
    }
}
