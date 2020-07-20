package com.moneytap.expensemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "category_seq")
    @SequenceGenerator(
            name = "category_seq",
            sequenceName = "categories_seq",
            allocationSize = 1
    )
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "title")
    @NotNull(message = "fill the title name")
    private String title;

    @Column(name = "description")
    @NotNull(message = "fill the description")
    private String description;

    @Transient
    private Double totalExpense;

    private int l;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private User user;


}
