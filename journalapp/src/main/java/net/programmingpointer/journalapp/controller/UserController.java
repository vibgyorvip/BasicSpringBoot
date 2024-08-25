package net.programmingpointer.journalapp.controller;


import net.programmingpointer.journalapp.entity.User;
import net.programmingpointer.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        List<User> old = userService.getAll();
        if(old !=null && !old.isEmpty())
        {
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createEntry(@RequestBody User user)
    {
        try {
            userService.createEntry(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<User> getUserByID(@PathVariable Integer myId)
    {
        Optional<User> old = userService.getById(myId);
        if(old.isPresent())
        {
            return new ResponseEntity<>(old.get(),HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteUserByID(@PathVariable Integer myId)
    {
        userService.delete(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id")
    public ResponseEntity<?> updateUserByID(@RequestParam Integer myId,@RequestBody User user)
    {
        User old = userService.getById(myId).orElse(null);
        if(old != null )
        {
            old.setUserName(user.getUserName() !=null && !user.getUserName().equals("") ? user.getUserName(): old.getUserName());
            old.setPassword(user.getPassword() !=null && !user.getPassword().equals("") ? user.getPassword(): old.getPassword());
            //old.setJournalEntries(user.getJournalEntries() !=null && !user.getPassword().equals("") ? user.getJournalEntries():old.getJournalEntries());

            userService.createEntry(old);
            return new ResponseEntity<>(old , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
