package dev.suhasini.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Group extends BaseModel{
    private String name ;
    @ManyToOne
    private User createdBy ;
    @ManyToMany
    private List<User> users ;
    @OneToMany
    private List<Expense> expenses ;
    @OneToMany
    private List<SettledTransaction> settledTransactionList ;
}
