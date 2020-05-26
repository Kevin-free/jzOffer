package Tree;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/10
 * @version: 1.0
 */
//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }


    // 层序遍历数组构造二叉树
    public static TreeNode createBT(Integer[] arr, int i) // 初始时,传入的i==0
    {
        TreeNode root = null; // 定义根节点

        if (i >= arr.length) // i >= arr.length 时,表示已经到达了根节点
            return null;
        Integer value = arr[i];
        if (value == null) {
            return null;
        }
        root = new TreeNode(arr[i]); // 根节点
        root.left = createBT(arr, 2*i+1); // 递归建立左孩子结点
        root.right = createBT(arr, 2*i+2); // 递归建立右孩子结点

        return root;
    }

    // 先序遍历
    public static void preOrder(TreeNode root)
    {
        if (root == null)
            return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public static void inOrder(TreeNode root)
    {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    public static void postOrder(TreeNode root)
    {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

}
