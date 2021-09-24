public class MaximumValueInTree {

    private TreeNode root;

    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);

        root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
    }

    public int maxValue(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int result = root.data;
        // here we will recursively calculate the max value of left tree and right tree
        // separately and compare it with the root
        int left = maxValue(root.left);
        int right = maxValue(root.right);
        if (left > result)
            result = left;
        if (right > result)
            result = right;

        return result;
    }

    public static void main(String[] args) {
        MaximumValueInTree max = new MaximumValueInTree();
        max.createBinaryTree();
        int value = max.maxValue(max.root);
        System.out.println("maximum value is " + value);
    }
}
