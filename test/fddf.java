package test;

public class fddf {
    public static void main(String[] args) {
        String[] array = {"(", "123", "abc"};
        for(int i = 0; i < array.length; i++){
            if(array[i] == "("){
                System.out.println(true);
            }
            else{
                System.out.println(false);
            }
        }

    }

}
