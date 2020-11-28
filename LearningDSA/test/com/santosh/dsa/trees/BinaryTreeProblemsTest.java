package com.santosh.dsa.trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.santosh.dsa.trees.BTreeNode;
import com.santosh.dsa.trees.BinaryTreeProblems;

/**
 * @author skumbara
 *
 */
public class BinaryTreeProblemsTest {

	private BTreeNode root;
	private BinaryTreeProblems t;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.t = new BinaryTreeProblems();
		this.root = this.getTempTree();
	}

	private BTreeNode getTempTree() {
		final BTreeNode node = new BTreeNode(1);
		this.t.insertIntoBT(node, 2);
		this.t.insertIntoBT(node, 3);
		this.t.insertIntoBT(node, 4);
		this.t.insertIntoBT(node, 5);
		this.t.insertIntoBT(node, 6);
		this.t.insertIntoBT(node, 7);
		return node;
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#maxElementInBT(learning.dsa.trees.BTreeNode)}.
	 */
	@Test
	public void testMaxElementInBT() {
		assertEquals(7, this.t.maxElementInBT(this.root));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#maxElementInBTIterative(learning.dsa.trees.BTreeNode)}.
	 */
	@Test
	public void testMaxElementInBTIterative() {
		assertEquals(7, this.t.maxElementInBTIterative(this.root));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#findElementInBT(learning.dsa.trees.BTreeNode, int)}.
	 */
	@Test
	public void testFindElementInBT() {
		assertTrue(this.t.findElementInBT(this.root, 6));
		assertTrue(this.t.findElementInBT(this.root, 7));
		assertFalse(this.t.findElementInBT(this.root, 8));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#findElementInBTIterative(learning.dsa.trees.BTreeNode, int)}.
	 */
	@Test
	public void testFindElementInBTIterative() {
		assertTrue(this.t.findElementInBTIterative(this.root, 2));
		assertTrue(this.t.findElementInBTIterative(this.root, 4));
		assertFalse(this.t.findElementInBTIterative(this.root, 8));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#insertIntoBT(learning.dsa.trees.BTreeNode, int)}.
	 */
	@Test
	public void testInsertIntoBT() {
		this.t.insertIntoBT(this.root, 8);
		this.t.insertIntoBT(this.root, 9);
		this.t.insertIntoBT(this.root, 11);
		assertTrue(this.t.findElementInBT(this.root, 6));
		assertTrue(this.t.findElementInBT(this.root, 8));
		assertTrue(this.t.findElementInBT(this.root, 9));
		assertTrue(this.t.findElementInBT(this.root, 11));
		assertTrue(this.t.findElementInBT(this.root, 7));
		assertFalse(this.t.findElementInBT(this.root, 12));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#getSizeOfBinaryTree(learning.dsa.trees.BTreeNode)}.
	 */
	@Test
	public void testGetSizeOfBinaryTree() {
		assertEquals(7, this.t.getSizeOfBinaryTree(this.root));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#getSizeOfBinaryTreeIterative(learning.dsa.trees.BTreeNode)}.
	 */
	@Test
	public void testGetSizeOfBinaryTreeIterative() {
		assertEquals(7, this.t.getSizeOfBinaryTreeIterative(this.root));
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#reverseLevelOrder(learning.dsa.trees.BTreeNode)}.
	 */
	@Test
	public void testReverseLevelOrder() {
		final Object[] a = { 4, 5, 6, 7, 2, 3, 1 };
		assertArrayEquals(a, this.t.reverseLevelOrder(this.root).toArray());
	}

	/**
	 * Test method for
	 * {@link learning.dsa.trees.BinaryTreeProblems#reverseLevelOrder(learning.dsa.trees.BTreeNode)}.
	 */
	@Test
	public void testMaxDepthOfTree() {
		assertEquals(3, this.t.maxDepthOfTree(this.root));
	}

}
