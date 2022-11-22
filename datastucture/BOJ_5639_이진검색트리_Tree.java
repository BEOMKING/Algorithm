package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_이진검색트리_Tree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        String input;
        while ((input = br.readLine()) != null && input.length() != 0) {
            tree.insert(tree.root, Integer.parseInt(input));
        }

        tree.postOrder(tree.root);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void insert(Node root, int data) {
            if(root == null) {
                initial(data);
                return;
            }
            search(root, data);
        }

        private void initial(int data) {
            root = new Node(data);
        }

        private void search(Node parent, int data) {
            if(parent.data > data) {
                if(parent.left == null) {
                    parent.left = new Node(data);
                } else {
                    search(parent.left, data);
                }
            } else if(parent.data < data) {
                if(parent.right == null) {
                    parent.right = new Node(data);
                } else {
                    search(parent.right, data);
                }
            }
        }

        public void postOrder(Node root) {
            if(root.left != null) postOrder(root.left);
            if(root.right != null)postOrder(root.right);
            System.out.println(root.data);
        }
    }
}
