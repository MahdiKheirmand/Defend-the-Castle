package ir.ac.kntu;

import ir.ac.kntu.Soldiers.*;
import javafx.scene.input.KeyCode;

/**
 * The type Player 2 thread.
 */
public class Player2Thread implements Runnable {

    private Board board;
    private BoardFx boardFx;

    /**
     * Instantiates a new Player 2 thread.
     *
     * @param board   the board
     * @param boardFx the board fx
     */
    public Player2Thread(Board board, BoardFx boardFx) {
        this.board = board;
        this.boardFx = boardFx;
    }

    /**
     *
     */
    @Override
    public void run() {

        KeyCode[] player2keyCodes = new KeyCode[]{
                KeyCode.U, KeyCode.I, KeyCode.O, KeyCode.P,
                KeyCode.J, KeyCode.K, KeyCode.L,
                KeyCode.DIGIT8, KeyCode.DIGIT9, KeyCode.DIGIT0};

        boolean related = false;
        for (KeyCode keyCode : player2keyCodes) {
            if (boardFx.getLastPressedKey() == keyCode) {
                related = true;
            }
        }
        if (!related) {
            return;
        }

        synchronized (board.getPlayer2()) {
            switch (boardFx.getLastPressedKey()) {
                // Archer
                case U:
                    if (board.getPlayer2().getMana() >= 15) {
                        Archer archer = new Archer(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-15);
                        board.addSoldier(archer);
                    }
                    break;
                //Dragon
                case I:
                    if (board.getPlayer2().getMana() >= 35) {
                        Dragon dragon = new Dragon(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-35);
                        board.addSoldier(dragon);
                    }
                    break;
                //Goblin
                case O:
                    if (board.getPlayer2().getMana() >= 10) {
                        Goblin goblin = new Goblin(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-10);
                        board.addSoldier(goblin);
                    }
                    break;
                //Healer
                case P:
                    if (board.getPlayer2().getMana() >= 30) {
                        Healer healer = new Healer(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-30);
                        board.addSoldier(healer);
                    }
                    break;
                //Knighr
                case J:
                    if (board.getPlayer2().getMana() >= 30) {
                        Knight knight = new Knight(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-30);
                        board.addSoldier(knight);
                    }
                    break;
                //Shield
                case K:
                    if (board.getPlayer2().getMana() >= 10) {
                        Shield shield = new Shield(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-10);
                        board.addSoldier(shield);
                    }
                    break;
                //SwordsMan
                case L:
                    if (board.getPlayer2().getMana() >= 20) {
                        SwordsMan swordsMan = new SwordsMan(0, 0,
                                board.getPlayer2().getTeam(), board.getBoard());
                        board.getPlayer2().setMana(-20);
                        board.addSoldier(swordsMan);
                    }
                    break;
                default:
                    break;
            }
        }


    }
}
