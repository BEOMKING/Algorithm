package study.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoundedGenerics {
    static <T extends Comparable<T>> long print(T[] arr, T elem) {
        return Arrays.stream(arr)
                .filter(t -> t.compareTo(elem) > 0)
                .count();
    }

    static <T extends Comparable> void printt(List<T> t) {

    }
    // 이 두개는 기능적으로 큰 차이는 없다. 하지만 구현부에 타입을 사용해야 할 때 와일드카드는 Object를 사용해야한다.
    // 이 때 좀더 명시적으로 작성하고 싶다면 T 를 사용하는 것이 좋을 것이다.
    static void print(List<? extends Comparable> t) {
        for (Object a : t) {

        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        String[] strings = new String[]{"a", "b", "c", "d"};
        System.out.println(BoundedGenerics.print(integers, 4));
        System.out.println(BoundedGenerics.print(strings, "a"));

        List<String> list = Collections.emptyList();

        printt(list);
        print(list);
    }
}
