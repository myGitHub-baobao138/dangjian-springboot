package com.partybuilding.webserver.dto.system.auditRecord;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 认证信息列表数据类
 */
public class GetVerificationInfoListDTO {

    /**
     * 组织职务id
     */
    private String organPostId;
    /**
     * 微信用户id
     */
    private String id;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学/工号
     */
    private String studentJobNumber;


    /**
     * 学院名
     */
    private String organizationName;

    /**
     * 电话号码（联系方式）
     */
    private String telNumber;

    /**
     * 类别 0-学生 1-教师
     */
    private Integer type;

    /**
     * 是否书记
     */
    private Integer isSecretary;

    /**
     * 是否认证 0-未认证 1-认证成功 2-认证失败
     */
    private Integer isAudited;

    private String postName;

    public String getOrganPostId() {
        return organPostId;
    }

    public void setOrganPostId(String organPostId) {
        this.organPostId = organPostId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentJobNumber() {
        return studentJobNumber;
    }

    public void setStudentJobNumber(String studentJobNumber) {
        this.studentJobNumber = studentJobNumber;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSecretary() {
        return isSecretary;
    }

    public void setIsSecretary(Integer isSecretary) {
        this.isSecretary = isSecretary;
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

}
