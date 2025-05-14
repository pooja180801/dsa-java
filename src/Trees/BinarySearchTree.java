package Trees;

class BinarySearchTreeImp {
    Node root;
    class Node{
        int key;
        Node left,right;

        public Node(int val){
            key = val;
            left = right = null;
        }
    }

    public BinarySearchTreeImp(int val){
        root = new Node(val);
    }

    public BinarySearchTreeImp(){
        root = null;
    }

    public void insert(int val){
        insert(root,val);
    }

    public Node insert(Node root, int val){
        if(root == null)
            return new Node(val);

        if(val < root.key)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right,val);

        return root;
    }

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);
        }
    }

    public Node search(Node root, int val){
        if(root == null || root.key == val){
            return root;
        }
        if(val<root.key){
            return search(root.left,val);
        }
        return search(root.right,val);
    }

    public Node delete(Node root, int val){
        if(root == null)
            return root;

        if(val> root.key)
            root.right = delete(root.right,val);
        else if (val< root.key)
            root.left = delete(root.left,val);
        else{
            if(root.left == null)
                return root.right;
            else if (root.right==null)
                return root.left;
            else{
                root.key=min(root.right);
                root.right=delete(root.right,root.key);
            }
        }
        return root;
    }

    public int min(Node root){
        int minVal = root.key;
        while (root.left!=null){
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTreeImp bst = new BinarySearchTreeImp(50);

        bst.insert(20);
        bst.insert(30);
        bst.insert(60);
        bst.insert(45);
        bst.insert(80);
        bst.insert(70);

        bst.inOrder(bst.root);

        if(bst.search(bst.root,40)==null){
            System.out.println("Not Found");
        }else {
            System.out.println("found");
        }

        bst.delete(bst.root, 60);
        bst.inOrder(bst.root);
    }
}
