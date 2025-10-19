package com.voting.votingapp.repositories;

import com.voting.votingapp.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
