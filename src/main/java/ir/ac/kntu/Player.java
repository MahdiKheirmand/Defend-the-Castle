package ir.ac.kntu;

/**
 * The type Player.
 */
public class Player {
    private String name;
    private int team;
    private int mana;
    private int health;
    private boolean soldierTower;
//    private int blackTowerLeft;
//    private int electricalTowerLeft;
//    private int hospitalTowerLeft;

    /**
     * Instantiates a new Player.
     *
     * @param name   the name
     * @param team   the team
     * @param towers the towers
     */
    public Player(String name, int team, int towers) {
        this.team = team;
        this.name = name;
        mana = 100;
        health = 3;
        soldierTower = false;
//        blackTowerLeft = towers;
//        electricalTowerLeft = towers;
//        hospitalTowerLeft = towers;
    }

    /*public int getBlackTowerLeft() {
        return blackTowerLeft;
    }

    public void setBlackTowerLeft() {
        blackTowerLeft--;
    }

    public int getElectricalTowerLeft() {
        return electricalTowerLeft;
    }

    public void setElectricalTowerLeft() {
        electricalTowerLeft--;
    }

    public int getHospitalTowerLeft() {
        return hospitalTowerLeft;
    }

    public void setHospitalTowerLeft() {
        hospitalTowerLeft--;
    }*/

    /**
     * Is soldier tower boolean.
     *
     * @return the boolean
     */
    public boolean isSoldierTower() {
        return soldierTower;
    }

    /**
     * Sets soldier tower.
     *
     * @param soldierTower the soldier tower
     */
    public void setSoldierTower(boolean soldierTower) {
        this.soldierTower = soldierTower;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public int getTeam() {
        return team;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets mana.
     *
     * @return the mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * Sets mana.
     *
     * @param mana the mana
     */
    public void setMana(int mana) {
        if (soldierTower) {
            mana /= 4;
        }
        this.mana += mana;
        if (this.mana > 100) {
            this.mana = 100;
        }
    }

    /**
     * Gets health.
     *
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health.
     */
    public void setHealth() {
        health--;
    }
}