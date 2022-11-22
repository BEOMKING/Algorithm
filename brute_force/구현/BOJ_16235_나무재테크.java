package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BOJ_16235_나무재테크 {
    static int[][] additionalNourishment, land;
    static List<Tree>[][] trees;
    static int N, M, K;
    static Queue<Tree> deadTrees = new ArrayDeque<>();
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        additionalNourishment = new int[N][N];
        land = new int[N][N];
        trees = new List[N][N];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                additionalNourishment[i][j] = Integer.parseInt(line[j]);
                land[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int y = Integer.parseInt(line[0]) - 1;
            int x = Integer.parseInt(line[1]) - 1;
            int age = Integer.parseInt(line[2]);

            trees[y][x].add(new Tree(y, x, age));
        }

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += trees[i][j].size();
            }
        }

        System.out.println(count);
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] += additionalNourishment[i][j];
            }
        }
    }

    private static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Tree tree : trees[i][j]) {
                    if (tree.age % 5 == 0) {
                        for (int k = 0; k < 8; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                                continue;
                            }

                            trees[ny][nx].add(new Tree(ny, nx, 1));
                        }
                    }
                }
            }
        }
    }

    private static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll();
            land[tree.y][tree.x] += tree.age / 2;
        }
    }

    private static void spring() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Tree> afterSpring = new ArrayList<>();
                Collections.sort(trees[i][j]);
                List<Tree> beforeSpring = trees[i][j];

                for (Tree tree : beforeSpring) {
                    if (land[i][j] >= tree.age) {
                        land[i][j] -= tree.age;
                        tree.age++;
                        afterSpring.add(tree);
                    } else {
                        deadTrees.add(tree);
                    }
                }

                trees[i][j] = afterSpring;
            }
        }
    }

    static class Tree implements Comparable<Tree> {
        int y, x, age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(final Tree o) {
            return this.age - o.age;
        }
    }
}
