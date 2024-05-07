package net.programmingpointer.journalapp.controller;

import net.programmingpointer.journalapp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/-journal")
public class JournalEntryController {

    private HashMap<String , JournalEntry> journalEntries= new HashMap<String, JournalEntry>();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryByID(@PathVariable String myId)
    {
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryByID(@PathVariable String myId)
    {
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryByID(@PathVariable String myID,@RequestBody JournalEntry myEntry)
    {
        return journalEntries.put(myID,myEntry);
    }
}
