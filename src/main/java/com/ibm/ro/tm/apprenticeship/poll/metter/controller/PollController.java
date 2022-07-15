package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Role;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PollController {
    private PollRepository repository;


    public  PollController(PollRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/polls")
    public List<Poll> all() {
        return repository.findAll();
    }
}
