package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 매우 어렵게 풀었다.
 * 범위가 작기 때문에 브루트 포스를 사용하면 되는데
 * 처음 접근을 자신이 몇명보다 더 큰지를 확인하는 방법을 사용해서 풀지 못했다.
 * 자기가 몇명보다 작은지를 확인하면 쉽게 구할 수 있는 문제였다.
 */
public class BOJ_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            Person person = new Person(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            people[i] = person;
        }

        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (people[i].isSmaller(people[j])) {
                    rank[i]++;
                }
            }
        }

        for (int i : rank) {
            System.out.print(i + " ");
        }
    }

    static class Person {
        int weight, height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isSmaller(Person o) {
            if (this.weight < o.weight && this.height < o.height) return true;
            return false;
        }
    }
}
