package com.santosh.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTravarsal {
    public List<Integer> preorderTraversal(final TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.preOrder(root, list);
        return list;
    }

    public void preOrder(final TreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        this.preOrder(root.left, list);
        this.preOrder(root.right, list);
    }

    public void preOrderIterative(final TreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        list.add(root.val);
        s.push(root.right);
        s.push(root.left);
        while (!s.empty()) {
            TreeNode x = s.pop();
            if (x != null) {
                list.add(x.val);
                s.push(x.right);
                s.push(x.left);
            }
        }
    }
}
