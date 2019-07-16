package ir.ac.kntu;

/**
 * The type Soldier.
 */
public class Soldier {
    private int team;
    private int mana;
    private int damage;
    private int health;
    private int pace;
    private int range;
    private int x, y;
    private int destX, destY;

    /**
     * Instantiates a new Soldier.
     *
     * @param mana   the mana
     * @param damage the damage
     * @param health the health
     * @param pace   the pace
     * @param range  the range
     * @param team   the team
     * @param x      the x
     * @param y      the y
     * @param board  the board
     */
    public Soldier(int mana, int damage,
                   int health, int pace, int range,
                   int team, int x, int y, int[][] board) {
        this.mana = mana;
        this.damage = damage;
        this.health = health;
        this.pace = pace;
        this.range = range;
        this.team = team;
        this.x = x;
        this.y = y;
        nearDest(board);
    }

    private void nearDest(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1 && team == 2) {
                    destX = x;
                    destY = 0;
                } else if (board[i][j] == 2 && team == 1) {
                    destX = x;
                    destY = 19;
                }
            }
        }
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
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
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
     *
     * @param health the health
     * @return the health
     */
    public boolean setHealth(int health) {
        this.health += health;
        if(this.health > 0){
            return true;
        }
        return false;
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
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Move.
     *
     * @param board the board
     */
    public void move(Board board) {
        for (int i = x - 1; i <= x + 1; i++) {
            if (((board.getBoard()[i][y] == 4 ) ||
                    (i == destX && y == destY))&&
                    distance(i, x, y, destX, 1, board)
                    && i != x) {
                return;
            }
        }
        for (int j = y - 1; j <= y + 1; j++) {
            if ((board.getBoard()[x][j] == 4 ||
                    (x == destX && j == destY))&&
                    distance(j, y, x, destY, 2, board) &&
                    j != y) {
                return;
            }
        }
    }

    private boolean distance(int finalVar, int initVar,
                             int constant, int destination,
                             int xy, Board board) {
        if (finalVar <= destination && finalVar > initVar) {
            for (int tempI = initVar + pace; tempI > initVar; tempI--) {
                if (checkPlace(tempI, constant, board)) {
                    if(setFinalPlace(finalVar, xy)){
                        if(team==1){
                            board.getPlayer2().setHealth();
                        }else {
                            board.getPlayer1().setHealth();
                        }
                    }
                    return true;
                }
            }
        }
        if (finalVar >= destination && finalVar < initVar) {
            for (int tempI = initVar - pace; tempI < initVar; tempI++) {
                if (checkPlace(tempI, constant, board)) {
                    setFinalPlace(finalVar, xy);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean setFinalPlace(int finalVar, int xy) {
        if (xy == 1) {
            x = finalVar;
        } else {
            y = finalVar;
        }
        if(x == destX && y ==destY){
            return true;
        }
        return false;
    }

    private boolean checkPlace(int i, int j, Board board) {
        return (board.getBoard()[i][j] == 4 &&
                !checkEnemyBetween(i, j, board) &&
                !checkAllie(i, j, board));
    }

    private boolean checkAllie(int tempI, int j, Board board) {
        for (Soldier allie : board.getSoldiers()) {
            if (team == allie.team &&
                    allie.x == tempI &&
                    allie.y == j) {
                return true;
            }
        }
        return false;
    }

    private boolean checkEnemyBetween(int i, int j, Board board) {
        for (int tempI = x + 1; tempI <= i; tempI++) {
            for (Soldier enemy : board.getSoldiers()) {
                if (team != enemy.team &&
                        enemy.x == tempI && enemy.y == j) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Enemy field boolean.
     *
     * @return the boolean
     */
    public boolean enemyField(){
        return Math.abs(x-destX) <= 20;
    }
}

