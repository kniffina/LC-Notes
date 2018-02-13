import java.util.LinkedList;
import java.util.Stack;

public class Notes {

    public static void inOrderTreeTraversalRecursive(TreeNode root) {
        if(root == null) return;

        inOrderTreeTraversalRecursive(root.left);

        System.out.println(root.data);

        inOrderTreeTraversalRecursive(root.right);
    }

    public static void inOrderIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //we cannot go left anywhere so pop off whatever is on the top
            //  and look to the right to see if we can do that. Otherwise
            //  we will keep popping
            else {
                curr = stack.pop();
                System.out.println(curr.data);
                curr = curr.right;
            }
        }
    }

    public static void preOrderRecursive(TreeNode root) {
        if(root == null) return;

        System.out.println(root.data);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public static void preOrderIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.data);

            //if we used a queue, we would put the root.left first,
            // because we take from the bottom FIFO (First In First Out)
            // but stacks are LIFO (Last In First Out)
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
    }

    public static void postOrderRecursive(TreeNode root) {
        if(root == null) return;

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.data);
    }

    public static void postOrderIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> out = new Stack<TreeNode>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            out.add(curr);

            if(curr.left != null) stack.add(curr.left);
            if(curr.right != null) stack.add(curr.right);
        }

            while(!out.isEmpty()) {
            TreeNode curr = out.pop();
            System.out.println(curr.data);
        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n8 = new TreeNode(8, null, null);
        TreeNode n9 = new TreeNode(9, null, null);

        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n7;
        n7.left = n6;
        n7.right = n8;

        postOrderIterative(n1);
    }
}

/*

Tree Traversal

          1
       /    \
      2       7
    /   \    /  \
   3     4  6     8


** In Order Traversal - Left - Root - Right
    - 3, 2, 4, 1, 6, 7, 8

    Can do this recursively or iteratively


** Pre Order Traversal - Root - Left - Right
   - 1, 2, 3, 4, 7, 6, 8

** Post Order Traversal - Left - Right - Root
   - 3, 4, 2, 6, 8, 7, 1

 */


//DEPTH FIRST SEARCH
// - go deep into graph. Follow node paths until get them all
// - preferred if we want to visit every edge of graph. Simpler

    /*
    public static void DFS(Node root) {
        if(root == null)
            return;
        visit(root);
        root.visited = true;
        for each(Node n in root.adjacent) {
            if(n.visited == false)
                DFS(n);
        }
    }
    */

//BREAD FIRST SEARCH
// - go to each of the root (or whatever nodes) children first before expanding
// - better for shortest path problems

    /*
    public static void BFS(Node root) {
        Queue q = new Queue();
        root.marked = true;
        q.add(root);
        while(!q.isEmpty()) {
            Node r = q.remove();
            visit(r);
            foreach(Node n in r.adjacent()) {
                if(n.marked == false) {
                    n.marked = true;
                    q.add(n);
                }
            }
        }
    }
     //  *** BFS  *******
    //visits 5 -> 3 -> 7 -> 2 -> 4 -> 6 -> 8
    //      visits all children first then goes to next level
    public static void breadth(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        queue.clear();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
    }
    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n8 = new TreeNode(8, null, null);
        TreeNode n9 = new TreeNode(12, null, null);
        TreeNode n15 = new TreeNode(15, null, null);
        //left subtree
        n5.left = n3;
        n3.left = n2;
        n3.right = n4;
        n5.right = n7;
        n7.left = n6;
        n7.right = n8;
        //n8.right = n9;
        //n9.right = n15;
        breadth(n5);
        //System.out.println(isBST(n5));
    }
    */
