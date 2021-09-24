import java.util.Stack;

public class Trees {

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

    // recursive pre-order traversal of binary tree
    // internally it uses stack to keep track of the nodes
    public void preOrderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;// base case to exit from the recursion

        System.out.print(root.data + " ");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }

    public void preOrderTraversalIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);// right is pushed first and the left as stack is LIFO and left element we want
                                      // it to be poped first
            }
        }
    }

    public void inOrderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;// base case to exit from the recursion

        inOrderTraversalRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderTraversalRecursive(root.right);
    }

    public void inOrderTraversalIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void postOrderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;// base case to exit from the recursion

        inOrderTraversalRecursive(root.left);
        inOrderTraversalRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderTraversalIterative(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // the following code is to identify whether the current is pointing to left
                // node or the right
                // if its pointing to right then we have already visited the left one and we are
                // in the right node
                // if the right node is null then no further nodes so pop the root element
                // if right node not null then current will point to the right node and same
                // process is carried
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        // this while is to check in the previous level whether we are in left node or
                        // right
                        // if in right then left is visited so pop the root
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Trees bt = new Trees();
        bt.createBinaryTree();
        bt.preOrderTraversalRecursive(bt.root);
        System.out.println();
        bt.preOrderTraversalRecursive(bt.root);
        System.out.println();
        bt.inOrderTraversalRecursive(bt.root);
        System.out.println();
        bt.inOrderTraversalIterative(bt.root);
        System.out.println();
        bt.postOrderTraversalRecursive(bt.root);
        System.out.println();
        bt.postOrderTraversalIterative(bt.root);
        System.out.println();
    }
}
