class Hnode
{
    int key;
    Hnode left,right;
    Hnode(int data)
    {
        key=data;
        left=right=null;
    }
}
public class Height {

    Hnode root;

    int height(Hnode root)
    {
        if(root==null)
        {
            return -1;
        }
        else
        {
            int l=height(root.left);
            int r=height(root.right);

            if(l>r)
            {
                return l+1;
            }
            else
            {
                return r+1;
            }
        }
    }

    public static void main(String[] args) {
        Height tree=new Height();
        tree.root=new Hnode(1);
        tree.root.left=new Hnode(2);
        tree.root.right=new Hnode(3);
        tree.root.left.left=new Hnode(4);
        tree.root.left.right=new Hnode(5);

        System.out.println(tree.height(tree.root));

    }
}
