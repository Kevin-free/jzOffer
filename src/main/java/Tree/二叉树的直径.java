package Tree;

/**
 * @description: https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 二叉树的直径
 * tag：树
 * 简单
 * @author: Kevin
 * @createDate: 2020/3/10
 * @version: 1.0
 */
public class 二叉树的直径 {

    public static void main(String[] args) {
        Integer[] arr = {1, null, null};
        TreeNode root = TreeNode.createBT(arr, 0);

        System.out.println("preOder:");
        TreeNode.preOrder(root);
        System.out.println();

        二叉树的直径 solution = new 二叉树的直径();
        int res = solution.diameterOfBinaryTree(root);
        System.out.println(res);
    }

    int res = 0; //全局变量记录

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 函数dfs的作用是：找到以root为根节点的二叉树的最大深度
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res, left + right); // 以node为根节点的直径res
        return Math.max(left, right) + 1; // 以node为根节点的最大深度
    }
}
