package com.guocai.DatasTructureAndAlgorithm.tree;

import sun.reflect.generics.tree.Tree;

/**
 * java类简单作用描述
 *
 * @ClassName: BinarySearchTree
 * @Package: com.guocai.DatasTructureAndAlgorithm.tree
 * @Description: 二叉搜索树
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2019-02-18-15:19
 */
public class BinarySearchTree {

    private TreeNode root;

    private static class TreeNode {
        private int key;
        private int val;
        private TreeNode left, right;
        private int size;

        public TreeNode(int key, int val, int size){
            this.key = key;
            this.size = size;
            this.val = val;
        }

    }


    public BinarySearchTree(){

    }

    public int size() {
        return root == null ?0 : root.size;
    }

    public int size(TreeNode node) {
        return node == null ? 0 : node.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int search(int key){
        return search(root, key);
    }

    public int search(TreeNode root, int key) {
        if(root == null) {
            return -1;
        }

        if (root.key < key) {
            return search(root.right, key);
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return root.val;
        }
    }

    public void insert(int key) {

    }

    public TreeNode insert(TreeNode root, int key, int val) {
        if (root == null) {
            return new TreeNode(key, val, 1);
        }

        if (root.key < key) {
            root.right = insert(root.right, key, val);
        } else if (root.key > key) {
            root.left = insert(root.left, key, val);
        } else {
            root.val = val;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void remove(int key){

    }

    public TreeNode remove(TreeNode root, int key){
        if (root == null) {
            return null;
        }

        if (root.key < key) {
            root.right = remove(root.right, key);

        }else if (root.key > key) {
            root.left = remove(root.left, key);
        }
        return null;
    }

}
