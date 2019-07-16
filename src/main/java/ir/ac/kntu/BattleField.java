package ir.ac.kntu;

/**
 * The type Battle field.
 */
public class BattleField {
    /**
     * The Board.
     */
    private Board board;

    /**
     * Instantiates a new Battle field.
     *
     * @param board the board
     */
    public BattleField(Board board) {
        this.board = board;
    }

    /**
     * Run.
     */
    public void run() {
        while (true) {
            towerShootSoldier(board);
            soldierShoot(board);
            soldierMove(board);
            if (checkPlayerAlive(board)) {
                return;
            }
            board.getPlayer1().setMana(10);
            board.getPlayer2().setMana(10);
        }
    }

    private void soldierMove(Board board) {
        for (int again = 0; again < 2; again++) {
            for (Soldier soldier : board.getSoldiers()) {
                if ((again == 0 && !soldier.enemyField()) ||
                        (again == 1 && soldier.enemyField())) {
                    soldier.move(board);
                    if (checkPlayerAlive(board)) {
                        return;
                    }
                }
            }
        }
    }

    private boolean checkPlayerAlive(Board board) {
        if (board.getPlayer1().getHealth() > 0 &&
                board.getPlayer2().getHealth() > 0) {
            return true;
        }
        return true;
    }

    private void soldierShoot(Board board) {
        for (int again = 0; again < 2; again++) {
            for (Soldier attack : board.getSoldiers()) {
                if ((again == 0 && !attack.enemyField()) ||
                        (again == 1 && attack.enemyField())) {
                    Tower tower = soldierCheckTower(attack, board);
                    if (tower != null) {
                        tower.setHealth(attack.getDamage());
                    } else {
                        Soldier soldier = soldierCheckSoldier(attack, board);
                        soldier.setHealth(attack.getDamage());
                    }
                }
            }
        }
    }

    private Soldier soldierCheckSoldier(Soldier attack, Board board) {
        for (int i = -attack.getRange();
             i <= attack.getRange(); i++) {
            for (int j = -attack.getRange();
                 j <= attack.getRange(); j++) {
                int tempI = attack.getX() + i;
                int tempJ = attack.getY() + j;
                for (Soldier soldier : board.getSoldiers()) {
                    if ((
                            (attack.getDamage() > 0 &&
                                    attack.getTeam() == soldier.getTeam())
                                    ||
                                    (attack.getDamage() < 0 &&
                                            attack.getTeam() !=
                                                    soldier.getTeam())) &&
                            (tempI == soldier.getX() &&
                                    tempJ == soldier.getY())) {
                        return soldier;
                    }
                }
            }
        }
        return null;
    }

    private Tower soldierCheckTower(Soldier soldier, Board board) {
        for (int i = -soldier.getRange();
             i <= soldier.getRange(); i++) {
            for (int j = -soldier.getRange();
                 j <= soldier.getRange(); j++) {
                int tempI = soldier.getX() + i;
                int tempJ = soldier.getY() + j;
                for (Tower tower : board.getTowers()) {
                    if (tower.getTeam() != soldier.getTeam()) {
                        if (tower.getX() == tempI &&
                                tower.getY() == tempJ) {
                            return tower;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Tower shoot soldier.
     *
     * @param board the board
     */
    public void towerShootSoldier(Board board) {
        for (Tower tower : board.getTowers()) {
            Soldier soldier = towerCheckSoldier(tower, board);
            if (soldier != null) {
                if (!soldier.setHealth(tower.getDamage())) {
                    board.getSoldiers().remove(soldier);
                }
            }
        }
    }

    /**
     * Tower check soldier soldier.
     *
     * @param tower the tower
     * @param board the board
     * @return the soldier
     */
    public Soldier towerCheckSoldier(Tower tower, Board board) {
        for (int i = -tower.getRange();
             i <= tower.getRange(); i++) {
            for (int j = -tower.getRange();
                 j <= tower.getRange(); j++) {
                int tempI = tower.getX() + i;
                int tempJ = tower.getY() + j;
                for (Soldier enemy : board.getSoldiers()) {
                    if (((tower.getDamage() > 0 &&
                            tower.getTeam() == tower.getTeam())
                            ||
                            (tower.getDamage() < 0 &&
                                    tower.getTeam() != enemy.getTeam())) &&
                            (tempI == enemy.getX() &&
                                    tempJ == enemy.getY())) {
                        return enemy;
                    }
                }
            }
        }
        return null;
    }
}
