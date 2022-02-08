package splittest.src.main.java.com.splittest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "expense_name")
    //@NotNull(message="Expense name cannot be empty")
    private String expenseName;

    @Column(name = "amount")
    @Min(1)
    private double amount;

    @Column(name = "created_date")
    @Past(message="Date cannot be in the future")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Usr user;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

}
