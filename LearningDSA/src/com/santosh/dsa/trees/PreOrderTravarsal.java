package learning.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeDemo {

    public static void main(final String[] args) {
        TreeDemo t = new TreeDemo();
        BTreeNode root = getTempTree();

        System.out.println("Pre Order: " + t.preOrder(root));
        System.out.println("Pre Order Iterative: " + t.preOrderIterative(root));

        System.out.println("In Order: " + t.inOrder(root));
        System.out.println("In Order Iterative: " + t.inOrderIterative(root));

        System.out.println("Post Order: " + t.postOrder(root));
        System.out.println("Post Order Iterative: " + t.postOrderIterative(root));

        System.out.println("Level Order: " + t.levelOrder(root));
        System.out.println("Level Order Levelwise: " + t.levelOrderLevelwise((root)));

        System.out.println("Max depth of tree: " + t.maxDepthTopDown(root));
        System.out.println("Max depth of tree: " + t.maxDepthBottomUp(root));
    }

    private int maxDep = 0;

    public int maxDepthTopDown(final BTreeNode root) {
        if (root != null) {
            this.maxDepTD(root, 1);
        }
        return this.maxDep;
    }

    public int maxDepthBottomUp(final BTreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = this.maxDepthBottomUp(root.left);
        int rMax = this.maxDepthBottomUp(root.right);
        return Math.max(lMax, rMax) + 1;
    }

    private void maxDepTD(final BTreeNode root, final int dep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            this.maxDep = Math.max(dep, this.maxDep);
        }
        this.maxDepTD(root.left, dep + 1);
        this.maxDepTD(root.right, dep + 1);
    }

    public List<Integer> levelOrder(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<BTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            BTreeNode n = q.poll();
            if (n != null) {
                list.add(n.data);
                q.offer(n.left);
                q.offer(n.right);
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrderLevelwise(final BTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<BTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> lis = new ArrayList<>();
        while (!q.isEmpty()) {
            BTreeNode n = q.poll();
            if (n != null) {
                lis.add(n.data);
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            } else {
                res.add(lis);
                lis = new ArrayList<>();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }
        return res;
    }

    public static BTreeNode getTempTree() {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.right.left = new BTreeNode(6);
        root.right.right = new BTreeNode(7);
        return root;
    }

    public List<Integer> inOrder(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.inOrder(root, list);
        return list;
    }

    private void inOrder(final BTreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        this.inOrder(root.left, list);
        list.add(root.data);
        this.inOrder(root.right, list);
    }

    public List<Integer> preOrder(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.preOrder(root, list);
        return list;
    }

    private void preOrder(final BTreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        this.preOrder(root.left, list);
        this.preOrder(root.right, list);
    }

    public List<Integer> postOrder(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.postOrder(root, list);
        return list;
    }

    private void postOrder(final BTreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        this.postOrder(root.left, list);
        this.postOrder(root.right, list);
        list.add(root.data);
    }

    public List<Integer> inOrderIterative(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.inOrderIterative(root, list);
        return list;
    }

    private void inOrderIterative(final BTreeNode root, final List<Integer> list) {
        Stack<BTreeNode> s = new Stack<>();
        BTreeNode curr = root;
        boolean flag = false;
        while (!flag) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if (s.isEmpty()) {
                    flag = true;
                } else {
                    curr = s.pop();
                    list.add(curr.data);
                    curr = curr.right;
                }
            }
        }
    }

    public List<Integer> preOrderIterative(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.preOrderIterative(root, list);
        return list;
    }

    private void preOrderIterative(final BTreeNode root, final List<Integer> list) {
        Stack<BTreeNode> s = new Stack<>();
        if (root != null) {
            s.push(root);
        }
        while (!s.empty()) {
            BTreeNode n = s.pop();
            if (n != null) {
                list.add(n.data);
                s.push(n.right);
                s.push(n.left);
            }
        }
    }

    public List<Integer> postOrderIterative(final BTreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.postOrderIterative(root, list);
        return list;
    }

    private void postOrderIterative(final BTreeNode root, final List<Integer> list) {
        // TODO: yet to implement
    }
}
