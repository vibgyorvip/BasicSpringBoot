package net.programmingpointer.journalapp.service;

import net.programmingpointer.journalapp.entity.User;
import net.programmingpointer.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createEntry(User user)
    {
        userRepository.save(user);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> getById(Integer id)
    {
        return userRepository.findById(id);
    }

    public void delete(Integer id)
    {
        userRepository.deleteById(id);

    }

}
