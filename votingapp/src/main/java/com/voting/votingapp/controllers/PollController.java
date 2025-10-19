package com.voting.votingapp.controllers;

import com.voting.votingapp.entity.Poll;
import com.voting.votingapp.request.Vote;
import com.voting.votingapp.services.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;
    public PollController(PollService pollService){
        this.pollService=pollService;
    }
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollsById(@PathVariable Long id){
        return pollService.getPollsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vote")
    public void Vote(@RequestBody Vote vote){
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}
