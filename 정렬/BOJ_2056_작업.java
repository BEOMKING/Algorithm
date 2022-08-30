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
        Task[] tasks = new Task[N + 1];

        for (int currentTask = 1; currentTask <= N; currentTask++) {
            String[] inputs = br.readLine().split(" ");
            int requiredTime = Integer.parseInt(inputs[0]);
            int inDegree = Integer.parseInt(inputs[1]);

            for (int i = 2; i < 2 + inDegree; i++) {
                int priorTaskIndex = Integer.parseInt(inputs[i]);
                Task priorTask = tasks[priorTaskIndex];
                priorTask.followUpTasks.add(currentTask);
            }

            tasks[currentTask] = new Task(requiredTime, new ArrayList<>(), inDegree);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            Task task = tasks[i];
            if (task.inDegree == 0) {
                queue.add(i);
                task.endTime = task.requiredTime;
            }
        }

        while (!queue.isEmpty()) {
            int taskIndex = queue.poll();
            Task currentTask = tasks[taskIndex];
            List<Integer> followUpTasks = currentTask.followUpTasks;

            for (int followUpTaskIndex: followUpTasks) {
                Task followUpTask = tasks[followUpTaskIndex];
                followUpTask.endTime = Math.max(followUpTask.endTime, currentTask.endTime + followUpTask.requiredTime);

                if (--followUpTask.inDegree == 0) {
                    queue.add(followUpTaskIndex);
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, tasks[i].endTime);
        }
        System.out.println(maxTime);
    }

    static class Task {
        int requiredTime;
        List<Integer> followUpTasks;
        int inDegree;
        int endTime;

        public Task(int requiredTime, List<Integer> followUpTasks, int inDegree) {
            this.requiredTime = requiredTime;
            this.followUpTasks = followUpTasks;
            this.inDegree = inDegree;
        }
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
