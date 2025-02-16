package proj5.services;

import java.security.InvalidParameterException;

public class BrazilInterestService {
    private Double interstRate;

    public BrazilInterestService(Double interstRate) {
        this.interstRate = interstRate;
    }

    public Double getInterstRate() {
        return interstRate;
    }

    public Double payment(double amount, int months) {
        if (months < 1) {
            throw  new InvalidParameterException("Months must be greater than zero");
        }
        return amount * Math.pow(1.0 + interstRate / 100.0, months);
    }
}
