
public class BinarySearchTree {

    private TreeNode root;

    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public TreeNode searchElement(int key) {
        return searchElement(root, key);
    }

    public TreeNode searchElement(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            return searchElement(root.left, key);
        } else {
            return searchElement(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(9);
        bst.inOrder();
        System.out.println();
        if (null != bst.searchElement(1)) {
            System.out.println("Key forund!!!!");
        }else {
            System.out.println("Key not forund!!!!");
        }
    }
}
