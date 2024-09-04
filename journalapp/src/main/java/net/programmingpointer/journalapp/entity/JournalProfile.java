package net.programmingpointer.journalapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="journalProfile")
@Data
public class JournalProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer journalProfileId;

    private String journalProfileStatus;

}
