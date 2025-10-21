package com.voting.votingapp.services;

import com.voting.votingapp.entity.OptionVote;
import com.voting.votingapp.entity.Poll;
import com.voting.votingapp.repositories.PollRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;
    public PollService(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollsById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        // Get Poll from db
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll Not Found"));
        // Get All Options
        List<OptionVote> option =  poll.getOptions();
        // Throw error for invalid index
        if(optionIndex<0 || optionIndex>=option.size()){
            throw new IllegalArgumentException("Invalid Option Index");
        }
        // Get Selected Option
        OptionVote selectedOption = option.get(optionIndex);
        // Increment the selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);
        // Save this in db
        pollRepository.save(poll);
    }
}
