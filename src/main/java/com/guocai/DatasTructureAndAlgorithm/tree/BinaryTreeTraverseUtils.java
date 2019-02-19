package com.guocai.DatasTructureAndAlgorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraverseUtils {

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	  public static List<Integer> preorderTraversal(TreeNode root) {
		    LinkedList<TreeNode> stack = new LinkedList<>();
		    LinkedList<Integer> output = new LinkedList<>();
		    if (root == null) {
		      return output;
		    }

		    stack.add(root);
		    while (!stack.isEmpty()) {
		      TreeNode node = stack.pollLast();
		      output.add(node.val);
		      if (node.right != null) {
		        stack.add(node.right);
		      }
		      if (node.left != null) {
		        stack.add(node.left);
		      }
		    }
		    return output;
		  }

	public static void main(String[] args) throws IOException {
		String line1 = "[1,null,2,3]";
		String line= "[4,2,7,1,3,5, 8]";
		TreeNode root = stringToTreeNode(line);
        BTreePrinter.printNode(root);

        List<Integer> list = new ArrayList<>(10);

		int height = BinaryTreeTraverse.maxHeight(root);

		System.out.println("height = " + height);


		// BinaryTreeTraverse.preorder(root, list);
		// System.out.println("list = " + list);
		//
		// list.clear();
		// BinaryTreeTraverse.preorderIter(root, list);
		// System.out.println("list = " + list);
		// list.clear();
        // BinaryTreeTraverse.inorder(root, list);
		// System.out.println("list = " + list);
		//
		// list.clear();
        // BinaryTreeTraverse.inorderIter(root, list);
		// System.out.println("list = " + list);


		// list.clear();
        // BinaryTreeTraverse.postorder(root, list);
		// System.out.println("list = " + list);
		//
		// list.clear();
		// BinaryTreeTraverse.postorderIter(root, list);
		// System.out.println("list = " + list);


	}
}
