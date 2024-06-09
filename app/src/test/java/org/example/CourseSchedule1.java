package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.example.data.Digraph;
import org.junit.jupiter.api.Test;

public class CourseSchedule1 {
    @Test
    public void run() {
        Digraph digraph = new Digraph();
        digraph.addEdge(1, 0);
        digraph.addEdge(0, 1);
        assertTrue(digraph.hasCycle());
    }

    @Test
    public void run2() {
        Digraph digraph = new Digraph();
        digraph.addEdge(2, 0);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 1);
        digraph.addEdge(1, 0);
        assertFalse(digraph.hasCycle());
    }
}