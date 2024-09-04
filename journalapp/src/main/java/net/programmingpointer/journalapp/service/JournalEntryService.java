package net.programmingpointer.journalapp.service;

import net.programmingpointer.journalapp.entity.*;
import net.programmingpointer.journalapp.repository.AddressRepository;
import net.programmingpointer.journalapp.repository.JournalEntryRepository;
import net.programmingpointer.journalapp.repository.JournalProfileRepository;
import net.programmingpointer.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Autowired
//    private JournalProfileRepository journalProfileRepository;

    public void createEntry(JournalEntry journalEntry)
    {
        if(journalEntry.getUser()!=null) {
            User user = new User();
            user.setId(journalEntry.getUser().getId());
            user.setUserName(journalEntry.getUser().getUserName());
            user.setPassword(journalEntry.getUser().getPassword());
            user.setEmail(journalEntry.getUser().getEmail());
            if(journalEntry.getUser().getAddress() !=null)
            {
                Address address = new Address();
                address.setAddress_id(journalEntry.getUser().getAddress().getAddress_id());
                address.setAddress_type(journalEntry.getUser().getAddress().getAddress_type());
                address.setAddress(journalEntry.getUser().getAddress().getAddress());
                user.setAddress(address);
            }
            journalEntry.setUser(user);
        }

        if(journalEntry.getJournalProfile() !=null)
        {
            JournalProfile journalProfile = new JournalProfile();
            journalProfile.setJournalProfileId(journalEntry.getJournalProfile().getJournalProfileId());
            journalProfile.setJournalProfileStatus(journalEntry.getJournalProfile().getJournalProfileStatus());

            journalEntry.setJournalProfile(journalProfile);
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
            journalUserDto.setPassword(journalEntry.getUser().getPassword());
            journalUserDto.setEmail(journalEntry.getUser().getEmail());

            journalUserDto.setTitle(journalEntry.getTitle());
            journalUserDto.setContent(journalEntry.getContent());


            journalUserDto.setAddress(journalEntry.getUser().getAddress().getAddress());

            return Optional.of(journalUserDto);
        }
        return Optional.empty();
    }

    public JournalEntry createEntryDto(JournalUserDto journalUserDto) {
        JournalEntry journalEntry = new JournalEntry();
        if (journalUserDto !=null) {
            User user = new User();

            Address address = new Address();


            //first save the child then parent
            address.setAddress(journalUserDto.getAddress());
            user.setAddress(address);
            user.setUserName(journalUserDto.getUserName());
            user.setPassword(journalUserDto.getPassword());
            user.setEmail(journalUserDto.getEmail());
            journalEntry.setUser(user);
            journalEntry.setTitle(journalUserDto.getTitle());
            journalEntry.setContent(journalUserDto.getContent());

            journalEntryRepository.save(journalEntry);

//            user.setUserName(journalUserDto.getUserName());
//            journalEntry.setTitle(journalUserDto.getTitle());
//            journalEntry.setContent(journalUserDto.getContent());
//            address.setAddress(journalUserDto.getAddress());
//
//            addressRepository.save(address);
//            userRepository.save(user);
//            journalEntryRepository.save(journalEntry);

            //return journalEntry;

        }
        return journalEntry;

    }
}
