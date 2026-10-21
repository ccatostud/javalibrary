package Library.model;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private int numberOfPages;
    private String classification;
    private boolean isAvailable;

    public Book(String title, String author, int numberOfPages, String classification){
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.classification = classification;
        this.isAvailable = true;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        return this.id + ", " + this.title + " by " + this.author + ", " + this.numberOfPages + " pages, " + this.classification;
    }

    public UUID getId(){
        return this.id;
    }
}
