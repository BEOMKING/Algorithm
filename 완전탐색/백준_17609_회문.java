package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_17609_회문 {
    static char str[];
    static int len;
    static StringBuilder sb = new StringBuilder();

    static int palindrome(int start, int end, int count){ // 시작 값, 끝 값, 삭제 횟수
        while(start <= end){ // 시작 값이 끝 값보다 커지면 종료
            if(str[start] == str[end]){
                start += 1;
                end -= 1;
            }else if(str[start] == str[end - 1] && str[start + 1] == str[end]){ // 시작 값을 지워도 다음이 대칭이고 끝 값을 지워도 다음이 대칭이 되는 경우
                count += 1;
                if(palindrome(start + 1, end - 2, count) < 2 || palindrome(start + 2, end - 1, count) < 2){ // 둘 다 해봐서 하나라도 된다면
                    return 1; // 이미 하나는 삭제해야하므로 0은 불가능
                }else{
                    return 2;
                }
            }else if(str[start] == str[end - 1]){ // 끝 값을 지웠을 때 대칭이라면
                start += 1;
                end -= 2;
                count += 1;
            }else if(str[start + 1] == str[end]){ // 시작 값을 지웠을 때 대칭이라면
                start += 2;
                end -= 1;
                count += 1;
            }else{
                count += 2;
            }
            if(count >= 2) return 2;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            str = br.readLine().toCharArray();
            len = str.length;
            int start = 0;
            int end = len - 1;
            int count = 0;
            int result = palindrome(start, end, count);
            sb.append(result + "\n");

        }
        System.out.println(sb.toString().trim());
    }
}
