import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponseThumbnail {
    @JsonProperty("path")
    private String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    @Override
    public String toString() {
        return "MarvelResponseThumbnail{" +
                "urlImage='" + urlImage + '\'' +
                '}';
    }
}
