package com.ibm.ro.tm.apprenticeship.poll.metter.controller;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
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

    @PostMapping("/add-vote")
    Vote addVote(
            @RequestBody Vote vote
    ) {
        return repository.save(vote);
    }

//    @PostMapping("/add-vote/{userId}/{pollId}/{score}/{comment}")
//    Vote addPoll(
//            @PathVariable Long userId,
//            @PathVariable Long pollId,
//            @PathVariable Integer score,
//            @PathVariable String comment
//    ){
//        Vote vote= new Vote(pollId,score,comment,userId);
//        return repository.save(vote);
//    }


}
