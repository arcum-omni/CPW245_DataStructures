// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void printInOrder() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
    
    public void printSideways() {
        printSideways(overallRoot, 0);
    }
    
    private void printSideways( SearchTreeNode<E> root, int level ) {
        if ( root != null ) {
            printSideways(root.right, level + 1 );
            for ( int i = 0; i < level; i++ ) {
                System.out.print("            ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1 );
        }
    }
    
    /////////////////////////////////
    // assignment
    /////////////////////////////////
    public LinkedList<E> getLeaves() {
        LinkedList<E> leaves = new LinkedList<E>();
        getLeaves( leaves, overallRoot );
        return leaves;
    }
    private void getLeaves(LinkedList<E> leaves, SearchTreeNode<E> root ) {
        // TO DO: implement this method
        LinkedList<E> empty = new LinkedList();
        
        /*
        Create an empty LinkedList<E> in public LinkedList<E> getLeaves()
        that calls a private helper method private void getLeaves(LinkedList<E> leaves, SearchTreeNode<E> root)
        which does an in-order traversal of the tree.
        When the traversal finds a leaf, that leaf is added to the linked list.
        The linked list is then returned by the public method to the client code.
        */
        
    }

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
