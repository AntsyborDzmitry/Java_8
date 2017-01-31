package Beans;


public class Book {
    private String title;
    private String Author;

    public Book(String title, String author) {
        this.title = title;
        Author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
