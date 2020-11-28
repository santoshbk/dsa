package learning.dsa.trees;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
        List<Integer> inOder = this.t.inOrder(this.root);
        List<Integer> inOderI = this.t.inOrderIterative(this.root);
        assertArrayEquals(inOder.toArray(), inOderI.toArray());
    }

    @Test
    public void testPreOrder() {
        List<Integer> preOder = this.t.preOrder(this.root);
        List<Integer> preOderI = this.t.preOrderIterative(this.root);
        assertArrayEquals(preOder.toArray(), preOderI.toArray());
    }

    @Test
    public void testPostOrder() {
        List<Integer> postOder = this.t.postOrder(this.root);
        List<Integer> postOderI = this.t.postOrderIterative(this.root);
//        assertArrayEquals(postOder.toArray(), postOderI.toArray());
        Object[] expected = { 4, 5, 2, 6, 7, 3, 1 };
        assertArrayEquals(expected, postOder.toArray());
    }

    @Test
    public void testLevelOder() {
        List<Integer> levelOder = this.t.levelOrder(this.root);
        Object[] expected = { 1, 2, 3, 4, 5, 6, 7 };
        assertArrayEquals(expected, levelOder.toArray());
    }

}
