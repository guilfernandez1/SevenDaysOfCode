import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class MarvelJsonParser implements JsonParser {

    private String json;

    MarvelJsonParser(String json) {
        this.json = json;
    }

    public List<Serie> parse() {
        try {
            return parseSerie(json);
        } catch(JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private List<Serie> parseSerie(String json) throws JsonProcessingException {
       MarvelResponse response = new ObjectMapper().readValue(json, MarvelResponse.class);
       List<MarvelResponseResult> results = response.getData().getResults();

       List<Serie> series = new ArrayList<>(results.size());

       for(MarvelResponseResult result : results) {
           series.add(new Serie(result.getTitle(), result.getThumbnail().getUrlImage(), result.getRating(), result.getYear()));
       }

       return series;
    }
}
