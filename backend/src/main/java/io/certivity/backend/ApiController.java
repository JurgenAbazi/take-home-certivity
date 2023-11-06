package io.certivity.backend;

import io.certivity.backend.domain.HtmlElementComponent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    public record CustomResponse(String message) {
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse> helloWorld() {
        return ResponseEntity.ok().body(new CustomResponse("Hello World!"));
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadHtml() {
        try {
            String url = "https://en.wikipedia.org/wiki/A_Tale_of_Two_Cities";
            Document doc = Jsoup.connect(url).get();

            Element contentElement = doc.select("div.mw-parser-output").first();
            if (contentElement != null) {
                int sortCounter = 0;
                contentElement.select("table, .mw-editsection, .noprint").remove();

                List<HtmlElementComponent> componentList = new ArrayList<>();
                Elements elements = contentElement.select("p, h1, h2, h3, h4, h5, h6, ol, ul");
                for (Element element : elements) {
                    componentList.add(extractElement(element, sortCounter++, url));
                }
            }

            return ResponseEntity.ok("elements");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching URL: " + e.getMessage());
        }
    }


    public HtmlElementComponent extractElement(Element element, int sort, String url) {
        String text;
        try {
            text = element.text();
        } catch (Exception e) {
            text = "";
        }
        String html = element.tagName();
        int length = text.length();

        return new HtmlElementComponent(text, html, length, sort, url);
    }
}

