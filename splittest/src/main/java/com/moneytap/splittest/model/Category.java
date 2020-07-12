package com.moneytap.splittest.model;


import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category")
    private String category;

    @Column(name = "message")
    private String message;

    public String getMessage() {
        return message;
    }

    public Category(int categoryId, String category, String message) {
        this.categoryId = categoryId;
        this.category = category;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Category() {
        // TODO Auto-generated constructor stub
    }



    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
