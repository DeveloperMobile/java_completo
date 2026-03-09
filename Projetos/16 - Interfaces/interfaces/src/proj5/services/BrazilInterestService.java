package proj5.services;

public class BrazilInterestService implements InterestService {
    private Double interstRate;

    public BrazilInterestService(Double interstRate) {
        this.interstRate = interstRate;
    }

    @Override
    public Double getInterestRate() {
        return interstRate;
    }
}
