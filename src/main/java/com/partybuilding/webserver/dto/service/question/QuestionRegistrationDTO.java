package com.partybuilding.webserver.dto.service.question;



/**
 * 考题分类——列表显示
 * @author asus
 */
public class QuestionRegistrationDTO {
    private String id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 创建人
     */
    private String founderName;

    /**
     * 创建时间
     */
    private String creationTime;

    /**
     * 相关考核题数
     */
    private Integer count;

    /**
     * 备注
     */
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
