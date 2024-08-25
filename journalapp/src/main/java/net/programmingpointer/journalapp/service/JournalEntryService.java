package net.programmingpointer.journalapp.service;

import net.programmingpointer.journalapp.entity.JournalEntry;
import net.programmingpointer.journalapp.entity.JournalUserDto;
import net.programmingpointer.journalapp.entity.User;
import net.programmingpointer.journalapp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void createEntry(JournalEntry journalEntry)
    {
        if(journalEntry.getUser()!=null) {
            User user = new User();
            user.setId(journalEntry.getUser().getId());
            user.setUserName(journalEntry.getUser().getUserName());
            user.setPassword(journalEntry.getUser().getPassword());
            journalEntry.setUser(user);
        }
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll()
    {

        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> getByID(Integer id)
    {
       return journalEntryRepository.findById(id);
    }
    public void deleteEntry(Integer id)
    {

        journalEntryRepository.deleteById(id);
    }

    public Optional<JournalUserDto> getJournalUserByID(Integer id) {
        Optional<JournalEntry> byId = journalEntryRepository.findById(id);
        if (byId.isPresent())
        {
            JournalEntry journalEntry = byId.get();

            JournalUserDto journalUserDto = new JournalUserDto();
            journalUserDto.setUserName(journalEntry.getUser().getUserName());
            journalUserDto.setTitle(journalEntry.getTitle());
            journalUserDto.setContent(journalEntry.getContent());

            return Optional.of(journalUserDto);
        }
        return Optional.empty();
    }
}