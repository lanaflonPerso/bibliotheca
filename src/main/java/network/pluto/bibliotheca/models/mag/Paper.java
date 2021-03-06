package network.pluto.bibliotheca.models.mag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import network.pluto.bibliotheca.dtos.AuthorDto;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(schema = "mcsa", name = "paper")
@Entity
public class Paper {

    @Id
    private long id;

    @Column
    private Long rank;

    @Column
    private String doi;

    @Column
    private String docType;

    @Column
    private String title;

    @Column
    private String originalTitle;

    @Column
    private String bookTitle;

    @Column
    private Integer year;

    @Column
    private String date;

    @Column
    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journal_id")
    private Journal journal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_series_id")
    private ConferenceSeries conferenceSeries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_instance_id")
    private ConferenceInstance conferenceInstance;

    @Column
    private String volume;

    @Column
    private String issue;

    @Column
    private String firstPage;

    @Column
    private String lastPage;

    @Column
    private Long paperCount;

    @Column
    private Long citationCount;

    @Column
    private Integer estimatedCitation;

    // TODO @LazyCollection generates a lot of unnecessary "count" queries
//    @LazyCollection(LazyCollectionOption.EXTRA)
//    @BatchSize(size = 10)
//    @OneToMany(mappedBy = "paper")
//    private List<PaperAuthorAffiliation> paperAuthorAffiliations = new ArrayList<>();

    @Transient
    private List<AuthorDto> authors = new ArrayList<>();

    //    @LazyCollection(LazyCollectionOption.EXTRA)
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper")
    private List<PaperFieldsOfStudy> paperFosList = new ArrayList<>();

    //    @LazyCollection(LazyCollectionOption.EXTRA)
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper")
    private List<PaperLanguage> paperLanguages = new ArrayList<>();

    //    @LazyCollection(LazyCollectionOption.EXTRA)
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper")
    private List<PaperUrl> paperUrls = new ArrayList<>();

    // for lazy loading of one-to-one relation
    @Getter(AccessLevel.PRIVATE)
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper")
    private List<PaperAbstract> paperAbstractHolder;

    public PaperAbstract getPaperAbstract() {
        if (paperAbstractHolder == null || paperAbstractHolder.size() == 0) {
            return null;
        }
        return paperAbstractHolder.get(0);
    }

}
