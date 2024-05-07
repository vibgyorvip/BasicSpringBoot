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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;

    private String content;

    private LocalDateTime date;
}
