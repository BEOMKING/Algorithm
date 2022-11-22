package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20436_ZOAC3 {
    static char[] consonant = {'a', 'c', 'd', 'e', 'f', 'g', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Locations left = Locations.valueOf(input[0]);
        Locations right = Locations.valueOf(input[1]);
        String str = br.readLine();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            Locations now = Locations.valueOf(str.substring(i, i + 1));
            int time;
            if(checkConsonant(str.charAt(i))){
                time = Math.abs(left.locationY - now.locationY) + Math.abs(left.locationX - now.locationX);
                left = now;
            } else {
                time = Math.abs(right.locationY - now.locationY) + Math.abs(right.locationX - now.locationX);
                right = now;
            }
            result += (time + 1);
        }

        System.out.println(result);
    }

    static boolean checkConsonant(char c) {
        for (int i = 0; i < consonant.length; i++) {
            if(consonant[i] == c) return true;
        }
        return false;
    }

    enum Locations {
        a(1, 0),
        b(2, 4),
        c(2, 2),
        d(1, 2),
        e(0, 2),
        f(1, 3),
        g(1, 4),
        h(1, 5),
        i(0, 7),
        j(1, 6),
        k(1, 7),
        l(1, 8),
        m(2, 6),
        n(2, 5),
        o(0, 8),
        p(0, 9),
        q(0, 0),
        r(0, 3),
        s(1, 1),
        t(0, 4),
        u(0, 6),
        w(0, 1),
        v(2, 3),
        x(2, 1),
        y(0, 5),
        z(2, 0);

        private final int locationY;
        private final int locationX;

        Locations(int locationY, int locationX) {
            this.locationY = locationY;
            this.locationX = locationX;
        }

    }

}
