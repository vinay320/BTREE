class Bnode1{
    Bnode1 left,right;
    int key;
    boolean rightThread;
    Bnode1(int data)
    {
        key=data;
    }
}
public class ThreadedBTraversal {
    Bnode1 root;
    ThreadedBTraversal()
    {
        root=null;
    }

    Bnode1 leftMost(Bnode1 root)
    {
        if(root==null)
        {
            return null;
        }
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    void insert(int key)
    {
        root=insertNode(root,key);
    }
    Bnode1 insertNode(Bnode1 root,int key)
    {
        if(root==null)
        { root=new Bnode1(key);
            return root;
        }

        if(key<root.key)
        {
            root.left = insertNode(root.left,key);
        }
        else if(key>root.key)
        {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    void inorder(Bnode1 root)
    {
        Bnode1 curr=leftMost(root);
        while(curr!=null) {
            System.out.println(curr.key);

            if ((curr.rightThread))
            {
                curr=curr.right;
            }
            else {
                curr=leftMost(curr.right);
            }
        }
    }
    public static void main(String[] args) {
    ThreadedBTraversal tree=new ThreadedBTraversal();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(80);
        tree.inorder(tree.root);
    }
}
