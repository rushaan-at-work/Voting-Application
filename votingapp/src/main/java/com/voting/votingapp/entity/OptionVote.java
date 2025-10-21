package com.voting.votingapp.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor
@Embeddable
public class OptionVote {
    private String optionText;
    private Long voteCount = 0L;

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
