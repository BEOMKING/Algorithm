package 기업코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

/*
올바른 괄호 문자열에서 딱 하나의 문자가 제거된 문자열이 주어진다.
이 문자열을 올바른 괄호 문자열로 만들 수 있는 위치의 개수는 ?
    ( [  { ( ) }   )
        ↑        ↑
        ]        ]
       답 2
   ( { ( ) } ] )
    ↑       ↑
    [       [
   답 2
   (   (   (   )   )   )   )
 ↑   ↑   ↑   ↑   ↑   ↑   ↑
 (   (   (   (   (   (   (
        답 7
*/
public class 쏘카_2021_하반기_1번 {
    static int result = 0;
    static char[] str = {'(', '{', '[', ')', '}', ']'};
    static char[] closed = {')', '}', ']'};
    static List<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] strCount = new int[6];
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(now == '(') strCount[0]++;
            if(now == '{') strCount[1]++;
            if(now == '[') strCount[2]++;
            if(now == ')') strCount[3]++;
            if(now == '}') strCount[4]++;
            if(now == ']') strCount[5]++;
        }

        char shortage = ' ';
        for (int i = 0; i < 3; i++) {
            if(strCount[i] != strCount[i + 3]) {
                if(strCount[i] < strCount[i + 3]) {
                    shortage = str[i];
                } else {
                    shortage = str[i + 3];
                }
                break;
            }
        }

        System.out.println(shortage);
    }

    private static boolean empty(char now) {
        if(stack.size() == 0) return true;
        stack.add(now);
        return false;
    }

    private static boolean match(char before, char now) {
        if(stack.size() == 0) return true;
        stack.add(now);
        return false;
    }

}

/*
    다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
    (), [], {} 는 모두 올바른 괄호 문자열입니다.
    만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
    예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
    만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
    예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
    올바른 괄호 문자열에서 딱 하나의 문자가 제거된 문자열이 있을 때,
    당신은 이 문자열에 제거된 문자를 다시 삽입함으로써 다시 올바른 괄호 문자열로 만들고자 합니다.
    이때, 문자열을 삽입할 수 있는 위치가 여러 개일 수 있습니다.
    올바른 괄호 문자열에서 딱 하나의 문자가 제거된 문자열 s가 매개변수로 주어집니다.
    s에 제거된 문자 하나를 삽입해서 s를 올바른 괄호 문자열로 만들 수 있는 위치의 개수를 return 하도록 solution 함수를 완성해주세요.
    500000
*/
//import java.util.Stack;
//
//class Solution {
//    static char[] type = {'[', ']', '{', '}', '(', ')'};
//    static int[] count = new int[6];
//    static Stack<Character> stack;
//    static char put;
//
//    public int solution(String s) {
//        int answer = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < type.length; j++) {
//                if(s.charAt(i) == type[j]) count[j]++;
//            }
//        }
//        int find = -1;
//        for (int i = 0; i < count.length; i += 2) {
//            if(count[i] == count[i + 1]) continue;
//            find = count[i] > count[i + 1] ? i + 1 : i;
//        }
//        put = type[find];
//
//        int a = 0;
//        for (int i = 0; i < count.length; i++) {
//            if(count[i] != 0) a++;
//        }
//        if(a < 3) answer = s.length();
//        else {
//            for (int i = 0; i <= s.length(); i++) {
//                stack = new Stack<>();
//                for (int j = 0; j < s.length(); j++) {
//                    if(i == j) insert(put);
//                    insert(s.charAt(j));
//                }
//                if(i == s.length() && remove(stack.peek(), put)) stack.pop();
//                if(stack.size() == 0) answer++;
//            }
//        }
//        return answer;
//    }
//
//    private void insert(char after) {
//        if(stack.size() != 0 && remove(stack.peek(), after)) stack.pop();
//        else stack.add(after);
//    }
//
//    private boolean remove(char before, char after) {
//        if(before == '[' && after == ']') return true;
//        if(before == '{' && after == '}') return true;
//        if(before == '(' && after == ')') return true;
//        return false;
//    }
//}
