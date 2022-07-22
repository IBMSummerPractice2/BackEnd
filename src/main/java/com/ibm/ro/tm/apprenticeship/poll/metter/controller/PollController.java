package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PollController {
    private final PollRepository repository;

    public  PollController( PollRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/polls")
    public List<Poll> all() {
        return repository.findAll();
    }


    @GetMapping("/polls/{id}")
    public Optional<Poll> getPollById(
            @PathVariable("id") long id
    ) {
       return repository.findById(id);

    }

    @GetMapping("/polls/{title}")
    public List<Poll> findPollbyTitle(@PathVariable String title){
        return repository.findByTitle(title);
    }

    @PostMapping("/add-poll")
    Poll addPoll(
            @RequestBody Poll poll
    ) {
        return repository.save(new Poll(poll.getTitle(), poll.getQuestion()));

    }


    @DeleteMapping("/delete-poll/{id}")
    public void detelePoll(@PathVariable("id") Long id){
       repository.deleteById(id);
    }






}

