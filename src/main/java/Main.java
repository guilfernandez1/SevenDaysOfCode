import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("Chamando API IMDB");
//        String imdbApiKey = System.getenv("IMDB_API_KEY");
//        String jsonImdb = new ImdbApiClient(imdbApiKey).getBody();

        System.out.println("Chamando API Marvel");
        String marvelPrivateKey = System.getenv("MARVEL_PRIVATE_KEY");
        String marvelPublicKey = System.getenv("MARVEL_PUBLIC_KEY");
        String jsonMarvel = new MarvelApiClient(marvelPrivateKey, marvelPublicKey).getBody();
        System.out.println(jsonMarvel);

//        System.out.println("Parsing do JSON IMDB");
//        List<? extends Content> contentList = new ImdbMovieJsonParser(jsonImdb).parse();
        System.out.println("Parsing do JSON Marvel");
        List<? extends Content> contentList = new MarvelJsonParser(jsonMarvel).parse();

        System.out.println("Gerando HTML");
        PrintWriter writer = new PrintWriter("content.html");
        new HtmlGenerator(writer).generate(contentList);
        writer.close();
    }
}