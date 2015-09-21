package edu.gatech.cs2340.Maps;

import edu.gatech.cs2340.GameObject.Mule;
import edu.gatech.cs2340.players.Person;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Tile class
 * @author Bilal
 * @version 1.0
 */
public class Tile {
    private String color;
    private Person owner;
    private TileType tileType;
    private int food;
    private int energy;
    private int ore;
    private int crystite;
    private int xLoc;
    private int yLoc;
    private Mule mule;
    private ImageView iv;
    private Image image;
    private Map map;

    /**
     * Tile construct on Instantiation, we will not handle who owns it.
     * The constructor call will be made only on new map, and we will
     * set owners and other things as the game goes on
     * @param tileType tileType of tile
     */
    public Tile(TileType tileType) {
        this.tileType = tileType;
        this.mule = null;

        this.iv = new ImageView();

        String imageString;

        switch (this.tileType) {
            case MOUNTAIN_1:
                imageString = "/resources/Mountain1.jpg";
                break;
            case MOUNTAIN_2:
                imageString = "/resources/Mountain2.jpg";

                break;
            case MOUNTAIN_3:
                imageString = "/resources/Mountain3.jpg";
                break;
            case PLAIN:
                imageString = "/resources/Plain.jpg";
                break;
            case RIVER:
                imageString = "/resources/River.jpg";
                break;
            case TOWN:
                imageString = "/resources/Town.jpg";
                break;
            default:
                throw new IllegalArgumentException("Unrecognized tile type");
        }

        this.image = new Image(imageString);
        this.iv.setImage(this.image);

        iv.setOnMouseEntered(event -> {
            if (this.tileType != TileType.TOWN) {
//            DropShadow ds = new DropShadow(20, this.map.getGame()
//                    .getCurrentPlayer().getColor());
//                iv.requestFocus();
//                DropShadow ds = new DropShadow(20, Color.RED);
//
//                iv.setEffect(ds);
            }
        });

        iv.setOnMouseExited(event -> {
            iv.setEffect(null);
        });
    }

    /**
     * @return x position
     */
    public int getxLoc() {
        return xLoc;
    }

    /**
     * @param xLoc set x position to xLoc
     */
    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    /**
     * @return y position
     */
    public int getyLoc() {
        return yLoc;
    }

    /**
     * @param yLoc set y position to yLoc
     */
    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    /**
     * @return String form of color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color color to be set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Person returned
     * @return person owner of tile
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * @param owner set owner to this owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     * @return tileType of tile
     */
    public TileType getResource() { return tileType; }

    /**
     * @param tileType set tileType of tile
     */
    public void setResource(TileType tileType) {
        this.tileType = tileType;
    }

    /**
     * @return get Mule of tile
     */
    public Mule getMule() { return mule; }

    /**
     * @param mule set mule of tile
     */
    public void setMule(Mule mule) { this.mule = mule; }

    /**
     * @return food count
     */
    public int getFood() {
        return food;
    }

    /**
     * @param food set food amount
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * @return energy amount
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy set energy to tile
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * @return ore of tile
     */
    public int getOre() { return ore; }

    /**
     * @param ore set ore amount to tile
     */
    public void setOre(int ore) { this.ore = ore; }

    /**
     * @return crystite of tile
     */
    public int getCrystite() {
        return crystite;
    }

    /**
     * @param crystite set crystite of tile
     */
    public void setCrystite(int crystite) {
        this.crystite = crystite;
    }

    /**
     * Returns the Image View of the tile
     * @return the image view of the tile
     */
    public ImageView getImageView() {
        return iv;
    }

    public void setMap(Map map) {
        this.map = map;
    }

}
