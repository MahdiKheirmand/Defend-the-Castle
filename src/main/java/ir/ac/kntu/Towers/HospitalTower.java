package ir.ac.kntu.Towers;

import ir.ac.kntu.Tower;

/**
 * The type Hospital tower.
 */
public class HospitalTower extends Tower {
    /**
     * Instantiates a new Hospital tower.
     *
     * @param team the team
     * @param x    the x
     * @param y    the y
     */
    public HospitalTower(int team, int x, int y) {
        super(50, 1000, 100, 2, team, x, y);
    }
}
