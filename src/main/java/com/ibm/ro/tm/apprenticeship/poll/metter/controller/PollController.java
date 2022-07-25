package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
            @PathVariable long id
    ) {
       return repository.findById(id);

    }

    @GetMapping("/polls/{title}")
    public Poll findPollByTitle(@PathVariable String title){
        List<Poll> polls =repository.findAll();
        Poll foundPoll = new Poll();
        for (Poll p: polls) {
            if(Objects.equals(p.getTitle(), title))
                foundPoll = p;
        }
        return foundPoll;
    }

    @PostMapping("/add-poll")
    Poll addPoll(
            @RequestBody Poll poll
    ) {
        return repository.save(poll);
    }

//    @PostMapping("/add-poll/{title}/{question}")
//    Poll addPoll(
//            @PathVariable String title,
//            @PathVariable String question
//    ){
//       Poll poll= new Poll(title,question);
//        return repository.save(poll);
//    }


    @DeleteMapping("/delete-poll/{id}")
    public void deletePoll(@PathVariable("id") Long id){
       repository.deleteById(id);
    }

    @DeleteMapping("/check-for-expiration")
    public void checkPolls(){
            List<Poll> polls = repository.findAll();
        for (Poll p:polls) {
            if(p.pollExpired(p))
                repository.delete(p);

        }


    }






}

