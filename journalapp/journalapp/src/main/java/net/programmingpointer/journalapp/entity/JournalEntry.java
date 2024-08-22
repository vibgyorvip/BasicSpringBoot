package net.programmingpointer.journalapp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "journal")
@Data
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title",nullable = false)
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="date")
    private LocalDateTime date;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="fk_userId", referencedColumnName = "id")
    private User user;
}
