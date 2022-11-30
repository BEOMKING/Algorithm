package brute_force.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_듣보잡 {
    private static List<String> notHearAndSee;
    private static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int notHear = Integer.parseInt(inputs[0]);
        int notSee = Integer.parseInt(inputs[1]);

        notHearAndSee = new ArrayList<>();
        set = new HashSet<>();

        for (int i = 0; i < notHear; i++) {
            check(br.readLine());
        }

        for (int i = 0; i < notSee; i++) {
            check(br.readLine());
        }

        Collections.sort(notHearAndSee);
        System.out.println(notHearAndSee.size());
        for (String name : notHearAndSee) {
            System.out.println(name);
        }
    }

    private static void check(String name) {
        if (set.contains(name)) {
            notHearAndSee.add(name);
        } else {
            set.add(name);
        }
    }
}
