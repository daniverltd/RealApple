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
    private boolean peeled;
    private boolean eaten;

    public Apple() {
        colour = Colour.green;
        weight = 10;
        taste = 1;
        worm = false;
        peeled = false;
        eaten = false;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 10 && weight <= 100)
            this.weight = weight;
        else
            throw new RuntimeException("An apple's weight must be between 10 and 100");
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

    public void setHasWorm(boolean worm) {
        this.worm = worm;
    }

    public void eat() throws RuntimeException {
        if (!isPeeled())
            throw new RuntimeException("An apple has to be peeled before being eaten");
        eaten = true;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void peel(Peeler peeler) {
        if (hasWorm() || getTaste() < 4 )
            throw new RuntimeException("You can only peel an apple that does not have a worm and its taste is > 3");

        if (getColour().equals(Colour.blue) && !(peeler instanceof ValyrianPeeler))
            throw new RuntimeException("Blue apples can only be peeled with ValyrianPeelers");

        peeled = true;
    }

    public boolean isPeeled() {
        return peeled;
    }
}
