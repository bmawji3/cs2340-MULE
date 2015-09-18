package edu.gatech.cs2340.Maps;

import edu.gatech.cs2340.GameObject.Mule;
import edu.gatech.cs2340.players.Person;

/**
 * Tile class
 * @author Bilal
 * @version 1.0
 */
public class Tile {
    private String color;
    private Person owner;
    private TileType resource;
    private int food;
    private int energy;
    private int ore;
    private int crystite;
    private int xLoc;
    private int yLoc;
    private Mule mule;

    /**
     * Tile construcot
     * @param owner owner of tile
     * @param resource resource of tile
     * @param mule mule set at that tile
     * @param xLoc x position of tile
     * @param yLoc y position of tile
     */
    public Tile(Person owner, TileType resource, Mule mule,
                int xLoc, int yLoc) {
        this.resource = resource;
        this.owner = owner;
        this.color = owner.getColor();
        this.mule = null;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
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
     * @return resource of tile
     */
    public TileType getResource() { return resource; }

    /**
     * @param resource set resource of tile
     */
    public void setResource(TileType resource) {
        this.resource = resource;
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
}