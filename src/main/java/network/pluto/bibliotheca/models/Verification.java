package network.pluto.bibliotheca.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class Verification extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articleSequence")
    @SequenceGenerator(name = "articleSequence", sequenceName = "article_sequence", allocationSize = 1)
    @Id
    private long id;

    @Column
    private String token;

    @Column
    private long memberId;
}
