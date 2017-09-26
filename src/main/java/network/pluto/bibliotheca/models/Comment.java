package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    private long commentId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "EVALUATION_ID")
    private Evaluation evaluation;

    @Column(nullable = false)
    private String comment;
}