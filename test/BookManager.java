package test;

public class BookManager {
    private final int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE];
    private int size;

    public void add(Book book){
        if(size < MAX_SIZE){
            books[size] = book;
            size++;
        }
    }

    public void remove(String isbn){
        for(int i = 0; i < size; i++){
            if(books[i].getIsbn().equals(isbn)){
                books[i] = books[size - 1];
                size--;
            }
        }
        System.out.println("삭제 완료");
    }

    public Book[] getList(){
        Book[] temp = new Book[size];
        for(int j = 0; j < size; j++){
            temp[j] = books[j];
        }
        return temp;
    }

    public Book searchByIsbn(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
}
