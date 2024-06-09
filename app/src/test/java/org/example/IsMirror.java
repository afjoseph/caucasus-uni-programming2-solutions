package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.data.BinaryTreeNode;
import org.junit.jupiter.api.Test;

public class IsMirror {
    @Test
    public void run() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(3);
        assertTrue(root.isMirror());
    }
}