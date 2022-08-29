package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 위상 정렬
 */
public class BOJ_2056_작업 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] followUpTasks = new List[N + 1];
        int[] requiredTime = new int[N + 1];
        int[] degree = new int[N + 1];

        for (int currentTask = 1; currentTask <= N; currentTask++) {
            followUpTasks[currentTask] = new ArrayList<>();
            String[] inputs = br.readLine().split(" ");
            requiredTime[currentTask] = Integer.parseInt(inputs[0]);
            degree[currentTask] = Integer.parseInt(inputs[1]);
            for (int i = 2; i < degree[currentTask] + 2; i++) {
                int priorTask = Integer.parseInt(inputs[i]);
                followUpTasks[priorTask].add(currentTask);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] endTime = new int[N + 1];
        for (int currentTask = 1; currentTask <= N; currentTask++) {
            if (degree[currentTask] == 0) {
                queue.add(currentTask);
                endTime[currentTask] = requiredTime[currentTask];
            }
        }

        while (!queue.isEmpty()) {
            int currentTask = queue.poll();
            for (int followUpTask : followUpTasks[currentTask]) {
                degree[followUpTask] -= 1;
                endTime[followUpTask] = Math.max(endTime[followUpTask], endTime[currentTask] + requiredTime[followUpTask]);

                if (degree[followUpTask] == 0) {
                    queue.add(followUpTask);
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, endTime[i]);
        }
        System.out.println(maxTime);
    }

    static Integer solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] endTime = new int[10001];

        for (int currentTask = 1; currentTask <= N; currentTask++) {
            String[] inputs = br.readLine().split(" ");
            int requiredTime = Integer.parseInt(inputs[0]);
            int numberOfPredecessors = Integer.parseInt(inputs[1]);
            int availableStartTime = 0;

            for (int predecessor = 2; predecessor < numberOfPredecessors + 2; predecessor++) {
                int predecessorEndTime = endTime[Integer.parseInt(inputs[predecessor])];
                availableStartTime = Math.max(predecessorEndTime, availableStartTime);
            }

            endTime[currentTask] = availableStartTime + requiredTime;
        }

        int maxTime = 0;
        for (int i : endTime) {
            maxTime = Math.max(maxTime, i);
        }
        return maxTime;
    }
}
