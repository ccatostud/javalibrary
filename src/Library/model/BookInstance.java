package Library.model;

public class BookInstance {
    private Book book;
    private int numberOfCopies;

    public BookInstance(){}

    public BookInstance(Book book, int numberOfCopies){
        this.book = book;
        this.numberOfCopies = numberOfCopies;
    }
    public Book getBook(){
        return this.book;
    }
    public int getNumberOfCopies(){
        return this.numberOfCopies;
    }
    public void setNumberOfCopies(int numberOfCopies){
        this.numberOfCopies = numberOfCopies;
    }
    public void setBook(Book book){
        this.book = book;
    }
}
