package Library.ui;

import Library.model.Book;
import Library.model.BookInstance;
import Library.model.Loan;
import Library.model.User;
import Library.service.BookRepository;
import Library.service.LoanManager;
import Library.service.UserRepository;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private LoanManager loanManager;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    public Menu(LoanManager loanManager, UserRepository userRepository, BookRepository bookRepository){
        this.loanManager = loanManager;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void printMenu(){
    /*
        Bibliotek v2: reservationskö – Utöka bibliotekssystemet med reservationskö per
        bok och notifiering när ett exemplar lämnas tillbaka.

        Kräver:
        - Böcker finns i x antal exemplar, ett lån minskar tillgängligt antal av den boken
        - Testaren ska kunna välja en användare att agera som (annars går inte notifiering att validera)
        -
    */
        printUsers();
        printBooks();
        printLoans();
        printWaitingList();

        System.out.println("Enter a number to select an option:");
        System.out.println("1. Print users, 2. Print books, 3. Print loans, 4. Print waiting list");
        System.out.println("Or enter any of the following:");
        System.out.println("return - Return a book, notifications - list notifications for a user, loan - loan a book");
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            switch (input){
                case "1":
                    printUsers();
                    break;
                case "2":
                    printBooks();
                    break;
                case "3":
                    printLoans();
                    break;
                case "4":
                    printWaitingList();
                    break;
                case "return":
                    handleBookReturnMenu(sc);
                    break;
            }
        }
    }


    private void handleBookReturnMenu(Scanner sc){
        System.out.println("Enter book ID");
        UUID bookId = UUID.fromString(sc.nextLine());
        System.out.println("Enter user ID");
        UUID userId = UUID.fromString(sc.nextLine());
        // Check if the user exists
        User user = userRepository.getUserById(userId);
        if(user == null){
            System.out.println("No such user!");
            printMenu();
        }
        BookInstance bi = bookRepository.getBookInstanceByBookId(bookId);
        if(bi == null){
            System.out.println("No such BookInstance!");
            printMenu();
        }
        // Check if there is a loan for the book
        Loan loan = loanManager.getLoanByUserAndBook(user,bi.getBook());
        if(loan == null){
            System.out.println("Loan not found!");
        } else {
            loanManager.returnBook(loan);
            System.out.println("Book returned!");
        }
    }

    private void printUsers(){
        System.out.println("List of users:");
        for(User u : userRepository.getUsers()){
            System.out.println("User:" + u.getFirstName() + " " + u.getLastName() + " (" + u.getId() + ")");
        }
    }

    private void printBooks(){
        System.out.println("List of books:");
        for(BookInstance bi : bookRepository.getBookInstances()){
            System.out.println("Book:" + bi.getBook().getTitle() + " (" + bi.getBook().getId() + ")");
        }
    }

    private void printLoans(){
        System.out.println("Active loans:");
        for(Loan l : loanManager.getLoans()){
            System.out.println("Loan:" + l.getBook().getTitle() + " " + l.getUser().getFirstName() + " " + l.getUser().getLastName() + " (" + l.getId() + ")");
        }
    }

    private void printWaitingList(){
        System.out.println("Waiting list:");
        loanManager.getWaitingList().forEach((book, users) -> {
            System.out.println("Book:" + book.getTitle());
            users.forEach(u -> System.out.println("User:" + u.getFirstName() + " " + u.getLastName()));
        });
    }

}
