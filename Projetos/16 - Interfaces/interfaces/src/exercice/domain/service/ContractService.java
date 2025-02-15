package exercice.domain.service;

import exercice.domain.entities.Contract;
import exercice.domain.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService service;

    public ContractService(OnlinePaymentService service) {
        this.service = service;
    }

    public void processContract(Contract contract, Integer months) {
        for (int i = 0; i < months; i++) {
            LocalDate pastMonthDate = contract.getDate().plusMonths(i + 1);
            double amount = service.interest(contract.getTotalValue() / months, i + 1);
            double parcel = amount + service.paymentFee(amount);
            contract.addInstallment(new Installment(pastMonthDate, parcel));
        }
    }
}
