package com.santosh.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Contains the problems based on Binary Tree.
 * <p>
 * Tree Node used is {@link BTreeNode}
 *
 * @author skumbara
 *
 */
public class BinaryTreeProblems {

    /**
     * 1 - Give an algorithm for finding maximum element in binary tree
     *
     * @param root
     * @return
     */
    public int maxElementInBT(final BTreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int lMax = this.maxElementInBT(root.left);
            int rMax = this.maxElementInBT(root.right);
            max = Math.max(lMax, rMax);
            if (root.data > max) {
                max = root.data;
            }
        }
        return max;
    }

    /**
     * 2 - Give an algorithm for finding maximum element in binary tree without
     * recursion
     *
     * @param root
     * @return
     */
    public int maxElementInBTIterative(final BTreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            Queue<BTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                BTreeNode node = q.poll();
                if (node != null) {
                    int x = node.data;
                    if (max < x) {
                        max = x;
                    }
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }
        return max;
    }

    /**
     * 3 - Give an algorithm for searching an element in binary tree
     *
     * @param root
     * @param data
     * @return
     */
    public boolean findElementInBT(final BTreeNode root, final int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        return this.findElementInBT(root.left, data) || this.findElementInBT(root.right, data);
    }

    /**
     * 4 - Give an algorithm for searching an element in binary tree without
     * recursion
     *
     * @param root
     * @param data
     * @return
     */
    public boolean findElementInBTIterative(final BTreeNode root, final int data) {
        if (root != null) {
            Queue<BTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                BTreeNode x = q.poll();
                if (x != null) {
                    if (x.data == data) {
                        return true;
                    }
                    q.offer(x.left);
                    q.offer(x.right);
                }
            }
        }
        return false;
    }

    /**
     * 5.a - Give an algorithm for inserting an element into binary tree Iteratively
     *
     * @param root
     * @param data
     */
    public void insertIntoBT(final BTreeNode root, final int data) {
        if (root != null) {
            Queue<BTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                BTreeNode x = q.poll();
                if (x.left != null) {
                    q.offer(x.left);
                } else {
                    x.left = new BTreeNode(data);
                    break;
                }
                if (x.right != null) {
                    q.offer(x.right);
                } else {
                    x.right = new BTreeNode(data);
                    break;
                }
            }
        }
    }

    /**
     * 5.b - Give an algorithm for inserting an element into binary tree recursively
     *
     * @param root
     * @param data
     */
    public void insertIntoBTRecur(final BTreeNode root, final int data) {
        if (root != null) {
            if (root.data < data) {
                if (root.right == null) {
                    root.right = new BTreeNode(data);
                } else {
                    this.insertIntoBTRecur(root.right, data);
                }
            } else {
                if (root.left == null) {
                    root.left = new BTreeNode(data);
                }
            }
        }
    }

    /**
     * 6 - Give an algorithm for finding the size of binary tree
     *
     * @param root
     * @return size of tree
     *
     */
    public int getSizeOfBinaryTree(final BTreeNode root) {
        if (root != null) {
            int lsize = this.getSizeOfBinaryTree(root.left);
            int rsize = this.getSizeOfBinaryTree(root.right);
            return lsize + rsize + 1;
        }
        return 0;
    }

    /**
     * 7 - Give an algorithm for finding the size of binary tree iteratively
     *
     * @param root
     * @return size of tree
     *
     */
    public int getSizeOfBinaryTreeIterative(final BTreeNode root) {
        int size = 0;
        if (root != null) {
            Queue<BTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                BTreeNode temp = q.poll();
                if (temp != null) {
                    size++;
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }
        }
        return size;
    }

    /**
     * 8 - Give an algorithm for deleting the tree
     *
     * @param root
     */
    public void deleteTree(BTreeNode root) {
        root = null;
    }

    /**
     * 9 - Give an algorithm for printing the level order data in reverse order
     *
     * @param root
     * @return
     */
    public List<Integer> reverseLevelOrder(final BTreeNode root) {
        List<Integer> lis = new ArrayList<>();
        if (root != null) {
            Stack<Integer> s = new Stack<>();
            Queue<BTreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                BTreeNode t = q.poll();
                if (t != null) {
                    s.push(t.data);
                    q.offer(t.right);
                    q.offer(t.left);
                }
            }
            while (!s.isEmpty()) {
                lis.add(s.pop());
            }
        }
        return lis;
    }

    /**
     * 10 - Give an algorithm for finding the height (or depth) of the binary tree
     *
     * @param root
     * @return
     */
    public int maxDepthOfTree(final BTreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = this.maxDepthOfTree(root.left);
        int rMax = this.maxDepthOfTree(root.right);
        return Math.max(rMax, lMax) + 1;
    }

}
