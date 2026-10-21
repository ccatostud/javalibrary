package Library.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Loan {
    private UUID id;
    private int loanDays;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
    private LocalDateTime dueDate;
    private User user;
    private Book book;
    private boolean isReturned;

    public Loan(User user, Book book, LocalDateTime loanDate, int loanDays) {
        this.id = UUID.randomUUID();
        this.loanDays = loanDays;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(loanDays);
        this.user = user;
        this.book = book;
        this.isReturned = false;
    }

    public UUID getId() {
        return id;
    }
    public int getLoanDays() {
        return loanDays;
    }
    public LocalDateTime getLoanDate() {
        return loanDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public User getUser() {
        return user;
    }
    public Book getBook() {
        return book;
    }
    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dueDate);
    }
    public void returnBook() {
        this.returnDate = LocalDateTime.now();
        this.isReturned = true;
    }
    @Override
    public String toString(){
        return this.id + ", " + this.user.getFirstName() + " " + this.user.getLastName()
                + " (" + this.user.getId() + "), "
                + "Date of loan: " + this.loanDate
                + ", Due date: " + this.dueDate
                + ", Return date: " + this.returnDate
                + ", Is overdue? " + this.isOverdue();
    }

    public boolean getIsReturned() {
        return isReturned;
    }
}
