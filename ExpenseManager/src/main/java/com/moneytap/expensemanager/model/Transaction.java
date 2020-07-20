package com.moneytap.expensemanager.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(generator = "transaction_seq")
    @SequenceGenerator(
            name = "transaction_seq",
            sequenceName = "transactions_seq",
            allocationSize = 1,
            initialValue = 1000
    )
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "amount")
    @NotNull(message = "fill the amount")
    @Min(1)
    private Double amount;

    @Column(name = "note")
    @NotNull(message = "fill the note")
    private String note;

    @Column(name = "transaction_date")
    @Past(message="Date cannot be in the future")
    private Instant transactionDate;

    private int c;
    private int l;

    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

}
