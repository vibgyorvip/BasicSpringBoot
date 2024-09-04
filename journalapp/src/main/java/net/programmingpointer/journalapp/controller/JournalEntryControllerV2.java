package net.programmingpointer.journalapp.controller;

import jakarta.validation.Valid;
import net.programmingpointer.journalapp.entity.JournalEntry;
import net.programmingpointer.journalapp.entity.JournalUserDto;
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

    @PostMapping("/journalUserDto")
    public ResponseEntity<JournalEntry> createEntryDto(@Valid @RequestBody JournalUserDto journalUserDto) {
        try {
            JournalEntry entryDto = journalEntryService.createEntryDto(journalUserDto);
            return new ResponseEntity<JournalEntry>(entryDto,HttpStatus.CREATED);
        }catch(Exception e)
        {
            return new ResponseEntity<JournalEntry>(HttpStatus.BAD_REQUEST);
        }


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

    @GetMapping("getJournalUserByID/{id}")
    public ResponseEntity<JournalUserDto> getJournalUserByID(@PathVariable Integer id)
    {
        Optional<JournalUserDto> journalUserDto = journalEntryService.getJournalUserByID(id);
        if(journalUserDto.isPresent())
        {
            return  new ResponseEntity<>(journalUserDto.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryByID(@PathVariable Integer myId) {
        //return journalEntryService.getByID(myId).orElse(null);
        Optional<JournalEntry> journalEntry = journalEntryService.getByID(myId);
        if(journalEntry.isPresent())
        {
            return new ResponseEntity<JournalEntry>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<JournalEntry>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryByID(@PathVariable Integer myId) {
        journalEntryService.deleteEntry(myId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("id/")
    public ResponseEntity<?> updateJournalEntryByID(@RequestParam Integer myID, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getByID(myID).orElse(null);
        if(old != null)
        {
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());

            old.getUser().setUserName(newEntry.getUser().getUserName()!=null && !newEntry.getUser().getUserName().equals("")?newEntry.getUser().getUserName():old.getUser().getUserName());
            old.getUser().setPassword(newEntry.getUser().getPassword()!=null&& !newEntry.getUser().getPassword().equals("")?newEntry.getUser().getPassword():old.getUser().getPassword());
            old.getUser().setEmail(newEntry.getUser().getEmail()!=null && !newEntry.getUser().getEmail().equals("")?newEntry.getUser().getEmail():old.getUser().getEmail());
            old.getUser().getAddress().setAddress_type(newEntry.getUser().getAddress().getAddress_type()!=null && !newEntry.getUser().getAddress().getAddress_type().equals("")?newEntry.getUser().getAddress().getAddress_type():old.getUser().getAddress().getAddress_type());
            old.getUser().getAddress().setAddress(newEntry.getUser().getAddress().getAddress()!=null && !newEntry.getUser().getAddress().getAddress().equals("")?newEntry.getUser().getAddress().getAddress():old.getUser().getAddress().getAddress());

            journalEntryService.createEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //journalEntryService.createEntry(old);
        //return null;
        //localhost:8080/journal/id/?myID=1
    }
}
