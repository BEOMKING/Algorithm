package 기업코테;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NC_2022_하반기_2번 {
    public int solution(int[] music) {
        List<Integer>[] list = new List[13];
        list[1] = List.of(2, 3);
        list[2] = List.of(1, 3);
        list[3] = List.of(1, 2, 4, 5);
        list[4] = List.of(3, 5);
        list[5] = List.of(3, 4, 6, 7);
        list[6] = List.of(5, 7);
        list[7] = List.of(5, 6, 8);
        list[8] = List.of(7, 9, 10);
        list[9] = List.of(8, 10);
        list[10] = List.of(8, 9, 11, 12);
        list[11] = List.of(10, 12);
        list[12] = List.of(10, 11);

        int answer = 0;

        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(1, 0, music[0], 0));
        boolean[][][] visited = new boolean[13][100001][music.length];

        while (!queue.isEmpty()) {
            Data data = queue.poll();
            int location = data.location;
            int count = data.count;
            int target = data.target;
            int goal = data.goal;

            if (location == target) {
                goal++;

                if (goal == music.length) {
                    answer = count;
                    break;
                }

                target = music[goal];
            }

            for (Integer i : list[location]) {
                if (visited[i][count + 1][goal]) continue;
                visited[i][count + 1][goal] = true;
                queue.add(new Data(i, count + 1, target, goal));
            }
        }

        return answer;
    }

    static class Data {
        int location, count, target, goal;

        public Data(int location, int count, int target, int goal) {
            this.location = location;
            this.count = count;
            this.target = target;
            this.goal = goal;
        }
    }

    public static void main(String[] args) {
        NC_2022_하반기_2번 solution = new NC_2022_하반기_2번();
        System.out.println(solution.solution(new int[]{10, 9, 4, 5, 12}));
        System.out.println(solution.solution(new int[]{6, 4, 2, 11}));
    }
}
