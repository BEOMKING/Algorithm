package 자료구조.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.createNode(root, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }

}

class Node {
    char node;
    Node left, right;

    public Node(char node) {
        this.node = node;
    }
}

class Tree {

    public Node root;

    public void createNode(char node, char left, char right) {
        if (root == null) {
            root = new Node(node);
            if (left != '.') {
                root.left = new Node(left);
            }
            if (right != '.') {
                root.right = new Node(right);
            }
        } else {
            searchNode(root, node, left, right);
        }
    }

    private void searchNode(Node root, char node, char left, char right) {
        if (root == null) {
            return;
        } else if (root.node == node) {
            if (left != '.') {
                root.left = new Node(left);
            }
            if (right != '.') {
                root.right = new Node(right);
            }
        } else {
            searchNode(root.left, node, left, right);
            searchNode(root.right, node, left, right);
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.node);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.node);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.node);
    }

}
