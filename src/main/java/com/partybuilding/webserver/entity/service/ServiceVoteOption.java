package com.partybuilding.webserver.entity.service;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ServiceVoteOption {

    private String id;
    //投票的选项的内容
    private String optionContent;
    //投票选项A,B
    private String option;
    @JsonIgnore
    private String voteId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }



    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }
}
