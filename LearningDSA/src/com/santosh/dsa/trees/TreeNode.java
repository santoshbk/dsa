package learning.dsa.trees;

public class BTreeNode {

    public int data;
    public BTreeNode left, right;

    public BTreeNode(final int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "BTN: " + this.data;
    }

}
