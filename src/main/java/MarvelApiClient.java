import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.*;

public class MarvelApiClient implements APIClient {
    private String endpoint;

    MarvelApiClient(String marvelPrivateKey, String marvelPublicKey) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String hash = HashUtils.getHashMd5(timestamp + marvelPrivateKey + marvelPublicKey);
        this.endpoint = String.format("https://gateway.marvel.com/v1/public/series?ts=%s&apikey=%s&hash=%s", timestamp, marvelPublicKey, hash);
    }

    public String getBody() {
        try {
            URI apiMarvel = URI.create(endpoint);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(apiMarvel).GET().build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch(IOException e) {
            throw new IllegalStateException(e);
        } catch(InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
