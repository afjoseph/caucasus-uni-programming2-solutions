package org.example.data;

public class BinarySearchTree {
    BinaryTreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecursively(root, key);
    }

    BinaryTreeNode insertRecursively(BinaryTreeNode root, int key) {
        // Base case: if the tree is empty, return a new node
        if (root == null) {
            root = new BinaryTreeNode(key);
            return root;
        }
        // Else, recurse down the tree
        if (key < root.key) {
            root.left = insertRecursively(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursively(root.right, key);
        }
        return root;
    }

    public int getMinimumDifferenceBetweenNodes() {
        return _getMinimumDifferenceBetweenNodes(root);
    }

    private int _getMinValue(BinaryTreeNode root) {
        BinaryTreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    private int _getMaxValue(BinaryTreeNode root) {
        BinaryTreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    int _getMinimumDifferenceBetweenNodes(BinaryTreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int minDiff = Integer.MAX_VALUE;
        if (root.left != null) {
            minDiff = Math.min(minDiff, root.key - _getMaxValue(root.left));
        }
        if (root.right != null) {
            minDiff = Math.min(minDiff, _getMinValue(root.right) - root.key);
        }
        return minDiff;
        // return Math.min(minDiff,
        // Math.min(_getMinimumDifferenceBetweenNodes(root.left),
        // _getMinimumDifferenceBetweenNodes(root.right)));
    }
}
