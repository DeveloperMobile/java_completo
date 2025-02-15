package entities;

public class BusinessAccount extends Account {
    private Double loamLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loamLimit) {
        super(number, holder, balance);
        this.loamLimit = loamLimit;
    }

    public Double getLoamLimit() {
        return loamLimit;
    }

    public void setLoamLimit(Double loamLimit) {
        this.loamLimit = loamLimit;
    }

    public void loan(Double amount) {
        if (amount <= loamLimit) {
           balance += amount - 10;
        }
    }

    @Override
    public void withdraw(Double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }
}
