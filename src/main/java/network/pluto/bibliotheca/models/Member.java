package network.pluto.bibliotheca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "REL_MEMBER_AUTHORITY",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID"))
    private List<Authority> authorities;

    @Column(nullable = false)
    private String name;

    @Column
    private String profileImage;

    @Column
    private String institution;

    @Column
    private String major;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
    private Wallet wallet;

    @Column(nullable = false)
    private int reputation;
}
