package ir.ac.kntu.Towers;

import ir.ac.kntu.Tower;

/**
 * The type Electrical tower.
 */
public class ElectricalTower extends Tower {
    /**
     * Instantiates a new Electrical tower.
     *
     * @param x    the x
     * @param y    the y
     * @param team the team
     */
    public ElectricalTower(int x, int y,int team) {
        super(45, 1500, -250, 3,team,x,y);
    }
}
