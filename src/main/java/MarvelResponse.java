import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponse {
    @JsonProperty("data")
    MarvelResponseData data;

    public MarvelResponseData getData() {
        return data;
    }

    @Override
    public String toString() {
        return "dto.marvel.MarvelResponse{" +
                "data=" + data +
                '}';
    }
}
