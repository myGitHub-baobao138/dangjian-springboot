package com.partybuilding.webserver.dto.service.leavewords;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 获取留言信息输入数据类
 */
public class GetLeaveWordsInfoInputDTO {


    /**
     * 留言id
     */
    @NotNull(message = "id不能为空")
    private String leaveWordsId;


    public String getLeaveWordsId() {
        return leaveWordsId;
    }

    public void setLeaveWordsId(String leaveWordsId) {
        this.leaveWordsId = leaveWordsId;
    }
}
