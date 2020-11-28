package com.santosh.dsa.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTravarsalTree {
    public List<Integer> inorderTraversal(final TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.inorder(root, list);
        return list;
    }

    public void inorder(final TreeNode n, final List<Integer> list) {
        if (n == null) {
            return;
        }
        this.inorder(n.left, list);
        list.add(n.val);

        this.inorder(n.right, list);
    }

    public void inOrderIterative(final TreeNode n, final List<Integer> list) {
        if (n == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = n;
        while (curr != null || !st.empty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }
    }
}
