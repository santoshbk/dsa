package com.santosh.dsa.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTravarsal {
    public List<Integer> postorderTraversal(final TreeNode root) {
        List<Integer> l = new ArrayList<>();
        this.postOrder(root, l);
        return l;
    }

    private void postOrder(final TreeNode root, final List<Integer> l) {
        if (root == null) {
            return;
        }
        this.postOrder(root.left, l);
        this.postOrder(root.right, l);
        l.add(root.val);
    }

    private void postOrderIterative(final TreeNode root, final List<Integer> l) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();

    }
}
