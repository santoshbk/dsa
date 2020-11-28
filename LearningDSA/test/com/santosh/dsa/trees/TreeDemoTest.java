package com.santosh.dsa.trees;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.santosh.dsa.trees.BTreeNode;
import com.santosh.dsa.trees.TreeDemo;

public class TreeDemoTest {

	private BTreeNode root;
	private TreeDemo t;

	@Before
	public void setUp() throws Exception {
		this.t = new TreeDemo();
		this.root = TreeDemo.getTempTree();
	}

	@Test
	public void testinOder() {
		final List<Integer> inOder = this.t.inOrder(this.root);
		final List<Integer> inOderI = this.t.inOrderIterative(this.root);
		assertArrayEquals(inOder.toArray(), inOderI.toArray());
	}

	@Test
	public void testPreOrder() {
		final List<Integer> preOder = this.t.preOrder(this.root);
		final List<Integer> preOderI = this.t.preOrderIterative(this.root);
		assertArrayEquals(preOder.toArray(), preOderI.toArray());
	}

	@Test
	public void testPostOrder() {
		final List<Integer> postOder = this.t.postOrder(this.root);
		final List<Integer> postOderI = this.t.postOrderIterative(this.root);
//        assertArrayEquals(postOder.toArray(), postOderI.toArray());
		final Object[] expected = { 4, 5, 2, 6, 7, 3, 1 };
		assertArrayEquals(expected, postOder.toArray());
	}

	@Test
	public void testLevelOder() {
		final List<Integer> levelOder = this.t.levelOrder(this.root);
		final Object[] expected = { 1, 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected, levelOder.toArray());
	}

}
