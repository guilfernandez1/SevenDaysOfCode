import java.io.PrintWriter;
import java.util.List;

public class HtmlGenerator {
    private final PrintWriter writer;

    public HtmlGenerator(PrintWriter printWriter) {
        this.writer = printWriter;
    }

    public void generate(List<? extends Content> contentList) {
        writer.println(
            """
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>List of Movies</title>
                </head>
                <body>
            """);

        for(Content content : contentList) {
            String div =
                    """
                    <div style=\"max-width: 18rem;\">
                        <h4>%s</h4>
                        <div>
                            <img src=\"%s\" alt=\"%s\">
                            <p>Nota: %s - Ano: %s</p>
                        </div>
                    </div>
                    """;
            writer.println(String.format(div, content.title(), content.urlImage(), content.title(), content.rating(), content.year()));
        }

        writer.println(
            """
                </body>
            </html>
            """);
    }
}
