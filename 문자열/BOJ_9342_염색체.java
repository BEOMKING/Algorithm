package 문자열;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BOJ_9342_염색체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String str = sc.next();
            if(Pattern.matches("^[A-F]?A+F+C+[A-F]?", str)){
                System.out.println("Infected!");
            }else{
                System.out.println("Good");
            }

        }
    }
}
