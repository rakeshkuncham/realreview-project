package com.example.realreview;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testIsPositive() {
        assertTrue(App.isPositive(5));
        assertFalse(App.isPositive(-1));
        assertFalse(App.isPositive(0));
    }

    @Test
    public void testMainOutput() {
        // Since main just prints to console, normally you wouldn't test it,
        // but here's a placeholder if needed later.
        assertTrue(true);
    }
}
