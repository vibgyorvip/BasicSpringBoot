package net.programmingpointer.journalapp.service;

import net.programmingpointer.journalapp.entity.JournalEntry;
import net.programmingpointer.journalapp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void createEntry(JournalEntry journalEntry)
    {

        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll()
    {
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> getByID(String id)
    {
       return journalEntryRepository.findById(id);
    }
    public void deleteEntry(String id)
    {
        journalEntryRepository.deleteById(id);
    }
}
