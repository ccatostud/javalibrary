package Library.model;

public class Notification {
    private String message;
    private User recipient;
    public Notification(String message, User recipient){
        this.message = message;
        this.recipient = recipient;
    }
    public String getMessage(){
        return this.message;
    }
    public User getRecipient(){
        return this.recipient;
    }
}
