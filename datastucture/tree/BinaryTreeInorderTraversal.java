package datastucture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * 트리의 중위순회를 구현하는 문제이다.
 *     1
 *   2   3
 * 4  5 6  7
 * 위와 같은 트리가 있을 때, 중위순회는 4 2 5 1 6 3 7 의 결과를 반환하면 된다.
 */
class BinaryTreeInorderTraversal {
    List<Integer> inordersList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return inordersList;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        inordersList.add(node.val);
        inorder(node.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
