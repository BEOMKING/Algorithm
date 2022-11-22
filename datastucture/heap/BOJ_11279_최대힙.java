package datastucture.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 각 연산의 시간 복잡도 O(lonN), 연산의 수 N -> O(NlogN)
 */
public class BOJ_11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int operation = Integer.parseInt(br.readLine());
            if (operation == 0) {
                sb.append(heap.pop()).append("\n");
            } else {
                heap.add(operation);
            }
        }

        System.out.println(sb);
    }

    private static class Heap {
        int[] arr = new int[100001];
        int size = 0;

        public void add(int value) {
            int index = size;

            while (index != 0) {
                int parent = index / 2;

                if (arr[parent] >= value) break;

                arr[index] = arr[parent];
                index = parent;
            }

            arr[index] = value;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return 0;
            }

            int value = arr[0];
            int target = arr[size - 1];
            arr[size - 1] = 0;
            arr[0] = 0;

            sort(0, target);

            return value;
        }

        private void sort(int parent, final int target) {
            size--;

            while ((parent * 2) < size) {
                int left = arr[parent * 2];
                int right;
                int tempIndex = parent * 2;
                int temp = left;

                if (parent * 2 + 1 < size && left < (right = arr[parent * 2 + 1])) {
                    tempIndex = parent * 2 + 1;
                    temp = right;
                }

                if (target >= temp) {
                    break;
                }

                arr[parent] = temp;
                parent = tempIndex;
            }

            arr[parent] = target;
        }
    }
}
