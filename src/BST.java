import java.util.ArrayList;

class Bnode{
    int key;
    Bnode left,right;
    Bnode(int key)
    {
        this.key=key;
    }
}

public class BST {

    Bnode root;
    BST()
    {
        root=null;
    }
    void insert(int key)
    {
        root=insertNode(root,key);
    }
     Bnode insertNode(Bnode root,int key)
    {
        if(root==null)
        { root=new Bnode(key);
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

    static ArrayList<Integer> obj=new ArrayList<>();
    static ArrayList<Integer> inorder(Bnode root)
    {

        if(root!=null) {
            inorder(root.left);
            //System.out.print(root.key+" ");
            obj.add(root.key);
            inorder(root.right);

        }
        return obj;
    }

    static void preorder(Bnode root)
    {
        if(root!=null)
        {
            System.out.print(""+root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void postorder(Bnode root)
    {
        if(root!=null)
        {

            postorder(root.left);
            postorder(root.right);
            System.out.print(""+root.key+" ");
        }
    }


    // delete

    void delete(int key)
    {
        root=delete(root,key);
    }
    static Bnode delete(Bnode root,int key)
    {
        if(root==null)
            return root;
        if(key<root.key)
        {
            root.left=delete(root.left,key);
        }
        else if(key>root.key)
        {
            root.right=delete(root.right,key);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            if(root.right==null)
            {
                return root.left;
            }

            root.key=minVal(root.right);
            root.right=delete(root.right,root.key);


        }
        return root;
    }
    static int minVal(Bnode root)
    {
int min=root.key;
while (root.left!=null)
{
    min=root.left.key;
    root=root.left;
}
return min;
    }

    static int count(Bnode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=count(root.right);
        int right=count(root.left);
        return left+right+1;
    }

static int sum(Bnode root)
{   int sum1=0;
    if(root==null) {
        return 0;
    }
    int left=sum(root.left);
    int right=sum(root.right);
    return left+right+root.key;

}

        int hight(Bnode root)
        {
            if(root == null)
            {
                return -1;
            }
            else 
            {
                int l = hight(root.left);
                int r = hight(root.right);
                if (l > r) 
                {
                    return l + 1;
                } 
                else 
                {
                    return r + 1;
                }
            }
        }

    public static void main(String[] args) {
        BST tree=new BST();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        //tree.insert(60);
        System.out.println("IN");
        ArrayList<Integer> in= tree.inorder(tree.root);
        for (int i=0;i<in.size();i++)
        {
            System.out.print(" "+in.get(i));
        }
        System.out.println("\nPP");
        tree .preorder(tree.root);
        System.out.println("\nPO");
        tree.postorder(tree.root);
        //tree.delete(70);
        System.out.println("\nin");
        tree.inorder(tree.root);

        System.out.println(count(tree.root));
        System.out.println(sum(tree.root));

        System.out.println("Hight of tree "+tree.hight(tree.root));
    }
}
