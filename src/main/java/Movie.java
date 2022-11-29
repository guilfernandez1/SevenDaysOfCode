public final class Movie implements Content {
    private final String title;
    private final String urlImage;
    private final String rating;
    private final String year;

    public Movie(String title, String urlImage, String rating, String year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Title: " + title()
                + " | " + "Year: " + year()
                + " | " + "Rating: " + rating()
                + " | " + "Image: " + urlImage();
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
