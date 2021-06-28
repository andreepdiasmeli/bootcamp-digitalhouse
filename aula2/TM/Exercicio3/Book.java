package andreepdiasmeli.Exercicio3;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private BookState state;

    public Book() {
    }

    public Book(String title, String author, String isbn, BookState state) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookState getState() {
        return state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void loanBook(){
        if(this.state == BookState.LOANED){
            throw new RuntimeException("This book is already loaned.");
        }
        this.state = BookState.LOANED;
    }

    private void returnBook(){
        if(this.state == BookState.AVAILABLE){
            throw new RuntimeException("This book is already available.");
        }
        this.state = BookState.AVAILABLE;
    }

    @Override
    public String toString() {
        Boolean isAvailable = this.getState() == BookState.AVAILABLE;
        return title + ", " + author + ", " + isbn + " " + (isAvailable ? "(Available)" : "(Not Available)") + ".";
    }

    public static void main(String[] args) {
        Book book = new Book(
                "Harry Potter",
                "J. K. Rowling",
                "123456789",
                BookState.AVAILABLE
        );

        System.out.println(book.toString());
        book.loanBook();
        System.out.println(book.toString());
        book.returnBook();
        System.out.println(book.toString());
    }
}
