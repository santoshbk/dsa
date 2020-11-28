package com.santosh.dsa.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTravarsal {
    public static List<List<Integer>> levelOrder(final TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        interativeLevelOrder(root, res);
//        levelOrder(root, 0, res);
        return res;
    }

    private static void levelOrder(final TreeNode n, final int level, final List<List<Integer>> list) {
        if (n == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(n.val);
        levelOrder(n.left, level + 1, list);
        levelOrder(n.right, level + 1, list);
    }

    private static void interativeLevelOrder(final TreeNode root, final List<List<Integer>> res) {
        Queue<TreeNode> q = new LinkedList<>();
        int count1 = 0;
        if (root != null) {
            res.add(Arrays.asList(root.val));
            if (addToQ(q, root.left)) {
                count1++;
            }
            if (addToQ(q, root.right)) {
                count1++;
            }
        }
        int count2 = 0;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            count1--;
            if (null != n) {
                list.add(n.val);
                if (addToQ(q, n.left)) {
                    count2++;
                }
                if (addToQ(q, n.right)) {
                    count2++;
                }
            }
            if (count1 == 0) {
                if (!list.isEmpty()) {
                    res.add(list);
                }
                list = new ArrayList<>();
                count1 = count2;
                count2 = 0;
            }
        }
    }

    private static boolean addToQ(final Queue<TreeNode> q, final TreeNode n) {
        return n != null ? q.offer(n) : false;
    }

    public static void main(final String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println(levelOrder(root));
    }
}
