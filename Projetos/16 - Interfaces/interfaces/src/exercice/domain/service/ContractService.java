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
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate pastMonthDate = contract.getDate().plusMonths(i);

            double interest = service.interest(basicQuota, i);
            double fee = service.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.addInstallment(new Installment(pastMonthDate, quota));
        }
    }
}
