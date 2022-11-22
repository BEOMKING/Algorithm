package brute_force.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_6588_골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> primes = new ArrayList<>();
        boolean[] notPrimes = new boolean[1000001];
        notPrimes[1] = true;

        for (int i = 2; i * i <= 1000000; i++) {
            if (notPrimes[i]) continue;
            primes.add(i);
            for (int j = i + i; j <= 1000000; j+=i) {
                notPrimes[j] = true;
            }
        }

        int input;
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 1; i < primes.size(); i++) {
                if (notPrimes[input - primes.get(i)]) continue;
                bw.write(input + " = " + primes.get(i) + " + " + (input - primes.get(i)) + "\n");
                break;
            }

        }

        bw.flush();
    }
}
