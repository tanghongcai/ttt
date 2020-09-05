package com.newer.blog.data.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TblBlog implements Serializable {
    private Integer blogId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date blogCreateDate;
    private String blogContent;
    private Integer blogAcc;
    private Integer blogRef;

    public TblBlog() {
    }

    public TblBlog(Integer blogId, Date blogCreateDate, String blogContent, Integer blogAcc, Integer blogRef) {
        this.blogId = blogId;
        this.blogCreateDate = blogCreateDate;
        this.blogContent = blogContent;
        this.blogAcc = blogAcc;
        this.blogRef = blogRef;
    }

    @Override
    public String toString() {
        return "TblBlog{" +
                "blogId=" + blogId +
                ", blogCreateDate=" + blogCreateDate +
                ", blogContent='" + blogContent + '\'' +
                ", blogAcc=" + blogAcc +
                ", blogRef=" + blogRef +
                '}';
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Date getBlogCreateDate() {
        return blogCreateDate;
    }

    public void setBlogCreateDate(Date blogCreateDate) {
        this.blogCreateDate = blogCreateDate;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getBlogAcc() {
        return blogAcc;
    }

    public void setBlogAcc(Integer blogAcc) {
        this.blogAcc = blogAcc;
    }

    public Integer getBlogRef() {
        return blogRef;
    }

    public void setBlogRef(Integer blogRef) {
        this.blogRef = blogRef;
    }
}