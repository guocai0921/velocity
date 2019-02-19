package com.guocai.DatasTructureAndAlgorithm.tree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ClassName: BinaryTreeTraverse
 * @Package: com.guocai.DatasTructureAndAlgorithm.tree
 * @Description: 遍历二叉树
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-02-18-9:40
 */
public class BinaryTreeTraverse {

    public static int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }



    /**
     * @description: 迭代前序遍历
     * @auther: Sun GuoCai
     * @datetime: 2019/2/18 12:59
     * @param: root
     * @param: result
     * @return: void
     */
    public static void preorderIter(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while( ! stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * @description: 迭代中序遍历
     * @auther: Sun GuoCai
     * @datetime: 2019/2/18 14:37
     * @param: root
     * @param: result
     * @return: void
     */
    public static void inorderIter(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;

        while (! stack.isEmpty() || curr != null){
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

    }

    /**
     * @description: 迭代后序遍历
     * @auther: Sun GuoCai
     * @datetime: 2019/2/18 14:46
     * @param: root
 * @param: result
     * @return: void
     */
    public static void postorderIter(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        Deque<TreeNode> output = new LinkedList<TreeNode>();

        stack.push(root);

        while (! stack.isEmpty()){
            TreeNode node = stack.pop();
            output.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while(!output.isEmpty()){
            result.add(output.pop().val);
        }
    }


    /**
     * @description: 前序遍历
     * @auther: Sun GuoCai
     * @datetime: 2019/2/18 9:43
     * @param: root
     * @param: result
     * @return: void
     */
    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val); // 访问根节点

        preorder(root.left, result); // 前序遍历左子树

        preorder(root.right, result); // 前序遍历右子树

    }

    /**
     * @description: 中序遍历
     * @auther: Sun GuoCai
     * @datetime: 2019/2/18 10:42
     * @param: root
     * @param: result
     * @return: void
     */
    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result); // 中序遍历左子树

        result.add(root.val); // 访问根节点

        inorder(root.right, result); // 中序遍历右子树

    }
    /**
     * @description: 后序遍历
     * @auther: Sun GuoCai
     * @datetime: 2019/2/18 11:20
     * @param: root
     * @param: result
     * @return: void
     */
    public static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorder(root.left, result); // 后序遍历左子树

        postorder(root.right, result); // 后序遍历右子树

        result.add(root.val); // 访问根节点
    }

}
