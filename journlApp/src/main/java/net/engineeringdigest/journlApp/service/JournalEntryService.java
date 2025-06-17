package net.engineeringdigest.journlApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journlApp.entity.JornalEntry;
import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;


    @Transactional
    public void saveEntry(JornalEntry jornalEntry, String userName) {
        User user = userService.findByUserName(userName);
        try {
            jornalEntry.setDate(LocalDateTime.now());
            JornalEntry saved = journalEntryRepository.save(jornalEntry);
             user.getJornalEntryList().add(saved);
           //  user.setUserName(null);
             userService.saveUser(user);
        }
        catch (Exception e) {
            System.out.println("Exception"+e);
        }

    }
    public void saveEntry(JornalEntry jornalEntry) {
            journalEntryRepository.save(jornalEntry);

    }


    public List<JornalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JornalEntry> findById(ObjectId id) {//Optional<> means result will be Optional.empty() if no match found
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {

            User user = userService.findByUserName(userName);
             removed = user.getJornalEntryList().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);//so that update  user is going to be saved
                journalEntryRepository.deleteById(id);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error while deleting Journal Entry",e);

        }
        return removed;
    }


}
//controller ----------> service ------------> repository