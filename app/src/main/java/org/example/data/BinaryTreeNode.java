package org.example.data;

public class BinaryTreeNode {
    public int key;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int item) {
        key = item;
        left = right = null;
    }

    public int maxDepth() {
        return _maxDepth(this);
    }

    private int _maxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = _maxDepth(root.left);
        int rightDepth = _maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isMirror() {
        return _isMirror(this, this);
    }

    private boolean _isMirror(BinaryTreeNode left, BinaryTreeNode right) {
        // If there's no left and right, then it's a mirror
        if (left == null && right == null) {
            return true;
        }
        // If one of them has a child, but the other doesn't, it's not a mirror
        if (left == null || right == null) {
            return false;
        }
        if (left.key != right.key) {
            return false;
        }
        return _isMirror(left.left, right.right) && _isMirror(left.right, right.left);
    }
}