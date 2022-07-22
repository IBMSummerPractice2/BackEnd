package com.ibm.ro.tm.apprenticeship.poll.metter.controller;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Vote;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

import com.ibm.ro.tm.apprenticeship.poll.metter.repository.VoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VoteController {
    private final VoteRepository repository;
    private final PollRepository pollRepository;

    public  VoteController(VoteRepository repository, PollRepository pollRepository1) {
        this.repository = repository;

        this.pollRepository = pollRepository1;
    }

    @GetMapping("/votes")
    public List<Vote> all() {
        return repository.findAll();
    }

//    @GetMapping("/votes/{pollId}")
//    List<Vote> allVotesFromPoll
//            (
//                    @PathVariable Long pollId
//            ){
//        List<>
//        pollRepository.getById(pollId).
//    }

    @PostMapping("/add-vote")
    Vote addPoll(
            @RequestBody Long userId,
            @RequestBody Long pollId,
            @RequestBody Integer score,
            @RequestBody String comment
    ){
        Vote vote= new Vote(pollId,score,comment,userId);
        pollRepository.getById(pollId).addVoteToPoll(vote);
        return repository.save(vote);
    }


}
