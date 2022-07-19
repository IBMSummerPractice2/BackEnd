package com.ibm.ro.tm.apprenticeship.poll.metter.controller;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Vote;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.VoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
