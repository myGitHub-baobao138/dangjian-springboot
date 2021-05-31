package com.partybuilding.webserver.entity.dynamic;

import java.util.Date;

public class DynamicPraiseRecord {
    private String id;

    private String articleId;

    private Date time;

    private Integer isCancle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIsCancle() {
        return isCancle;
    }

    public void setIsCancle(Integer isCancle) {
        this.isCancle = isCancle;
    }
}