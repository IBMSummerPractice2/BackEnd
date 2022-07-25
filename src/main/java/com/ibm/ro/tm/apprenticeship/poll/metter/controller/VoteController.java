package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Vote;


import com.ibm.ro.tm.apprenticeship.poll.metter.repository.VoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class VoteController {
    private final VoteRepository repository;


    public  VoteController(VoteRepository repository) {
        this.repository = repository;

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
@PutMapping("update-vote/{id}")
public Vote updateVote(@PathVariable long id,@RequestBody Vote vote) {

        if(repository.findById(id).isEmpty())
            return null;

    Vote updateVote = repository.findById(id).get();

    updateVote.setScore(vote.getScore());
    updateVote.setComment(vote.getComment());

    return repository.save(updateVote);

}


}
