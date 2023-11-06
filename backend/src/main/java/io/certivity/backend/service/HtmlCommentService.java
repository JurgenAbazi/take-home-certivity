package io.certivity.backend.service;

import io.certivity.backend.domain.HtmlComment;
import io.certivity.backend.repository.MongoHtmlCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HtmlCommentService {
    private final MongoHtmlCommentRepository mongoHtmlCommentRepository;

    @Autowired
    public HtmlCommentService(MongoHtmlCommentRepository mongoHtmlCommentRepository) {
        this.mongoHtmlCommentRepository = mongoHtmlCommentRepository;
    }

    public Optional<HtmlComment> getById(String id) {
        return mongoHtmlCommentRepository.findById(id);
    }

    public HtmlComment save(HtmlComment htmlElementComponent) {
        return mongoHtmlCommentRepository.save(htmlElementComponent);
    }

    public HtmlComment update(String id, HtmlComment htmlElementComponent) {
        htmlElementComponent.setId(id);
        return mongoHtmlCommentRepository.save(htmlElementComponent);
    }

    public void deleteById(String id) {
        mongoHtmlCommentRepository.deleteById(id);
    }
}
