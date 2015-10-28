/**
 * Created by nisarg on 4/1/15.
 */
public class LCA {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    static boolean covers(Node root, Node p){
        if(root == null)
            return false;
        if(root == p)
            return true;
        return (covers(root.left,p) || covers(root.right,p));
    }

    static Node commonLCAHelper(Node root, Node p, Node q){
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;

        boolean is_p_on_left = covers(root.left,p);
        boolean is_q_on_left = covers(root.left,q);

        if(is_p_on_left != is_q_on_left)
            return root;

        Node child_side = is_p_on_left?root.left:root.right;

        return commonLCAHelper(child_side,p,q);
    }

    static Node commonLCA(Node root, Node p, Node q){
        if(!covers(root,p) || !covers(root,q))
            return null;
        return commonLCAHelper(root,p,q);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(8);
        System.out.println(commonLCA(root,root.right,root.right.right).data);
    }
}
