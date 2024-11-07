package dev.suhasini.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user ;
    private double moneyOwned ;
    private double moneyPaid ;
    @Enumerated(EnumType.STRING)
    private UserType userType ;
}
