package Library.setup;

import Library.model.Book;
import Library.model.BookInstance;
import Library.model.User;
import Library.service.BookRepository;
import Library.service.LoanManager;
import Library.service.UserRepository;
import Library.util.NameGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class LibrarySetup {
    private UserRepository userRepository;
    private BookRepository bookRepository;
    private NameGenerator nameGenerator;
    private LoanManager loanManager;

    public LibrarySetup(NameGenerator nameGenerator, UserRepository userRepository, BookRepository bookRepository, LoanManager loanManager){
        this.nameGenerator = new NameGenerator();
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.loanManager = loanManager;
    }

    public void seed(){
        NameGenerator ng = new NameGenerator();
        System.out.println("Library created");
        Random random = new Random();

        // Seed library with users, books and loans
        for(int i = 0; i < 5; i++){
            // Generate and add a User
            String[] name = ng.generateRandomPersonName();
            User u = new User(name[0], name[1]);
            userRepository.addUser(u);
            // Generate and add a book
            Book b = new Book(
                    ng.generateRandomBookTitle(),
                    ng.generateRandomAuthor(),
                    random.nextInt(500),
                    ng.generateRandomClassification());
            BookInstance bi = new BookInstance(b, random.nextInt(1,5));
            bookRepository.addBookInstance(bi);
        }

        List<User> users = userRepository.getUsers();
        List<BookInstance> bookInstances = bookRepository.getBookInstances();

        // Generate and add 100 loans
        for(int i = 0; i < 10; i++){
            User user = users.get((int) (Math.random() * users.size()));
            BookInstance bi = bookInstances.get((int) (Math.random() * bookInstances.size()));
            Book book = bi.getBook();
            LocalDateTime loanDate = LocalDateTime.now().minusWeeks((int) (Math.random() * 2));
            UUID loanId = loanManager.createLoan(book, user, loanDate, 7);
            if(loanId != null){
                System.out.println("Loan created: " + loanId.toString());
            } else {
                System.out.println("Book not available for loan, added user to waiting list.");
            }
        }
    }
}
