package com.daniver;

/**
 * Model a strange type of apple
 *
 * Created by GARY on 23/08/2016.
 */
public class Apple {
    private Colour colour;
    private int weight;
    private int taste;
    private boolean worm;

    public Apple() {
        colour = Colour.unknown;
        weight = 0;
        taste = 1;
        worm = false;
    }

    public Colour getColour() {
        return colour;
    }

    public int getWeight() {
        return weight;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) throws RuntimeException {
        if (taste >= 1 && taste <= 4)
            this.taste = taste;
        else
            throw new RuntimeException("An apple's taste must be between 1 and 4");
    }

    public boolean hasWorm() {
        return worm;
    }
}
