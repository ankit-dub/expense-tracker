package splittest.src.main.java.com.splittest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category")
    @NotNull(message="category cannot be empty")
    private String category;

    @Column(name = "membr")
    private String message;

    @OneToMany(mappedBy = "category")
    private Collection<Expense> expense=new ArrayList<Expense>();
}
