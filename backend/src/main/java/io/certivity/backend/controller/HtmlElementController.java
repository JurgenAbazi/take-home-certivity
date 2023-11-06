package io.certivity.backend.controller;

import io.certivity.backend.domain.HtmlElementComponent;
import io.certivity.backend.service.HtmlElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/html")
public class HtmlElementController {

    private final HtmlElementService htmlElementService;

    @Autowired
    public HtmlElementController(HtmlElementService htmlElementService) {
        this.htmlElementService = htmlElementService;
    }

    @GetMapping("/")
    public ResponseEntity<List<HtmlElementComponent>> getAllObjects() {
        List<HtmlElementComponent> components = htmlElementService.getAll();
        return components != null
                ? ResponseEntity.ok().body(components)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HtmlElementComponent> getObjectById(@PathVariable String id) {
        HtmlElementComponent htmlElementComponent = htmlElementService.getById(id)
                .orElse(null);
        return htmlElementComponent != null
                ? ResponseEntity.ok().body(htmlElementComponent)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HtmlElementComponent> createObject(@RequestBody HtmlElementComponent htmlElementComponent) {
        HtmlElementComponent component = htmlElementService.save(htmlElementComponent);
        return component != null
                ? ResponseEntity.ok().body(component)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HtmlElementComponent> updateObject(@PathVariable String id,
                                                             @RequestBody HtmlElementComponent htmlElementComponent) {
        HtmlElementComponent component = htmlElementService.update(id, htmlElementComponent);
        return component != null
                ? ResponseEntity.ok().body(component)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteObject(@PathVariable String id) {
        htmlElementService.deleteById(id);
    }
}
