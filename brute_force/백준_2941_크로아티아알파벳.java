package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        char croatia[] = br.readLine().toCharArray();
        char before = ' ';
        for (int i = 0; i < croatia.length; i++) {
            if(croatia[i] == '=') {
                if(before == 'c' || before == 's'){
                }else if(before == 'z'){
                    if(i - 2 >= 0 && croatia[i - 2] == 'd'){
                        result--;
                    }
                }
            }else if(croatia[i] == '-'){
            }else if(croatia[i] == 'j'){
                if(before != 'l' && before != 'n') result++;
            }else{
                result++;
            }
            before = croatia[i];
        }
        System.out.println(result);
    }
}
