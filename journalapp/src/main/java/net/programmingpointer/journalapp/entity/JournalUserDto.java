package net.programmingpointer.journalapp.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class JournalUserDto {
    private String userName;


    private String title;


    private String content;
}
