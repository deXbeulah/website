package com.github.ichenkaihua.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016 11 01 14:24
 */

@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String blogName;
    private String authorName;
    private Date createTime;
    private Integer disable;//是否可用标记

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    private String blogFile;

    public Integer getId() {
        return id;
    }

    /**
     * @return id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getDisable() {
        return disable;
    }

    public String getBlogFile() {
        return blogFile;
    }

    public void setBlogFile(String blogFile) {
        this.blogFile = blogFile;
    }

}
