package ir.ac.kntu;

import ir.ac.kntu.Soldiers.*;
import javafx.scene.input.KeyCode;

/**
 * The type Player 1 thread.
 */
public class Player1Thread implements Runnable {

    private Board board;
    private BoardFx boardFx;

    /**
     * Instantiates a new Player 1 thread.
     *
     * @param board   the board
     * @param boardFx the board fx
     */
    public Player1Thread(Board board, BoardFx boardFx) {
        this.board = board;
        this.boardFx = boardFx;
    }

    /**
     *
     */
    @Override
    public void run() {
        
        KeyCode[] player1keyCodes = new KeyCode[]{
                KeyCode.Q, KeyCode.W, KeyCode.E, KeyCode.R,
                KeyCode.S, KeyCode.D, KeyCode.A,
                KeyCode.Z, KeyCode.X, KeyCode.C};

        boolean related = false;
        for (KeyCode keyCode : player1keyCodes) {
            if (boardFx.getLastPressedKey() == keyCode) {
                related = true;
            }
        }
        if (!related) {
            return;
        }

        synchronized (board.getPlayer1()) {
            switch (boardFx.getLastPressedKey()) {
                // Archer
                case Q:
                    if (board.getPlayer1().getMana() >= 15) {
                        Archer archer = new Archer(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-15);
                        board.addSoldier(archer);
                    }
                    break;
                //Dragon
                case W:
                    if (board.getPlayer1().getMana() >= 35) {
                        Dragon dragon = new Dragon(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-35);
                        board.addSoldier(dragon);
                    }
                    break;
                //Goblin
                case E:
                    if (board.getPlayer1().getMana() >= 10) {
                        Goblin goblin = new Goblin(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-10);
                        board.addSoldier(goblin);
                    }
                    break;
                //Healer
                case R:
                    if (board.getPlayer1().getMana() >= 30) {
                        Healer healer = new Healer(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-30);
                        board.addSoldier(healer);
                    }
                    break;
                //Knighr
                case A:
                    if (board.getPlayer1().getMana() >= 30) {
                        Knight knight = new Knight(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-30);
                        board.addSoldier(knight);
                    }
                    break;
                //Shield
                case S:
                    if (board.getPlayer1().getMana() >= 10) {
                        Shield shield = new Shield(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-10);
                        board.addSoldier(shield);
                    }
                    break;
                //SwordsMan
                case D:
                    if (board.getPlayer1().getMana() >= 20) {
                        SwordsMan swordsMan = new SwordsMan(0, 0,
                                board.getPlayer1().getTeam(), board.getBoard());
                        board.getPlayer1().setMana(-20);
                        board.addSoldier(swordsMan);
                    }
                    break;
                default:
                    break;
            }
        }


    }
}
