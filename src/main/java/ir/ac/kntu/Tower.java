package ir.ac.kntu;

/**
 * The type Tower.
 */
public class Tower {
    private int team;
    private int mana;
    private int health;
    private int damage;
    private int range;
    private int x, y;

    /**
     * Instantiates a new Tower.
     *
     * @param mana   the mana
     * @param health the health
     * @param damage the damage
     * @param range  the range
     * @param team   the team
     * @param x      the x
     * @param y      the y
     */
    public Tower(int mana, int health,
                 int damage, int range,
                 int team, int x, int y) {
        this.team = team;
        this.mana = mana;
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.x = x;
        this.y = y;
    }

    /**
     * Sets mana.
     *
     * @param mana the mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Sets health.
     *
     * @param health the health
     * @return the health
     */
    public boolean setHealth(int health) {
        this.health += health;
        if (health > 0){
            return true;
        }
        return false;
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
     * Gets mana.
     *
     * @return the mana
     */
    public int getMana() {
        return mana;
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
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets range.
     *
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }
}
