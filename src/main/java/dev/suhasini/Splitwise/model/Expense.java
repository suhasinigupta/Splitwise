package dev.suhasini.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String name ;
    private double amount ;
    @OneToMany
    private List<UserExpense> userExpenseList ;
    @ManyToOne
    private Group group ;
    @ManyToOne
    private User addedBy ;
}
