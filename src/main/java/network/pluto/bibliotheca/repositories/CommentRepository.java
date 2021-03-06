package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Comment;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    Page<Comment> findByPaperIdOrderByUpdatedAtDesc(long paperId, Pageable pageable);
    long countByCreatedBy(Member createdBy);
}
