package com.partybuilding.webserver.dto.service.voteDto;

import java.io.Serializable;

/**
 * 投票的每个选项包含的内容
 */
public class ServiceVoteOptionDto {

    private String id;

    //投票的选项
    private String optionContent;
    //投票选项A,B
    private String option;

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
}
