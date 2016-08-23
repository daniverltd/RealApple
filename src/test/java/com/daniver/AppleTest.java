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
}
