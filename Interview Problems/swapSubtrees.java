import java.util.Scanner;

/**
 * Created by Nisarg on 09-Mar-15.
 */


public class swapSubtrees {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public static void MirrorTree(Node root){
        if(root == null)
            return;
        else{
            Node temp = null;
            MirrorTree(root.left);
            MirrorTree(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner inp = new Scanner(System.in);
        int numNodes = Integer.parseInt(inp.nextLine());
        Node root = new Node(1);
        for(int i = 0; i < numNodes; i++){
            String[] childNodes = inp.nextLine().split(" ");
            if(Integer.parseInt(childNodes[0]) == -1)
                root.left = null;
            else
                root.left = new Node(Integer.parseInt(childNodes[0]));

            if(Integer.parseInt(childNodes[1]) == -1)
                root.left = null;
            else
                root.left = new Node(Integer.parseInt(childNodes[1]));

        }
        int numSwaps = Integer.parseInt(inp.nextLine());
        for(int j = 0; j < numSwaps; j++){
            MirrorTree(root);
        }

    }
}
