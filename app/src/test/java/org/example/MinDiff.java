package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.data.BinarySearchTree;

class MinDiff {
    @Test
    void run() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(0);
        tree.insert(48);
        tree.insert(12);
        tree.insert(49);
        assertEquals(tree.getMinimumDifferenceBetweenNodes(), 1);
    }

    @Test
    void run2() {
        BinarySearchTree tree = new BinarySearchTree();
        // [543,384,652,null,445,null,699]
        tree.insert(543);
        tree.insert(384);
        tree.insert(652);
        tree.insert(445);
        tree.insert(699);
        assertEquals(tree.getMinimumDifferenceBetweenNodes(), 98);
    }
}
