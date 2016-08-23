package com.daniver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
