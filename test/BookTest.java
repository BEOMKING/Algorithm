package test;

public class BookTest {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.add(new Book("21424", "javapro", "김하나", "ssafy.com", 15000, "자바 기본"));
        manager.add(new Book("21425", "javapro", "김하나", "ssafy.com", 15000, "자바 기본"));
        manager.add(new Book("21426", "javapro", "김하나", "ssafy.com", 15000, "자바 기본"));
        manager.add(new Book("21427", "javapro", "김하나", "ssafy.com", 15000, "자바 기본"));
        manager.add(new Book("21428", "javapro", "김하나", "ssafy.com", 15000, "자바 기본"));

        Book[] temp = manager.getList();
        for (Book tem : temp) {
            System.out.println(tem);
        }
        String isbn = "21426";
        System.out.println(manager.searchByIsbn(isbn));
        manager.remove(isbn);
        System.out.println("**********도서 삭제" + isbn + "******");
        temp = manager.getList();
        for (Book b : temp) {
            System.out.println(b);
        }
    }
}
