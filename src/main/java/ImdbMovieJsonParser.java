import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImdbMovieJsonParser implements JsonParser{
    private String json;

    ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Movie> parse() {
        try {
            List<String> titles = parseAttribute(json, "fullTitle");
            List<String> urlImages = parseAttribute(json, "image");
            List<String> ratings = parseAttribute(json, "imDbRating");
            List<String> years = parseAttribute(json, "year");

            List<Movie> movies = new ArrayList<>(titles.size());

            for(int i = 0; i < titles.size(); i++) {
                movies.add(new Movie(titles.get(i), urlImages.get(i), ratings.get(i), years.get(i)));
            }
            return movies;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private List<String> parseAttribute(String json, String key) throws JsonProcessingException {
        Map<String, List<HashMap<String, String>>> mapper = new ObjectMapper().readValue(json, HashMap.class);
        List<String> itemsList = mapper.get("items")
                .stream()
                .filter(value -> value.get(key) != null)
                .map(value -> value.get(key))
                .collect(Collectors.toList());
        return itemsList;
    }
}
