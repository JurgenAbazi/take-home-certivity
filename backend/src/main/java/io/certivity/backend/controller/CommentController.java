package io.certivity.backend.controller;

import io.certivity.backend.domain.HtmlComment;
import io.certivity.backend.service.HtmlCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final HtmlCommentService htmlCommentService;

    @Autowired
    public CommentController(HtmlCommentService htmlCommentService) {
        this.htmlCommentService = htmlCommentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HtmlComment> getComment(@PathVariable String id) {
        HtmlComment htmlElementComponent = htmlCommentService.getById(id)
                .orElse(null);
        return htmlElementComponent != null
                ? ResponseEntity.ok().body(htmlElementComponent)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<HtmlComment> saveComment(@PathVariable String id,
                                                   @RequestBody HtmlComment htmlElement) {
        htmlElement.setCreatedAt(LocalDate.now());
        htmlElement.setLastUpdate(LocalDate.now());
        HtmlComment component = htmlCommentService.update(id, htmlElement);
        return component != null
                ? ResponseEntity.ok().body(component)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HtmlComment> updateComment(@PathVariable String id,
                                                     @RequestBody HtmlComment htmlElement) {
        htmlElement.setLastUpdate(LocalDate.now());
        HtmlComment component = htmlCommentService.update(id, htmlElement);
        return component != null
                ? ResponseEntity.ok().body(component)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable String id) {
        htmlCommentService.deleteById(id);
    }
}
