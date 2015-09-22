package edu.gatech.cs2340.GameEngine;

import edu.gatech.cs2340.Game;
import edu.gatech.cs2340.Maps.Tile;
import edu.gatech.cs2340.Maps.TileType;
import edu.gatech.cs2340.players.Person;

import java.util.ArrayList;

/**
 * Created by Nick on 9/22/2015.
 */
public class Turn {
    private  Game game;
    private ArrayList<Person> players;

    public Turn(Game game) {
        this.game = game;
        players = new ArrayList<>();
        players.addAll(game.getPlayers());
        game.setCurrentPlayer(players.get(0));
        if (game.getRoundNumber() == 1) {
            game.incrementRound();
            game.startRound();
        }
    }

    public void move(Tile tile) {
        if (tile.getTileType() == TileType.TOWN) {
            game.goToTown();
        }
    }
}
