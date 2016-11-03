package com.github.ichenkaihua.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author WangQiang
 * @Description ${DESCRIPTION}
 * @create 2016-11-02 13:56
 */
@Table(name="classify")
public class Classify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//分类编号
    private String classifyName;//分类名称
    private Integer groupId;//分类分组编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }@Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", classify name='" + classifyName + '\'' +
                ", group id='" + groupId + '\'' +
                '}';
    }
}
