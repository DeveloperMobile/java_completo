package proj5.services;

import java.security.InvalidParameterException;

public class UsaInterestService implements InterestService {
    private Double interstRate;

    public UsaInterestService(Double interstRate) {
        this.interstRate = interstRate;
    }


    @Override
    public Double getInterestRate() {
        return interstRate;
    }
}
