package study.generics;

// 컴파일러가 컴파일시에 타입을 정확히 체킹할 수 있다.
public class Generics<T> { // 타입을 선언할 때 Type Parameter
    private T t;

//    static void impossible(T t) { 여기서 T는 클래스에서 정의한 Type 이다. 그리고 이 Type은 인스턴스가 생성될 때 정해지기 때문에 static 으로는 만들 수 없다.
//        System.out.println(t.toString());
//    }

    void possible(T t) {
        System.out.println(t.toString());
    }

    static <T> void possible2(T t) { // 이건 가능하다. 여기서의 Type은 메서드 레벨의 파라미터이기 때문이다. 다만 헷갈리기 때문에 T -> S 처럼 문자를 다르게 주는 것이 좋다.
        System.out.println(t.toString());
    }

    <S> T print(S s) {
        System.out.println(s);
        return t;
    }

    public static void main(String[] args) {
        Generics<String> generics = new Generics<>(); // 타입을 넣을 때 Type Argument
//        List list = Arrays.asList(1, 2, 3);
//        list.add("BJP");  // 에러 발생
        Generics.possible2("BJP");
        Generics.possible2(1);
        generics.possible("BJP");
    }
}
