public class Serie implements Content {
    private String title;
    private String urlImage;
    private String rating;
    private String year;

    Serie(String title, String urlImage, String rating, String year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    public String title() {
        return title;
    }

    public String urlImage() {
        return urlImage;
    }

    public String rating() {
        return rating;
    }

    public String year() {
        return year;
    }
}
