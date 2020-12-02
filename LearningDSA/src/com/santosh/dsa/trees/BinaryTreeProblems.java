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
	 * @param root Root Node of binary tree
	 * @return max element in given binary tree
	 */
	public int maxElementInBT(final BTreeNode root) {

		int max = Integer.MIN_VALUE;
		if (root != null) {
			final int lMax = this.maxElementInBT(root.left);
			final int rMax = this.maxElementInBT(root.right);
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
	 * @param root Root Node of binary tree
	 * @return max element in binary tree
	 */
	public int maxElementInBTIterative(final BTreeNode root) {
		int max = Integer.MIN_VALUE;
		if (root != null) {
			final Queue<BTreeNode> q = new LinkedList<>();
			q.offer(root);
			while (!q.isEmpty()) {
				final BTreeNode node = q.poll();
				if (node != null) {
					final int x = node.data;
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
	 * @param root Root Node of binary tree
	 * @param data data for searching in tree
	 * @return true if element found else false
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
	 * @param root Root Node of binary tree
	 * @param data
	 * @return
	 */
	public boolean findElementInBTIterative(final BTreeNode root, final int data) {
		if (root != null) {
			final Queue<BTreeNode> q = new LinkedList<>();
			q.offer(root);
			while (!q.isEmpty()) {
				final BTreeNode x = q.poll();
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
	 * @param root Root Node of binary tree
	 * @param data
	 */
	public void insertIntoBT(final BTreeNode root, final int data) {
		if (root != null) {
			final Queue<BTreeNode> q = new LinkedList<>();
			q.offer(root);
			while (!q.isEmpty()) {
				final BTreeNode x = q.poll();
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
	 * @param root Root Node of binary tree
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
	 * @param root Root Node of binary tree
	 * @return size of tree
	 *
	 */
	public int getSizeOfBinaryTree(final BTreeNode root) {
		if (root != null) {
			final int lsize = this.getSizeOfBinaryTree(root.left);
			final int rsize = this.getSizeOfBinaryTree(root.right);
			return lsize + rsize + 1;
		}
		return 0;
	}

	/**
	 * 7 - Give an algorithm for finding the size of binary tree iteratively
	 *
	 * @param root Root Node of binary tree
	 * @return size of tree
	 *
	 */
	public int getSizeOfBinaryTreeIterative(final BTreeNode root) {
		int size = 0;
		if (root != null) {
			final Queue<BTreeNode> q = new LinkedList<>();
			q.offer(root);
			while (!q.isEmpty()) {
				final BTreeNode temp = q.poll();
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
	 * @param root Root Node of binary tree
	 */
	public void deleteTree(BTreeNode root) {
		root = null;
	}

	/**
	 * 9 - Give an algorithm for printing the level order data in reverse order
	 *
	 * @param root Root Node of binary tree
	 * @return the level order data in reverse order
	 */
	public List<Integer> reverseLevelOrder(final BTreeNode root) {
		final List<Integer> lis = new ArrayList<>();
		if (root != null) {
			final Stack<Integer> s = new Stack<>();
			final Queue<BTreeNode> q = new LinkedList<>();
			q.offer(root);
			while (!q.isEmpty()) {
				final BTreeNode t = q.poll();
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
	 * @param root Root Node of binary tree
	 * @return max depath of binary tree
	 */
	public int maxDepthOfTree(final BTreeNode root) {
		if (root == null) {
			return 0;
		}
		final int lMax = this.maxDepthOfTree(root.left);
		final int rMax = this.maxDepthOfTree(root.right);
		return Math.max(rMax, lMax) + 1;
	}

	/**
	 * 13.a - Give an algorithm for finding the minimum depth of the binary tree
	 *
	 * @param root Root Node of binary tree
	 * @return min Depth of binary tree
	 */
	public int minDepthTree(final BTreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return this.minDepthTree(root.right) + 1;
		}
		if (root.right == null) {
			return this.minDepthTree(root.left) + 1;
		}
		return Math.min(this.minDepthTree(root.left), this.minDepthTree(root.right)) + 1;
	}

	/**
	 * 13.b - Give an algorithm for finding the minimum depth of the binary tree
	 * iterative
	 *
	 * @param root Root Node of binary tree
	 * @return min Depth of binary tree
	 */
	public int minDepthTreeIterative(final BTreeNode root) {
		if (root == null) {
			return 0;
		}
		int dep = 1;
		final Queue<BTreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			final BTreeNode t = q.poll();
			if (t != null) {
				if (t.left == null && t.right == null) {
					return dep;
				}
				if (t.left != null) {
					q.offer(t.left);
				}
				if (t.right != null) {
					q.offer(t.right);
				}
			} else {
				if (!q.isEmpty()) {
					dep++;
					q.offer(null);
				}
			}
		}
		return dep;
	}

	/**
	 * 14 - Give an algorithm for finding the deepest node of the binary tree.
	 *
	 * @param root Root Node of binary tree
	 * @return deepest node
	 */
	public BTreeNode deepestNodeInTree(final BTreeNode root) {
		if (root == null) {
			return null;
		}
		BTreeNode t = null;
		final Queue<BTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			t = q.poll();
			if (t.left != null) {
				q.offer(t.left);
			}
			if (t.right != null) {
				q.offer(t.right);
			}
		}
		return t;
	}

	/**
	 * 15 - Give an algorithm for deleting an element (assuming data is given) from
	 * binary tree
	 *
	 * @param root Root Node of binary tree
	 * @param data data to be deleted
	 */
	public boolean deleteNodeFromTree(final BTreeNode root, final int data) {
		if (root == null) {
			return false;
		}
		BTreeNode n = null;
		final Queue<BTreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BTreeNode x = q.poll();
			if (x != null) {
				if (x.data == data) {
					n = x;
				}
				q.offer(x.left);
				q.offer(x.right);
			}
		}
		if (n == null) {
			return false;
		}
		BTreeNode t = null;
		q.clear();
		q.offer(root);
		while (!q.isEmpty()) {
			t = q.poll();
			if (t.left != null) {
				q.offer(t.left);
			}
			if (t.right != null) {
				q.offer(t.right);
			}
		}
		n.data = t.data;
		t = null;
		return true;
	}
}
