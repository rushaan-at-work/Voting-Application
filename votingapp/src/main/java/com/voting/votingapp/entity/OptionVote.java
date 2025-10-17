package com.voting.votingapp.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor
@Embeddable
public class OptionVote {
    private String voteOption;
    private Long votecount = 0L;

    public String getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(String option) {
        this.voteOption = option;
    }

    public Long getVotecount() {
        return votecount;
    }

    public void setVotecount(Long votecount) {
        this.votecount = votecount;
    }
}
