package app.database.entity;

public class Music {
    private String name;
    private String path;

    public Music(String path, String name) {
        this.path = path;
        this.name = name;
    }


    public String getPath() {
        return path;
    }


    @Override
    public String toString() {
        return name;
    }
}
