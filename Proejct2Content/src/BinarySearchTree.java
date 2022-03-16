public class BinarySearchTree {
    private static class TreeNode{
        private int item;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int item){
            this.item = item;
            left = null;
            right = null;
        }

        public void setLeft(TreeNode targetNode){
            left = targetNode;
        }

        public void setRight(TreeNode targetNode){
            right = targetNode;
        }

        public TreeNode getLeft(){
            return left;
        }

        public TreeNode getRight(){
            return right;
        }

        public int getItem(){
            return item;
        }
    }

    private static TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public static void setRoot(TreeNode target){
        root = target;
    }

    public static TreeNode getRoot(){
        return root;
    }

    /**
     * Function: takes a sorted array and convert it into a balanced binary search tree, and return the root
     * Error condition: present error when array is null or is empty, or when the index array is out of bounds when accessing an array element (low or high invalid)
     * @param array
     * @param low
     * @param high
     * @return ultimately return the root of the newly constructed binary search tree
     */
    public static TreeNode ArrayToTree(int[] array, int low, int high){
        //error detecting:
        //case 1: when array is null, print error message and return null
        if (array == null){
            System.out.println("Error: array is null, can't construct tree");
            return null;
        }
        //case 2: when array is empty, print error message and return null
        else if (array.length == 0){
            System.out.println("Error: empty array, can't construct tree");
            return null;
        }
        //Base case: if low > high, it means the parent node should not have this child node, so return null
        if (low > high){
            return null;
        }
        else{
            //get the middle element and make it a parent node
            int mid = (low + high) / 2;
            TreeNode newNode = null;
            try{
                newNode = new TreeNode(array[mid]);
            }
            //if the index is out of bounds, print error message and return null (this try statement is intentionally for the first recursion
            // when the initial index is unknown in terms of its validity)
            catch(IndexOutOfBoundsException e1){
                System.out.println("Error: array index out of bounds.");
                return null;
            }
            //recursively construct the left subtree and make it left child of the parent
            newNode.setLeft(ArrayToTree(array, low, mid - 1));
            //recursively construct the right subtree and make it left child of the parent
            newNode.setRight(ArrayToTree(array, mid + 1, high));
            return newNode;
        }
    }

    /**
     * Error condition: when the tree is empty (root is null), show error
     */
    public static void preorder_traversal(){
        //when the root is null, print error message and return
        if (root == null){
            System.out.println("Error: tree is empty, can't traverse");
            return;
        }
        else{
            preorder_traversal_helper(root);
        }
    }

    /**
     * Function: traverse and print the int variables stored in the tree nodes in preorder
     * @param node
     */
    public static void preorder_traversal_helper(TreeNode node){
        //base case
        if (node == null){
            return;
        }
        else{
            System.out.print(node.getItem() + " ");
            preorder_traversal_helper(node.getLeft());
            preorder_traversal_helper(node.getRight());
        }
    }

    /**
     * Error condition: when the tree is empty (root is null), show error
     */
    public static void postorder_traversal(){
        //when the root is null, print error message and return
        if (root == null){
            System.out.println("Error: tree is empty, can't traverse");
            return;
        }
        else{
            postorder_traversal_helper(root);
        }
    }
    /**
     * Function: traverse and print the int variables stored in the tree nodes in postorder
     * @param node
     */
    public static void postorder_traversal_helper(TreeNode node){
        //base case
        if (node == null){
            return;
        }
        else{
            postorder_traversal_helper(node.getLeft());
            postorder_traversal_helper(node.getRight());
            System.out.print(node.getItem() + " ");
        }
    }

    /**
     * Error condition: when the tree is empty (root is null), show error
     */
    public static void inorder_traversal(){
        //when the root is null, print error message and return
        if (root == null){
            System.out.println("Error: tree is empty, can't traverse");
            return;
        }
        else{
            inorder_traversal_helper(root);
        }
    }

    /**
     * Function: traverse and print the int variables stored in the tree nodes in inorder
     * @param node
     */
    public static void inorder_traversal_helper(TreeNode node){
        //base case
        if (node == null){
            return;
        }
        else{
            inorder_traversal_helper(node.getLeft());
            System.out.print(node.getItem() + " ");
            inorder_traversal_helper(node.getRight());
        }
    }


    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        int arr[] = new int[] {7,8,9,10,12,15,17};
        tree.setRoot(tree.ArrayToTree(arr, 0, arr.length - 1));
        System.out.println();
        System.out.println("Preorder:");
        tree.preorder_traversal();
        System.out.println();
        System.out.println("Postorder:");
        tree.postorder_traversal();
        System.out.println();
        System.out.println("Inorder");
        tree.inorder_traversal();
    }
}
