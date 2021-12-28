package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도 삽입(N(문자열의 개수 10000) x L(최대 개수 500)) + 탐색(M(문자열의 개수 10000) x L(최대 개수 500)) == NL
public class BOJ_14425_문자열집합_Trie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if(trie.find(br.readLine())) count++;
        }
        System.out.println(count);
    }

    static class Node {
        final int SIZE = 26;
        Node[] child = new Node[SIZE];
        boolean isLast = false;
        int childNum = 0;
        char data;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Trie {

        final Node root = new Node(' ');

        public void insert(String str) {
            int length = str.length();
            Node now = root;
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                int num = charToInt(c);

                if (now.child[num] == null) {
                    now.child[num] = new Node(c);
                    now.childNum++;
                }

                now = now.child[num];
            }

            now.isLast = true;
        }

        public boolean find(String str) {
            int length = str.length();
            Node now = root;

            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                int num = charToInt(c);
                if (now.child[num] == null)
                    return false;
                now = now.child[num];
            }

            return now != null && now.isLast;
        }

        private int charToInt(char c) {
            return c - 'a';
        }

    }
}
