import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.*;

public class ImdbApiClient implements APIClient{
    private String imdbApiKey;

    ImdbApiClient(String imdbApiKey) {
        this.imdbApiKey = imdbApiKey;
    }

    public String getBody() {
        try {
            URI apiImdb = URI.create("https://imdb-api.com/en/API/Top250Movies/" + imdbApiKey);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(apiImdb).GET().build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
