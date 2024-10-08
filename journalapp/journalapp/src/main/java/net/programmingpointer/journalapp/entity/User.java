package net.programmingpointer.journalapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
//@Table(name="users")
//@Table(
//    name = "users",
//    uniqueConstraints = @UniqueConstraint(columnNames = {"column1", "column2"})
//)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(unique=true , nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user" , cascade =CascadeType.ALL)
    private JournalEntry journalEntry;
    //JournalEntry_id  == name of reference entity_primarykey of refrenced table
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_JournalEntry")
//    private JournalEntry journalEntry ;
    //private List<JournalEntry> journalEntries= new ArrayList<>() ;
}
