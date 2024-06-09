package org.example.data;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Digraph {
    private final HashMap<Integer, List<Integer>> adj;
    private final HashSet<Integer> vertices;

    public Digraph() {
        adj = new HashMap<>();
        vertices = new HashSet<>();
    }

    public void addEdge(int v, int w) {
        if (!adj.containsKey(v)) {
            adj.put(v, new ArrayList<>());
        }
        adj.get(v).add(w);
        vertices.add(v);
        vertices.add(w);
    }

    public int getVertexCount() {
        return adj.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (int v : adj.keySet()) {
            count += adj.get(v).size();
        }
        return count;
    }

    public List<Integer> getAdjacentVertices(int v) {
        return adj.get(v);
    }

    public List<Integer> getTopologicalSort() {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int v : vertices) {
            visited.put(v, false);
        }
        Stack<Integer> result = new Stack<>();
        int root = vertices.iterator().next();
        _getTopologicalSort(root, visited, result);
        return result.reversed();
    }

    private void _getTopologicalSort(int v, HashMap<Integer, Boolean> visited, List<Integer> result) {
        if (visited.get(v)) {
            return;
        }
        visited.put(v, true);

        for (int n : adj.keySet()) {
            _getTopologicalSort(n, visited, result);
        }
        result.add(v);
    }

    public boolean hasCycle() {
        // If the vertex is not in the visitStatus, it means it was never visited.
        // If the value is false, it means it is currently being visited.
        // If the value is true, it means it was already visited.
        // The idea is to keep track of the vertices that are currently being visited.
        // And if we encounter a vertex that is already being visited (i.e., the value
        // is false),
        // then it means there is a cycle found in the current path.
        HashMap<Integer, Boolean> visitStatus = new HashMap<>();
        for (int v : adj.keySet()) {
            if (_hasCycle(v, visitStatus)) {
                return true;
            }
            visitStatus.clear();
        }
        return false;
    }

    private boolean _hasCycle(int v, HashMap<Integer, Boolean> visitStatus) {
        if (visitStatus.containsKey(v) && visitStatus.get(v)) {
            // This vertex was already visited in the current path.
            // So this is a cycle
            return false;
        }
        if (visitStatus.containsKey(v) && !visitStatus.get(v)) {
            // This vertex was already visited somewhere in the past, but not the current
            // path. So this is not a cycle
            return true;
        }

        // Report as "visiting". This signals the start of the current path
        visitStatus.put(v, false);
        // And check if any of the adjacent vertices has a cycle
        List<Integer> adjacentVertices = getAdjacentVertices(v);
        if (adjacentVertices != null) {
            for (int w : adjacentVertices) {
                if (_hasCycle(w, visitStatus)) {
                    return true;
                }
            }
        }
        // Report as "visited" and that there is no cycle yet.
        // This signals the end of the current path
        visitStatus.put(v, true);
        return false;
    }
}
