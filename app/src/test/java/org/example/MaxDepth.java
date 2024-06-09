package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.data.BinaryTreeNode;

class MaxDepth {
    @Test
    void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        assertEquals(root.maxDepth(), 3);
    }
}
