package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Role;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
