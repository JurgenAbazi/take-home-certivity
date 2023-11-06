package io.certivity.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class HtmlElementComponent {
    private final String text;

    private final String html;

    private final int length;

    private final int sort;

    private final String url;

    private final LocalDate createdAt;

    @Setter
    private LocalDate lastModified;

    public HtmlElementComponent(String text, String html, int length, int sort, String url) {
        this.text = text;
        this.html = html;
        this.length = length;
        this.sort = sort;
        this.url = url;
        this.createdAt = LocalDate.now();
        this.lastModified = LocalDate.now();
    }

    public String parseToString() {
        return "<" + getHtml() + ">" + getText() + "</" + getHtml() + ">";
    }
}
