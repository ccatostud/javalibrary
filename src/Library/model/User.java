package Library.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private String firstName;
    private String lastName;
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime lastActivity;

    public User(String firstName, String lastName){
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = LocalDateTime.now();
        this.lastActivity = LocalDateTime.now();
    }
    public void updateLastActivity(){
        this.lastActivity = LocalDateTime.now();
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public UUID getId(){
        return this.id;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }

    @Override
    public String toString(){
        return this.id + ", " + this.firstName + " " + this.lastName + ", createdAt: " + this.createdAt + ",  last activity: " + this.lastActivity;
    }
}
