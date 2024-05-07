package net.programmingpointer.journalapp.controller;

import net.programmingpointer.journalapp.entity.JournalEntry;
import net.programmingpointer.journalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<JournalEntry> old= journalEntryService.getAll();
        if(old!=null && !old.isEmpty())
        {
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.createEntry(myEntry);
            return new ResponseEntity<JournalEntry>(myEntry,HttpStatus.CREATED);
        }catch(Exception e)
        {
            return new ResponseEntity<JournalEntry>(HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryByID(@PathVariable String myId) {
        //return journalEntryService.getByID(myId).orElse(null);
        Optional<JournalEntry> journalEntry = journalEntryService.getByID(myId);
        if(journalEntry.isPresent())
        {
            return new ResponseEntity<JournalEntry>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryByID(@PathVariable String myId) {
        journalEntryService.deleteEntry(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateJournalEntryByID(@PathVariable String myID, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getByID(myID).orElse(null);
        if(old != null)
        {
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            journalEntryService.createEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //journalEntryService.createEntry(old);
        //return null;
    }
}
