package 자료구조.트리;

import java.util.Arrays;

class Pro_길찾기게임 {
    int i = 0;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            root.add(nodes[i]);
        }

        int[][] answer = new int[2][nodeinfo.length];
        root.preorder(answer[0]);
        i = 0;
        root.postorder(answer[1]);

        return answer;
    }

    class Node {
        int x;
        int y;
        int index;
        Node left;
        Node right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public void add(final Node node) {
            if (node.x < this.x) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }

        public void preorder(final int[] ints) {
            ints[i++] = this.index;
            if (this.left != null) {
                this.left.preorder(ints);
            }
            if (this.right != null) {
                this.right.preorder(ints);
            }
        }

        public void postorder(final int[] ints) {
            if (this.left != null) {
                this.left.postorder(ints);
            }
            if (this.right != null) {
                this.right.postorder(ints);
            }
            ints[i++] = this.index;
        }
    }
}