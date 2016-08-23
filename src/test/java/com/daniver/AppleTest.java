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
        assertEquals(apple.getColour(), Colour.unknown);
        assertEquals(apple.getWeight(), 0);
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
}
