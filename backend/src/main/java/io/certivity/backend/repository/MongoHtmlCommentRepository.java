package io.certivity.backend.repository;

import io.certivity.backend.domain.HtmlComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoHtmlCommentRepository extends MongoRepository<HtmlComment, String> {
}
