package Library.service;

import Library.model.BookInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookRepository {
    private List<BookInstance> bookInstances;
    public BookRepository(){
        this.bookInstances = new ArrayList<>();
    }
    public void addBookInstance(BookInstance book){
        this.bookInstances.add(book);
    }
    public List<BookInstance> getBookInstances(){
        return this.bookInstances;
    }
    public BookInstance getBookInstanceByBookId(UUID bookId){
        return this.bookInstances.stream().filter(bookInstance -> bookInstance.getBook().getId().equals(bookId)).findFirst().orElse(null);
    }
    public void removeBookInstance(int bookId){
        this.bookInstances.remove(bookId);
    }
    public void updateBookInstance(int bookId, BookInstance book){
        this.bookInstances.set(bookId, book);
    }
    public int getNumberOfBookInstances(){
        return this.bookInstances.size();
    }
    public void clearBookInstances(){
        this.bookInstances.clear();
    }
}
