package net.engineeringdigest.journlApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journlApp.entity.JornalEntry;
import net.engineeringdigest.journlApp.entity.User;
import net.engineeringdigest.journlApp.service.JournalEntryService;
import net.engineeringdigest.journlApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
@Tag(name = "Journal APIs", description = "APIs for managing journal entries")
public class JouranalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<?> getAllJournalEnteriesOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JornalEntry> all = user.getJornalEntryList();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JornalEntry> createEntry(@RequestBody JornalEntry myEntry) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();

            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JornalEntry> getJornalEntryById(@PathVariable ObjectId myId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JornalEntry> collect = user.getJornalEntryList().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
        if (collect != null && !collect.isEmpty()) {
            Optional<JornalEntry> jornalEntry = journalEntryService.findById(myId);
            if (jornalEntry.isPresent()) {
                return new ResponseEntity<>(jornalEntry.get(), HttpStatus.OK);

            }


        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    @DeleteMapping("id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
//        journalEntryService.deleteById(myId);
//        return true;
//    }
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed = journalEntryService.deleteById(myId, userName);
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //similary i can do for the remaining
    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JornalEntry newEntry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JornalEntry> collect = user.getJornalEntryList().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
        if (collect != null && !collect.isEmpty()) {
            Optional<JornalEntry> jornalEntry = journalEntryService.findById(myId);
            if (jornalEntry.isPresent()) {
//                JornalEntry old = jornalEntry.get();
                JornalEntry old = jornalEntry.get();
                old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
                old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
                old.setSentiment(newEntry.getSentiment() != null ? newEntry.getSentiment() : old.getSentiment());
                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old, HttpStatus.OK);

            }
        }
//            JornalEntry old = journalEntryService.findById(myId).orElse(null);
//            if (old != null) {
//                old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
//                old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
//                journalEntryService.saveEntry(old);
//                return new ResponseEntity<>(old, HttpStatus.OK); }



            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }


