package Library.model;

import java.util.*;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Loan> loans;

    public Library(){
        this.books = new ArrayList<Book>();
        this.users = new ArrayList<User>();
        this.loans = new ArrayList<Loan>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void addLoan(Loan loan){
        this.loans.add(loan);
    }
    public List<Book> getBooks(){
        return Collections.unmodifiableList(this.books);
    }
    public List<User> getUsers(){
        return Collections.unmodifiableList(this.users);
    }
    public List<Loan> getLoans(){
        return Collections.unmodifiableList(this.loans);
    }
    public List<Loan> getOverdueLoans(){
        ArrayList<Loan> overdueLoans = new ArrayList<Loan>();
        for(Loan loan : this.loans){
            if(loan.isOverdue()){
                overdueLoans.add(loan);
            }
        }
        return Collections.unmodifiableList(overdueLoans);
    }
    public Set<User> getUsersWithOverdueLoans(){
        Set<User> overdueUsers = new HashSet<User>();
        for(Loan loan : this.loans){
            if(loan.isOverdue()){
                overdueUsers.add(loan.getUser());
            }
        }
        return Collections.unmodifiableSet(overdueUsers);
    }

}
