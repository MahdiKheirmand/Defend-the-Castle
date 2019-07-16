package ir.ac.kntu;

import java.util.ArrayList;

/**
 * The type Board.
 */
public class Board {
    private Player player1;
    private Player player2;
    private ArrayList<Soldier> soldiers;
    private ArrayList<Tower> towers;
    private int[][] board;
    private int amountOfEachTower;
    private int typesOfTower;
    private int typesOfSoldier;

    /**
     * Instantiates a new Board.
     */
    public Board() {
        soldiers = new ArrayList<>();
        towers = new ArrayList<>();
        board = new int[20][20];
        player1 = new Player("", 1, amountOfEachTower);
        player2 = new Player("", 2, amountOfEachTower);
        amountOfEachTower = 3;
        typesOfTower = 3;
        typesOfSoldier = 4;
    }

    /**
     * Gets amount of each tower.
     *
     * @return the amount of each tower
     */
    public int getAmountOfEachTower() {
        return amountOfEachTower;
    }

    /**
     * Gets types of tower.
     *
     * @return the types of tower
     */
    public int getTypesOfTower() {
        return typesOfTower;
    }

    /**
     * Gets types of soldier.
     *
     * @return the types of soldier
     */
    public int getTypesOfSoldier() {
        return typesOfSoldier;
    }

    /**
     * Gets soldiers.
     *
     * @return the soldiers
     */
    public ArrayList<Soldier> getSoldiers() {
        ArrayList<Soldier> copy = soldiers;
        return copy;
    }

    /**
     * Gets towers.
     *
     * @return the towers
     */
    public ArrayList<Tower> getTowers() {
        ArrayList<Tower> copy = towers;
        return copy;
    }

    /**
     * Add soldier.
     *
     * @param soldier the soldier
     */
    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    /**
     * Add tower.
     *
     * @param tower the tower
     */
    public void addTower(Tower tower) {
        towers.add(tower);
    }

    /**
     * Gets player 1.
     *
     * @return the player 1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets player 2.
     *
     * @return the player 2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Get board int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Sets board.
     *
     * @param charsArray the chars array
     * @param length     the length
     */
    public void setBoard(char[] charsArray, double length) {
        int k = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                switch (charsArray[k]) {
                    case 'r':
                        if (i == 0) {
                            board[i][j] = 1;
                        } else {
                            board[i][j] = 2;
                        }
                        break;
                    case 'b':
                        board[i][j] = 3;
                        break;
                    case 'y':
                        board[i][j] = 4;
                        break;
                    case 'g':
                        board[i][j] = 5;
                        break;
                    default:
                        board[i][j] = 0;
                        break;
                }
                k++;
            }
        }
    }


}
