package com.partybuilding.webserver.dto.service.question;


/**
 * 编辑问题分类
 */
public class EditQuestionCategoryDTO {
    /**
     * 分类id
     */
    private String id;
    /**
     * 分类名称
     */
    private String categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
