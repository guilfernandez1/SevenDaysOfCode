import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponseResult {
    @JsonProperty("title")
    private String title;

    @JsonProperty("thumbnail")
    private MarvelResponseThumbnail thumbnail;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("startYear")
    private String year;

    public String getTitle() {
        return title;
    }

    public MarvelResponseThumbnail getThumbnail() {
        return thumbnail;
    }

    public String getRating() {
        return rating;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MarvelResponseResult{" +
                "title='" + title + '\'' +
                ", thumbnail=" + thumbnail +
                ", rating='" + rating + '\'' +
                ", year=" + year +
                '}';
    }
}
