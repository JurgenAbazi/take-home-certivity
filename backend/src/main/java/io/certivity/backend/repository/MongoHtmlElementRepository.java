package io.certivity.backend.repository;

import io.certivity.backend.domain.HtmlElementComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoHtmlElementRepository extends MongoRepository<HtmlElementComponent, String> {
}
