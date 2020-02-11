package com.yuan.model;

import java.util.Date;

public class Proclamation {
    private Integer id;

    private String title;

    private String content;

    private Date createtime;

    private String addpeople;

    private Boolean ifdisplay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAddpeople() {
        return addpeople;
    }

    public void setAddpeople(String addpeople) {
        this.addpeople = addpeople == null ? null : addpeople.trim();
    }

    public Boolean getIfdisplay() {
        return ifdisplay;
    }

    public void setIfdisplay(Boolean ifdisplay) {
        this.ifdisplay = ifdisplay;
    }
}