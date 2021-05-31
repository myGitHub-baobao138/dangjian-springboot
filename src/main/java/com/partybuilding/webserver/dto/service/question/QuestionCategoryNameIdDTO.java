package com.partybuilding.webserver.dto.service.question;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 问题分类id和name对象封装
 */
public class QuestionCategoryNameIdDTO {
    private String id;
    private String categoryName;

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
}
