class Node1{
    int data,height;
    Node1 left,right;
    Node1(int key)
    {
        data=key;
        height=1;
        left=right=null;
    }
}

public class AVL {
    Node1 root;
    int height(Node1 N)
    {
        if(N==null)
        {
            return 0;
        }
        return N.height;
    }

    int max(int a,int b)
    {
        return Math.max(a, b);
    }

    Node1 rotateRight(Node1 y)
    {
        Node1 x=y.left;
        Node1 T2=x.right;
        x.right=y;
        y.left=T2;

        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;
        return x;

    }
    Node1 rotateLeft(Node1 x)
    {
        Node1 y=x.right;
        Node1 T2=y.left;
        y.left=x;
        x.right=T2;

        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        return y;

    }
    int getBalance(Node1 N)
    {
        if(N==null)
        {
            return 0;
        }
        return height(N.left)-height(N.right);
    }
    Node1 insert(Node1 root,int data)
    {
        if(root==null)
        {
            return (new Node1(data));
        }
        if(data<root.data)
        {
            root.left=insert(root.left,data);
        }
        else if(data>root.data)
        {
            root.right=insert(root.right,data);
        }
        else
        {
            return root;
        }

        root.height=1+max(height(root.left),height(root.right));

        int bal=getBalance(root);

        // four cases

        if(bal>1 && data<root.left.data)
        {
            return rotateRight(root);
        }
        if(bal<-1 && data>root.right.data)
        {
            return rotateLeft(root);
        }
        if(bal>1 && data>root.left.data)
        {
            root.left=rotateLeft(root.left);
            return rotateRight(root);
        }
        if(bal<-1 && data<root.right.data)
        {
            root.right=rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    void inorder(Node1 root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
    public static void main(String[] args)
    {
        AVL tree=new AVL();
        tree.root=tree.insert(tree.root,10);
        tree.root=tree.insert(tree.root,20);
        tree.root=tree.insert(tree.root,30);
        tree.root=tree.insert(tree.root,40);
        tree.root=tree.insert(tree.root,50);
        tree.root=tree.insert(tree.root,25);
        tree.inorder(tree.root);



    }
}

