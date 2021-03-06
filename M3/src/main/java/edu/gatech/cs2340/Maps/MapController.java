package edu.gatech.cs2340.Maps;

import edu.gatech.cs2340.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Bilal
 * @version 1.0
 */
public class MapController implements Initializable, Serializable {

    private static final int MAP_WIDTH = 9;
    private static final int MAP_HEIGHT = 5;

    private Tile[][] tiles;
    private MapType maptype = MapType.STANDARD;
    @FXML
    private transient GridPane backingPane;
    @FXML
    private transient StackPane stackPane;
    private Game game;
    private static final long serialVersionUID = 2L;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Sets the maptype.
     * @param newMaptype Maptype to be set
     */
    public void setMaptype(MapType newMaptype) {
        this.maptype = newMaptype;
    }

    /**
     * Sets the stackpane.
     * @param newStackPane Stackpane to be set
     */
    public void setStackPane(StackPane newStackPane) {
        this.stackPane = newStackPane;
    }

    /**
     * Sets the gridpane.
     * @param newGridPane Gridpane to be set
     */
    public void setGridPane(GridPane newGridPane) {
        this.backingPane = newGridPane;
    }

    /**
     * Gets the tiles of the map.
     * @return 2D array of tiles
     */
    public Tile[][] getTiles() {
        return this.tiles;
    }

    /**
     * Sets up the map.
     */
    private void setUpMap() {
        tiles = new Tile[MAP_HEIGHT][MAP_WIDTH];
        if (maptype == MapType.STANDARD) {
            try {
                URL url = getClass().getResource("/resources/standardmap.txt");
                File mapfile = new File(url.getPath());
                Scanner scan = new Scanner(mapfile);
                int row = 0;
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    for (int i = 0; i < line.length(); i++) {
                        Tile t = setUpTile(line.charAt(i));
                        t.setMap(this);

                        GridPane.setColumnIndex(t, i);
                        GridPane.setRowIndex(t, row);

                        this.backingPane.getChildren().add(t);

                        tiles[row][i] = t;
                    }
                    row++;
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Trash tier coding");
            }
        }
    }

    private void randomGenMap() {
        tiles = new Tile[MAP_HEIGHT][MAP_WIDTH];
        char[] tileTypes = {'P', 'M', 'N', 'O', 'E', 'C', 'S'};
        Random r = new Random();

        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                Tile t;
                if (j == 4) {
                    if (i == 2) {
                        t = new TownTile();
                    } else {
                        t = new RiverTile();
                    }
                } else {
                    char tileType = tileTypes[r.nextInt(6)];
                    t = setUpTile(tileType);
                }

                t.setMap(this);

                GridPane.setColumnIndex(t, j);
                GridPane.setRowIndex(t, i);

                this.backingPane.getChildren().add(t);
                tiles[i][j] = t;
            }
        }
    }

    /**
     * Sets tiles according to character.
     * @param c character used to determine which tile to return
     * @return Tile specified by character
     * @throws IllegalArgumentException If the letter doesn't exist
     */
    private Tile setUpTile(char c) throws IllegalArgumentException {
        if (c == 'R') {
            return new RiverTile();
        } else if (c == 'P') {
            return new PlainsTile();
        } else if (c == 'M') {
            return new MountainOneTile();
        } else if (c == 'N') {
            return new MountainTwoTile();
        } else if (c == 'O') {
            return new MountainThreeTile();
        } else if (c == 'T') {
            return new TownTile();
        } else if (c == 'E') {
            return new ElectricTile();
        } else if (c == 'C') {
            return new CaveTile();
        } else if (c == 'S') {
            return new CasinoTile();
        } else {
            throw new IllegalArgumentException("No Such Tile type");
        }
    }



    /**
     * Returs the game.
     * @return Gets the game being played
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Sets the game for the map.
     * @param gameToSet the game to set
     */
    public void setGame(Game gameToSet) {
        this.game = gameToSet;

        try {
            if (this.game.getMapType() == MapType.STANDARD) {
                setUpMap();
            } else {
                randomGenMap();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("Problem setting up map");
            System.out.println(iae.getMessage());
        }
    }

    /**
     * @return Gets the stackpane
     */
    public StackPane getStackPane() {
        return this.stackPane;
    }
}
