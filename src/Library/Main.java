package Library;

import Library.service.BookRepository;
import Library.service.LoanManager;
import Library.service.NotificationManager;
import Library.service.UserRepository;
import Library.setup.LibrarySetup;
import Library.ui.Menu;
import Library.util.NameGenerator;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        BookRepository bookRepository = new BookRepository();
        NotificationManager notificationManager = new NotificationManager();
        LoanManager loanManager = new LoanManager(bookRepository, userRepository, notificationManager);
        LibrarySetup librarySetup = new LibrarySetup(new NameGenerator(), userRepository, bookRepository, loanManager);
        librarySetup.seed();

        Menu menu = new Menu(loanManager, userRepository, bookRepository);
        menu.printMenu();
    }
}
