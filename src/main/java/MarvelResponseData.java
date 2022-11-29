import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponseData {
    @JsonProperty("results")
    List<MarvelResponseResult> results;

    public List<MarvelResponseResult> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "MarvelResponseData{" +
                "results=" + results +
                '}';
    }
}
