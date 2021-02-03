package 구현;

import java.util.Scanner;

public class 백준_1244_스위치켜고끄기 {
    static void switchfunction(int intsta[], int now, int student[][]){
        if(now == student.length){return;} // 학생 수보다 현재값이 더 크다면 종료
        if(student[now][0] == 1){ // 남자
            for(int i = 0; i < intsta.length; i++){
                if((i + 1) % student[now][1] == 0){ // 주어진 수의 배수라면
                    if(intsta[i] == 0){
                        intsta[i] = 1;
                    }else{
                        intsta[i] = 0;
                    }
                }
            }
            switchfunction(intsta, now + 1, student);
        }else{
            int count = 1;
            while((student[now][1] - 1) - count >= 0 && (student[now][1] - 1) + count < intsta.length && (intsta[(student[now][1] - 1) - count] == intsta[(student[now][1] - 1) + count])){
                if(intsta[(student[now][1] - 1) - count] == 1){
                    intsta[(student[now][1] - 1) - count] = 0;
                    intsta[(student[now][1] - 1) + count] = 0;
                }else{
                    intsta[(student[now][1] - 1) - count] = 1;
                    intsta[(student[now][1] - 1) + count] = 1;
                }
                count += 1;
            }
            if(intsta[student[now][1] - 1] == 1){
                intsta[student[now][1] - 1] = 0;
            }
            else{
                intsta[student[now][1] - 1] = 1;
            }
            switchfunction(intsta, now + 1, student);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int swi = sc.nextInt(); // 스위치 개수

        int intsta[] = new int[swi]; // 스위치 상태 리스트
        for(int i = 0; i < swi; i++){
            int n = sc.nextInt();
            intsta[i] = n;
        }

        int studentnum = sc.nextInt(); // 학생수
        int student[][] = new int[studentnum][2]; // 학생 정보를 담은 리스트
        for(int i = 0; i < studentnum; i++){
            int gender = sc.nextInt();
            int number = sc.nextInt();
            student[i][0] = gender;
            student[i][1] = number;
        }
        int now = 0;
        switchfunction(intsta, now, student);
        for(int i = 0; i < intsta.length; i++){
            if(i != 0 && i % 20 == 0){
                System.out.println();
            }
            System.out.print(intsta[i]);
            if(i < intsta.length - 1 && i % 20 != 19){
                System.out.print(" ");
            }
        }
    }
}
