package dev.suhasini.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Entity
@Getter
@Setter
public class SettledTransaction extends BaseModel{
    @ManyToOne
    private User borrower ;
    @ManyToOne
    private User lender ;
    private double amount ;
    private Currency currency ;
}
