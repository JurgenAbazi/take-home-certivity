package io.certivity.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
public class HtmlComment {
    @Id
    public String id;

    public String message;

    public String parentID;

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate createdAt;

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate lastUpdate;

    public HtmlComment(String id, String message, String parentID, LocalDate createdAt, LocalDate lastUpdate) {
        this.id = id;
        this.message = message;
        this.parentID = parentID;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
    }
}
