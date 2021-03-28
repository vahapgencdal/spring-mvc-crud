package com.helmes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGREE_TO_TERMS",nullable = false)
    private Boolean agreeTerms = Boolean.FALSE;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_SECTOR", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "SECTOR_ID", referencedColumnName = "id"))
    private Set<Sector> sectors;

}