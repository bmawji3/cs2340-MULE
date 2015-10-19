package edu.gatech.cs2340.GameEngine;

import edu.gatech.cs2340.Game;
import edu.gatech.cs2340.GameObject.Player;
import edu.gatech.cs2340.Maps.Tile;
import edu.gatech.cs2340.Maps.TownTile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 9/22/2015.
 * @author Nick, Shyam
 */
public class Turn {
    private  Game game;
    private ArrayList<Player> players;
    private Label label;
    private int turnTime = 50;
    private int timeRemaining;
    private Timeline timer;

    public boolean mule;
    private Stage stage;

    public Turn(Game game) {
        this.game = game;
        players = new ArrayList<>();
        players.addAll(game.getPlayers());
        game.setCurrentPlayer(players.get(0));
        setTurnTime();
        label = new Label();
        game.getMap().getStackPane().getChildren().add(label);
        label.setFont(Font.font(24));
        StackPane.setAlignment(label, Pos.TOP_RIGHT);
        label.setTextFill(Paint.valueOf("white"));
        turnTimerCreator();
        mule = false;
    }

    public void move(Tile tile) {
        if (tile instanceof TownTile) {
            game.goToTown();
        }
    }

    public int getTurnTime() {
        return turnTime;
    }

    public void setTurnTime() {
        Player player = players.get(0);
        if (player.getFood() >= 12) {
            turnTime = 50;
        } else if (player.getFood() > 8) {
            turnTime = 30;
        } else {
            turnTime = 50;
        }
    }

    public void endPlayerTurn() {
        game.setState(Game.GameState.TURN);
        game.getCurrentPlayer().setMule(null);
        game.getCurrentPlayer().muleBoughtThisTurn = false;
        this.game.getScene().setCursor(Cursor.DEFAULT);
        players.remove(game.getCurrentPlayer());
        game.timer.stop();

        if (players.isEmpty()) {
            calcProduction();
            game.incrementRound();
            game.startRound();
            label.setText("");
        } else {
            game.setCurrentPlayer(players.get(0));
            setTurnTime();
            turnTimerCreator();
        }

    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public void turnTimerCreator() {
        game.timer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            private int turnTime;
            public int checker;
            private Player player = game.getCurrentPlayer();

            public void handle(ActionEvent event) {
                timerMethod();
            }

            public void timerMethod() {
                turnTime = game.getTurn().getTurnTime();
                if (!game.getCurrentPlayer().equals(player)) {
                    game.getTurn().getLabel().setText("");
                    timer.stop();
                    if (players.size() != 0) {
                        turnTimerCreator();
                    }
                } else {
                    timeRemaining = turnTime - checker - 1;
                    game.getTurn().getLabel().setText(timeRemaining + " seconds "
                            + "remaining");
                    checker++;
                    if (turnTime - checker == 0) {
                        checker = 0;
                        if (game.getStoreEntered()) {
                            game.getTown().getStoreController().onStoreLeave();
                        }

                        if (game.getTownEntered()) {
                            game.getTown().onExitClicked();
                        }
                        game.getTurn().getLabel().setText("");
                        game.getTurn().getLabel().setText("Your have run out of time");
                        game.getTurn().endPlayerTurn();
                    }
                }
            }
        }));
        timer = game.timer;
        timer.setCycleCount(turnTime);
        timer.play();
    }

    public Label getLabel() {
        return label;
    }

    private void calcProduction() {
        List<Player> players = game.getPlayers();
        for (Player p : players) {
            p.calcProduction();
        }
    }

//    TODO summary should be at beginning of turn
    public void summary() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("/resources/Summary.fxml"));
        loader.setClassLoader(this.getClass().getClassLoader());

        Parent root = null;

        try {
            root = loader.load();
            root.toFront();
        } catch (IOException e) {
            System.out.println("IOException loading Summary.fxml");
            System.out.println(e.getMessage());
        }

        Scene scene = new Scene(root, 1600, 900);
        this.game.getStage().setTitle("Summary!");
        this.game.getStage().setScene(scene);
        this.game.getStage().show();
//        Rectangle2D bounds = Screen.getPrimary().getBounds();
//        Scene scene = new Scene(root, bounds.getMaxX(), bounds.getMaxY());
//        stage.setScene(scene);
    }


}
