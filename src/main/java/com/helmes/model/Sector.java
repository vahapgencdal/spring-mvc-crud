package com.helmes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SECTOR")
public class Sector extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "sectors", fetch = FetchType.LAZY)
    private Collection<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "id")
    private Sector parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @OrderBy("name ASC")
    private Set<Sector> sectors;

}