package app.database.entity;

public class Music {
    private String name;

    private String author;

    public Music(String name, String author) {
        this.name = name;
        this.author = author;
    }


    public String getName() {
        return name;
    }


    public String getAuthor() {
        return author;
    }


    @Override
    public String toString() {
        return name + " - " + author;
    }
}
