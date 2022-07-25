package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/poll")
public class PollController {
    private final static Logger logger = Logger.getLogger(PollController.class.getName());

    private final PollRepository repository;


    public  PollController( PollRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Poll> all() {
        return repository.findAll();
    }


    @GetMapping("/byId/{id}")
    public Optional<Poll> getPollById(
            @PathVariable long id
    ) {
       return repository.findById(id);

    }

    @GetMapping("/byTitle/{title}")
    public Poll findPollByTitle(@PathVariable String title){
        return repository.findByTitle(title);

    }

    @PostMapping("/add")
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


    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable("id") Long id){
       repository.deleteById(id);
    }

    @DeleteMapping("/clean")
    public List<Poll> checkPolls(){
//            List<Poll> polls = repository.findAll();
//        for (Poll p:polls) {
//            if(p.pollExpired(p))
//               // repository.delete(p);
//                logger.info("Poll "+ p +" is deleted");
       return repository.findWithDateBefore(LocalDateTime.now());


        }


    }








