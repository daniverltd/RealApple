package com.daniver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the Apple class
 *
 * Created by GARY on 23/08/2016.
 */
public class AppleTest {
    static Apple apple;

    @BeforeEach
    void setup() {
        apple = new Apple();
    }

    @Test
    void creation() {
        assertTrue(apple != null);
    }

    @Test
    void defaults() {
        assertEquals(apple.getColour(), Colour.green);
        assertEquals(apple.getWeight(), 10);
        assertEquals(apple.getTaste(), 1);
        assertFalse(apple.hasWorm());
        assertFalse(apple.isPeeled());
        assertFalse(apple.isEaten());
    }

    @Test
    void taste() {
        for (int i = 1; i <= 4; i++) {
            apple.setTaste(i);
            assertEquals(apple.getTaste(), i);
        }

        expectThrows(RuntimeException.class, () -> apple.setTaste(5));
        expectThrows(RuntimeException.class, () -> apple.setTaste(0));
    }

    @Test
    void weight() {
        apple.setWeight(10);
        assertEquals(apple.getWeight(), 10);
        apple.setWeight(100);
        assertEquals(apple.getWeight(), 100);

        expectThrows(RuntimeException.class, () -> apple.setWeight(9));
        expectThrows(RuntimeException.class, () -> apple.setWeight(101));

    }

    @Test
    void colour() {
        apple.setColour(Colour.red);
        assertEquals(apple.getColour(), Colour.red);
        apple.setColour(Colour.green);
        assertEquals(apple.getColour(), Colour.green);
        apple.setColour(Colour.blue);
        assertEquals(apple.getColour(), Colour.blue);
    }

    @Test
    void peelRed() {
        apple.setColour(Colour.red);
        testPeeling();
    }

    void peelGreen() {
        apple.setColour(Colour.green);
        testPeeling();
    }

    void testPeeling() {
        Peeler peeler = new Peeler();

        apple.setTaste(3);
        expectThrows(RuntimeException.class, () -> apple.peel(peeler));

        apple.setTaste(4);
        apple.setHasWorm(true);
        expectThrows(RuntimeException.class, () -> apple.peel(peeler));

        apple.setTaste(3);
        apple.setHasWorm(true);
        expectThrows(RuntimeException.class, () -> apple.peel(peeler));

        apple.setTaste(4);
        apple.setHasWorm(false);
        apple.peel(peeler);
        assertTrue(apple.isPeeled());
    }

    @Test
    void peelBlue() {
        Peeler peeler = new ValyrianPeeler();

        apple.setColour(Colour.blue);
        apple.setTaste(3);
        expectThrows(RuntimeException.class, () -> apple.peel(peeler));

        apple.setTaste(4);
        apple.setHasWorm(true);
        expectThrows(RuntimeException.class, () -> apple.peel(peeler));

        apple.setTaste(3);
        apple.setHasWorm(true);
        expectThrows(RuntimeException.class, () -> apple.peel(peeler));

        apple.setTaste(4);
        apple.setHasWorm(false);

        expectThrows(RuntimeException.class, () -> apple.peel(new Peeler()));

        apple.peel(peeler);
        assertTrue(apple.isPeeled());
    }

    @Test
    void eat() {
        expectThrows(RuntimeException.class, () -> apple.eat());

        apple.setTaste(4);
        apple.peel(new Peeler());
        apple.eat();
        assertTrue(apple.isEaten());
    }
}
