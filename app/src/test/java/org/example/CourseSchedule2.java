package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.example.data.Digraph;
import org.junit.jupiter.api.Test;

public class CourseSchedule2 {
    @Test
    public void run() {
        Digraph digraph = new Digraph();
        digraph.addEdge(2, 0);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 1);
        digraph.addEdge(1, 0);
        assertFalse(digraph.hasCycle());
        assertEquals(digraph.getTopologicalSort(), java.util.List.of(0, 1, 2, 3));
    }
}