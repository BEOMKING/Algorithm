package 기업코테;

public class 십일번가_2022_인턴_1번 {

    public int solution(int A, int B) {
        String a = intToStr(A);
        String b = intToStr(B);
        return b.indexOf(a);
    }

    private String intToStr(int n) {
        return String.valueOf(n);
    }

}
