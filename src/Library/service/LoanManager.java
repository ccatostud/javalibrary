package Library.service;

import Library.model.Book;
import Library.model.BookInstance;
import Library.model.Loan;
import Library.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class LoanManager {
    private List<Loan> loans;
    private HashMap<Book, List<User>> waitingList;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private NotificationManager notificationManager;
    public LoanManager(BookRepository bookRepository, UserRepository userRepository, NotificationManager notificationManager){
        this.loans = new ArrayList<>();
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.notificationManager = notificationManager;
        this.waitingList = new HashMap<>();
    }

    // Try to create a loan, return null if not possible
    public UUID createLoan(Book book, User user, LocalDateTime loanDate, int term){
        // Check how many copies of the book are available
        BookInstance bi = bookRepository.getBookInstanceByBookId(book.getId());
        int availableCopies = bi.getNumberOfCopies();
        if(availableCopies > getActiveLoansCount(book.getId())){
            // create a loan
            Loan loan = new Loan(user, book, loanDate, term);
            loans.add(loan);
            return loan.getId();
        } else {
            // Add the user to a waiting list
            addUserToWaitingList(book, user);
            return null;
        }
    }

    public void returnBook(Loan loan){
        // Increment book instance count
        BookInstance bi = bookRepository.getBookInstanceByBookId(loan.getBook().getId());
        bi.setNumberOfCopies(bi.getNumberOfCopies() + 1);
        // Remove loan
        loans.remove(loan);
        // Remove user from waiting list
        removeUserFromWaitingList(loan.getBook(), loan.getUser());
        // Notify user of book availability

    }

    private void addUserToWaitingList(Book book, User user){
        waitingList
                .computeIfAbsent(book, b -> new ArrayList<>())
                .add(user);
    }

    private void removeUserFromWaitingList(Book book, User user){
        if(waitingList.containsKey(book)){
            waitingList.get(book).remove(user);
        }
    }

    public int getActiveLoansCount(UUID bookId){
        return (int) loans.stream()
                .filter(loan -> loan.getBook().getId().equals(bookId))
                .count();
    }

    public Loan getLoanByUserAndBook(User user, Book book){
        return loans.stream()
                .filter(loan -> loan.getUser().equals(user) && loan.getBook().equals(book))
                .findFirst()
                .orElse(null);
    }

    public List<Loan> getLoans(){
        return this.loans.stream().toList();
    }

    public HashMap<Book, List<User>> getWaitingList(){
        return this.waitingList;
    }

}
