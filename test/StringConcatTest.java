package test;

public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + ", " + s2;

        System.out.println(s3);

        StringBuilder sb = new StringBuilder("");
        sb.append(s1).append(", ").append(s2);

        System.out.println(sb.toString());

        String[] strArray = {"Hello", ", ", "World" };
        String str = "";
        for( String s : strArray ) {
            str += s;
        }
        System.out.println(str);

        sb.setLength(0);
        for( String s : strArray ) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
