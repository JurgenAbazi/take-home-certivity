package io.certivity.backend.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
public class HtmlElementComponent {
    @Id
    private String id;

    private final String text;

    private final String html;

    private final int length;

    private final int sort;

    private final String url;

    private final LocalDate createdAt;

    private LocalDate lastModified;

//    public HtmlElementComponent(String text, String html, int length, int sort, String url) {
//        this.text = text;
//        this.html = html;
//        this.length = length;
//        this.sort = sort;
//        this.url = url;
//        this.createdAt = LocalDate.now();
//        this.lastModified = LocalDate.now();
//    }

    public HtmlElementComponent(String id, String text, String html, int length, int sort,
                                String url, LocalDate createdAt, LocalDate lastModified) {
        this.id = id;
        this.text = text;
        this.html = html;
        this.length = length;
        this.sort = sort;
        this.url = url;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public String parseToString() {
        return "<" + getHtml() + ">" + getText() + "</" + getHtml() + ">";
    }

}
