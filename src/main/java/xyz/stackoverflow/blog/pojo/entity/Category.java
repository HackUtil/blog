package xyz.stackoverflow.blog.pojo.entity;

import java.io.Serializable;

/**
 * @Author: 凉衫薄
 * @Date: 2018-10-21
 * @Desciption: 分类实体类
 */
public class Category implements Serializable {
    protected String id;
    protected String categoryName;
    protected String categoryCode;
    protected Integer deleteAble;

    public Category(){

    }

    public Category(String id, String categoryName, String categoryCode, Integer deleteAble) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.deleteAble = deleteAble;
    }

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getDeleteAble() {
        return deleteAble;
    }

    public void setDeleteAble(Integer deleteAble) {
        this.deleteAble = deleteAble;
    }
}
