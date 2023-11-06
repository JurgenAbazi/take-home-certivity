package io.certivity.backend.service;

import io.certivity.backend.domain.HtmlElementComponent;
import io.certivity.backend.repository.MongoHtmlElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HtmlElementService {
    private final MongoHtmlElementRepository mongoDBRepository;

    @Autowired
    public HtmlElementService(MongoHtmlElementRepository mongoDBRepository) {
        this.mongoDBRepository = mongoDBRepository;
    }

    public List<HtmlElementComponent> getAll() {
        return mongoDBRepository.findAll();
    }

    public Optional<HtmlElementComponent> getById(String id) {
        return mongoDBRepository.findById(id);
    }

    public HtmlElementComponent save(HtmlElementComponent htmlElementComponent) {
        return mongoDBRepository.save(htmlElementComponent);
    }

    public void saveAll(List<HtmlElementComponent> components) {
        mongoDBRepository.saveAll(components);
    }

    public HtmlElementComponent update(String id, HtmlElementComponent htmlElementComponent) {
        htmlElementComponent.setId(id);
        return mongoDBRepository.save(htmlElementComponent);
    }

    public void deleteById(String id) {
        mongoDBRepository.deleteById(id);
    }
}
