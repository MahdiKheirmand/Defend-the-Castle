package ir.ac.kntu;

import ir.ac.kntu.Towers.BlackTower;
import ir.ac.kntu.Towers.ElectricalTower;
import ir.ac.kntu.Towers.HospitalTower;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * The type Board fx.
 */
public class BoardFx extends Application {
    private Stage primaryStage2 = new Stage();
    private Scene setPlayerName;
    private Scene chooseP1ElTower, chooseP1BlTower, chooseP1HTower;
    private Scene chooseP2ElTower, chooseP2BlTower, chooseP2HTower;
    private Scene drawBoard;
    private KeyCode lastPressedKey;

    /**
     * Gets last pressed key.
     *
     * @return the last pressed key
     */
    public KeyCode getLastPressedKey() {
        return lastPressedKey;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage2 = primaryStage;
        Board board = new Board();
        setPlayerName = new Scene(setPlayerNames(
                board.getPlayer1(), board.getPlayer2()), 1040, 1040);

        /*for (int i = 0; i < 2 * board.getTypesOfSoldier(); i++) {
            if (i < board.getTypesOfSoldier()) {
                chooseSoldier = new Scene
                    (chooseSoldiers(board.getPlayer1()),1040,1040);
            } else {
                chooseSoldier = new Scene
                    (chooseSoldiers(board.getPlayer2()),1040,1040);
            }
        }*/

        //SubmitSoldier

        File file = new File();
        String input = file.ReadFile();
        double inputLength = Math.sqrt(input.length());
        char[] charsArray = input.toCharArray();
        board.setBoard(charsArray, inputLength);

        chooseP1ElTower = new Scene(chooseP1ElTowers(board), 1040, 1040);
        chooseP1BlTower = new Scene(chooseP1BlTowers(board), 1040, 1040);
        chooseP1HTower = new Scene(chooseP1HTowers(board), 1040, 1040);

        chooseP2ElTower = new Scene(chooseP2ElTowers(board), 1040, 1040);
        chooseP2BlTower = new Scene(chooseP2BlTowers(board), 1040, 1040);
        chooseP2HTower = new Scene(chooseP2HTowers(board), 1040, 1040);

        Pane pane = new Pane();
        drawBoard = new Scene(drawBoards(pane, board), 1040, 1040);
        /*for (int i = 0; i < 2 *
                board.getAmountOfEachTower() *
                    board.getTypesOfTower(); i++) {
            if (i < board.getTypesOfTower() *
                    board.getAmountOfEachTower()) {
                chooseTower = new Scene(
                    chooseTowers(board.getPlayer1(), board));
            } else {
                chooseTower = new Scene(
                    chooseTowers(board.getPlayer2(), board));
            }
        }*/

        primaryStage2.setScene(setPlayerName);
        primaryStage2.show();
        /*Thread main = new Thread((Runnable) new BattleField(board));
        main.start();
        drawBoard.setOnKeyPressed(event -> {
            lastPressedKey = event.getCode();
            Thread thread1 = new Thread(new Player1Thread(board,this));
            Thread thread2 = new Thread(new Player2Thread(board,this));
            thread1.start();
            thread2.start();
        });*/
    }

    private GridPane chooseP2HTowers(Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Label player = new Label("Player 2");
        Label h1 = new Label("Hospital Tower 1");
        Label h2 = new Label("Hospital Tower 2");
        Label h3 = new Label("Hospital Tower 3");
        Label x = new Label("x");
        Label y = new Label("y");
        TextField x1 = new TextField("2");
        TextField y1 = new TextField("12");
        TextField x2 = new TextField("6");
        TextField y2 = new TextField("12");
        TextField x3 = new TextField("14");
        TextField y3 = new TextField("12");
        Button submit = new Button("Submit");

        GridPane.setConstraints(player, 0, 2);
        GridPane.setConstraints(h1, 1, 1);
        GridPane.setConstraints(h2, 1, 2);
        GridPane.setConstraints(h3, 1, 3);
        GridPane.setConstraints(x, 2, 0);
        GridPane.setConstraints(y, 3, 0);
        GridPane.setConstraints(x1, 2, 1);
        GridPane.setConstraints(x2, 2, 2);
        GridPane.setConstraints(x3, 2, 3);
        GridPane.setConstraints(y1, 3, 1);
        GridPane.setConstraints(y2, 3, 2);
        GridPane.setConstraints(y3, 3, 3);
        GridPane.setConstraints(submit, 4, 2);

        gridPane.getChildren().addAll(
                player, h1, h2, h3, x, y, x1, x2, x3, y1, y2, y3, submit);

        submit.setOnAction(click -> {
            HospitalTower b1 = new HospitalTower(
                    Integer.parseInt(x1.getText()),
                    Integer.parseInt(y1.getText()), 2);
            board.addTower(b1);
            HospitalTower b2 = new HospitalTower(
                    Integer.parseInt(x2.getText()),
                    Integer.parseInt(y2.getText()), 2);
            board.addTower(b2);
            HospitalTower b3 = new HospitalTower(
                    Integer.parseInt(x3.getText()),
                    Integer.parseInt(y3.getText()), 2);
            board.addTower(b3);
            primaryStage2.setScene(drawBoard);
        });
        return gridPane;
    }

    private GridPane chooseP2BlTowers(Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Label player = new Label("Player 2");
        Label bl1 = new Label("Black Tower 1");
        Label bl2 = new Label("Black Tower 2");
        Label bl3 = new Label("Black Tower 3");
        Label x = new Label("x");
        Label y = new Label("y");
        TextField x1 = new TextField("5");
        TextField y1 = new TextField("16");
        TextField x2 = new TextField("13");
        TextField y2 = new TextField("16");
        TextField x3 = new TextField("16");
        TextField y3 = new TextField("16");
        Button submit = new Button("Submit");

        GridPane.setConstraints(player, 0, 2);
        GridPane.setConstraints(bl1, 1, 1);
        GridPane.setConstraints(bl2, 1, 2);
        GridPane.setConstraints(bl3, 1, 3);
        GridPane.setConstraints(x, 2, 0);
        GridPane.setConstraints(y, 3, 0);
        GridPane.setConstraints(x1, 2, 1);
        GridPane.setConstraints(x2, 2, 2);
        GridPane.setConstraints(x3, 2, 3);
        GridPane.setConstraints(y1, 3, 1);
        GridPane.setConstraints(y2, 3, 2);
        GridPane.setConstraints(y3, 3, 3);
        GridPane.setConstraints(submit, 4, 2);

        gridPane.getChildren().addAll(
                player, bl1, bl2, bl3, x, y, x1, x2, x3, y1, y2, y3, submit);

        submit.setOnAction(click -> {
            BlackTower b1 = new BlackTower(
                    Integer.parseInt(x1.getText()),
                    Integer.parseInt(y1.getText()), 2);
            board.addTower(b1);
            BlackTower b2 = new BlackTower(
                    Integer.parseInt(x2.getText()),
                    Integer.parseInt(y2.getText()), 2);
            board.addTower(b2);
            BlackTower b3 = new BlackTower(
                    Integer.parseInt(x3.getText()),
                    Integer.parseInt(y3.getText()), 2);
            board.addTower(b3);
            primaryStage2.setScene(chooseP2HTower);
        });
        return gridPane;
    }

    private GridPane chooseP2ElTowers(Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Label player = new Label("Player 2");
        Label el1 = new Label("Electrical Tower 1");
        Label el2 = new Label("Electrical Tower 2");
        Label el3 = new Label("Electrical Tower 3");
        Label x = new Label("x");
        Label y = new Label("y");
        TextField x1 = new TextField("0");
        TextField y1 = new TextField("15");
        TextField x2 = new TextField("18");
        TextField y2 = new TextField("15");
        TextField x3 = new TextField("18");
        TextField y3 = new TextField("18");
        Button submit = new Button("Submit");

        GridPane.setConstraints(player, 0, 2);
        GridPane.setConstraints(el1, 1, 1);
        GridPane.setConstraints(el2, 1, 2);
        GridPane.setConstraints(el3, 1, 3);
        GridPane.setConstraints(x, 2, 0);
        GridPane.setConstraints(y, 3, 0);
        GridPane.setConstraints(x1, 2, 1);
        GridPane.setConstraints(x2, 2, 2);
        GridPane.setConstraints(x3, 2, 3);
        GridPane.setConstraints(y1, 3, 1);
        GridPane.setConstraints(y2, 3, 2);
        GridPane.setConstraints(y3, 3, 3);
        GridPane.setConstraints(submit, 4, 2);

        gridPane.getChildren().addAll(player,
                el1, el2, el3, x, y, x1, x2, x3, y1, y2, y3, submit);

        submit.setOnAction(click -> {
            ElectricalTower e1 = new ElectricalTower(
                    Integer.parseInt(x1.getText()),
                    Integer.parseInt(y1.getText()), 2);
            board.addTower(e1);
            ElectricalTower e2 = new ElectricalTower(
                    Integer.parseInt(x2.getText()),
                    Integer.parseInt(y2.getText()), 2);
            board.addTower(e2);
            ElectricalTower e3 = new ElectricalTower(
                    Integer.parseInt(x3.getText()),
                    Integer.parseInt(y3.getText()), 2);
            board.addTower(e3);
            primaryStage2.setScene(chooseP2BlTower);
        });
        return gridPane;
    }

    private GridPane chooseP1HTowers(Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Label player = new Label("Player 1");
        Label h1 = new Label("Hospital Tower 1");
        Label h2 = new Label("Hospital Tower 2");
        Label h3 = new Label("Hospital Tower 3");
        Label x = new Label("x");
        Label y = new Label("y");
        TextField x1 = new TextField("4");
        TextField y1 = new TextField("7");
        TextField x2 = new TextField("12");
        TextField y2 = new TextField("7");
        TextField x3 = new TextField("18");
        TextField y3 = new TextField("7");
        Button submit = new Button("Submit");

        GridPane.setConstraints(player, 0, 2);
        GridPane.setConstraints(h1, 1, 1);
        GridPane.setConstraints(h2, 1, 2);
        GridPane.setConstraints(h3, 1, 3);
        GridPane.setConstraints(x, 2, 0);
        GridPane.setConstraints(y, 3, 0);
        GridPane.setConstraints(x1, 2, 1);
        GridPane.setConstraints(x2, 2, 2);
        GridPane.setConstraints(x3, 2, 3);
        GridPane.setConstraints(y1, 3, 1);
        GridPane.setConstraints(y2, 3, 2);
        GridPane.setConstraints(y3, 3, 3);
        GridPane.setConstraints(submit, 4, 2);

        gridPane.getChildren().addAll(player,
                h1, h2, h3, x1, x, y, x2, x3, y1, y2, y3, submit);

        submit.setOnAction(click -> {
            HospitalTower b1 = new HospitalTower(
                    Integer.parseInt(x1.getText()),
                    Integer.parseInt(y1.getText()), 1);
            board.addTower(b1);
            HospitalTower b2 = new HospitalTower(
                    Integer.parseInt(x2.getText()),
                    Integer.parseInt(y2.getText()), 1);
            board.addTower(b2);
            HospitalTower b3 = new HospitalTower(
                    Integer.parseInt(x3.getText()),
                    Integer.parseInt(y3.getText()), 1);
            board.addTower(b3);
            primaryStage2.setScene(chooseP2ElTower);
        });
        return gridPane;
    }

    private GridPane chooseP1BlTowers(Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Label player = new Label("Player 1");
        Label bl1 = new Label("Black Tower 1");
        Label bl2 = new Label("Black Tower 2");
        Label bl3 = new Label("Black Tower 3");
        Label x = new Label("x");
        Label y = new Label("y");
        TextField x1 = new TextField("5");
        TextField y1 = new TextField("3");
        TextField x2 = new TextField("13");
        TextField y2 = new TextField("3");
        TextField x3 = new TextField("18");
        TextField y3 = new TextField("3");
        Button submit = new Button("Submit");

        GridPane.setConstraints(player, 0, 2);
        GridPane.setConstraints(bl1, 1, 1);
        GridPane.setConstraints(bl2, 1, 2);
        GridPane.setConstraints(bl3, 1, 3);
        GridPane.setConstraints(x, 2, 0);
        GridPane.setConstraints(y, 3, 0);
        GridPane.setConstraints(x1, 2, 1);
        GridPane.setConstraints(x2, 2, 2);
        GridPane.setConstraints(x3, 2, 3);
        GridPane.setConstraints(y1, 3, 1);
        GridPane.setConstraints(y2, 3, 2);
        GridPane.setConstraints(y3, 3, 3);
        GridPane.setConstraints(submit, 4, 2);

        gridPane.getChildren().addAll(player,
                bl1, bl2, bl3, x, y, x1, x2, x3, y1, y2, y3, submit);

        submit.setOnAction(click -> {
            BlackTower b1 = new BlackTower(
                    Integer.parseInt(x1.getText()),
                    Integer.parseInt(y1.getText()), 1);
            board.addTower(b1);
            BlackTower b2 = new BlackTower(
                    Integer.parseInt(x2.getText()),
                    Integer.parseInt(y2.getText()), 1);
            board.addTower(b2);
            BlackTower b3 = new BlackTower(
                    Integer.parseInt(x3.getText()),
                    Integer.parseInt(y3.getText()), 1);
            board.addTower(b3);
            primaryStage2.setScene(chooseP1HTower);
        });
        return gridPane;
    }

    private GridPane chooseP1ElTowers(Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Label player = new Label("Player 1");
        Label el1 = new Label("Electrical Tower 1");
        Label el2 = new Label("Electrical Tower 2");
        Label el3 = new Label("Electrical Tower 3");
        Label x = new Label("x");
        Label y = new Label("y");
        TextField x1 = new TextField("0");
        TextField y1 = new TextField("4");
        TextField x2 = new TextField("4");
        TextField y2 = new TextField("4");
        TextField x3 = new TextField("8");
        TextField y3 = new TextField("5");
        Button submit = new Button("Submit");

        GridPane.setConstraints(player, 0, 2);
        GridPane.setConstraints(el1, 1, 1);
        GridPane.setConstraints(el2, 1, 2);
        GridPane.setConstraints(el3, 1, 3);
        GridPane.setConstraints(x, 2, 0);
        GridPane.setConstraints(y, 3, 0);
        GridPane.setConstraints(x1, 2, 1);
        GridPane.setConstraints(x2, 2, 2);
        GridPane.setConstraints(x3, 2, 3);
        GridPane.setConstraints(y1, 3, 1);
        GridPane.setConstraints(y2, 3, 2);
        GridPane.setConstraints(y3, 3, 3);
        GridPane.setConstraints(submit, 4, 2);

        gridPane.getChildren().addAll(player,
                el1, el2, el3, x, y, x1, x2, x3, y1, y2, y3, submit);

        submit.setOnAction(click -> {
            ElectricalTower e1 = new ElectricalTower(
                    Integer.parseInt(x1.getText()),
                    Integer.parseInt(y1.getText()), 1);
            board.addTower(e1);
            ElectricalTower e2 = new ElectricalTower(
                    Integer.parseInt(x2.getText()),
                    Integer.parseInt(y2.getText()), 1);
            board.addTower(e2);
            ElectricalTower e3 = new ElectricalTower(
                    Integer.parseInt(x3.getText()),
                    Integer.parseInt(y3.getText()), 1);
            board.addTower(e3);
            primaryStage2.setScene(chooseP1BlTower);
        });
        return gridPane;
    }

    /*private GridPane chooseTowers(Player player, Board board) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);

        Label turn = new Label(player.getName());
        Label towers = new Label("Tower(remaining):");
        Label eT = new Label("1.ElectricalTower(" +
            player.getElectricalTowerLeft() + ")");
        Label bT = new Label("2.BlackTower(" +
            player.getBlackTowerLeft() + ")");
        Label hT = new Label("1.HospitalTower(" +
            player.getHospitalTowerLeft() + ")");
        TextField towerChoice = new TextField("
            your tower Choice");
        TextField x = new TextField("x");
        TextField y = new TextField("y");
        Button submit = new Button("Submit");

        GridPane.setConstraints(turn, 0, 0);
        GridPane.setConstraints(towers, 2, 0);
        GridPane.setConstraints(eT, 2, 2);
        GridPane.setConstraints(bT, 4, 2);
        GridPane.setConstraints(hT, 6, 2);
        GridPane.setConstraints(towerChoice, 2, 4);
        GridPane.setConstraints(x, 4, 4);
        GridPane.setConstraints(y, 6, 4);
        GridPane.setConstraints(submit, 8, 4);

        submit.setOnAction(click -> {
            setTowers(player, board,
            towerChoice.getText(), x.getText(), y.getText());
        });
        return gridPane;
    }*/

    /*private void setTowers(Player player,
        Board board, String towerChoice, String x, String y) {
        switch (towerChoice) {
            case "1":
                ElectricalTower electricalTower =
                        new ElectricalTower(Integer.parseInt(x),
                                Integer.parseInt(y), player.getTeam());
                board.addTower(electricalTower);
                player.setElectricalTowerLeft(-1);
                break;
            case "2":
                BlackTower blackTower =
                        new BlackTower(Integer.parseInt(x),
                                Integer.parseInt(y), player.getTeam());
                board.addTower(blackTower);
                player.setBlackTowerLeft(-1);
                break;
            case "3":
                HospitalTower hospitalTower =
                        new HospitalTower(Integer.parseInt(x),
                                Integer.parseInt(y), player.getTeam());
                board.addTower(hospitalTower);
                player.setHospitalTowerLeft(-1);
                break;

        }
    }*/

    private Pane drawBoards(Pane pane, Board board) {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[0].length; j++) {
                switch (board.getBoard()[j][i]) {
                    case 1:
                    case 2:
                        Rectangle r = new Rectangle(
                                (i + 1) * 40, (j + 1) * 40, 40, 40);
                        r.setStroke(Color.BLACK);
                        r.setFill(Color.RED);
                        pane.getChildren().add(r);
                        break;
                    case 3:
                        Rectangle b = new Rectangle(
                                (i + 1) * 40, (j + 1) * 40, 40, 40);
                        b.setStroke(Color.BLACK);
                        b.setFill(Color.BLUE);
                        pane.getChildren().add(b);
                        break;
                    case 4:
                        Rectangle y = new Rectangle(
                                (i + 1) * 40, (j + 1) * 40, 40, 40);
                        y.setStroke(Color.BLACK);
                        y.setFill(Color.YELLOW);
                        pane.getChildren().add(y);
                        break;
                    case 5:
                        Rectangle g = new Rectangle(
                                (i + 1) * 40, (j + 1) * 40, 40, 40);
                        g.setStroke(Color.BLACK);
                        g.setFill(Color.GREEN);
                        pane.getChildren().add(g);
                        break;
                    case 0:
                        Rectangle n = new Rectangle(
                                (i + 1) * 40, (j + 1) * 40, 40, 40);
                        n.setStroke(Color.BLACK);
                        n.setFill(Color.GREY);
                        pane.getChildren().add(n);
                        break;
                    default:
                        break;
                }
            }
        }
        for (Tower tower : board.getTowers()) {
            if (tower instanceof ElectricalTower) {
                Circle el = new Circle(tower.getX(), tower.getY(), 10);
                el.setFill(Color.WHITE);
                pane.getChildren().add(el);
            } else if (tower instanceof BlackTower) {
                Circle bl = new Circle(tower.getX(), tower.getY(), 10);
                bl.setFill(Color.BLACK);
                pane.getChildren().add(bl);
            } else {
                Circle h = new Circle(tower.getX(), tower.getY(), 10);
                h.setFill(Color.GREY);
                pane.getChildren().add(h);
            }
        }
        for (Soldier soldier : board.getSoldiers()) {
            Circle s = new Circle(soldier.getX(), soldier.getY(), 10);
            s.setFill(Color.ORANGE);
            pane.getChildren().add(s);
        }
        return pane;
    }

    /*private GridPane chooseSoldiers(Player player) {
        String name = player.getName();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        Label turn = new Label(name);
        Label archer = new Label("1.Archer");
        Label dragon = new Label("2.Dragon");
        Label goblin = new Label("3.Goblin");
        Label healer = new Label("4.Healer");
        Label knight = new Label("5.knight");
        Label shield = new Label("6.Shield");
        Label swordsMan = new Label("7.SwordsMan");
        TextField choice = new TextField("your choice");
        Button submit = new Button("Submit");
        GridPane.setConstraints(turn, 0, 1);
        GridPane.setConstraints(archer, 0, 2);
        GridPane.setConstraints(dragon, 0, 3);
        GridPane.setConstraints(goblin, 0, 4);
        GridPane.setConstraints(healer, 0, 5);
        GridPane.setConstraints(knight, 0, 6);
        GridPane.setConstraints(shield, 0, 7);
        GridPane.setConstraints(swordsMan, 0, 8);
        GridPane.setConstraints(choice, 0, 10);
        GridPane.setConstraints(submit, 4, 10);

        submit.setOnAction(click -> {
            switchChooseSoldier(player, choice.getText());
        });
        gridPane.getChildren().addAll(turn, archer, dragon, goblin,
                healer, knight, shield, swordsMan, choice, submit);
        return gridPane;
    }*/
    /*
    private void switchChooseSoldier(Player player, String input) {
        switch (input) {
            case "1":
                player.setArcher(true);
                break;
            case "2":
                player.setDragon(true);
                break;
            case "3":
                player.setGoblin(true);
                break;
            case "4":
                player.setGoblin(true);
                break;
            case "5":
                player.setKnight(true);
                break;
            case "6":
                player.setShield(true);
                break;
            case "7":
                player.setSwordsMan(true);
                break;
            default:
                break;
        }
    }*/

    private GridPane setPlayerNames(Player player1, Player player2) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        Label label1 = new Label("Player 1");
        Label label2 = new Label("Player 2");
        TextField textField1 = new TextField("Name");
        TextField textField2 = new TextField("Name");
        Button button = new Button("Game start");
        GridPane.setConstraints(label1, 0, 1);
        GridPane.setConstraints(textField1, 1, 1);
        GridPane.setConstraints(label2, 0, 2);
        GridPane.setConstraints(textField2, 1, 2);
        GridPane.setConstraints(button, 1, 5);
        button.setOnAction(click -> {
            player1.setName(textField1.getText());
            player2.setName(textField2.getText());
            primaryStage2.setScene(chooseP1ElTower);
        });
        gridPane.getChildren().addAll(label1,
                label2, textField1, textField2, button);
        return gridPane;
    }
}
