package pl.lewandowski.recommendations_api;

public class Movie {

    private int id;
    private String title;
    private String category;
    private String ranking;

    public Movie(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
