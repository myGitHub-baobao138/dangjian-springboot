package com.partybuilding.webserver.dto.system.wxuser;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 返回的微信用户列表结果类
 */
public class GetWxUserListDTO {
    /**
     * 微信用户id
     */
    private String id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别 0-男 1-女
     */
    private Integer sex;
    /**
     * 首次登录时间
     */
    private String createTime;
    /**
     * 是否认证 0-未认证 1-认证成功 2-认证失败
     */
    private Integer isAudited;
    /**
     * 认证时间
     */
    private String verifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }
}
