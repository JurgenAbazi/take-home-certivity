package io.certivity.backend.controller;

import io.certivity.backend.domain.HtmlElementComponent;
import io.certivity.backend.service.HtmlElementService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/html")
public class ApiController {

    private final HtmlElementService htmlElementService;

    @Autowired
    public ApiController(HtmlElementService htmlElementService) {
        this.htmlElementService = htmlElementService;
    }

    @GetMapping("/init")
    public ResponseEntity<List<HtmlElementComponent>> downloadHtml() {
        try {
            String url = "https://en.wikipedia.org/wiki/A_Tale_of_Two_Cities";
            Document doc = Jsoup.connect(url).get();

            Element contentElement = doc.select("div.mw-parser-output").first();
            int sortCounter = 0;
            contentElement.select("table, .mw-editsection, .noprint").remove();

            List<HtmlElementComponent> componentList = new ArrayList<>();
            Elements elements = contentElement.select("p, h1, h2, h3, h4, h5, h6, ol, ul");
            for (Element element : elements) {
                componentList.add(extractElement(element, sortCounter++, url));
            }
            htmlElementService.saveAll(componentList);
            return ResponseEntity.ok(componentList);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
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

        return new HtmlElementComponent(null, text, html, length, sort, url, LocalDate.now(), LocalDate.now());
    }

    @GetMapping("/")
    public ResponseEntity<List<HtmlElementComponent>> getAllHtmlElements() {
        List<HtmlElementComponent> components = htmlElementService.getAll();
        return components != null
                ? ResponseEntity.ok().body(components)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HtmlElementComponent> getHtmlElementByID(@PathVariable String id) {
        HtmlElementComponent htmlElementComponent = htmlElementService.getById(id)
                .orElse(null);
        return htmlElementComponent != null
                ? ResponseEntity.ok().body(htmlElementComponent)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HtmlElementComponent> updateHtmlElement(@PathVariable String id,
                                                                  @RequestBody HtmlElementComponent htmlElement) {
        HtmlElementComponent component = htmlElementService.update(id, htmlElement);
        return component != null
                ? ResponseEntity.ok().body(component)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteHtmlElement(@PathVariable String id) {
        htmlElementService.deleteById(id);
    }
}
