package network.pluto.bibliotheca.models.mag;

import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@BatchSize(size = 50)
@Table(schema = "mcsa", name = "affiliation")
@Entity
public class Affiliation {

    @Id
    private long id;

    @Column
    private Long rank;

    @Column
    private String normalizedName;

    @Column
    private String displayName;

    @Column
    private Long paperCount;

    @Column
    private Long citationCount;

}
